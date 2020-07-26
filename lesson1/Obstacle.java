package ru.geekbrains.lesson1;

public abstract class Obstacle {
    private String name;

    public Obstacle(String name) {
        this.name = name;
    }

    protected abstract boolean moving(Human human);

    protected abstract boolean moving(Robot robot);

    protected abstract boolean moving(Cat cat);

    public String getName() {
        return name;
    }
}
