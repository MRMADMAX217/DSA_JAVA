import java.util.*;

public class J13Step3Easy2 {
    public static void main(String[] args) {
         Scanner sc= new Scanner(System.in);
        System.out.print("Enter number of elements in array 1: ");
        int n1=sc.nextInt();
        int[] array1=new int[n1];
        System.err.print("Enter elements in array 1: ");
        for(int i=0;i<n1;i++){
            array1[i]=sc.nextInt();
        }
        // System.out.print("Enter number of elements in array 2: ");
        // int n2=sc.nextInt();
        // int[] array2=new int[n2];
        // System.err.print("Enter elements in array 1: ");
        // for(int i=0;i<n2;i++){
        //     array2[i]=sc.nextInt();
        // }
        // int[] union=UnionArray(array1, array2);
        // print(union);
        // sc.close();
        if(MissingNumHashing(array1)==array1[0]){
            System.out.println("no elements are missing!! ");
        }
        // else System.out.println("Missing element is "+MissingNumHashing(array1));
        // System.out.println("Maximum consecutive 1's are "+MaxConsOnes(array1));
        // System.out.println("Once in aarray "+Once(array1));
        System.out.print("Enter target: ");
        int tar=sc.nextInt();
        System.out.println("Two sum pair: ");
        print(TwoSum(array1, tar));
    }
      public static void print(int[] arr){
        for(int i=0;i<arr.length;i++){
            System.err.print(arr[i]+" ");
        }
    }
    // public static int[] UnionArray(int[] a,int[] b){
    //     int[] union=new int[a.length+b.length];
    //     int n1=a.length,n2=b.length,i=0,j=0,k=0;
    //     while(i<n1&&j<n2){
    //         if(a[i]<=b[j]){
    //             if(k!=0){
    //                 if(a[i]==union[k-1]){
    //                     i++;
    //                     continue;
    //                 }
    //             }
    //             union[k++]=a[i++];
    //         }
    //         else {
    //             if(k!=0){
    //                 if(b[j]==union[k-1]){
    //                     j++;
    //                     continue;
    //                 }
    //             }
    //             union[k++]=b[j++];
    //         }
    //     }
    //     return union;
    // }
    public static int[] UnionArray(int[] a, int[] b){
        int[] union = new int[a.length + b.length];
        int i = 0, j = 0, k = 0;

        while(i < a.length && j < b.length){
            if(a[i] <= b[j]){
                if(k == 0 || a[i] != union[k - 1])
                    union[k++] = a[i];
                i++;
            } else {
                if(k == 0 || b[j] != union[k - 1])
                    union[k++] = b[j];
                j++;
            }
        }

        while(i < a.length){
            if(k == 0 || a[i] != union[k - 1])
                union[k++] = a[i];
            i++;
        }

        while(j < b.length){
            if(k == 0 || b[j] != union[k - 1])
                union[k++] = b[j];
            j++;
        }
        return Arrays.copyOf(union, k);
    }
    public static int MaxEle(int[] arr){
        int max=arr[0];
        for(int i=0;i<arr.length;i++){
            if(max<=arr[i]){
                max=arr[i];
            }
        }
        if(max<arr.length) max=arr.length;
        return max;
    }
    public static int MissingNumHashing(int[] arr){
        int miss=0;
        int[] hash=new int[MaxEle(arr)+1];
        Arrays.fill(hash,0);
        for(int i=0;i<arr.length;i++){
            hash[arr[i]]++;
        }
        for(int i=0;i<hash.length;i++){
            if(hash[i]==0){
                if(i!=0) return i;
            }
        }
        return miss;
    }
    public static int max(int a,int b){
        if(a>b) return a;
        else return b;
    }
    public static int MaxConsOnes(int[] arr){
        int cons=0;
        int maxx=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==1){
                cons++;
                maxx=max(cons,maxx);
            }
            else cons=0;
        }
        return maxx;
    }
    public static int Once(int[] arr){
        Map<Integer,Integer> ot=new HashMap<>();
        for(int i=0;i<arr.length;i++){
            ot.put(arr[i],0);
        }
        for(int i=0;i<arr.length;i++){
            ot.put(arr[i],ot.get(arr[i])+1);
        }
        for(int i=0;i<arr.length;i++){
            if(ot.get(arr[i])==1) return arr[i];
        }
        return -1;
    }
    public static int[] TwoSum(int arr[],int tar){
        int[] ts=new int[2];
        Map<Integer,Integer> match=new HashMap<>();
        for(int i=0;i<arr.length;i++){
            if(!match.containsKey(arr[i])) match.put(arr[i],i);
        }
        for(int i=0;i<arr.length;i++){
            int a=arr[i];
            int req=tar-arr[i];
            if(match.containsKey(req)&& match.get(req)!=i) {
                ts[0]=i;
                ts[1]=match.get(req);
                return ts;
            }
        }
        return ts;
    }
}
