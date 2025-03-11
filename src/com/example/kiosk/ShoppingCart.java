package com.example.kiosk;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private final List<MenuItem> shoppingList;

    //  생성자
    public ShoppingCart(){
        shoppingList = new ArrayList<>();
    }

    // 장바구니 추가
    public void addShoppingCart(MenuItem menu){
        shoppingList.add(menu);
    }

    // 장바구니 초기화
    public void resetShoppingCart(){
        shoppingList.clear();
    }

    // 장바구니 목록 출력
    public void printShoppingCart(){
        for(MenuItem item: shoppingList){
            System.out.println(item.toString());
        }
        System.out.println();
    }
}
