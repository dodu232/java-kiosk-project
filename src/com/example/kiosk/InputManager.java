package com.example.kiosk;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputManager {
    private Scanner sc;

    public InputManager(){
        sc = new Scanner(System.in);
    }

    public int inputInt(){
        while(true){
            try{
                return sc.nextInt();
            }catch(InputMismatchException e){
                System.out.println("정수를 입력하세요.");
            }
        }
    }

    public int checkRange(int max){
        while(true){
            try {
                int select = inputInt();
                if(select < 0 || select > max){
                    throw new OutOfRangeException("메뉴 안에 있는 값만 입력하세요.");
                }
                return select;
            } catch (OutOfRangeException e){
                System.out.println(e.getMessage());
            }
        }
    }

}
