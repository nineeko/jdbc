package com.neeko.section02.update;

import java.util.Scanner;

public class Appliction {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("새 메뉴 이름 : ");
        String menuName = sc.nextLine();
        System.out.print("새 메뉴 가격 : ");
        int menuPrice = sc.nextInt();
        System.out.print("수정하고 싶은 메뉴의 코드: ");
        int menuCode = sc.nextInt();

        Menu menu = new Menu(menuName, menuPrice, menuCode);

        MenuService menuService = new MenuService();
        menuService.modifyMenu(menu);
    }
}
