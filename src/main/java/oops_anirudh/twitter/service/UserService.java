package oops_anirudh.twitter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import oops_anirudh.twitter.dao.UserDAO;
import oops_anirudh.twitter.model.User;
import oops_anirudh.twitter.repository.UserRepository;


@Service
public class UserService {

    private final UserDAO userDAO;
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserDAO userDAO, UserRepository userRepository) {
        this.userDAO = userDAO;
        this.userRepository = userRepository;
    }

    public String login(Object requestBody) {
        String email = userDAO.getEmailFromRequest(requestBody);
        String password = userDAO.getPasswordFromRequest(requestBody);
        User user = userRepository.findByEmail(email);
        if (user == null) {
            return "User does not exist";
        }
        if (!user.getPassword().equals(password)) {
            return "Username/Password Incorrect";
        }
        return "Login Successful";
    }

    public String signUp(Object requestBody) {
        String email = userDAO.getEmailFromRequest(requestBody);
        String password = userDAO.getPasswordFromRequest(requestBody);
        String name = userDAO.getNameFromRequest(requestBody);
        User existingUser = userRepository.findByEmail(email);
        if (existingUser != null) {
            return "Forbidden, Account already exists";
        }
        User newUser = new User();
        newUser.setEmail(email);
        newUser.setName(name);
        newUser.setPassword(password);
        userRepository.save(newUser);
        return "Account Creation Successful";
    }

    public User getUserDetails(Integer userId) {
        return userRepository.findById(userId).orElse(null);
    }

    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }
}
