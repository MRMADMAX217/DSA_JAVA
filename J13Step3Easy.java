import java.util.Scanner;

public class J13Step3Easy {
    public static void main(String[] args) {
         Scanner sc= new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n=sc.nextInt();
        int[] array=new int[n];
        System.err.print("Enter elements in array: ");
        for(int i=0;i<n;i++){
            array[i]=sc.nextInt();
        }
        int[] arr2=new int[array.length];
        for(int i=0;i<array.length;i++){
            arr2[i]=array[i];
        }
        // System.out.println("Largest element is "+LargestInArray(array));        
        // System.out.println("Secont Largest element is "+SecondLargest(arr2,LargestInArray(arr2)));
        // System.out.println("Array is sorted - "+IsSorted(array));
        // if(RemoveDup(array)==null) return;
        print(array);
        System.out.println("going to fn");
        // int dupArray=RemoveDup(array);
        // System.out.println(dupArray);
        // int[] arr3=new int[array.length];
        // for(int i=0;i<array.length;i++){
        //     arr3[i]=array[i];
        // }
        int[] arr4=new int[array.length];
        for(int i=0;i<array.length;i++){
            arr4[i]=array[i];
        }
        // System.out.print("Enter the number of left Rotations: ");
        // int d=sc.nextInt();
        // LeftRotate(arr3,d);
        // print(arr3);
        // RightRotate(arr4, d);
        // System.out.println();
        // print(arr4);
        MoveZeroEnd(arr4);
        print(arr4);
        sc.close();
    }
    public static void print(int[] arr){
        for(int i=0;i<arr.length;i++){
            System.err.print(arr[i]+" ");
        }
    }
    public static int LargestInArray(int[] array){
        int largest=array[0];
        for(int i=0;i<array.length;i++){
            if(array[i]>largest){
                largest=array[i];
            }
        }
        return largest;
    }
    public static int SecondLargest(int[] arr,int largest){
        for(int i=0;i<arr.length;i++){
            if(arr[i]==largest) arr[i]=0;
        }
        return LargestInArray(arr);
    }
    public static boolean IsSorted(int[] arr){
        for(int i=1;i<arr.length;i++){
            if(arr[i-1]<=arr[i]);
            else return false;
        }
        return true;
    }
    public static int RemoveDup(int[] arr){
        int[] newarr=new int[arr.length];
        if(IsSorted(arr));
        else {
            System.out.println("Not sorted array");
            return 0;
        }
        int k=0;
        newarr[k++]=arr[0];
        print(arr);
        for(int i=1;i<arr.length;i++){
            if((i!=arr.length-1)&&arr[i]!=arr[i-1]){
                newarr[k++]=arr[i];
                System.out.println("first if "+k);
            }
            if(i==arr.length-1){
                System.out.println("second if"+k+arr[i]+arr[i-1]);
                System.out.println("in loop ");
                // print(arr);
                if(arr[i]!=arr[i-1]){
                     System.out.println("second if"+k);
                    newarr[k]=arr[i];
                } 
            }
            
        }
        for(int j=0;j<arr.length;j++){
            arr[j]=newarr[j];
        }
        System.out.println("k is "+k);
        return k+1;
    }
    public static void LeftRotate(int[] arr,int k){
        while(k>0){
            int temp=arr[0];
            for(int i=0;i<arr.length-1;i++){
                arr[i]=arr[i+1];
            }
            arr[arr.length-1]=temp;
            k--;
        }
    }
    public static void RightRotate(int[] arr,int k){

        while(k>0){
            int temp=arr[arr.length-1];
            for(int i=arr.length-1;i>0;i--){
                arr[i]=arr[i-1];
            }
            arr[0]=temp;
            k--;
        }
    }
    public static void Swap(int[] array,int a,int b){
        int x=array[a];
        array[a]=array[b];
        array[b]=x;
    }
    public static void MoveZeroEnd(int[] arr){
        int n=arr.length;
        int j=-1;
        int i;
        for(i=0;i<n;i++){
            if(arr[i]==0){
                j=i;
                break;
            }
        }
        if (j==-1) return;
        for(i=j+1;i<n;i++){
            if(arr[i]!=0){
                Swap(arr,i,j);
                j++;
            }
        }
    }

    
    public static int  Linearsearch(int array[],int target){
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
