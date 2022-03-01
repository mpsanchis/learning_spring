package ch4abstractions.proxies;

import ch4abstractions.models.Comment;

public interface CommentNotificationProxy {
    public void sendComment(Comment comment);
}
