package com.example.kiosk;

public class MenuItem {
    private final String name;
    private final int price;
    private final String desc;

    public MenuItem(String name, int price, String desc){
        this.name = name;
        this.price = price;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public String getDesc() {
        return desc;
    }

    @Override
    public String toString(){
        return String.format(" : %-5s  | ￦ %-10d | %s", name, price, desc);
    }
}
