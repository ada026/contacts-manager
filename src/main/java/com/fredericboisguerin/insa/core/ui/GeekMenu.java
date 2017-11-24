package com.fredericboisguerin.insa.core.ui;

import java.util.Scanner;
import java.util.StringJoiner;

public class GeekMenu {
    private static final String LINE_SEPARATOR = System.lineSeparator();
    private static final String CHOICES = new StringJoiner(LINE_SEPARATOR).add("Actions :")
            .add("0: exit")
            .add("1: print all contacts")
            .add("2: search for a contact")
            .add("3: add a contact")
            .toString();

    private final GeekUI geekUI;

    public GeekMenu(GeekUI geekUI) {
        this.geekUI = geekUI;
    }

    public void display() throws Exception {
        Scanner scanner = new Scanner(System.in);
        int choice = -1;
        while (choice != 0) {
            System.out.print(CHOICES);
            choice = scanner.nextInt();
            switch (choice) {
            case 1:
                geekUI.printAllContacts();
                break;
            case 2:
                geekUI.askForNameToSearch();
                break;
            case 3:
                geekUI.askForContactInformation();
                break;
            }
        }
    }
}
