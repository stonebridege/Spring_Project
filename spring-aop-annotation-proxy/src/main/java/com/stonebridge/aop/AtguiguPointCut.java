package com.stonebridge.aop;

import org.aspectj.lang.annotation.Pointcut;

public class AtguiguPointCut {
    @Pointcut(value = "execution(public int com.stonebridge.aop.api.Calculator.*(int,int))")
    public void atguiguGlobalPointCut() {
    }
}
