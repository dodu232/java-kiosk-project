package com.example.kiosk;

public class MenuPrinter {

    public void printMenuList() {
        System.out.println("----------- 도두 버거 -----------");
        System.out.println("도두 버거에 오신것을 환영합니다.");

        for(int i=0; i<Burger.values().length; i++){
            System.out.println( (i+1) + " : " + Burger.values()[i]);
        }
        System.out.println("0 : 종료" );
        System.out.print("메뉴를 선택해 주세요: ");
    }
}
