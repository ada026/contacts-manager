package com.fredericboisguerin.insa.contactsmanager.core.ui;

import java.util.Scanner;

import com.fredericboisguerin.insa.contactsmanager.core.service.ContactsManager;
import com.fredericboisguerin.insa.contactsmanager.core.service.InvalidEmailException;
import com.fredericboisguerin.insa.contactsmanager.core.service.InvalidContactNameException;

public class GeekUI {
    private final ContactsManager contactsManager;

    public GeekUI(ContactsManager contactsManager) {
        this.contactsManager = contactsManager;
    }

    public void askForContactInformation() throws InvalidEmailException, InvalidContactNameException {
        Scanner scanner = createScanner();
        String name = scanner.nextLine();
        String email = scanner.nextLine();
        String phoneNumber = scanner.nextLine();
        contactsManager.addContact(name, email, phoneNumber);
    }

    public void askForNameToSearch() {
        Scanner scanner = createScanner();
        String pattern = scanner.nextLine();
        contactsManager.searchContactByName(pattern);
    }

    public void printAllContacts() {
        contactsManager.printAllContacts();
    }

    private static Scanner createScanner() {
        return new Scanner(System.in);
    }
}
