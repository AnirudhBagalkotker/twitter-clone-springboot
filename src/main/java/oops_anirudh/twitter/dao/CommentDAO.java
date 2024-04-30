package oops_anirudh.twitter.dao;

public interface CommentDAO {
	String getCommentBodyFromRequest(Object requestBody);
    int getUserIdFromRequest(Object requestBody);
    int getPostIdFromRequest(Object requestBody);
    int getCommentIdFromRequest(Object requestBody);
}
