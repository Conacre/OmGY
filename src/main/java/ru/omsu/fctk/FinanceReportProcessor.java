
package ru.omsu.fctk;

import java.util.ArrayList;

public class FinanceReportProcessor {
    public static FinanceReport returnPaymentsWithLetters(char c, FinanceReport one) {
        if (one.getCountOfPayments() != 0) {
            ArrayList<Payment> arr = new ArrayList<>();
            for (int i = 0; i < one.getCountOfPayments(); i++) {
                if (one.getArrI(i).getName().charAt(0) == c) {
                    arr.add(one.getArrI(i));
                }
            }
            if (arr.isEmpty()) {
                return new FinanceReport(one.getName(), one.getDay(), one.getMonth(), one.getYear());
            }
            return new FinanceReport(one.getName(), one.getDay(), one.getMonth(), one.getYear(), arr.toArray(new Payment[0]));
        }
        else return new FinanceReport(one.getName(), one.getDay(), one.getMonth(), one.getYear());
    }

    public static FinanceReport returnPaymentsWithLessMoney(int money, FinanceReport one) {
        if (one.getCountOfPayments() != 0) {
            ArrayList<Payment> arr = new ArrayList<>();
            for (int i = 0; i < one.getCountOfPayments(); i++) {
                if (one.getArrI(i).getTotal() < money) {
                    arr.add(one.getArrI(i));
                }
            }
            if (arr.isEmpty()) {
                return new FinanceReport(one.getName(), one.getDay(), one.getMonth(), one.getYear());
            }
            return new FinanceReport(one.getName(), one.getDay(), one.getMonth(), one.getYear(), arr.toArray(new Payment[0]));
        }
        else return new FinanceReport(one.getName(), one.getDay(), one.getMonth(), one.getYear());
    }
}
