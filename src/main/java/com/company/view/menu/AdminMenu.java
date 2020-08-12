package com.company.view.menu;

import com.company.authorization.view.impl.AuthorizationMenuImpl;
import com.company.view.Menu;
import com.company.view.menu.submenu.ProductMenu;
import com.company.view.menu.submenu.UserBlockMenu;
import com.company.view.menu.submenu.UserOrderMenu;

public class AdminMenu implements Menu {

    private final String[] adminMenuItems = {
            "\t\t\tADMIN MENU",
            "1. Block/unblock user",
            "2. Confirm/unconfirm user order",
            "3. Product menu",
            "4. Log out",
            "0. Exit"
    };

    @Override
    public void dropMenu() {
        showMenuItems(adminMenuItems);
        switch (enterChoice()) {
            case 1 -> new UserBlockMenu().dropMenu();
            case 2 -> new UserOrderMenu().dropMenu();
            case 3 -> new ProductMenu().dropMenu();
            case 4 -> new AuthorizationMenuImpl().authorization();
            case 0 -> exitMenu();
            default -> showWrongInputMassage();
        }
    }
}
