package com.mabdullaev.lesson2;


import com.mabdullaev.lesson2.config.AppConfig;
import com.mabdullaev.lesson2.controller.MainMenu;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        MainMenu menu = context.getBean(MainMenu.class);
        menu.showMenu();

        System.out.println("pause");
    }


}
