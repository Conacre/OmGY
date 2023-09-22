import java.util.Scanner;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.SortedMap;

import static java.lang.Math.sqrt;

public class Main {

    public static void main(String[] args) {
//------1. Хеллоу мир-------------------------------------------------------------—
// System.out.println("Hello, World!");

//------2. Три вещественных числа.------------------------------------------------—
// Scanner in = new Scanner(System.in);
// System.out.print("Enter 3 number: ");
// double num1 = in.nextDouble();
// double num2 = in.nextDouble();
// double num3 = in.nextDouble();
// double ans1 = num1 * num2 * num3;
// double ans2 = (num1 + num2 + num3)/3;
// double x;
// System.out.printf("Umnojenie: %f \n", ans1);
// System.out.printf("Average: %f \n", ans2);
// if (num1 > num2) {
// x = num1; num1 = num2; num2 = x;
// }
// if (num2 > num3) {
// x = num2; num2 = num3; num3 = x;
// }
// if (num1 > num2) {
// x = num1; num1 = num2; num2 = x;
// }
// System.out.printf("sort: %f %f %f \n", num1, num2, num3);
// in.close();

//------3. Три целых числа.-------------------------------------------------------—
// Scanner in = new Scanner(System.in);
// System.out.print("Enter 3 number: ");
// int num1 = in.nextInt();
// int num2 = in.nextInt();
// int num3 = in.nextInt();
// int ans1 = num1 * num2 * num3;
// double ans2 = (num1 + num2 + num3)/3.0;
// int x;
// System.out.printf("Umnojenie: %d \n", ans1);
// System.out.printf("Average: %f \n", ans2);
// if (num1 > num2) {
// x = num1; num1 = num2; num2 = x;
// }
// if (num2 > num3) {
// x = num2; num2 = num3; num3 = x;
// }
// if (num1 > num2) {
// x = num1; num1 = num2; num2 = x;
// }
// System.out.printf("sort: %d %d %d \n", num1, num2, num3);
// in.close();

//------4. ax^2+bx+c=0.-----------------------------------------------------------—
// Scanner in = new Scanner(System.in);
// System.out.println("Программа решает квадратное уравнение вида:");
// System.out.println("ax^2 + bx + c = 0");
// System.out.println("Введите a, b и c:");
// double a = in.nextDouble();
// double b = in.nextDouble();
// double c = in.nextDouble();
// double dis = 0;
// dis = b * b - 4 * a * c;
// if (dis < 0) {
// System.out.println("Нет однозначного решени");
// } else if (a != 0) {
// if (dis > 0) {
// double x1 = (-b - sqrt(dis)) / (2. * a);
// double x2 = (-b + sqrt(dis)) / (2. * a);
// if (x1 == -0) {
// x1 = 0;
// }
// System.out.println("Кол-во корней: 2 \n x1 = " + x1 + " \n x2 = " + x2);
//
// } else {
// double x1 = -b / (2. * a);
// if (x1 == -0) {
// x1 = 0;
// }
// System.out.println("Кол-во корней: 1 \n x1 = " + x1);
// }
// } else {
// if (b != 0) {
// double x1 = -c / b;
// if (x1 == -0) {
// x1 = 0;
// }
// System.out.println("Кол-во корней: 1 \n x1 = " + x1);
// } else {
// System.out.println("Нет однозначного решения");
// }
// }


//------5. Табулирование функции sin(x).------------------------------------------—
// Scanner in = new Scanner(System.in);
// System.out.println("Введите пределы: ");
// double a = in.nextInt();
// double b = in.nextInt();
// System.out.println("Задайте шаг: ");
// double step = in.nextInt();
// int k = 0;
// if (a < b && step >= 0) {
// for (double x = a; x < b; x += step) {
// double sine = Math.sin(x);
// a += step;
// System.out.println("sin(" + a + ") = " + sine);
// }
// }
// else {
// System.out.println("Некорректный предел");
// }

//------6. Системы двух линейных уравнений.---------------------------------------—
//        Scanner in = new Scanner(System.in);
//        System.out.println("Введите первое уравнение вида Ax+By=C:");
//        double a1 = in.nextDouble();
//        double b1 = in.nextDouble();
//        double c1 = in.nextDouble();
//        System.out.println("Введите второе уравнение вида Ax+By=C:");
//        double a2 = in.nextDouble();
//        double b2 = in.nextDouble();
//        double c2 = in.nextDouble();
//        double detFirstMatrix = a1 * b2 - b1 * a2;
//        double detSecondMatrix = b1 * c2 - c1 * b2;
//        double detThirdMatrix = a1 * c2 - c1 * a2;
//        if (detFirstMatrix == 0 && detSecondMatrix == 0 && detThirdMatrix == 0)  {
//            System.out.println("Бесконеное число решений");
//        } else if (detFirstMatrix == 0) {
//            System.out.println("Нет решений");
//        } else {
//            double rootFirst = detSecondMatrix / detFirstMatrix;
//            double rootSecond = detThirdMatrix / detFirstMatrix;
//            System.out.println("X = " + rootFirst + " Y = " + rootSecond);
//        }

//------7. Ряд Тейлора. —---------------------------------------------------------—
        double x;
        double num_terms;
        System.out.println("Х: ");
        x = in.nextDouble();
        System.out.println("Точность: ");
        num_terms = in.nextDouble();
        double res;
        Sexponenta(x, num_terms);
    }
    private static int Fucktorial(int n) {
        int result = (int) 1.0;
        for (int i = 1; i <= n; ++i) {
            result *= i;
        }
        return result;
    }
    private static double Sexponenta(double x, double num_terms) {
        double result = 1.0;
        for (int n = 1; n <= num_terms; ++n) {
            result += Math.pow(x, n) / Fucktorial(n);
        }
        System.out.println("Exp(" + x + ") = " + result);
        return result;
   }
}
