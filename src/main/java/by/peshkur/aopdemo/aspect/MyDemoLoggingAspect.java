package by.peshkur.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

    @Pointcut("execution(* by.peshkur.aopdemo.dao.*.*(..))")
    private void forDaoPackage() {}

    //create point cut for getter methods

    @Pointcut("execution(* by.peshkur.aopdemo.dao.*.get*(..))")
    private void getter() {}

    //create point cut for setter methods
    @Pointcut("execution(* by.peshkur.aopdemo.dao.*.set*(..))")
    private void setter() {}


    //create point: include package .. exclude getters/sette
    @Pointcut("forDaoPackage() && !(getter() || setter())")


    @Before("forDaoPackage()")
    public void beforeAddAccountAdvice() {
        System.out.println("\n=====>>> Executing @Before advice on method");
    }

    @Before("forDaoPackage()")
    public void performApiAnalytics() {
        System.out.println("\n=====>>> Perform API analytics");
    }

}
