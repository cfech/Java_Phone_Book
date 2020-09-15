package com.classes;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static Phone phone = new Phone("12234323");


    public static void main(String[] args) {
        // write your code here
        boolean quit = false;
        startPhone();
        printActions();
        while (!quit) {
            System.out.println("Enter action (0 to show available actions)");
            int action = scanner.nextInt();
            scanner.nextLine();

            switch (action) {
                case 0:
                    printActions();
                    break;
                case 1:
                    phone.printContacts();
                    break;
                case 2:
                    addContact();
                    break;
                case 3:
                    updateContact();
                    break;
                case 4:
                    removeContact();
                    break;
                case 5:
                    queryContact();
                    break;
                case 6:
                    phone.printPhoneNumber();
                    break;
                case 7:
                    System.out.println("Goodbye");
                    quit = true;
                    break;
            }
        }

    }

    private static void addContact() {
        System.out.println("Enter contact name");
        String name = scanner.nextLine().toLowerCase();
        System.out.println("Enter contact phone number");
        String number = scanner.nextLine();
        Contact newPerson = Contact.createContact(name, number);
        if (phone.addNewContact(newPerson)) {
            System.out.println("New contact added " + name + " phone number -> " + number);
        } else {
            System.out.println("Cant add, name already on file");
        }
    }

    private static void updateContact() {
        phone.printContacts();
        System.out.println("Enter the name of the contact you wish to update");
        String name = scanner.nextLine().toLowerCase();
        Contact existingContact = phone.queryContact(name);
        if (existingContact == null) {
            System.out.println("Contact not found");
            return;
        }

        System.out.println("Enter new contact name ");
        String newName = scanner.nextLine().toLowerCase();
        System.out.println("Enter new phone number");
        String newNumber = scanner.nextLine();
        Contact newContact = Contact.createContact(newName, newNumber);

        if (phone.updateContact(existingContact, newContact)) {
            System.out.println("Successfully updated contact");
        } else {
            System.out.println("Error updating record");
        }
    }

    private static void removeContact() {
        phone.printContacts();
        System.out.println("Enter the name of the contact you wish to remove");
        String name = scanner.nextLine().toLowerCase();
        Contact existingContact = phone.queryContact(name);
        if (existingContact == null) {
            System.out.println("Contact not found");
            return;
        }

        if (phone.removeContact(existingContact)) {
            System.out.println("Successfully removed contact");
        } else {
            System.out.println("Error updating record");
        }
    }


    private static void queryContact() {
        System.out.println("Enter the name of the contact you want to search for");
        String name = scanner.nextLine().toLowerCase();
        Contact existingContact = phone.queryContact(name);
        if (existingContact == null) {
            System.out.println("Contact not found");
            return;
        }

        System.out.println("Name: " + existingContact.getName() + "-> Phone: " + existingContact.getPhoneNumber());
    }


    public static void startPhone() {
        System.out.println("starting phone");
    }

    private static void printActions() {
        System.out.println("\n Available actions \nPress");
        System.out.println("\t 0 - to print a list of available actions");
        System.out.println("\t 1 - to print contacts");
        System.out.println("\t 2 - to add a new contact");
        System.out.println("\t 3 - to modify an existing contact");
        System.out.println("\t 4 - to remove an existing contact");
        System.out.println("\t 5 - to search for a contact");
        System.out.println("\t 6 - to print my phone number");
        System.out.println("\t 7 - to shut down ");
        System.out.println("Choose your action: ");
    }

}
