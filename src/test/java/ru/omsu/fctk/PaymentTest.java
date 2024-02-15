package ru.omsu.fctk;

import org.junit.Test;
import static org.junit.Assert.*;

public class PaymentTest {

    //объекты равны и их хешкоды тоже
    @Test
    public void testEqualsAndHashCode() {
        Payment payment1 = new Payment("Скобенко Дмитрий Анатольевич", 12, 2, 2024, 50000);
        Payment payment2 = new Payment("Скобенко Дмитрий Анатольевич", 12, 2, 2024, 50000);

        assertEquals(payment1, payment2);
        assertEquals(payment1.hashCode(), payment2.hashCode());
    }
    //объекты не равны
    @Test
    public void testNotEquals() {
        Payment payment1 = new Payment("Скобенко Дмитрий Анатольевич", 12, 2, 2024, 50000);
        Payment payment2 = new Payment("НеСкобенко Дмитрий Анатольевич", 12, 2, 2024, 50000);

        assertNotEquals(payment1, payment2);
    }
    //сравниваем вывод ту стринг с написанным тут выводом
    @Test
    public void testToString() {
        Payment payment = new Payment("Скобенко Дмитрий Анатольевич", 12, 2, 2024, 50000);
        String expected = "ОПЛАТА{ФИО: Скобенко Дмитрий Анатольевич; Дата: 12.2.2024; Сумма: 50000}";
        assertEquals(expected, payment.toString());
    }
}