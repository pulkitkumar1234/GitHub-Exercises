package SpringEventAOPEXERCISE2;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect

public class ServiceAspect {

    @Before("execution(public * *(..))")  //Running
    void AllMEthods() {
        System.out.println("Running For All Method");
    }


    @Before("execution(public void display())")  //RUNNUNG
    void beforeAdvice() {
        System.out.println("Before advice is running");
    }
    @After("execution(void display())")  //Running
    void afterAdvice(){
        System.out.println("Running after advice");
    }

    /*@Around("@annotation(SpringAOPExeecise.Loggable)")*/

    @Around("execution(void display())") //Running
    void aroundAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("Around before");
        proceedingJoinPoint.proceed();
        System.out.println("Around after");
    }

    @AfterReturning(pointcut = "execution(Integer getInteger(Integer))", returning = "returnValue")
    void afterReturningAdvice(Integer returnValue) {
        System.out.println("Running AfterReturning " + returnValue);
    }

    @AfterThrowing(pointcut = "execution(void throwException())", throwing = "ex")
    void afterReturningAdvice(Exception ex) {
        System.out.println("Running AfterThrowing " + ex);
    }

    /*@Before("execution(Integer getInteger(Integer))")   //No Running*/
    @Before("AllMethod()")
    void beforeAdviceJoin(JoinPoint joinPoint) {
        System.out.println("Running JOINT POINT before advice");
        System.out.println(joinPoint);
        System.out.println(joinPoint.getThis());
        System.out.println(joinPoint.getSignature());
        Object [] objects=joinPoint.getArgs();
        for (Object object:objects){
            System.out.println(object);
        }
    }




    /*@Before("within(SpringEventAOPEXERCISE2.*)") //Running
    void WithinAdvice() {
        System.out.println("WithIn Advices");
    }*/

    @Before("AllMethod()") //Running
    void WithinAdvice() {
        System.out.println("WithIn Advices");
    }

    @Before("bean(Service))") //Runninng
    void beanAdvice() {
        System.out.println("Running Bean advice");
    }

    @Before("args(Integer)")  //running
    void ArgsAdvice() {
        System.out.println("Running Agrs advice");
    }

    @Before("this(SpringEventAOPEXERCISE2.Service)")  //Running
    void ThisAdvice() {
        System.out.println("Running THIS before advice");
    }

    @Pointcut("within(SpringEventAOPEXERCISE2.*)")
    public void AllMethod(){  };
}