package org.practice.general;

public class Temp1 {
    public static void main(String[] args) {
        Interf i = () -> System.out.println("Hello Lambda");
        i.m1();
        //System.out.println(prime(8));
    }

    public static String prime(int n){
        for(int i = 2; i < n; i++){
            if(n % i == 0){
                return n + " is not a Prime number";
            }
        }
        return n + " is a Prime Number";
    }

}
interface Interf{
    void m1();
}
