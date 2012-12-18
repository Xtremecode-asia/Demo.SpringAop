package demo.springaop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * Created by Xtremecodes.asia @2012
 * User: saintc0d3r@gmail.com
 * Date: 12/18/12
 * Time: 8:18 PM
 */

@Aspect
public class InfrastructureAspect {
    @Pointcut("execution(public * demo.springaop.service.*.*(..)) && this(demo.springaop.service.IService)")
    public void inServiceLayer(){}
}
