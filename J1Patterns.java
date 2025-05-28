import java.util.Scanner;
public class J1Patterns{
    public static void main(String[] args) {
        int n;
        Scanner sc= new Scanner(System.in);
        System.out.print("Inter number of rows: ");
        n=sc.nextInt();
        Star_Pattern1(n);
        Star_Pattern2(n);
        Star_Pattern3(n);
        Star_Pattern4(n);
        Star_Pattern5(n);
        Num_Pattern1(n);
        Num_Pattern2(n);
        Num_Pattern3(n);
       sc.close();
    }

    public static void Star_Pattern1(int n){
        for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    System.out.print("*");
                }
                System.out.println();
        }
    }
    public static void Star_Pattern2(int n){
        for(int i=1;i<=n;i++){
                for(int j=1;j<=i;j++){
                    System.out.print("*");
                }
                System.out.println();
        }
    }
    public static void Star_Pattern3(int n){
        for(int i=1;i<=n;i++){
                for(int j=n+1-i;j>0;j--){
                    System.out.print("*");
                }
                System.out.println();
        }
    }
    public static void Star_Pattern4(int n){
        int r=2*n-1;
        for(int i=1;i<n+1;i++){
            int k=n-i;
            for(int j=0;j<k;j++){
               System.err.print(" ");
            }
            for(int j=0;j<(r-2*k);j++){
               System.err.print("*");
            }
            for(int j=0;j<k;j++){
                System.err.print(" ");
            }
            System.out.println();
                
        }
    }
    public static void Star_Pattern5(int n){
        for(int i=1;i<n+1;i++){
            int k=i-1;
            while(k>0){
                System.out.print(" ");
                k--;
            }
            for(int j=n-i;j>0;j--){
                System.out.print("*");
            }
            System.err.print("*");//middle
            for(int j=n-i;j>0;j--){
                System.out.print("*");
            }
            System.out.println();
        }
    }
    public static void Num_Pattern1(int n){
        for(int i=1;i<=n;i++){
                for(int j=1;j<=i;j++){
                    System.out.print(j);
                }
                System.out.println();
        }
    }
     public static void Num_Pattern2(int n){
        for(int i=1;i<=n;i++){
                for(int j=1;j<=i;j++){
                    System.out.print(i);
                }
                System.out.println();
        }
    }
    public static void Num_Pattern3(int n){
        for(int i=1;i<=n;i++){
            int k=1;
                for(int j=n+1-i;j>0;j--){
                    System.out.print(k++);
                }
                System.out.println();
        }
    }
}
