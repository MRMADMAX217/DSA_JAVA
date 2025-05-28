import java.util.Scanner;

public class BinarySearch {
    public static void main(String[] args){
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
        BinarySearchFunction(arr, tar);
        sc.close();
    }
    public static int BinarySearchFunction(int arr[],int tar){
        int left=0;
        int right=arr.length;
        int mid=(left+right)/2;
        while(left<=right){
            if(tar==arr[mid]){System.out.println("Index of the array is "+mid); return 0;}
            if(tar>mid){
                left=mid;
                mid=(left+right)/2;
                
            }
        }
       while(tar>arr[mid]){

        }
        return -1;
    }
}
