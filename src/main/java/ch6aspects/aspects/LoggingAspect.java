package ch6aspects.aspects;

import ch4abstractions.models.Comment;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.logging.Logger;

@Aspect
@Order(2)
@Component
public class LoggingAspect {

    private Logger logger = Logger.getLogger(LoggingAspect.class.getName());

    @Around("execution(* ch4abstractions.services.CommentService.publishComment(..))")
    public void logCommentServiceMethodExecutions(ProceedingJoinPoint joinPoint) throws Throwable {
        logger.info("Method will execute");
        joinPoint.proceed();
        logger.info("Method executed");
    }

    @Around("execution(* ch4abstractions.repositories.*.retrieveComment(..))")
    public Object logCommentRetrieval(ProceedingJoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().getName();
        Object[] arguments = joinPoint.getArgs();
        logger.info(() -> "Method " + methodName + " with parameters: " + Arrays.asList(arguments) + " has been called.");
        Object returnedByMethod;
        int commentID = (int) arguments[0];
        if (commentID == 10) {
            Object[] newArguments = {11};
            returnedByMethod = joinPoint.proceed(newArguments);
            logger.info(() -> "Method intercepted, executed and returned: " + returnedByMethod);
        } else if (commentID == 100) {
            returnedByMethod = joinPoint.proceed();
            logger.info(() -> "Method intercepted, executed and returned: " + returnedByMethod);
            logger.info("-- MODIFYING THE RETURNED VALUE IN THE ASPECT --");
            String originalAuthorOfReturnedComment = ((Comment) returnedByMethod).getAuthor();
            return new Comment(
                    "INTERCEPTED_" + originalAuthorOfReturnedComment,
                    ((Comment) returnedByMethod).getText()
            );
        } else {
            returnedByMethod = joinPoint.proceed();
            logger.info(() -> "Method executed and returned: " + returnedByMethod);
        }
        return returnedByMethod;
    }

    @Around("@annotation(ch6aspects.annotations.ToLog)")
    public void logMethodsAnnotated(ProceedingJoinPoint joinPoint) throws Throwable {
        var methodName = joinPoint.getSignature().getName();
        logger.info(() -> "Method "  + methodName + " annotated by @ToLog intercepted at the aspect");
        joinPoint.proceed();
        logger.info(() -> "Method "  + methodName + " annotated by @ToLog finished execution");
    }

    @Before("execution(* ch4abstractions.repositories.*.editComment(..))")
    public void logEditComment() {
        logger.info("editComment is going to be called");
    }
}
