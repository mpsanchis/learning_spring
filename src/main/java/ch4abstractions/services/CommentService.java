package ch4abstractions.services;

import ch4abstractions.models.Comment;
import ch4abstractions.models.TransactionStatus;
import ch4abstractions.proxies.CommentNotificationProxy;
import ch4abstractions.repositories.CommentRepository;
import ch6aspects.annotations.ToLog;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class CommentService {
    private CommentRepository commentRepository;
    private CommentNotificationProxy commentNotificationProxy;

    //@Autowired not needed because there is only one constructor
    //Spring detects beans that implement the interfaces, and injects them automatically
    public CommentService(CommentRepository commentRepository,
                          @Qualifier("PUSH") CommentNotificationProxy commentNotificationProxy) {
        this.commentRepository = commentRepository;
        this.commentNotificationProxy = commentNotificationProxy;
    }

    public void publishComment(Comment comment) {
        this.commentRepository.storeComment(comment);
        this.commentNotificationProxy.sendComment(comment);
    }

    public Comment retrieveComment(int commentID) {
        return this.commentRepository.retrieveComment(commentID);
    }

    public void editComment(int commentID, Comment newComment) {
        this.commentRepository.editComment(commentID, newComment);
    }

    @ToLog
    public TransactionStatus deleteComment(int commentID) {
        return this.commentRepository.deleteComment(commentID);
    }
}
