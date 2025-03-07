package com.example.kiosk;

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
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
}
