package ru.omsu.fctk;
import java.util.Arrays;
import java.util.Objects;
import java.lang.String;
public class FinanceReport {
    private Payment[] payments;
    private String name;
    private int day;
    private int month;
    private int year;

    //8

    public FinanceReport() {
    payments = new Payment[0];
        name = "Скобенко Дмитрий Анатольевич";
        day = 1;
        month = 1;
        year = 0;
    }
    public int getCountOfPayments () { return payments.length; }

    public Payment getArrI(int i) {
        return payments[i];
    }

    public void setArrI(int i, Payment otherPay) { payments[i]=otherPay; }

    //
    FinanceReport(String person, int d,int m, int y, Payment...one_pay){
        payments = new Payment[one_pay.length];

        for (int i = 0; i < payments.length; i++) {
            payments[i]=one_pay[i];
        }
        name = person;
        day = d;
        month = m;
        year = y;
    }
    //10
    FinanceReport(FinanceReport a){
        payments = new Payment[a.getCountOfPayments()];

        for (int i = 0; i < payments.length; i++) {
            payments[i]=a.getArrI(i);
        }
        name = a.getName();
        day = a.getDay();
        month = a.getMonth();
        year = a.getYear();
    }
        /*public FinanceReport(Payment[] arr) {
            payments = arr;
        }*/

        public Payment[] getArr() {
            return payments;
        }

        public void setArr(Payment... arr) {
            for(int i=0;i<arr.length;i++) {
                payments[i]=arr[i];
            }
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getDay() {
            return day;
        }

        public void setDay(int day) {
            this.day = day;
        }

        public int getMonth() {
            return month;
        }

        public void setMonth(int month) {
            this.month = month;
        }

        public int getYear() {
            return year;
        }

        public void setYear(int year) {
            this.year = year;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof FinanceReport)) return false;
            FinanceReport that = (FinanceReport) o;
            return getDay() == that.getDay() && getMonth() == that.getMonth() &&
                    getYear() == that.getYear() && Arrays.equals(getArr(), that.getArr()) && Objects.equals(getName(), that.getName());
        }

//9

    @Override
    public String toString() {
        String all_pay = "";
        for (Payment i: payments) {
            all_pay = all_pay.concat(i.toString());
        }
        return String.format("[Автор: %s, Дата: %d.%d.%d, Платежи: [%s]]", name, day, month, year, all_pay);
    }
}
