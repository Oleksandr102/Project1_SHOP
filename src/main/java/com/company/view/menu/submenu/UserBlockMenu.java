package com.company.view.menu.submenu;

import com.company.service.UserServiceImpl;
import com.company.view.Menu;
import com.company.view.menu.AdminMenu;

import static com.company.config.Scanner.readString;

public class UserBlockMenu implements Menu {
    UserServiceImpl userService = new UserServiceImpl();
    private final String[] subMenuUserBlockItems = {
            "\t\tBLOCK USER MENU",
            "1. Block user",
            "2. Unblock user",
            "3. Back",
            "0. Exit"
    };

    public void blockUser() {
        System.out.println("\t\tUSER BLOCKING");
        System.out.print("Enter user ID for blocking: ");
        int id = Integer.parseInt(readString());
        userService.userBlock(id);
        System.out.println("User with ID " + id + " was blocked\n");
        pauseMenu();
        this.dropMenu();
    }

    public void unblockUser() {
        System.out.println("\t\tUSER UNBLOCKING");
        System.out.print("Enter user ID for unblocking: ");
        int id = Integer.parseInt(readString());
        userService.userUnblock(id);
        System.out.println("User with ID" + id + " was unblocked\n");
        pauseMenu();
        this.dropMenu();
    }

    @Override
    public void dropMenu() {
        showMenuItems(subMenuUserBlockItems);
        switch (enterChoice()) {
            case 1 -> blockUser();
            case 2 -> unblockUser();
            case 3 -> new AdminMenu().dropMenu();
            case 0 -> exitMenu();
            default -> showWrongInputMassage();
        }
    }
}
