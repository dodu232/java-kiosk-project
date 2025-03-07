package com.example.kiosk;

public class Kiosk {
    private final MenuPrinter menuPrinter;
    private final InputManager inputManager;

    public Kiosk() {
        this.menuPrinter = new MenuPrinter();
        this.inputManager = new InputManager();
    }

    public void run() {
        boolean flag = true;
        do {
            // 메뉴 출력
            menuPrinter.printMenuList();

            // 선택
            int select = inputManager.checkRange(Burger.values().length);

            if (select == 0) {
                flag = false;
            } else {
                System.out.println(Burger.values()[select - 1].getBurger() + "는 " + Burger.values()[select - 1].getPrice() + "원 입니다.");
                System.out.println();
            }
        } while (flag);
        System.out.println("방문해 주셔서 감사합니다. ^____^");
    }
}
