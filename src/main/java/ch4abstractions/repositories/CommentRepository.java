package ch4abstractions.repositories;

import ch4abstractions.models.Comment;
import ch4abstractions.models.TransactionStatus;

public interface CommentRepository {
    public void storeComment(Comment comment);
    public void editComment(int commentID, Comment newComment);
    public Comment retrieveComment(int commentID);
    public TransactionStatus deleteComment(int commentID);
}
