package com.fredericboisguerin.insa.core.ui;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.io.ByteArrayInputStream;

import org.junit.Before;
import org.junit.Test;

import com.fredericboisguerin.insa.core.service.ContactsManager;

public class GeekUITest {

    private static final String LINE_SEPARATOR = System.lineSeparator();
    private static final String SOME_PHONE_NUMBER = "some phone number";
    private static final String SOME_EMAIL = "some email";
    private static final String SOME_NAME = "some name";

    private GeekUI geekUI;
    private ContactsManager contactsManager;

    @Before
    public void setUp() throws Exception {
        contactsManager = mock(ContactsManager.class);
        geekUI = new GeekUI(contactsManager);
    }

    @Test
    public void should_add_a_contact_to_contacts_manager_when_user_enter_contact_information() throws Exception {
        setUserInput(SOME_NAME + LINE_SEPARATOR + SOME_EMAIL + LINE_SEPARATOR + SOME_PHONE_NUMBER + LINE_SEPARATOR);

        geekUI.askForContactInformation();

        verify(contactsManager).addContact(SOME_NAME, SOME_EMAIL, SOME_PHONE_NUMBER);
    }

    @Test
    public void should_search_contact_when_user_enter_a_name_to_search() throws Exception {
        setUserInput(SOME_NAME + LINE_SEPARATOR);

        geekUI.askForNameToSearch();

        verify(contactsManager).searchContactByName(SOME_NAME);
    }

    @Test
    public void should_print_all_contacts_from_contacts_manager() throws Exception {
        geekUI.printAllContacts();

        verify(contactsManager).printAllContacts();
    }

    private void setUserInput(String input) {
        byte[] inputAsBytes = input.getBytes();
        System.setIn(new ByteArrayInputStream(inputAsBytes));
    }
}