package ru.geekbrains.lesson1;

public class Test {
    public static void main(String[] args) {

        Action[] actions = new Action[3];


        actions[0] = new Cat("Кот","Мурзик",100,2);
        actions[1] = new Robot("Робот","R2-D2",1000,200);
        actions[2] = new Human("Человек","Боб",200,1);



        for (Action action : actions) {

        }
    }
}
