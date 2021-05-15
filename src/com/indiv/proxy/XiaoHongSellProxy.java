package com.indiv.proxy;

/**
 * 定义小红代理类，她需要代购去售卖香奈儿香水，所以她是香奈儿香水提供商的代理对象
 */
public class XiaoHongSellProxy implements SellPerfume{

    private SellPerfume sellPerfume;

    public XiaoHongSellProxy(SellPerfume sellPerfume) {
        this.sellPerfume = sellPerfume;
    }

    /**
     *
     * @param price
     */
    @Override
    public void sellPerfume(double price) {
        // 代理人在购买香水时的前置操作
        toFrench();
        discount();

        // 代理商小红购买香水，至于购买什么香水，让委托代购的那个人告诉代理商吧
        sellPerfume.sellPerfume(price);

        // 代理人在购买香水时的后置操作
        postBack();
    }

    private void toFrench(){
        System.out.println("小红去法国----------------");
    }

    private void discount(){
        System.out.println("代理商的专属折扣********");
    }

    private void postBack(){
        System.out.println("小红邮寄回给委托人==========");
    }
}
