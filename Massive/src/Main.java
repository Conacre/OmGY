import java.io.IOException;
import java.sql.SQLOutput;
import java.util.Scanner;
import java.util.SortedMap;

import static java.lang.Math.sqrt;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Задайте длину массива:");
        int Rows = 0;
        int numberTask2;
        Rows = in.nextInt();
        Array arr = new Array(Rows);
        do {
            System.out.println("0 - Чтобы завершить.");
            System.out.println("1 - Ввод элементов массива с клавиатуры.");
            System.out.println("2 - Вывод массива на консоль.");
            System.out.println("3 - Сумма всех элементов массива.");
            System.out.println("4 - Количество четных чисел в массиве.");
            System.out.println("5 - Количество элементов массива, принадлежащих отрезку [a; b].");
            System.out.println("6 - Проверка: все ли элементы массива положительные.");
            System.out.println("7-  Переставьте в массиве элементы в обратном порядке.");

            numberTask2 = in.nextInt();

            switch (numberTask2) {
                case 1 -> {
                    System.out.println("Введите массив:");
                    boolean key = arr.createArr();
                    if (key) {
                        System.out.println("Массив создан!");
                    } else {
                        System.out.println("Не удалось создать массив :(");
                    }
                }
                case 2 -> arr.PrintArr();
                case 3 -> {
                    double key = arr.SumArr();
                    System.out.println("Сумма всех элементов массива:");
                    System.out.println(key);
                }
                case 4 -> {
                    System.out.println("Количество четных чисел в массиве " + arr.evenNumber());
                }
                case 5 -> {
                    System.out.println("Введите a: ");
                    int a = in.nextInt();
                    System.out.println("Введите b: ");
                    int b = in.nextInt();
                    System.out.println("Количество элементов массива, принадлежащих отрезку [" + a + ":" + b + "] = " + arr.Interval(a, b));
                }
                case 6 -> {
                    if (arr.CheckNumber()) {
                        System.out.println("Все элементы массива положительные!");
                    } else {
                        System.out.println("Все элементы массива отрицательные!");
                    }
                }
                case 7 -> {
                    System.out.println("Массив:");
                    arr.PrintArr();
                    System.out.println("Новый массив:");
                    arr.permutation();
                    arr.PrintArr();
                }
            }
        } while (numberTask2 != 0);
    }
}
