package com.example.kiosk;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Kiosk {
    private final List<Menu> menuList;
    private final Scanner sc;
    private final int END = -1;

    public Kiosk() {
        sc = new Scanner(System.in);
        menuList  = new ArrayList<>();
        initMenu();
    }

    private void initMenu(){
        menuList.add(new Menu("Burgers"));
        menuList.add(new Menu("Drinks"));
        menuList.add(new Menu("Desserts"));
    }

    public void start() {
        System.out.println("----------- 도두 버거 -----------");
        System.out.println("도두 버거에 오신것을 환영합니다.");

        while (true) {
            // 반복문을 활용해 List 안에 있는 MenuItem을 하나씩 출력
            System.out.println("[ MAIN MENU ]");
            for (int i = 0; i < menuList.size(); i++) {
                System.out.println((i + 1) + menuList.get(i).toString());
            }
            System.out.println("0 : 종료");

            // 숫자를 입력 받기
            int idx1 = checkInt();

            // 입력된 숫자에 따른 처리
            if (idx1 == END) {
                break;
            }

            // 선택한 메뉴 : 이름, 가격, 설명
            System.out.println();
            menuList.get(idx1).printMenuItemList();

            int idx2 = checkInt();

            if(idx2 == END){
                System.out.println();
                continue;
            }

            System.out.println("선택한 메뉴" + menuList.get(idx1).getMenuItemList().get(idx2));
            System.out.println();
        }

        // 프로그램을 종료
        System.out.println("방문해 주셔서 감사합니다. ^____^");
    }

    public int checkInt() {
        while (true) {
            System.out.print("메뉴를 선택해 주세요: ");
            try {
                int select = sc.nextInt() - 1;
                sc.nextLine();

                if (select < menuList.size() && select >= END) {
                    return select;
                }
                System.out.println("메뉴 판에 있는 번호를 입력하세요. ");
            } catch (InputMismatchException e) {
                System.out.println("정수를 입력하세요.");
                sc.nextLine();
            }
        }
    }
}
