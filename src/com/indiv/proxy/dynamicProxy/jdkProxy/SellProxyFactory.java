package com.indiv.proxy.dynamicProxy.jdkProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class SellProxyFactory implements InvocationHandler {
    /**
     * 真实的代理对象，但是在我们的工程中是不存在java源文件的
     */
    private Object realObject;

    public SellProxyFactory(Object realObject) {
        this.realObject = realObject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        toFrench();
        discount();
        Object invoke = method.invoke(realObject, args);
        postBack();
        return invoke;
    }

    private void toFrench(){
        System.out.println("去法国----------------");
    }

    private void discount(){
        System.out.println("代理商的专属折扣********");
    }

    private void postBack(){
        System.out.println("邮寄回给委托人==========");
    }
}
