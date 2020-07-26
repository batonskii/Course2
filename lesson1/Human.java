package ru.geekbrains.lesson1;

public class Human implements Action{
    String object;
    String name;
    private int runLimit;
    private int jumpLimit;

    public Human(String object, String name, int runLimit, int jumpLimit) {
        this.object = object;
        this.name = name;
        this.runLimit = runLimit;
        this.jumpLimit = jumpLimit;
    }

    public Human() {
    }

    public int getRunLimit() {
        return this.runLimit;
    }


    public int getJumpLimit() {
        return this.jumpLimit;
    }


    @Override
    public void jump(){
        System.out.println(object + this.name + " совершил прыжок на " + this.getJumpLimit() + " метров");
    }

    @Override
    public void run(){
        System.out.println(object + this.name + " побежал "+ this.getRunLimit() + " метров");
    }

}
