package oops_anirudh.twitter.dao;

import org.springframework.stereotype.Component;

@Component
public class PostDAOImpl implements PostDAO {

    @Override
    public String getPostBodyFromRequest(Object requestBody) {
        try {
            String jsonString = (String) requestBody;
            int startIndex = jsonString.indexOf("\"postBody\":") + 11;
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
    public int getUserIdFromRequest(Object requestBody) {
        try {
            String jsonString = (String) requestBody;
            int startIndex = jsonString.indexOf("\"userID\":") + 9;
            int endIndex = jsonString.indexOf(",", startIndex);
            if (endIndex == -1) {
                endIndex = jsonString.indexOf("}", startIndex);
            }
            return Integer.parseInt(jsonString.substring(startIndex, endIndex));
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    @Override
    public int getPostIdFromRequest(Object requestBody) {
        try {
            String jsonString = (String) requestBody;
            int startIndex = jsonString.indexOf("\"postID\":") + 9;
            int endIndex = jsonString.indexOf(",", startIndex);
            if (endIndex == -1) {
                endIndex = jsonString.indexOf("}", startIndex);
            }
            return Integer.parseInt(jsonString.substring(startIndex, endIndex));
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}
