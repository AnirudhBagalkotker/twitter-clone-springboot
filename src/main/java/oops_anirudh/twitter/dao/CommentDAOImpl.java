package oops_anirudh.twitter.dao;

import org.springframework.stereotype.Component;

@Component
public class CommentDAOImpl implements CommentDAO {

    @Override
    public String getCommentBodyFromRequest(Object requestBody) {
        try {
            String jsonString = (String) requestBody;
            int startIndex = jsonString.indexOf("\"commentBody\":") + 14;
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

    @Override
    public int getCommentIdFromRequest(Object requestBody) {
        try {
            String jsonString = (String) requestBody;
            int startIndex = jsonString.indexOf("\"commentID\":") + 12;
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
