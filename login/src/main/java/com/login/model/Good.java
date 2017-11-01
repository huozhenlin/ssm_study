package com.login.model;

/**
 * Created by hzl on 2017/4/25.
 */
public class Good {
    private String goods_link;
    private String goods_name;
    private float goods_price;

    public String getGoods_link() {
        return goods_link;
    }

    public void setGoods_link(String goods_link) {
        this.goods_link = goods_link;
    }

    public String getGoods_name() {
        return goods_name;
    }

    public void setGoods_name(String goods_name) {
        this.goods_name = goods_name;
    }

    public float getGoods_price() {
        return goods_price;
    }

    public void setGoods_price(float goods_price) {
        this.goods_price = goods_price;
    }

    public Good() {
        super();
    }

    public Good(String goods_link, String goods_name, float goods_price) {
        this.goods_link = goods_link;
        this.goods_name = goods_name;
        this.goods_price = goods_price;
    }
}
