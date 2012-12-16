package demo.springaop.aspect;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
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
public class ServiceAuditingAspect {
    @Around("execution(public * demo.springaop.service.*.*(..))")
    public Object auditServiceCall(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Class methodOwner = proceedingJoinPoint.getSignature().getDeclaringType();
        Log logger = LogFactory.getLog(methodOwner);
        String methodsName = String.format("%s.%s", methodOwner.getName(), proceedingJoinPoint.getSignature().getName());
        // Log the timestamp the beginning before actually calling the method
        logger.info(String.format("Start calling '%s' method at %s", methodsName, DateTime.now()));
        Object result = proceedingJoinPoint.proceed();
        // Log the timestamp after the method has been called.
        logger.info(String.format("Finished calling '%s' method at %s", methodsName, DateTime.now()));
        return result;
    }
}
