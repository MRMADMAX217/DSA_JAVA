import java.util.Scanner;
public class J8ReverseAnArray {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n=sc.nextInt();
        int[] array=new int[n];
        System.err.print("Enter elements in array: ");
        for(int i=0;i<n;i++){
            array[i]=sc.nextInt();
        }
        ReverseA(array, 0,n);
        for(int i=0;i<n;i++){
            System.out.print(array[i]+" ");;
        }
        sc.close();
    }
    public static void Swap(int[] array,int a,int b){
        int x=array[a];
        array[a]=array[b];
        array[b]=x;
    }
    public static void ReverseA(int[] arr,int x,int n){
        if(x<n/2){
            Swap(arr,x,n-1-x);
            ReverseA(arr, x+1, n);
        }
        else return;
    }
}

