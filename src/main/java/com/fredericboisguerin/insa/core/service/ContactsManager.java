package com.fredericboisguerin.insa.core.service;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

import com.fredericboisguerin.insa.model.Contact;

public class ContactsManager {

    private static final String EMAIL_REGEX = "^[a-zA-Z0-9._%+-]+@[a-zA-Z.-]+\\.[a-zA-Z]+$";
    private final List<Contact> contacts = new ArrayList<>();

    public void addContact(String name, String email, String phoneNumber)
            throws InvalidContactNameException, InvalidEmailException {
        if (name == null || name.isEmpty()) {
            throw new InvalidContactNameException();
        }
        if (email != null && !email.matches(EMAIL_REGEX)) {
            throw new InvalidEmailException();
        }
        contacts.add(new Contact(name, email, phoneNumber));
    }

    public void printAllContacts() {
        contacts.forEach(this::print);
    }

    public void searchContactByName(String name) {
        contacts.stream().filter(contact -> contact.nameMatches(name)).forEach(this::print);
    }

    private void print(Contact contact) {
        StringJoiner stringJoiner = new StringJoiner(", ");
        stringJoiner.add(contact.getName());
        String email = contact.getEmail();
        if (email != null) {
            stringJoiner.add(email);
        }
        String phoneNumber = contact.getPhoneNumber();
        if (phoneNumber != null) {
            stringJoiner.add(phoneNumber);
        }
        System.out.println(stringJoiner.toString());
    }
}
