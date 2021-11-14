package com.stonebridge.aop.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

// @Aspect表示这个类是一个切面类
@Aspect
// @Component注解保证这个切面类能够放入IOC容器
@Component
@Order(7)
public class LogAspect {

    // @Before注解：声明当前方法是前置通知方法
    // value属性：指定切入点表达式，由切入点表达式控制当前通知方法要作用在哪一个目标方法上
    //在通知方法形参位置声明一个JoinPoint类型的参数，Spring就会将这个对象传入
    //根据JoinPoint对象就可以获取目标方法名称，实际参数列表
    @Before(value = "com.stonebridge.aop.AtguiguPointCut.atguiguGlobalPointCut()")
    public void printLogBeforeCore(JoinPoint joinPoint) {
        //1.通过JoinPoint对象获取目标方法签名对象
        //方法的签名：一个方法的全部声明信息
        Signature signature = joinPoint.getSignature();
        String methodName = signature.getName();
        System.out.println("methodName:" + methodName);

        Integer modifiers = signature.getModifiers();
        System.out.println("modifiers:" + modifiers);

        String declaringTypeName = signature.getDeclaringTypeName();
        System.out.println("declaringTypeName:" + declaringTypeName);

        // 3.通过JoinPoint对象获取外界调用目标方法时传入的实参列表
        Object[] args = joinPoint.getArgs();
        // 4.由于数组直接打印看不到具体数据，所以转换为List集合
        List<Object> argList = Arrays.asList(args);
        System.out.println("[AOP前置通知] " + methodName + "方法开始了，参数列表：" + argList);
    }

    // 在返回通知中获取目标方法返回值分两步：
    // 第一步：在@AfterReturning注解中通过returning属性设置一个名称
    // 第二步：使用returning属性设置的名称在通知方法中声明一个对应的形参
    @AfterReturning(value = "com.stonebridge.aop.AtguiguPointCut.atguiguGlobalPointCut()", returning = "targetMethodReturnValue")
    public void printLogAfterSuccess(JoinPoint joinPoint, Object targetMethodReturnValue) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("[AOP返回通知] " + methodName + "方法成功结束了，返回值是：" + targetMethodReturnValue);
    }

    // @AfterThrowing注解标记异常通知方法
    // 在异常通知中获取目标方法抛出的异常分两步：
    // 第一步：在@AfterThrowing注解中声明一个throwing属性设定形参名称
    // 第二步：使用throwing属性指定的名称在通知方法声明形参，Spring会将目标方法抛出的异常对象从这里传给我们
    @AfterThrowing(value = "com.stonebridge.aop.AtguiguPointCut.atguiguGlobalPointCut()", throwing = "targetMethodException")
    public void printLogAfterException(JoinPoint joinPoint, Throwable targetMethodException) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("[AOP异常通知] " + methodName + "方法抛异常了，异常类型是：" + targetMethodException.getClass().getName());
    }

    @After(value = "com.stonebridge.aop.AtguiguPointCut.atguiguGlobalPointCut()")
    public void printLogFinallyEnd() {
        System.out.println("[AOP后置通知] 方法最终结束了");
    }

}
