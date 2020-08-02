package ru.geekbrains.lesson3;

import java.util.HashMap;
import java.util.HashSet;

public class Phonebook {
    HashMap<String, HashSet<String>> phonebook;

    public Phonebook() {
        this.phonebook = new HashMap<>();
    }


    public void addContact (String name, String phone){
        HashSet<String> number = phonebook.getOrDefault(name, new HashSet<>());
        number.add(phone);
        phonebook.put(name, number);
    }

    public void find(String name) {
        System.out.println("Контакт: " + name + " тел. " + phonebook.getOrDefault(name, new HashSet<>()));
    }
}
