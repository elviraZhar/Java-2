package lesson3;

import sun.reflect.generics.tree.Tree;

import java.util.*;

public class PhoneBook {
    static class Contact {
        private String surname;
        private String name;

        Contact(String surname, String name) {
            this.surname = surname;
            this.name = name;
        }
         public String getSurname() {
            return surname;
        }

    }

    public static void main (String [] args) {
        List<Contact> contacts = new ArrayList<>();
        contacts.add(0, new Contact("Petrov", "Ivan"));
        contacts.add(1, new Contact("Sidorov", "Igor"));
        contacts.add(2, new Contact("Petrov", "Igor"));
        contacts.add(3, new Contact("Egorova", "Olga"));
        contacts.add(4, new Contact("Sidorov", "Denis"));

        HashMap<List<Contact>, String> phoneBook = new HashMap<>();
        phoneBook.put((List<Contact>) contacts.get(0), "9991234578");
        phoneBook.put((List<Contact>) contacts.get(1), "9997894512");
        phoneBook.put((List<Contact>) contacts.get(2), "9994561278");
        phoneBook.put((List<Contact>) contacts.get(3), "9641234589");
        phoneBook.put((List<Contact>) contacts.get(4), "9247892356");


    }
}
