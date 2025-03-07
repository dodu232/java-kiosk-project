package com.example.kiosk;

public enum Burger {
    CLASSICBURGER("클래식 버거", 4900, "토마토, 양상추, 케찹이 들어간 기본 버거"),
    CHEESEBURGER("치즈 버거  ", 5400, "치즈와 케찹이 들어간 혈관 막히는 치즈 버거"),
    BULGOGIBURGER("불고기 버거", 5900, "불고기 소스가 들어간 다 아는 맛, 불고기 버거"),
    SHRIMPBURGER("새우 버거  ", 5400, "새우가 들어간 새우 버거");
    private final String burger;
    private final int price;
    private final String desc;

    private Burger(String burger, int price, String desc){
        this.burger = burger;
        this.price = price;
        this.desc = desc;
    }

    public String getBurger(){
        return burger;
    }

    public int getPrice() {
        return price;
    }

    public String getDesc() {
        return desc;
    }

    @Override
    public String toString(){
        return String.format("%-5s  | ￦ %-10d | %s", burger, price, desc);
    }
}
