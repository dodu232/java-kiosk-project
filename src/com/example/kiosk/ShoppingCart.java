package com.example.kiosk;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

// 메뉴 아이템을 장바구니에 추가하고 총 가격을 관리
public class ShoppingCart {

  private final Map<MenuItem, Integer> shoppingList;
  private int totalPrice;

  //  생성자
  public ShoppingCart() {
    this.shoppingList = new HashMap<>();
    this.totalPrice = 0;
  }

  // 총 금액 반환
  public int getTotalPrice() {
    return this.totalPrice;
  }

  public Map<MenuItem, Integer> getShoppingCartList() {
    return this.shoppingList;
  }

  // 장바구니 추가
  public void addMenuItem(MenuItem menu) {
    this.shoppingList.put(menu, this.shoppingList.getOrDefault(menu, 0) + 1);
    this.totalPrice += menu.getPrice();
  }

  // 장바구니 물건 삭제
  public void removeMenuItem(String menu) {
    Map<MenuItem, Integer> shoppingList = this.shoppingList.entrySet().stream()
        .filter(item -> !(equalsIgnoreWhitespace(item.getKey().getName(), menu)))
        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

    this.shoppingList.clear();
    this.shoppingList.putAll(shoppingList);

    this.totalPrice = shoppingList.entrySet().stream()
        .filter(item -> !(equalsIgnoreWhitespace(item.getKey().getName(), menu)))
        .mapToInt(item -> item.getKey().getPrice() * item.getValue())
        .sum();
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
    shoppingList.entrySet().stream()
        .forEach(item -> System.out.println(
            item.getKey().toShoppingCartFormat() + item.getValue() + "개  |  ￦ " +
                (item.getKey()).getPrice() * item.getValue()));
    System.out.println(this);
  }

  public static boolean equalsIgnoreWhitespace(String s1, String s2) {
    if (s1 == null || s2 == null) {
      return s1 == s2;
    }
    return s1.replaceAll("\\s+", "").equals(s2.replaceAll("\\s+", ""));
  }

  @Override
  public String toString() {
    int quantity = shoppingList.values().stream().reduce(0, Integer::sum);
    return String.format("장바구니 상품: %s개, 합계: %d원", quantity,
        this.totalPrice);
  }
}
