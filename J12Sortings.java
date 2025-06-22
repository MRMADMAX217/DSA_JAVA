import java.util.*;
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
        // int[] bubble=new int[array.length];
        // bubble=BubbleSort(array);
        // int[] merge=new int[array.length];
        // Mergesort(array,0,array.length-1);
        // int[] quick=new int[array.length];
        Quicksort(array,0,array.length-1);
        System.err.println();
        // print(insertion);
        // print(selection);
        // print(bubble);
        print(array);
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
    public static void Mergesort(int[] arr,int low,int high){
        if(low>=high) return;
        int mid=(low+high)/2;
        Mergesort(arr,low,mid);
        Mergesort(arr,mid+1,high);
        Merge(arr,low,mid,high);
    }
    public static void Merge(int[] arr,int low,int mid,int high){
        int[] temp=new int[arr.length];
        int left=low;
        int right=mid+1;
        int k=0;
        while(left<=mid&&right<=high){
            if(arr[left]<=arr[right]){
                temp[k++]=arr[left++];
            }
            else{
                temp[k++]=arr[right++];
            }
        }
        while(left<=mid){
            temp[k++]=arr[left++];
        }
        while(right<=high){
            temp[k++]=arr[right++];
        }
        for(int i=low;i<=high;i++){
            arr[i]=temp[i-low];
        }
    }
    public static void Quicksort(int[] arr,int low,int high){
        if(low<high){
            int pivot=partion(arr,low,high);
            Quicksort(arr, low, pivot-1);
            Quicksort(arr, pivot+1, high);
        }
    }
    public static int partion(int[] arr,int low,int high){
        int pivot=arr[low];
        int i=low;
        int j=high;
        while(i<j){
            while(i<=high&&arr[i]<=pivot){
                i++;
            }
            while(j>=low&&arr[j]>pivot){
                j--;
            }
            if(i<j){
                Swap(arr,i, j);
            }
        }
        Swap(arr, low, j);
        return j;
    }
}
