import java.util.Scanner;

public class Array {
    Array(int Rows) {
        arr = new int[Rows];
    }

    private int[] arr;

    public int[] getArr() {
        return arr;
    }

    public boolean createArr() {
        Scanner in = new Scanner(System.in);
        for (int i = 0; i < getArr().length; i++) {
            getArr()[i] = in.nextInt();
        }
        if (arr.length == 0) {
            return false;
        } else {
            return true;
        }
    }
    public void PrintArr() {
        for (int i = 0; i < getArr().length; i++) {
            System.out.println("arr[" + i + "] = " + getArr()[i]);
        }
    }

    public double SumArr() {
        double sum = 0;
        for (int i = 0; i < getArr().length; i++) {
            sum += arr[i];
        }
        return sum;
    }

    public int evenNumber() {
        int cnt = 0;
        for (int i = 0; i < getArr().length; i++) {
            if (arr[i] % 2 == 0) {
                cnt++;
            }
        }
        return cnt;

    }

    public int Interval(int a, int b){
        int cnt = 0;
        for (int i = 0; i < getArr().length; i++) {
            if (a < arr[i] && arr[i] < b) {
                cnt++;
            }
        }
        return cnt;

    }
    public boolean CheckNumber(){
        int cnt = 0;
        for (int i = 0; i < getArr().length; i++) {
            if (arr[i] < 0) {
                cnt++;
            }
        }
        if(cnt == 0){
            return true;
        }
        else{
            return false;
        }
    }
    public void permutation(){
        int start = 0;
        int end = getArr().length - 1;
        while(end > start){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}