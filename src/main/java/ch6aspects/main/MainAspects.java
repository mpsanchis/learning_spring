package ch6aspects.main;

import ch4abstractions.models.Comment;
import ch4abstractions.services.CommentService;
import ch6aspects.config.ProjectConfig6;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainAspects {

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig6.class);
        var service = context.getBean(CommentService.class);
//        var comment = new Comment("Miguel", "Here is a comment");
//        service.publishComment(comment);
//        service.retrieveComment(3);
//        var commentRetrieved = service.retrieveComment(100);
//        System.out.println("Main method. The comment retrieved with ID=100 is the following: " + commentRetrieved);
//        commentRetrieved = service.retrieveComment(10);
//        System.out.println("Main method. The comment retrieved with ID=10 is the following: " + commentRetrieved);
//        service.deleteComment(10);
        service.editComment(-1, new Comment("Miguel", "editing a comment"));
    }
}
