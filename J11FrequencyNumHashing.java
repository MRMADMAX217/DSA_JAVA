import java.util.*;

class J11FrequencyNumHashing{
    public static void main(String[] args) {
        int n;
        Scanner sc= new Scanner(System.in);
        System.out.print("Inter number of rows: ");
        n=sc.nextInt();
        int[] arr=new int[n];
        System.err.print("Enter elements in array: ");
        int max=0;
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
            if(arr[i]>max) max=arr[i];
        }
        sc.close();
        // System.out.println(max);
        int[] new_arr=Hashing(arr,max);
        for(int i=0;i<max+1;i++){
            System.out.println("frequency of "+(i)+" is "+new_arr[i]+" ");
        }
        System.err.println("max "+MaxFreq(new_arr));
        System.err.println("min "+MinFreq(new_arr));
    }
    public static int[] Hashing(int[] arr,int max){
        int[] narr=new int[max+1];
        Arrays.fill(narr,0);
        for(int i=0;i<arr.length;i++){
            narr[arr[i]]+=1;
        }
        return narr;
    }
    public static int MaxFreq(int[] narr){
        int max=0;
        int index=0;
        for(int i=1;i<narr.length;i++){
            if(narr[i]>max){
                max=narr[i];
                index=i;
            }
        }
        return index;
    }
    public static int MinFreq(int[] narr){
        int min=10000;
        int index=0;
        for(int i=1;i<narr.length;i++){
            if(narr[i]<min){
                min=narr[i];
                index=i;
            }
        }
        return index;
    }
}