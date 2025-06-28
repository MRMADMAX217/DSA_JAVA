import java.util.Scanner;

public class J17Step4BS2 {
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        System.out.print("Enter n: ");
        int n=sc.nextInt();
        int[] arr=new int[n];
        System.out.print("Enter elements: ");
        for(int i=0;i<n;i++){
            int k=sc.nextInt();
            arr[i]=k;
        }
        System.out.print("Enter K: ");
        int m=sc.nextInt();
        // System.out.print("Enter k: ");
        // int k=sc.nextInt();
        // System.out.println(Sqrt(n));
        // System.out.println(Nthroot(n, m));
        // System.err.println(findMin(arr)+"min");
        // System.out.println(minEatingSpeed(arr, m));
        // System.out.println(FloorsBlossom(arr,m,k));
        // System.out.println(smallestDivisor(arr, m));
        // System.out.println(shipWithinDays(arr, m));
        // System.out.println(findSum(arr));
        System.out.println(findKthPositive(arr, m));
    }
    public static int Sqrt(int n){
        int low=1;
        int high=n;
        while(low<=high){
            int mid=(low+high)/2;
            int val=mid*mid;
            if(val<=n) low=mid+1;
            else high=mid-1;
        }
        return high;
    }
    public static int pow(int mid,int n){
        int ans=1;
        while(n>0){
            if(n%2==1){
                ans=ans*mid;
                n--;
            }
            else{
                mid=mid*mid;
                n=n/2;
            }
        }
        return ans;
    }
    public static int Nthroot(int n,int m){
        int low=1;
        int high=m;
        while(low<=high){
            int mid=(low+high)/2;
            int val=pow(mid, n);
            if(val==m) return mid;
            else if(val<m) low=mid+1;
            else high=mid-1;
        }
        return -1;
    }
    public static int findMax(int arr[]){
        int max=Integer.MIN_VALUE;
        for(int i:arr){
            max=Math.max(max,i);
        }
        return max;
    }
    public static int findMin(int arr[]){
        int max=Integer.MAX_VALUE;
        for(int i:arr){
            max=Math.min(max,i);
        }
        return max;
    }public static int findSum(int arr[]){
        int max=0;
        for(int i:arr){
            max+=i;
        }
        return max;
    }
    public static int Req(int[] arr,int hr){
        int hrs=0;
        for(int i:arr){
            hrs+=Math.ceil((double)i/(double)hr);
        }
        return hrs;
    }
    public static int minEatingSpeed(int[] arr, int h) {
        int low=1;
        int high=findMax(arr);
        while(low<=high){
            int mid=(low+high)/2;
            int total_hrs=Req(arr, mid);
            if(total_hrs<=h){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return low;
    }
    public static boolean possible(int[] arr,int day,int m,int k){
        int cnt=0;
        int nob=0;
        for(int i:arr){
            if(i<=day) cnt++;
            else{
                nob+=(cnt/k);
                cnt=0;
            }
        }
        nob+=(cnt/k);
        if(nob>=m) return true;
        else return false;
    }
    public static int FloorsBlossom(int[] arr,int m,int k){
        if(arr.length<m*k) return -1;
        int high=findMax(arr);
        int low=findMin(arr);
        int ans=high;
        while(low<=high){
            int mid=(low+high)/2;
            if(possible(arr,mid, m, k)){
                ans=mid;
                high=mid-1;
            }
            else low=mid+1;
        }
        return ans;
    }
    public static int sumofD(int[] arr,int div){
        int sum=0;
        for(int i:arr){
            sum=sum+=Math.ceil((double)i/(double)div);
        }
        return sum;
    }
    public static int smallestDivisor(int[] arr, int thres) {
        int low=0;
        int high=findMax(arr);
        int ans=-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(sumofD(arr, mid)<=thres){
                ans=mid;
                high=mid-1;
            }
            else low=mid+1;
        }
        return low;
    }
    public static int ReqDays(int[] weights,int cap){
        int day=1;
        int load=0;
        for(int i:weights){
            if(load+i>cap){
                load=i;
                day++;
            }
            else load+=i;
        }
        return day;
    }
    public static int shipWithinDays(int[] weights, int days) {
        int low=findMax(weights);
        int high=findSum(weights);
        while(low<=high){
            int mid=(low+high)/2;
            int reqdays=ReqDays(weights, mid);
            if(reqdays<=days) high=mid-1;
            else low=mid+1;
        }
        return low;
    }
    public static int findKthPositive(int[] arr, int k) {
        int low=0;
        int high=arr.length-1;
        while(low<=high){
            int mid=(low+high)/2;
            int miss=arr[mid]-mid-1;
            if(miss<k) low=mid+1;
            else high=mid-1;
        }
        return high+1+k;
    }
}