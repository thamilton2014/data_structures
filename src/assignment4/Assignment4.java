package assignment4;

/**
 * Created by THamilton on 6/25/2014.
 */
public class Assignment4 {

    public static void main(String[] args){
        int count = 15;
        int key = 0;
        while(count < 30){
            count = count * 3;
            key++;
            printInt(key);
        }
    }

    public static void checkAlgorithm(int n){
        System.out.println(Math.log(n)/Math.log(2));
        System.out.println(n);
        System.out.println((Math.log(n)/Math.log(2)) * n);
        System.out.println(Math.pow(n,2));
        System.out.println(Math.pow(n,3));
        System.out.println(Math.pow(2,n));
    }

    public static void algorithm8(){
        int n = 75;
        int count = 0;
        for(int i = 0; i < n; i++){
            count++;
            for(int j = 0; j < i; j++){
                count++;

            }
        }
        printInt(count);
    }



    public static void algorithm7(){
        int n = 20;
        int counter = 0;
        for(int k = 0; k < 10; k++){
            counter++;
            for(int i = 0; i < n; i++ ){
                counter++;
                for(int j = 0; j < n; j++){
                    counter++;
                }
            }
        }
        printInt(counter);
    }

    public static void algorithm6(){
        int count = 0;
        int n = 20;
        for(int i = 0; i < n; i++){
            count++;
            for(int j = 0; j < n; j++){
                count++;
            }
        }
        printInt(count);
    }

    public static void algorithm5(){
        int n = 20;
        for(int i = 0; i < n; i++){
            printStr(i + " *" );
        }
    }

    public static void printInt(int msg){
        System.out.println(msg);
    }

    public static void printStr(String msg){
        System.out.println(msg);
    }

    public static Integer algorithm1(){
        int itr = 0;
        int count = 1;
        while(count < 30) {
            count = count * 2;
            itr++;
        }
        return itr;
    }

    public static Integer algorithm2(){
        int itr = 0;
        int count = 15;
        while (count < 30){
            count = count * 3;
            itr++;
        }
        return itr;
    }

    public static Integer algorithm3(){
        int itr = 0;
        int count = 1;
        int n = 30;
        while (count < n){
            count = count * 2;
            itr++;
        }
        return itr;
    }

    public static Integer algorithm4(int n){
        int itr = 0;
        int count = 15;
        while (count < n){
            count = count * 3;
            itr++;
        }
        return itr;
    }


}
