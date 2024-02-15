package ru.omsu.fctk;
import java.util.Objects;
public class Payment {
    private String name;
    private int day;
    private int month;
    private int year;
    private int total;
    public Payment(String name, int day, int month, int year, int total) {
        this.name = name;
        this.day = day;
        this.month = month;
        this.year = year;
        this.total = total;
    }
    String getName() { return name; }
    void setName(String name) { this.name = name; }
    int getDay() { return day; }
    void setDay(int day) { this.day = day; }
    int getMonth() { return month; }
    void setMonth(int month) { this.month = month; }
    int getYear() { return year; }
    void setYear(int year) { this.year = year; }
    int getTotal() { return total; }
    void setTotal(int total) { this.total = total; }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Payment payment = (Payment) o;
        return day == payment.day && month == payment.month && year == payment.year &&
                total == payment.total && Objects.equals(name, payment.name);
    }
    @Override
    public int hashCode() {
        return Objects.hash(name, day, month, year, total);
    }
    @Override
    public String toString() {
        return  "\n ОПЛАТА{" + "ФИО: " + name +
                "; Дата: " + day + "." + month + "." + year +
                "; Сумма: " + total + '}';
    }

    public Payment() {}
}
