package ch4abstractions.proxies;

import ch4abstractions.models.Comment;
import org.springframework.stereotype.Component;

@Component
public class EmailCommentNotificationProxy implements CommentNotificationProxy {

    @Override
    public void sendComment(Comment comment) {
        System.out.println("Sending e-mail with comment: " + comment);
    }

}
