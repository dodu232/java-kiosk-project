package com.example.kiosk;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Kiosk {

  private final List<Menu> menuList;
  private final ShoppingCart shoppingCart;
  private final Scanner sc;
  private final int SHOPPINGCART = 9;
  private final int END = 0;

  public Kiosk() {
    this.sc = new Scanner(System.in);
    this.menuList = new ArrayList<>();
    initMenu();
    this.shoppingCart = new ShoppingCart();
  }

  private void initMenu() {
    this.menuList.add(new Menu(Category.BURGERS));
    this.menuList.add(new Menu(Category.DRINKS));
    this.menuList.add(new Menu(Category.DESSERTS));
  }

  public void start() {
    System.out.println("----------- 도두 버거 -----------");
    System.out.println("도두 버거에 오신것을 환영합니다.");

    while (true) {
      printMainMenu();

      int idx = inputValidMenu(menuList.size());

      if (idx == END) {  // 0이면 종료
        break;
      } else if (idx == 9) { // 9면 장바구니 출력
        shoppingCart.printShoppingCart();
        System.out.println("1. 구매 2. 초기화 0. 뒤로가기");
        int select = inputValidSubMenu(END, 2);
        System.out.println();

        if (select == 0) {
          continue;
        } else if (select == 1) {
          System.out.println("구매가 완료 되었습니다.");
          shoppingCart.resetShoppingCart();
          break;
        } else if (select == 2) {
          System.out.println("장바구니를 비웠습니다.");
          shoppingCart.resetShoppingCart();
          continue;
        }
      }

      // 서브메뉴 출력
      idx--;
      Menu selectMenu = printSubMenu(idx);
      idx = inputValidSubMenu(END, selectMenu.getMenuItemList().size());

      if (idx == END) {
        continue;
      }

      // 선택한 메뉴 출력
      idx--;
      MenuItem selectSubMenu = printSelectMenu(selectMenu, idx);

      int select = inputValidSubMenu(1, 2);
      if (select == 1) {
        shoppingCart.addMenuItem(selectSubMenu);
      }
    }

    // 프로그램을 종료
    System.out.println("방문해 주셔서 감사합니다. ^____^");
  }

  // 카테고리 출력
  private void printMainMenu() {
    System.out.println();
    System.out.println("[ MAIN MENU ]");
    for (int i = 0; i < menuList.size(); i++) {
      System.out.println((i + 1) + menuList.get(i).toString());
    }
    if (!shoppingCart.checkShoppingCartEmpty()) {
      System.out.println("9.  " + shoppingCart.toString());
    }
    System.out.println("0.  종료");
  }

  // 서브메뉴 출력
  private Menu printSubMenu(int idx) {
    System.out.println();
    Menu selectMenu = menuList.get(idx);
    selectMenu.printMenuItemList();
    return selectMenu;
  }

  // 선택한 메뉴 출력
  private MenuItem printSelectMenu(Menu menu, int idx) {
    MenuItem subMenu = menu.getMenuItemList().get(idx);
    System.out.println();
    System.out.println("선택한 메뉴" + subMenu.toString());
    System.out.println("1. 추가 2. 취소");
    return subMenu;
  }

  private int inputValidMenu(int max) {
    while (true) {
      System.out.print("입력: ");
      try {
        int select = sc.nextInt();

        if (select >= END && select <= max) {
          return select;
        } else if (select == SHOPPINGCART && !shoppingCart.checkShoppingCartEmpty()) {
          return select;
        } else {
          System.out.println("범위 내의 숫자를 입력하세요. ");
        }
      } catch (InputMismatchException e) {
        System.out.println("정수를 입력하세요.");
      } finally {
        sc.nextLine();
      }
    }
  }

  private int inputValidSubMenu(int min, int max) {
    while (true) {
      System.out.print("입력: ");
      try {
        int select = sc.nextInt();

        if (!(select >= min && select <= max)) {
          System.out.println("범위 내의 숫자를 입력하세요. ");
        } else {
          return select;
        }
      } catch (InputMismatchException e) {
        System.out.println("정수를 입력하세요.");
      } finally {
        sc.nextLine();
      }
    }
  }
}
