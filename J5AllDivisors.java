import java.util.Scanner;

public class J5AllDivisors {
    public static void main(String[] args) {
        int n;
        Scanner sc= new Scanner(System.in);
        System.out.print("Enter the number : ");
        n=sc.nextInt();
        sc.close();
        System.err.print("The divisors are: ");
        for(int i=1;i<n;i++){
            if(n%i==0){
                System.out.print(i+" ");
            }
        }
    }
}
