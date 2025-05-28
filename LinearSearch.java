import java.util.Scanner;

public class LinearSearch{
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.print("Enter number of elements in the array: ");
        int n=sc.nextInt();
        int[] arr=new int[n];
        System.out.print("Enter elements: ");
        for(int i=0;i<n;i++){
            int k=sc.nextInt();
            arr[i]=k;
        }
        System.out.print("Array is : ");
        for(int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.print("\nEnter Target element: ");
        int tar=sc.nextInt();
        LinearsearchFunction(arr,tar);
    }
    public static int  LinearsearchFunction(int array[],int target){
        for(int i=0;i<array.length;i++){
            if(array[i]==target){
                System.err.print("Index of the Target element is "+i);
                return 0;
            }
        }
        System.out.println("Element not Found!! ");
        return -1;
    }
}