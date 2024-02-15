package ru.omsu.fctk;

public class StringProcessor {
    String CopyNTimeS(int N, String s) {
        if (N > 1) {
            String a = "";
            for (int i = 0; i < N; i++) {
                a += s;
            }
            return a;
        } else if (N == 1) {
            return s;
        } else if (N == 0) {
            return "";
        } else {
            throw new IllegalArgumentException("Отрицательный параметр N");
        }
    }

    int CountTimesInString (String a, String b){
        if(b == null){
            throw new IllegalArgumentException ("Строка b - null");
        } else if(b.isEmpty()){
            throw new IllegalArgumentException ("Строка b - пустая");
        } else if(a == null){
            throw new IllegalArgumentException ("Строка a - null");
        } else if(a.isEmpty()){
            throw new IllegalArgumentException ("Строка a - пустая");
        } else{
            int i = 0;
            int count = 0;
            do{
                i = a.indexOf(b,i);
                count++;
                i++;
            } while(i != 0 && i < a.length());
            return count-1;
        }
    }

    public String ReplaceNumbersWithWords(String a) {
        String b, c, d;
        b = a.replaceAll("1", "один");
        c = b.replaceAll("2", "два");
        d = c.replaceAll("3", "три");
        return d;
    }

    void ChangeEverySecondSymbol(StringBuilder a) {
        for (int i = 1; i < a.length(); i += 2) {
            a.delete(i, i + 1);
            i--;
        }
    }
}