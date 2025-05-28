import java.util.Scanner;

public class J2CountDigits {
    public static void main(String[] args) {
        int n;
        Scanner sc= new Scanner(System.in);
        System.out.print("Enter the number: ");
        n=sc.nextInt();
        int count=0;
        while(n>0){
            n=n/10;
            count++;
        }
        sc.close();
        System.out.println("Number of Digits is "+count);

    }
}
