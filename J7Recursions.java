import java.util.Scanner;
public class J7Recursions {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n=sc.nextInt();
        sc.close();
        NName(n);
        System.out.println();
        Num1toN(n,1);
        System.out.println();
        NumNto1(n);
        System.out.println();
        System.out.println("Sum of n numbers is "+SumN(n));
        System.out.println("Factorial of n numbers is "+ProN(n));
    }
    public static void NName(int n){
        if(n>0) {System.out.print("Monu ");NName(n-1); }
        else return;
    }
    public static void Num1toN(int n,int x){
        if(n>=x){
            System.out.print(x+" ");
            Num1toN(n, x+1);
        }
    }
    public static void NumNto1(int n){
        if(n>0){
            System.out.print(n+" ");
            NumNto1(n-1);
        }
    }
    public static int SumN(int n){
        int sum=0;
        if(n>0){
            sum=n+SumN(n-1);
        }
        else return 0;
        return sum;
    }public static int ProN(int n){
        int pro=1;
        if(n>0){
            pro=n*ProN(n-1);
        }
        else return 1;
        return pro;
    }
}
