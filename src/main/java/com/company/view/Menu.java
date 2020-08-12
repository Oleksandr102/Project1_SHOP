package com.company.view;

import static com.company.config.Scanner.readString;

public interface Menu {
    default void showMenuItems(String[] menuItems) {
        for (String item : menuItems) {
            System.out.println(item);
        }
    }

    default int enterChoice() {
        String menuLine = "-------------------------------";
        System.out.println(menuLine);
        System.out.print("Enter a number, please: ");
        Integer choice = null;
        choice = Integer.parseInt(readString());
        if (choice == null) {
            System.out.println("Enter only numbers!");
            enterChoice();
        }
        System.out.println(menuLine);
        return choice;
    }

    default void pauseMenu() {
        System.out.println("Press Enter to continue");
        readString();
    }

    default void exitMenu() {
        System.exit(0);
    }

    default void showWrongInputMassage() {
        System.out.println("Wrong input, try one more time");
        pauseMenu();
        this.dropMenu();
    }

    void dropMenu();
}
