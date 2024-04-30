package oops_anirudh.twitter.dao;

public interface UserDAO {
    String getNameFromRequest(Object requestBody);
    String getEmailFromRequest(Object requestBody);
    String getPasswordFromRequest(Object requestBody);
}

