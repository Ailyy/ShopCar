package com.yechao.demo;

import java.util.Scanner;

public class shopCarTest {
    public static void main(String[] args) {

        Goods[] shopCar = new Goods[100];

        while (true) {
            System.out.println("请选择要执行的操作：");
            System.out.println("添加购物车的商品：add");
            System.out.println("查询购物车的商品：query");
            System.out.println("修改商品的购买数量：update");
            System.out.println("结算金额：pay");
            System.out.println("请输入执行命令：");
            Scanner in = new Scanner(System.in);
            String commend = in.next();
            switch (commend){
                case "add":
                {
                    // 添加商品
                    addGoods(shopCar, in);
                    break;
                }
                case "query":
                {
                    // 查询商品
                    queryGoods(shopCar);
                    break;
                }
                case "update":
                {
                    // 更新商品购买数量
                    updateGoods(shopCar, in);
                    break;
                }
                case "pay":
                    // 结算金额
                    pay(shopCar);
                    break;
                default:
                    System.out.println("没有该功能！");
            }
        }
    }

    public static void pay(Goods[] shopCar) {
        double money = 0.0;
        for (int i = 0; i < shopCar.length; i++) {
            Goods g = shopCar[i];
            if (g != null){
                money += g.getPrice() * g.getBuyNumber();
            }else {
                break;
            }
        }
        System.out.println("您一共需要支付：" + money);
    }

    /*
    修改购物车中商品的购买数量
     */
    public static void updateGoods(Goods[] shopCar, Scanner in) {
        // 让用户输入要修改的商品id
        while (true){
            System.out.println("请输入您要修改数量的商品id：");
            int id = in.nextInt();
            Goods g = getGoodsById(shopCar, id);
            if (g == null){
                // 没有该商品
                System.out.println("对不起，您输入的商品id购物车中不存在，请重新输入！");
            }else {
                // 存在该商品，输入要修改的数量
                System.out.println("请输入" + g.getName() + "商品新的购买数量：");
                int buyNumber = in.nextInt();
                g.setBuyNumber(buyNumber);
                System.out.println("修改完成！");
                queryGoods(shopCar);
                break;
            }
        }
    }

    /*
    找出要查询的商品id是否在购物车中
     */
    public static Goods getGoodsById(Goods[] shopCar, int id){
        for (int i = 0; i < shopCar.length; i++) {
            Goods g = shopCar[i];
            if (g != null){
                // 判断改商品的id是不是我们要找的商品id
                if (g.getId() == id)
                return g;
            }else {
                return null;
            }
        }
        return null;// 找完了购物车中的100个商品都没有我们要找的商品id
    }

    /*
    完成查询商品，展示商品信息的功能
     */
    public static void queryGoods(Goods[] shopCar) {
        System.out.println("^^^^^^^^^^^^^^^^^查询商品的信息如下^^^^^^^^^^^^^^^^");
        System.out.println("编号\t\t\t名称\t\t\t价格\t\t\t购买数量");
        for (int i = 0; i < shopCar.length; i++) {
            Goods g = shopCar[i];
            if (g != null){
                // 展示商品信息
                System.out.println(g.getId() + "\t\t\t" + g.getName() + "\t\t\t\t" + g.getPrice() + "\t\t\t\t" + g.getBuyNumber());
            }else {
                break;
            }
        }

    }

    /*
    完成商品加入购物车的功能
     */
    public static void addGoods(Goods[] shopCar, Scanner in) {
        // 录入用户输入的购买商品的信息
        System.out.println("请输入您要购买的商品编号（不重复）：");
        int id = in.nextInt();
        System.out.println("请输入您要购买的商品名称：");
        String name = in.next();
        System.out.println("请输入您要购买的商品价格：");
        double price = in.nextDouble();
        System.out.println("请输入您要购买的商品购买数量：");
        int buyNumber = in.nextInt();

        // 把商品信息封装成一个商品对象
        Goods g = new Goods();
        g.setId(id);
        g.setName(name);
        g.setPrice(price);
        g.setBuyNumber(buyNumber);

        // 把这个商品添加到购物车去
        for (int i = 0; i < shopCar.length; i++) {
            if (shopCar[i] == null){
                shopCar[i] =g;
                break;
            }
        }
        System.out.println("商品" + g.getName() + "已成功加入购物车！");
    }
}
