package ru.geekbrains.lesson1;

public abstract class Wall extends Obstacle {
    private final int height;

    public Wall(String name, int height) {
        super(name);
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    @Override
    protected boolean moving(Human human) {
        System.out.println("The wall " + super.getName() + "heigth: " + this.height);

        human.jump();

        if (getHeight() <= human.getJumpLimit()) {
            System.out.println("Человек успешно перепрыгнул через стену");

            return true;
        } else {
            System.out.println("Человекне смог перепрыгнуть через стену");

            return false;
        }
    }

    @Override
    protected boolean moving(Robot robot) {
        System.out.println("The wall " + super.getName() + "heigth: " + this.height);

        robot.jump();

        if (getHeight() <= robot.getJumpLimit()) {
            System.out.println("Робот успешно перепрыгнул через стену");

            return true;
        } else {
            System.out.println("Робот смог перепрыгнуть через стену");

            return false;
        }
    }

    @Override
    protected boolean moving(Cat cat) {
        System.out.println("The wall " + super.getName() + "heigth: " + this.height);

        cat.jump();

        if (getHeight() <= cat.getJumpLimit()) {
            System.out.println("Кот успешно перепрыгнул через стену");

            return true;
        } else {
            System.out.println("Кот смог перепрыгнуть через стену");

            return false;
        }
    }
}
