package com.example.kiosk;

// 메뉴 항목을 나타내는 클래스
public class MenuItem {

  private final String name;
  private final int price;
  private final String desc;

  public MenuItem(String name, int price, String desc) {
    this.name = name;
    this.price = price;
    this.desc = desc;
  }

  public int getPrice() {
    return this.price;
  }

  @Override
  public String toString() {
    return String.format(".  %-5s  | ￦ %-10d | %s", this.name, this.price, this.desc);
  }

  public String toShoppingCartFormat() {
    return String.format("%-5s  | ￦ %-8d|  ", this.name, this.price);
  }
}
