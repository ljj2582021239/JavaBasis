package com.indiv.proxy;

import com.indiv.proxy.cglibProxy.CglibSellProxyFactory;
import com.indiv.proxy.dynamicProxy.jdkProxy.RedWineFactory;
import com.indiv.proxy.dynamicProxy.jdkProxy.SellProxyFactory;
import com.indiv.proxy.dynamicProxy.jdkProxy.SellWine;

import java.lang.reflect.Proxy;
import java.util.HashMap;

/**
 * 需求者小名委托代理人小红买香水
 */
public class XiaoMing {

    public static void JDKProxy(){
        // 小明说我想买香奈儿的香水
        ChanelFactory chanelFactory = new ChanelFactory();
        // 然后找到代理工厂，给代理工厂处理
        SellProxyFactory sellProxyFactory = new SellProxyFactory(chanelFactory);
        // 由代理工厂找到合适的代理对象
        /**
         * ClassLoader loader：加载动态代理类的类加载器
         * Class<?>[] interfaces：代理类实现的接口，可以传入多个接口
         * InvocationHandler h：指定代理类的调用处理程序，即调用接口中的方法时，会找到该代理工厂h，执行invoke()方法
         */
        SellPerfume sellPerfume = (SellPerfume) Proxy.newProxyInstance(
                chanelFactory.getClass().getClassLoader(),
                chanelFactory.getClass().getInterfaces(),       // 利用到反射了
                sellProxyFactory);
        sellPerfume.sellPerfume(1580.0);
    }

    public static void JDKProxySellWine(){
        // 实例化一个红酒销售商
        RedWineFactory redWineFactory = new RedWineFactory();
        // 实例化代理工厂，传入红酒销售商引用控制对其的访问
        SellProxyFactory sellProxyFactory = new SellProxyFactory(redWineFactory);
        // 实例化代理对象，该对象可以代理售卖红酒
        SellWine sellWine = (SellWine) Proxy.newProxyInstance(
                redWineFactory.getClass().getClassLoader(),
                redWineFactory.getClass().getInterfaces(),
                sellProxyFactory);
        sellWine.sellWine(8888.88);
    }

    /**
     * cglib动态代理获取 代理对象
     */
    public static void CglibProxy(){
        CglibSellProxyFactory proxyFactory = new CglibSellProxyFactory();
        // 获取一个代理实例
        SellPerfume instance =(SellPerfume) proxyFactory.getProxyInstance(new ChanelFactory());
        instance.sellPerfume(1580.0);
    }
    public static void main(String[] args) {

        // 小明说我想买香奈儿的香水
        ChanelFactory chanelFactory = new ChanelFactory();
        // 然后把购买的品牌告诉给小红
        XiaoHongSellProxy xiaoHongSellProxy = new XiaoHongSellProxy(chanelFactory);
        // 小红购买所指定价格香水
        xiaoHongSellProxy.sellPerfume(1580.0);

        System.out.println("===================分割===================");
        JDKProxy();
        System.out.println("===================分割===================");
        JDKProxySellWine();
        System.out.println("===================分割===================");
        CglibProxy();

        int [] a = new int[5];
        for (int i: a
             ) {
            System.out.println(i);
        }

    }
}
