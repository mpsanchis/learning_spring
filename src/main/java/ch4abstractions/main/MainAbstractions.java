package ch4abstractions.main;

import ch4abstractions.config.ProjectConfig4;
import ch4abstractions.models.Comment;
import ch4abstractions.services.CommentService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainAbstractions {

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig4.class);
        var comment = new Comment("Miguel", "Hello World!");

        var commentService = context.getBean(CommentService.class);
        commentService.publishComment(comment);
    }
}
