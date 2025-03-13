package com.example.kiosk;

import java.util.ArrayList;
import java.util.List;

// 메뉴 아이템을 장바구니에 추가하고 총 가격을 관리
public class ShoppingCart {

  private final List<MenuItem> shoppingList;
  private int totalPrice;

  //  생성자
  public ShoppingCart() {
    this.shoppingList = new ArrayList<>();
    this.totalPrice = 0;
  }

  // 장바구니 추가
  public void addMenuItem(MenuItem menu) {
    this.shoppingList.add(menu);
    this.totalPrice += menu.getPrice();
  }

  // 장바구니 초기화
  public void resetShoppingCart() {
    this.shoppingList.clear();
    this.totalPrice = 0;
  }

  // 장바구니 비었는지 확인
  public boolean checkShoppingCartEmpty() {
    return this.shoppingList.isEmpty();
  }

  // 장바구니 목록 출력
  public void printShoppingCart() {
    System.out.println();
    if (this.shoppingList.isEmpty()) {
      System.out.println("장바구니가 비어 있습니다.");
      return;
    }
    System.out.println("----장바구니 목록----");
    for (int i = 0; i < this.shoppingList.size(); i++) {
      System.out.println((i + 1) + this.shoppingList.get(i).toString());
    }
    System.out.println(this);
  }

  @Override
  public String toString() {
    return String.format("장바구니 상품: %s개, 합계: %d원", this.shoppingList.size(), this.totalPrice);
  }
}
