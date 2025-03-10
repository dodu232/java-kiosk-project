package com.example.kiosk;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Kiosk {
    private final List<MenuItem> menuItemList = new ArrayList<>();
    private final Scanner sc;

    public Kiosk(){
        sc = new Scanner(System.in);
        menuItemList.add(new MenuItem("클래식 버거", 4900, "토마토, 양상추, 케찹이 들어간 기본 버거"));
        menuItemList.add(new MenuItem("치즈 버거  ", 5400, "치즈와 케찹이 들어간 혈관 막히는 치즈 버거"));
        menuItemList.add(new MenuItem("불고기 버거", 5900, "불고기 소스가 들어간 다 아는 맛, 불고기 버거"));
        menuItemList.add(new MenuItem("새우 버거  ", 5400, "새우가 들어간 새우 버거"));
    }

    public void start(){
        System.out.println("----------- 도두 버거 -----------");
        System.out.println("도두 버거에 오신것을 환영합니다.");

        final int END = -1;

        while (true) {
            // 반복문을 활용해 List 안에 있는 MenuItem을 하나씩 출력
            for (int i = 0; i < menuItemList.size(); i++) {
                System.out.println((i + 1) + menuItemList.get(i).toString());
            }
            System.out.println("0 : 종료");

            // 숫자를 입력 받기
            int select;
            while (true) {
                System.out.print("메뉴를 선택해 주세요: ");
                try {
                    select = sc.nextInt() - 1;
                    sc.nextLine();

                    if (select < menuItemList.size() && select >= END) {
                        break;
                    }
                    System.out.println("메뉴 판에 있는 번호를 입력하세요. ");
                } catch (InputMismatchException e) {
                    System.out.println("정수를 입력하세요.");
                    sc.nextLine();
                }
            }

            // 입력된 숫자에 따른 처리
            if (select == END) {
                break;
            }

            // 선택한 메뉴 : 이름, 가격, 설명
            System.out.println(menuItemList.get(select).getName() + "는 " + menuItemList.get(select).getPrice() + "원 입니다.");
            System.out.println();
        }

        // 프로그램을 종료
        System.out.println("방문해 주셔서 감사합니다. ^____^");
    }
}
