package lesson3;

import java.util.*;

public class PhoneBook {

    public static void main (String [] args) {
        List<String> ivanov = new ArrayList<>();
        List<String> petrov = new ArrayList<>();
        List<String> glebova = new ArrayList<>();

        ivanov.add(0, "9991234578");
        ivanov.add(1, "9644562378");
        petrov.add(0,"9249876521");
        petrov.add(1,"9994563917");
        glebova.add(0,"9999631485");

        HashMap<String, List<String>> phoneBook = new HashMap<>();
        phoneBook.put("Ivanov", (List<String>) ivanov);
        phoneBook.put("Petrov", (List<String>) petrov);
        phoneBook.put("Glebova", (List<String>) glebova);

        System.out.println(phoneBook);
    }

}
