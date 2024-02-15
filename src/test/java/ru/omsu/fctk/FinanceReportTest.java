
package ru.omsu.fctk;

import org.junit.Assert;
import org.junit.Test;

public class FinanceReportTest {

    @Test
    public void getCountOfPayments() {
        //8
        FinanceReport a = new FinanceReport();

        Payment one = new Payment("Скобенко Дмитрий Анатольевич", 30, 9, 2023, 117952);
        Payment two = new Payment();
        Payment three = new Payment("Петров Пётр Александрович", 20, 10, 2020, 789683245);
        FinanceReport b = new FinanceReport("Скобенко Дмитрий Анатольевич", 7, 12, 2027, one, two, three);

        Assert.assertEquals(3, b.getCountOfPayments());
        Assert.assertEquals(0, a.getCountOfPayments());

        //10

        FinanceReport c = new FinanceReport(b);
        Assert.assertEquals(b, c);
    }

    @Test
    public void getArrI() {
        //8
        Payment one = new Payment("Скобенко Дмитрий Анатольевич", 30, 9, 2023, 117952);
        Payment two = new Payment();
        Payment three = new Payment("Петров Пётр Александрович", 20, 10, 2020, 789683245);
        FinanceReport a = new FinanceReport("Скобенко Дмитрий Анатольевич", 7, 12, 2027, one, two, three);

        Assert.assertEquals(two, a.getArrI(1));
    }

    @Test
    public void setArrI() {
        //8
        Payment one = new Payment("Скобенко Дмитрий Анатольевич", 30, 9, 2023, 117952);
        Payment two = new Payment();
        Payment three = new Payment("Петров Пётр Александрович", 20, 10, 2020, 789683245);
        FinanceReport a = new FinanceReport("Скобенко Дмитрий Анатольевич", 7, 12, 2027, one, two, three);
        a.setArrI(2, one); //one two one

        Assert.assertEquals(one, a.getArrI(2));

        //10

        FinanceReport b = new FinanceReport(a);
        b.setArrI(1, three); //one three three

        Assert.assertNotEquals(a.getArrI(1), b.getArrI(1));
        Assert.assertNotSame(a, b); //не одно и то же
    }

//9
    @Test
    public void testToString() {
        FinanceReport a = new FinanceReport();

        Payment one = new Payment("Скобенко Дмитрий Анатольевич", 30, 9, 2023, 117952);
        Payment two = new Payment("Иванов Иван Иванович" ,1,1,0, 0);
        Payment three = new Payment("Петров Пётр Александрович", 20, 10, 2020, 789683245);
        FinanceReport b = new FinanceReport("Скобенко Дмитрий Анатольевич", 7, 12, 2027, one, two, three);

        System.out.println(b.toString());
        Assert.assertEquals("[Автор: Скобенко Дмитрий Анатольевич, Дата: 7.12.2027, Платежи: [" +
                "\n ОПЛАТА{ФИО: Скобенко Дмитрий Анатольевич; Дата: 30.9.2023; Сумма: 117952}" +
                "\n ОПЛАТА{ФИО: Иванов Иван Иванович; Дата: 1.1.0; Сумма: 0}" +
                "\n ОПЛАТА{ФИО: Петров Пётр Александрович; Дата: 20.10.2020; Сумма: 789683245}]]",b.toString());

    }
}