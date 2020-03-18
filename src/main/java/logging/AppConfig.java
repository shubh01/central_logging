package logging;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class AppConfig {

	@Before("@annotation(logging.LogBefore) && execution(* *(..))")
    public void logBefore(JoinPoint joinPoint){
		System.out.println("logging before: "+joinPoint.getTarget().getClass().getName()+" @method "+joinPoint.getSignature());
    }
	
	@After("@annotation(logging.LogAfter) && execution(* *(..))")
    public void logAfter(JoinPoint joinPoint){
		System.out.println("logging after: "+joinPoint.getTarget().getClass().getName()+" @method "+joinPoint.getSignature());
    }

	@AfterThrowing(pointcut = "@annotation(logging.LogException) && execution(* *(..))", throwing = "ex")
	public void logException(JoinPoint joinPoint, Throwable ex) {
		System.out.println("exception occurred @class: "+joinPoint.getTarget().getClass().getName()+" @method "+joinPoint.getSignature()+" exception msg: "+ex.getMessage());
		
	}
	
}
