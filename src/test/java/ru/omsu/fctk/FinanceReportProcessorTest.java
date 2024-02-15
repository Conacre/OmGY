
package ru.omsu.fctk;

import org.junit.Assert;
import org.junit.Test;

public class FinanceReportProcessorTest {

    @Test
    public void returnPaymentsWithLetters() {

        FinanceReport a = new FinanceReport();

        Payment one = new Payment("Скобенко Дмитрий Анатольевич", 30, 9, 2023, 117952);
        Payment two = new Payment("Петров Пётр Александрович", 20, 10, 2020, 789683245);
        FinanceReport b = new FinanceReport("Скобенко Дмитрий Анатольевич", 7, 12, 2027, one, two);

        Assert.assertEquals(a, FinanceReportProcessor.returnPaymentsWithLetters('С', a));
        Assert.assertNotEquals(b, FinanceReportProcessor.returnPaymentsWithLetters('Р', b));
    }

    @Test
    public void returnPaymentsWithLessMoney() {
        FinanceReport a = new FinanceReport();

        Payment one = new Payment("Скобенко Дмитрий Анатольевич", 30, 9, 2023, 117952);
        Payment two = new Payment("Петров Пётр Александрович", 20, 10, 2020, 789683245);
        FinanceReport b = new FinanceReport("Скобенко Дмитрий Анатольевич", 7, 12, 2027, one, two);
        FinanceReport c = new FinanceReport("Скобенко Дмитрий Анатольевич", 7, 12, 2027, one);

        Assert.assertEquals(a, FinanceReportProcessor.returnPaymentsWithLessMoney(0, a));
        Assert.assertEquals(c, FinanceReportProcessor.returnPaymentsWithLessMoney(789683245, b));
        Assert.assertEquals(new FinanceReport("Скобенко Дмитрий Анатольевич", 7, 12, 2027), FinanceReportProcessor.returnPaymentsWithLessMoney(0, b));
        Assert.assertNotEquals(c, FinanceReportProcessor.returnPaymentsWithLessMoney(117952, b));
    }
}
