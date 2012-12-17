package demo.springaop.aspect;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.joda.time.DateTime;
import org.springframework.stereotype.Component;

/**
 * Created by Xtremecodes.asia @2012
 * User: saintc0d3r@gmail.com
 * Date: 12/16/12
 * Time: 8:11 PM
 */

@Aspect
@Component
public class ServiceCallsLoggerAspect {
    private static final String ON_BEFORE_LOG_MESSAGE_FORMAT = "Start calling '%s' method at %s";
    private static final String ON_ERROR_LOG_MESSAGE_FORMAT = "Error happened when calling '%s' method at %s";
    private static final String ON_AFTER_LOG_MESSAGE_FORMAT = "Finished calling '%s' method at %s";

    private Log logger;
    private String methodsName;

    @Before("execution(public * demo.springaop.service.*.*(..))")
    public void logBeforeServiceCall(JoinPoint joinPoint) {
        Class methodOwner = joinPoint.getSignature().getDeclaringType();
        logger = LogFactory.getLog(methodOwner);
        methodsName = String.format("%s.%s", methodOwner.getName(), joinPoint.getSignature().getName());
        // Log the timestamp the beginning before actually calling the method
        logger.info(String.format(ON_BEFORE_LOG_MESSAGE_FORMAT, methodsName, DateTime.now()));
    }

    @AfterReturning("execution(public * demo.springaop.service.*.*(..))")
    public void logAfterServiceCall(){
        logger.info(String.format(ON_AFTER_LOG_MESSAGE_FORMAT, methodsName, DateTime.now()));
    }

    @AfterThrowing(pointcut = "execution(public * demo.springaop.service.*.*(..))", throwing="ex")
    public void logAfterExceptionThrownInServiceCall(Exception ex){
        logger.error(String.format(ON_ERROR_LOG_MESSAGE_FORMAT, methodsName, DateTime.now()), ex);
    }
}
