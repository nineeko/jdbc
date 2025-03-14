package com.neeko.section03.delete;

import java.util.Scanner;

public class Appliction {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("삭제하고 싶은 메뉴의 코드: ");
        int menuCode = sc.nextInt();

        Menu menu = new Menu(menuCode);

        MenuService menuService = new MenuService();
        menuService.deleteMenu(menu);
    }
}
