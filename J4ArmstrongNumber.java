import java.util.Scanner;
import java.math.*;
public class J4ArmstrongNumber{
    public static void main(String[] args) {
        int n;
        Scanner sc= new Scanner(System.in);
        System.out.print("Enter the number: ");
        n=sc.nextInt();
        int r=n;
        int r2=n;
        int count=0;
        while(n>0){
            n=n/10;
            count++;
        }
        System.out.println("Number of Digits is "+count);
        int sum=0;
        while(r>0){
            int k=r%10;
            sum=(int) (sum+ Math.pow(k,count));
            r=r/10;
        }
        System.out.println(sum);
        if(r2==sum){
            System.out.println("It is a armstrong number!!");
        }
        else{
            System.out.println("It is not a Armstrong number..");
        }
        sc.close();
    }
}