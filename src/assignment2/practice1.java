package assignment2;

/**
 * Created by THamilton on 6/10/2014.
 */
public class practice1 {

    public static void main(String[] arg){
        complicatedSum(6);
    }
    public static int complicatedSum(int n) {
        int count = 0;
        if (n <= 3) {
            System.out.println(count);
            return n;
        }
        else if (n % 3 == 0) {
            count++;
            System.out.println(count);
            return n * 3 + complicatedSum(n - 1);
        }
        else if (n % 3 == 2) {
            count++;
            System.out.println(count);
            return n * 2 + complicatedSum(n - 1);
        }
        else
        count++;
        System.out.println(count);
        return n + complicatedSum(n-1);
    }
}
