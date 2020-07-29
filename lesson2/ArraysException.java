package ru.geekbrains.lesson2;


public class ArraysException {
    public static void main(String[] args) {

        int result =0;


        // Создаем 3 массива.

        String [][] arrayTry = {{"1","0","1","0"},{"1","0","1","0"}};
        String [][] arrayExceptionSize = {{"1","0","1","0","2","3"},{"1","0","1"}}; //ошибка в размерности массива
        String [][] arrayExceptionData = {{"1","0","6n","0"},{"1","0","1","0"}}; //ошибка в формате данных

        //корректный блок
        System.out.println("Корректная работа: ");

        try{
            result=checkArray(arrayTry);              //проверка
        }catch (MyArraySizeException | MyArrayDataException e){     //проверка на размер массива и формат данных
            System.out.println(e.getMessage());
        }
        finally {
            System.out.println("Количество элементов массива : "+ String.valueOf(result));
        }

        System.out.println("\n");

        //некорректный размер массива

        System.out.println("Неверный размер массива: ");
        try {
            result = checkArray(arrayExceptionSize);  //проверка
        }catch (MyArraySizeException | MyArrayDataException e){ //проверка на размер массива,корректность данных
            System.out.println(e.getMessage());
        }
        finally {
            System.out.println("Количество элементов массива : "+ String.valueOf(result));

        }
        System.out.println("\n");

        //некорректные данные

        System.out.println("Неверный ввод данных: ");
        try {
            result = checkArray(arrayExceptionData);  //проверка
        }catch (MyArraySizeException | MyArrayDataException e){ //проверка на размер массива,корректность данных
            System.out.println(e.getMessage());
        }
        finally {
            System.out.println("Количество элементов массива : "+ String.valueOf(result));
        }

        System.out.println("\nРабота программы завершена");
    }

    public static int checkArray(String[][] array) throws MyArraySizeException, MyArrayDataException {

        int sum=0;
        int num=0;

        if(array[0].length!=4 || array.length !=2) { // проверка -должно быть 2 ряда, и 4 элемента
            throw new MyArraySizeException();        //если нет выводим ошибку
        }
        for (int i = 1; i<3; i++) {       //отсчет с 1 .  всего 2 ряда
            for (int j = 1; j<array[0].length; j++) {   //отсчет с 1. проверка на 4 элемента в ряду

                try{
                    num = Integer.parseInt(array[i-1][j-1]); //первый элемент с индексом 0
                    sum += num;                              // подсчет элементов
                } catch (IllegalArgumentException e){
                    String message = String.valueOf(i)+" ряд, "+String.valueOf(j)+" элемент";
                    throw new MyArrayDataException(message);
                }
            }
        }
        return sum;
    }

}


     class MyArraySizeException extends RuntimeException {
        public MyArraySizeException(){
            super("Некорректный размер массива! ");
        }
    }
    class MyArrayDataException extends RuntimeException {
        public MyArrayDataException(String message) {
            super("Некорректные данные "+ message);
        }
    }

