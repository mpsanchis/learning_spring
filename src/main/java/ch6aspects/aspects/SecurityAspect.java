package ch6aspects.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Order(1)
@Component
public class SecurityAspect {

    private Logger logger = Logger.getLogger(LoggingAspect.class.getName());

    @Around("execution(* ch4abstractions.repositories.*.editComment(..))")
    public void checkCommentEditable(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] inputArgs = joinPoint.getArgs();
        int commentID = (int)inputArgs[0];
        if (commentID >= 0) {
            logger.info("editComment() called with a valid comment ID");
            joinPoint.proceed();
        } else {
            logger.warning(() -> "editComment called with invalid comment ID: " + commentID);
        }
    }
}
