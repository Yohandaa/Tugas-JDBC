package com.PBO11;

import java.util.Scanner;

public class Kasir implements Login {
    String password = "yoyo1000";
    String captcha = "3Yvc5T";
    String inputCaptcha;
    String inputPassword;

    //method login
    public void login(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("================ LOGIN ================");

        //Captcha
        System.out.println("Kode captcha = " + captcha);
        System.out.println("Masukkan captcha");
        inputCaptcha = scanner.next();

        while(!inputCaptcha.equalsIgnoreCase(captcha)){
            System.out.println("KODE TIDAK BENAR\n");
            System.out.println("Masukkan captcha");
            inputCaptcha = scanner.next();
        }

        System.out.println("CAPTCHA BENAR\n\n");

        //Password
        System.out.println("Masukkan Password");
        inputPassword = scanner.next();

        while(!inputPassword.equals(password)){
            System.out.println("PASSWORD SALAH\n");
            System.out.println("Masukkan password : ");
            inputPassword = scanner.next();
        }
        
        System.out.println("BERHASIL LOGIN\n\n");


    }
}
