package com.yechao.demo;

public class Goods {
    private int id;// 产品编号
    private String name;// 名称
    private double price;// 价格
    private int buyNumber;// 购买数量

    public Goods() {
    }

    public Goods(int id, String name, double price, int buyNumber) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.buyNumber = buyNumber;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setBuyNumber(int buyNumber) {
        this.buyNumber = buyNumber;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getBuyNumber() {
        return buyNumber;
    }
}
