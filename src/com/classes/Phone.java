package com.classes;

import java.util.ArrayList;
import java.util.Collection;

public class Phone {
    private String phoneNumber;
    ArrayList<Contact> myContacts;

    public Phone(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        this.myContacts = new ArrayList<Contact>();
    }

    public boolean addNewContact(Contact contact) {
        if (findContact(contact.getName()) >= 0) {
            System.out.println("Contact is already on file");
            return false;
        }

        myContacts.add(contact);
        System.out.println("Contact added");
        return true;
    }

    public boolean updateContact (Contact oldContact, Contact newContact){
        int foundPosition = findContact(oldContact);
        if(foundPosition <0){
            System.out.println("Contact not found");
            return false;
        } else if(findContact(newContact.getName()) != -1){
            System.out.println("Contact with name " + newContact.getName() + " already exists. Update failed");
            return false;
        }

        this.myContacts.set(foundPosition, newContact);
        System.out.println(oldContact.getName() + "Was replaced with " + newContact .getName());
        return true;

    }

    public boolean removeContact(Contact contact){
        int foundPosition = findContact(contact);
        String name = contact.getName();
        if(foundPosition <0){
            System.out.println("Contact not found");
            return false;
        }
        this.myContacts.remove(foundPosition);
        System.out.println(name + " was deleted");
        return true;
    }


    private int findContact(Contact contact) {
        return this.myContacts.indexOf(contact);
    }

    private int findContact(String contactName) {
        for (int i = 0; i < this.myContacts.size(); i++) {
            Contact contact = this.myContacts.get(i);
            if (contact.getName().equals(contactName)) {
                return i;
            }
        }
        return -1;
    }


    public Contact queryContact(String name){
        int position = findContact(name);
        if(position >=0){
            return this.myContacts.get(position);
        }
        return null;
    }

    public String queryContact(Contact contact){
        if(findContact(contact) >= 0){
            return contact.getName();
        }
        return null;
    }

    public void printContacts(){
        System.out.println(myContacts.size() + " Contacts in the list");
        for(int i = 0; i<this.myContacts.size(); i++){
            System.out.println((i+1) + ". " +
                    this.myContacts.get(i).getName() + " -> "
                    + this.myContacts.get(i).getPhoneNumber());
        }
    }

    public void printPhoneNumber(){
        System.out.println("My phone number is " + this.phoneNumber);
    }

}


