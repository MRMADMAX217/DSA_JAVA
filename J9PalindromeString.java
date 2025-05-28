import java.util.Scanner;

public class J9PalindromeString {
    public static void main(String[] args) {
    Scanner sc= new Scanner(System.in);
    System.out.print("Enter the string: ");
    String s=sc.nextLine();
    char[] ch=s.toCharArray();
    System.out.println(Palindrome(ch,s.length(),0));
    System.out.println(PalindromeWithoutR(s));
    sc.close();
    }
    public static boolean Palindrome(char[] s,int n,int x){
        if(x==n/2) return true; 
        if(s[x]!=s[n-1]){
            return false;
        }
        else{
            Palindrome(s, n, x+1);
        }
        return true;
    }
    public static boolean PalindromeWithoutR(String s){
        if(s.isEmpty()) return true;
        String s2=s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        for(int i=0;i<(s2.length()/2);i++){
            if(s2.charAt(i)!=s2.charAt(s2.length()-1-i)) return false;
        }
        return true;
    }
}
