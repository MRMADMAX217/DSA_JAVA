import java.util.Scanner;

public class J16Step4BS1 {
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        System.out.print("Enter number of elements in the array: ");
        int n=sc.nextInt();
        // int[] arr=new int[n];
        // System.out.print("Enter elements: ");
        // for(int i=0;i<n;i++){
        //     int k=sc.nextInt();
        //     arr[i]=k;
        // }
        // System.out.print("Array is : ");
        // for(int i:arr){
        //     System.out.print(i+" ");
        // }
        // print1d(arr);
        // System.out.print("\nEnter Target element: ");
        // int tar=sc.nextInt();
        // System.out.println((BinarySearchFunction(arr, tar)));
        // System.out.println(LowerBoundary(arr, tar));
        // System.out.println(floorEle(arr, tar));
        // int [] firstlast=new int[2];
        // firstlast=searchRange(arr, tar);
        // print1d(firstlast);
        // System.out.println(count(arr, tar));
        // System.out.println(SingleElement(arr));
        // System.out.println(findPeakElement(arr));
        sc.close();
    }
    public static void print1d(int[] arr){
        for(int nums:arr){
            System.out.print(nums+" ");
        }
        System.out.println();
    }
    public static int BinarySearchFunction(int arr[],int tar){
        int left=0;
        int right=arr.length-1;
        while(left<=right){
            int mid=(left+right)/2;
            if(tar==arr[mid]) return mid;
            if(tar>arr[mid]){
                left=mid+1;
            }
            else{
                right=mid-1;
            }
        }
        return -1;
    }
    public static int LowerBoundary(int[] arr,int tar){
        int ans=arr.length;
        int left=0;
        int right=arr.length-1;
        while(left<=right){
            int mid=(left+right)/2;
            if(tar>arr[mid]){
                left=mid+1;
            }
            else{
                ans=mid;
                right=mid-1;
            }
         }
        return ans;
    }
    public static int UpperBoundary(int[] arr,int tar){
        int ans=arr.length;
        int left=0;
        int right=arr.length-1;
        while(left<=right){
            int mid=(left+right)/2;
            if(tar>=arr[mid]){
                left=mid+1;
            }
            else{
                ans=mid;
                right=mid-1;
            }
         }
        return ans;
    }
    public static int floorEle(int arr[],int tar){
        int ans=-1;
        int left=0,right=arr.length-1;
        while(left<=right){
            int mid=(left+right)/2;
            if(tar>=arr[mid]){
                ans=mid;
                left=mid+1;
            }
            else{
                right=mid-1;
            }
        }
        return arr[ans];
    }
    public static int[] searchRange(int[] nums, int target) {
        int[] ans=new int[2];
        int lb=LowerBoundary(nums,target);
        if(lb==nums.length||nums[lb]!=target){
            ans[0]=-1;
            ans[1]=-1;
            return ans;
        }
        else{
            ans[0]=LowerBoundary(nums,target);
            ans[1]=UpperBoundary(nums,target)-1;
        }
        return ans;
    }
    public static int count(int[] nums,int target){
        int count=0;
        if(searchRange(nums, target)[0]==-1){
            return 0;
        }
        count=searchRange(nums, target)[1]-searchRange(nums, target)[0]+1;
        return count;
    }
    public int Rotatedsearch1(int[] nums, int target) {
        int low=0,high=nums.length-1;
        while(low<=high){
            int mid=low+high/2;
            if(nums[mid]==target) return mid;
            if(nums[low]<=nums[mid]){
                if(nums[low]<=target&&target<=nums[mid]){
                    high=mid-1;
                }
                else low=mid+1;
            }
            else{
                if(nums[mid]<=target&&target<=nums[high]){
                    low=mid+1;
                }
                else high=mid-1;
            }
        } 
        return -1;
    }
    public boolean Rotatedsearch2(int[] nums, int target) {
        int low=0,high=nums.length-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(nums[mid]==target) return true;
            if(nums[low]==nums[mid]&&nums[mid]==nums[high]){
                low=low+1;
                high=high-1;
                continue;
            }
            if(nums[low]<=nums[mid]){
                if(nums[low]<=target&&target<=nums[mid]){
                    high=mid-1;
                }
                else low=mid+1;
            }
            else{
                if(nums[mid]<=target&&target<=nums[high]){
                    low=mid+1;
                }
                else high=mid-1;
            }
        }
        return false;
    }
    public int findMin(int[] nums) {
        int low=0,high=nums.length-1;
        int ans=Integer.MAX_VALUE;
        while(low<=high){
            int mid=(low+high)/2;
            if(nums[low]<=nums[high]){
                ans=Math.min(ans,nums[low]);
                break;
            }
            if(nums[low]<=nums[mid]){
                ans=Math.min(ans,nums[low]);
                low=mid+1;
            }
            else{
                ans=Math.min(ans,nums[mid]);
                high=mid-1;
            }
        }
        return ans;
    }
    public int countRotations(int[] nums) {
        int low=0,high=nums.length-1;
        int ans=Integer.MAX_VALUE;
        int index=-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(nums[low]<=nums[high]){
                if(ans<nums[low]){
                    index=low;
                    ans=nums[low];
                }
                break;
            }
            if(nums[low]<=nums[mid]){
                if(ans<nums[low]){
                    index=low;
                    ans=nums[low];
                }
                low=mid+1;
            }
            else{
                if(ans<nums[mid]){
                    index=mid;
                    ans=nums[mid];
                }
                high=mid-1;
            }
        }
        return ans;
    }
    public static int SingleElement(int arr[]){
         int left=0;
        int right=arr.length-1;
        while(left<=right){
            int mid=(left+right)/2;
            if(mid==0) if(arr[mid+1]!=arr[mid]) return arr[mid];
            if(mid==arr.length-1) if(arr[mid-1]!=arr[mid]) return arr[mid];
            if(arr[mid-1]!=arr[mid]&&arr[mid+1]!=arr[mid]) return arr[mid];
            if(mid%2==0){
                if(arr[mid-1]==arr[mid]) right=mid-1;
                else left=mid+1;
            }
            else {
                if(arr[mid+1]==arr[mid]) right=mid-1;
                else left=mid+1;
            }
        }
        return -1;
    }
    public static int findPeakElement(int[] arr) {
        if(arr.length==0||arr[0]>arr[1]) return 0;
        if(arr[arr.length-1]>arr[arr.length-2]) return arr.length-1;
        int low=1;
        int high=arr.length-2;
        while(low<=high){
            int mid=(low+high)/2;
            if(arr[mid]>arr[mid-1]&&arr[mid]>arr[mid+1]) return mid;
            else if(arr[mid]>arr[mid-1]) low=mid+1;
            else if(arr[mid]>arr[mid+1]) high=mid-1;
            else low=mid+1;
        }
        return -1;
    }
}
