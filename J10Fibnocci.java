import java.util.Scanner;

public class J10Fibnocci {
    public static void main(String[] args) {
        int n;
        Scanner sc= new Scanner(System.in);
        System.out.print("Enter the number : ");
        n=sc.nextInt();
        System.out.println(F(n));
        sc.close();
    }
    public static int F(int n){
        if(n==0) return 0;
        if(n==1) return 1;
        else return F(n-1)+F(n-2);
    }
}
