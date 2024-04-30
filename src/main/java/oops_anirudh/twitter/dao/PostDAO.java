package oops_anirudh.twitter.dao;

public interface PostDAO {
    String getPostBodyFromRequest(Object requestBody);
    int getUserIdFromRequest(Object requestBody);
    int getPostIdFromRequest(Object requestBody);
}
