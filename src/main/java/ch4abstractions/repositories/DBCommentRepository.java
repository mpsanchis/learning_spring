package ch4abstractions.repositories;

import ch4abstractions.models.Comment;
import ch4abstractions.models.TransactionStatus;
import org.springframework.stereotype.Repository;

@Repository
public class DBCommentRepository implements CommentRepository {

    @Override
    public void storeComment(Comment comment) {
        System.out.println("Storing " + comment + " in DB");
    }

    @Override
    public void editComment(int commentID, Comment newComment) {
        System.out.println("Editing comment with ID: " + commentID + ". Substituting it for: " + newComment);
    }

    @Override
    public Comment retrieveComment(int commentID) {
        if (commentID < 10) {
            return new Comment("Juan", "this comment was retrieved from a DB with an ID < 10");
        } else if (commentID == 10) {
            return new Comment("DB_Error", "comments with ID = 10 are not handled");
        } else {
            return new Comment("DB_Admin", "this comment has ID > 10");
        }
    }

    @Override
    public TransactionStatus deleteComment(int commentID) {
        if (commentID == 10) {
            return TransactionStatus.CRASHING_ERROR;
        } else if (commentID < 10) {
            return TransactionStatus.SOME_WARNINGS;
        } else {
            return TransactionStatus.ALL_OK;
        }
    }
}
