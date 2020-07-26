package ru.geekbrains.lesson1;

public abstract class Treadmill extends Obstacle {
    private final int distance;

    public Treadmill(String name, int distance) {
        super(name);
        this.distance = distance;
    }

    public int getDistance() {
        return distance;
    }

    @Override
    protected boolean moving(Human human) {
        System.out.println("Дорожка  " + super.getName() + " дистанция : " + this.distance);

        human.run();

        if (getDistance() <= human.getRunLimit()) {
            System.out.println("Человек успешно пробежал дистанцию ");

            return true;
        } else {
            System.out.println("Человек не смог пробежать дистанцию ");

            return false;
        }
    }

    @Override
    protected boolean moving(Robot robot) {
            System.out.println("Дорожка  " + super.getName() + " дистанция : " + this.distance);

            robot.run();

            if (getDistance() <= robot.getRunLimit()) {
                System.out.println("Робот успешно пробежал дистанцию ");

                return true;
            } else {
                System.out.println("Робот не смог пробежать дистанцию ");

                return false;
            }
        }

    @Override
    protected boolean moving(Cat cat) {
        System.out.println("Дорожка  " + super.getName() + " дистанция : " + this.distance);

        cat.run();

        if (getDistance() <= cat.getRunLimit()) {
            System.out.println("Кот успешно пробежал дистанцию ");

            return true;
        } else {
            System.out.println("Кот не смог пробежать дистанцию ");

            return false;
        }
    }
}
