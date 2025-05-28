import java.util.Scanner;

public class J6ReverseNumber {
    public static void main(String[] args) {
        int n;
        Scanner sc= new Scanner(System.in);
        System.out.print("Enter the number : ");
        n=sc.nextInt();
        int rev=0;
        int k;
        int r=n;
        n=Math.abs(n);
        while(n>0){
            k=n%10;    //last digit
            n=n/10;
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && k> 7)){rev=0;break;};
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && k< -8)) {rev=0; break;};
            rev=rev*10+k;
        }
        if(r<0) System.out.println(-rev);
        else System.out.println(rev);
        checkPalindrome(rev, r);
    }
    public static void checkPalindrome(int a,int b){
        if(a==b){
            System.out.println("It is a palindrome NUmber!!");
        }
        else{
            System.out.println("It is not a Palindrome");
        }
    }
}
