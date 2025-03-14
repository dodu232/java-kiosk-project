package com.example.kiosk;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
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
                System.out.println("1. 구매 2. 비우기 0. 뒤로가기");
                int select = inputValidInt(END, 2);
                System.out.println();

                if (select == 0) {
                    continue;
                } else if (select == 1) {
                    System.out.println("할인 정보를 입력해주세요.");
                    for (int i = 0; i < DiscountPercent.values().length; i++) {
                        System.out.println((i + 1) + "" + DiscountPercent.values()[i]);
                    }
                    int type = inputValidInt(1, 3);

                    DiscountPercent dis = null;

                    switch (type) {
                        case 1 -> dis = DiscountPercent.SOLDIER;
                        case 2 -> dis = DiscountPercent.STUDENT;
                        case 3 -> dis = DiscountPercent.GENERAL;
                    }

                    int amount = shoppingCart.getTotalPrice() * (100 - dis.getDiscountRate()) / 100;

                    System.out.println(
                        "구매가 완료 되었습니다. 금액은 " + amount + "원 입니다.");
                    break;
                } else if (select == 2) {
                    removeMenuItem();
                    continue;
                }
            }

            // 서브메뉴 출력
            idx--;
            Menu selectMenu = printSubMenu(idx);
            idx = inputValidInt(END, selectMenu.getMenuItemList().size());

            if (idx == END) {
                continue;
            }

            // 선택한 메뉴 출력
            idx--;
            MenuItem selectSubMenu = printSelectMenu(selectMenu, idx);

            int select = inputValidInt(1, 2);
            if (select == 1) {
                shoppingCart.addMenuItem(selectSubMenu);
            }
        }

        // 프로그램을 종료
        System.out.println("방문해 주셔서 감사합니다. ^____^");
    }

    // 장바구니 비우기
    private void removeMenuItem() {
        while (true) {
            shoppingCart.printShoppingCart();
            System.out.print("비우고 싶은 메뉴를 입력해주세요: ");
            String menu = sc.nextLine();
            boolean found = false;

            for (Map.Entry<MenuItem, Integer> entry : shoppingCart.getShoppingCartList()
                .entrySet()) {
                if (ShoppingCart.equalsIgnoreWhitespace(entry.getKey().getName(), menu)) {
                    found = true;
                }
            }

            if (found) {
                shoppingCart.removeMenuItem(menu);
                break;
            } else {
                System.out.println("해당 메뉴가 장바구니에 없습니다. 다시 입력해주세요.");
            }
        }
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

    private int inputValidInt(int min, int max) {
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
