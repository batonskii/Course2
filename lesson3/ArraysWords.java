package ru.geekbrains.lesson3;

import java.util.HashMap;

public class ArraysWords {
    public static void main(String[] args) {
        String[] arrSchool ={"home work","computer","score","board","pen","lesson","photo","children","teacher","lesson","bell","chalk","diary","photo","score","home work","lesson","class"};
        HashMap<String, Integer> school = new HashMap<>();
        for (String x : arrSchool) {
            school.put(x, school.getOrDefault(x,0)+1);
        }
        System.out.println(school);
    }
}
