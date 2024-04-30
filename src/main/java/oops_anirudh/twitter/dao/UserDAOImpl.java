package oops_anirudh.twitter.dao;

import org.springframework.stereotype.Component;

@Component
public class UserDAOImpl implements UserDAO {

    @Override
    public String getNameFromRequest(Object requestBody) {
        try {
            String jsonString = (String) requestBody;
            int startIndex = jsonString.indexOf("\"userId\":") + 9;
            int endIndex = jsonString.indexOf(",", startIndex);
            if (endIndex == -1) {
                endIndex = jsonString.indexOf("}", startIndex);
            }
            return jsonString.substring(startIndex, endIndex).replace("\"", "");
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public String getEmailFromRequest(Object requestBody) {
        try {
            String jsonString = (String) requestBody;
            int startIndex = jsonString.indexOf("\"email\":") + 8;
            int endIndex = jsonString.indexOf(",", startIndex);
            if (endIndex == -1) {
                endIndex = jsonString.indexOf("}", startIndex);
            }
            return jsonString.substring(startIndex, endIndex).replace("\"", "");
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public String getPasswordFromRequest(Object requestBody) {
        try {
            String jsonString = (String) requestBody;
            int startIndex = jsonString.indexOf("\"password\":") + 11;
            int endIndex = jsonString.indexOf(",", startIndex);
            if (endIndex == -1) {
                endIndex = jsonString.indexOf("}", startIndex);
            }
            return jsonString.substring(startIndex, endIndex).replace("\"", "");
        } catch (Exception e) {
            return null;
        }
    }
}
