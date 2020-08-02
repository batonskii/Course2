package ru.geekbrains.lesson3;

public class TestPhoneBook {
    public static void main(String[] args) {

        Phonebook contact = new Phonebook();

        Phonebook book = new Phonebook();
        book.addContact("Иванов", "8-921-000-00-01");
        book.addContact("Петров", "8-902-555-45-67");
        book.addContact("Иванов", "76-52-02");
        book.addContact("Тихомиров", "8-900-320-43-43");

        // ищем по имени
        book.find("Иванов");
        book.find("Тихомиров");

    }
}
