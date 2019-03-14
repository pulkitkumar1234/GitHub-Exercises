package SpringAOPExeecise;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect

public class MyAspect {

    @Before("execution(public void display())")
    void beforeAdvice() {
        System.out.println("Before advice is running");
    }

    @AfterReturning(pointcut = "execution(Integer getInteger())", returning = "returnValue")
    void afterReturningAdvice(Integer returnValue) {
        System.out.println("Running AfterReturning " + returnValue);
    }

    @AfterThrowing(pointcut = "execution(Exception throwException())", throwing = "ex")
    void afterReturningAdvice(Exception ex) {
        System.out.println("Running AfterThrowing " + ex);
    }
    @After("execution(void display())")
    void afterAdvice(){
        System.out.println("Running after advice");
    }
    /* @Around("execution(void display())")*/

    @Around("@annotation(SpringAOPExeecise.Loggable)")
    void aroundAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("Around before");
        proceedingJoinPoint.proceed();
        System.out.println("Around after");
    }
}