import java.util.Scanner;
public class J12Sortings {
    public static void main(String[] args) {
         Scanner sc= new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n=sc.nextInt();
        int[] array=new int[n];
        System.err.print("Enter elements in array: ");
        for(int i=0;i<n;i++){
            array[i]=sc.nextInt();
        }
         print(array);
        // int[] insertion=new int[array.length];
        // insertion=InsertionSort(array);
        // int[] selection=new int[array.length];
        // selection=SelectionSort(array);
        int[] bubble=new int[array.length];
        bubble=BubbleSort(array);
        System.err.println();
        // print(insertion);
        // print(selection);
        print(bubble);
        sc.close();
    }
    public static void Swap(int[] array,int a,int b){
        int x=array[a];
        array[a]=array[b];
        array[b]=x;
    }
    public static void print(int[] arr){
        for(int i=0;i<arr.length;i++){
            System.err.print(arr[i]+" ");
        }
    }
    public static int[] InsertionSort(int[] arr){
        for(int i=0;i<arr.length;i++){
            int j=i;
            while(j>0&&arr[j-1]>arr[j]){
                Swap(arr,j-1, j);
                j--;
            }
        }
        return arr;
    }
    public static int[] SelectionSort(int[] arr){
        for(int i=0;i<arr.length-1;i++){
            int min=i;
            for(int j=i;j<arr.length;j++){
                if(arr[j]<arr[min]){
                    min=j;
                }
            }
            Swap(arr,i,min);
        }
        return arr;
    }
    public static int[] BubbleSort(int[] arr){
        for(int i=arr.length-1;i>=1;i--){
            for(int j=0;j<i-1;j++){
                if(arr[j]>arr[j+1]){
                    Swap(arr,j,j+1);
                }
            }
        }
        return arr;
    }
}
