package com.example.kiosk;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

  private final List<MenuItem> shoppingList;
  private int total;

  //  생성자
  public ShoppingCart() {
    this.shoppingList = new ArrayList<>();
    this.total = 0;
  }

  // 장바구니 추가
  public void addShoppingCart(MenuItem menu) {
    this.shoppingList.add(menu);
    this.total += menu.getPrice();
  }

  // 장바구니 초기화
  public void resetShoppingCart() {
    this.shoppingList.clear();
  }

  // 장바구니 목록 출력
  public void printShoppingCart() {
    int sum = 0;
    for (MenuItem item : this.shoppingList) {
      System.out.println(item.toString());
      sum += item.getPrice();
    }
    System.out.println(sum);
  }

  @Override
  public String toString() {
    return String.format("장바구니 상품: %s개, 합계: %d원", this.shoppingList.size(), this.total);
  }
}
