import java.util.Scanner;

public class J3PrimeNumber {
    public static void main(String[] args) {
        int n;
        Scanner sc= new Scanner(System.in);
        System.out.print("Enter the number : ");
        n=sc.nextInt();
        if(checkPrime(n)) System.out.println("It is a prime number!!");
        else System.out.println("Not a prime number ");
        sc.close();
    }
    public static Boolean checkPrime(int n){
        int count=0;
        for(int i=1;i<n;i++){
            if(n%i==0) count++;
        }
        if(count==1) return true;
        else return false; 
    }
}
