package ru.geekbrains.lesson5;

import java.util.Arrays;

public class Les5 {
    static final int size = 1000;
    static final int h = size / 2;

    public static void main(String[] args) {
        float[] arr = new float[size];

        fillArray(arr); //заполняем еденицами
        long time = System.currentTimeMillis(); // запускаем отсчет
        System.out.println("Метод №1");
        System.out.println("Запуск " + Arrays.toString(arr));
        method1(arr); //вычисляем новое значение ячеек
        System.out.println("Время выполнения " + (System.currentTimeMillis() - time));
        System.out.println("После окончания " + Arrays.toString(arr));

        fillArray(arr); //заполняем еденицами
        System.out.println();
        System.out.println("Метод №2");
        System.out.println("Запуск " + Arrays.toString(arr));
        time = System.currentTimeMillis();
        method2(arr); //вычисляем новое значение ячеек
        System.out.println("Время выполнения " + (System.currentTimeMillis() - time));
        System.out.println("После окончания " + Arrays.toString(arr));

    }

    /**
     * заполняем массив еденицами
     * @param a
     */
    private static void fillArray(float[] a) {
        for (int i = 0; i < a.length; i++)
            a[i] = 1;
    }

    /**
     * вычисляем значение каждой ячейки
     * @param a
     */
    private static void method1(float[] a) {
        for (int i = 0; i < a.length; i++)
            a[i] = (float) (a[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
    }

    private static void method2New(float[] a, int h) {
        for (int i = 0; i < a.length; i++) {
            a[i] = (float) (a[i] * Math.sin(0.2f + (i + h) / 5) * Math.cos(0.2f + (i + h) / 5) * Math.cos(0.4f + (i + h) / 2));
        }
    }

    private static void method2(float[] a) {
        float[] a1 = new float[h];
        float[] a2 = new float[h];
        System.arraycopy(a, 0, a1, 0, h);
        System.arraycopy(a, h, a2, 0, h);

        System.out.println("Поток a1 до " + Arrays.toString(a1));
        System.out.println("Поток a2 до " + Arrays.toString(a2));

        new Thread(() -> Les5.method2New(a1, 0)).start();
        new Thread(() -> Les5.method2New(a2, h)).start();

        System.out.println("Поток a1 после " + Arrays.toString(a1));
        System.out.println("Поток a2 после " + Arrays.toString(a2));

        System.arraycopy(a1, 0, a, 0, h);
        System.arraycopy(a2, 0, a, h, h);
    }


}