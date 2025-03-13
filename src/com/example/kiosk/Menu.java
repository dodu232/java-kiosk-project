package com.example.kiosk;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// menuItem List를 가진 카테고리 클래스
public class Menu {

  private final List<MenuItem> menuItemList;
  private final Category category;

  public Menu(Category category) {
    this.category = category;
    this.menuItemList = new ArrayList<>();
    init();
  }

  private void init() {
    switch (this.category) {
      case BURGERS -> {
        this.menuItemList.add(new MenuItem("클래식 버거", 4900, "토마토, 양상추, 케찹이 들어간 기본 버거"));
        this.menuItemList.add(new MenuItem("치즈 버거  ", 5400, "치즈와 케찹이 들어간 혈관 막히는 치즈 버거"));
        this.menuItemList.add(new MenuItem("불고기 버거", 5900, "불고기 소스가 들어간 다 아는 맛, 불고기 버거"));
        this.menuItemList.add(new MenuItem("새우 버거  ", 5400, "새우가 들어간 새우 버거"));
      }
      case DRINKS -> {
        this.menuItemList.add(new MenuItem("콜라       ", 2000, "스파클링 원탑"));
        this.menuItemList.add(new MenuItem("사이다     ", 2000, "청량청량해"));
        this.menuItemList.add(new MenuItem("물         ", 1300, "진정한 제로 칼로리"));
      }
      case DESSERTS -> {
        this.menuItemList.add(new MenuItem("감자 튀김  ", 4900, "이거 안시키면 맛알못"));
        this.menuItemList.add(new MenuItem("오징어 튀김", 5400, "가끔 먹고싶은 별미"));
        this.menuItemList.add(new MenuItem("치킨너겟   ", 5900, "머스타드와 함께"));
      }
    }
  }

  // List를 리턴하는 함수
  public List<MenuItem> getMenuItemList() {
    return Collections.unmodifiableList(this.menuItemList);
  }

  // category에 소속된 menuItem을 모두 출력
  public void printMenuItemList() {
    System.out.println("[ " + this.category.getLabel() + " ]");
    for (int i = 0; i < this.menuItemList.size(); i++) {
      System.out.println((i + 1) + this.menuItemList.get(i).toString());
    }
    System.out.println("0.  뒤로가기");
  }

  public String toString() {
    return String.format(".  %s", this.category.getLabel());
  }
}
