import java.util.*;

public class J15Step3Hard {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.print("Enter Dimension of array: ");
        int d=sc.nextInt();
        if(d==1){
            System.out.print("Enter number of rows in array : ");
            int n=sc.nextInt();
            int[] array1=new int[n];
            for(int j=0;j<n;j++){
                System.err.print("Enter element "+j+" ");
                array1[j]=sc.nextInt();
            }
            // System.err.println(Inversion(array1));
            System.out.println(reversePairs(array1, 0, n-1));
        }
        else if (d==2){
            System.out.print("Enter number of rows in array : ");
            int n=sc.nextInt();
            System.out.print("Enter number of cols in array : ");
            int m=sc.nextInt();
            int[][] array1=new int[n][m];
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    System.err.print("Enter element "+i+j+" ");
                    array1[i][j]=sc.nextInt();
                }
            }
            int[][] array2=new int[n][m];
            array2=merge(array1);
            print2d(array2, n, m);
        }
        else if(d==3){
            System.out.print("Enter number of rows in array 1 : ");
            int n=sc.nextInt();
            System.out.print("Enter number of rows in array 2 : ");
            int m=sc.nextInt();
            int[] array1=new int[n];
            int[] array2=new int[m];
            System.out.println("Array 1");
            for(int j=0;j<n;j++){
                System.err.print("Enter element "+j+" ");
                array1[j]=sc.nextInt();
            }
            System.out.println("Array 2");
            for(int j=0;j<m;j++){
                System.err.print("Enter element "+j+" ");
                array2[j]=sc.nextInt();
            }
            System.err.print("Enter size1: ");
            int s1=sc.nextInt();
            System.err.print("Enter size2: ");
            int s2=sc.nextInt();
            merge(array1, s1, array2, s2);
            System.out.println("Array 1");            
            print1d(array1);
            System.out.println("Array 2");
            print1d(array2);

        }
        // System.out.println(majorityElement(array1));
        // System.out.println(generate(n));
        // System.out.println(threeSum(array1));
        // System.out.print("Enter Target element : ");
        // long t=sc.nextInt();
        // System.out.println(fourSum(array1, t));
        // System.out.println(LargestSubarray(array1));
        // System.out.println(maxProduct(array1));
    }
    public static void print2d(int[][] array1,int n,int m){
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                System.err.print(array1[i][j]+" ");
            } 
            System.out.println();
        }
    }
    public static void print1d(int[] arr){
        for(int nums:arr){
            System.out.print(nums+" ");
        }
    }
    public static List<Integer> GenarateRow(int r){
        List<Integer> row=new ArrayList<>();  
        int ans=1;
        row.add(1);
        for(int col=1;col<r;col++){
            ans=ans*(r-col);
            ans=ans/col;
            row.add(ans);
        }
        return row;
    }
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> pascal= new ArrayList<>();
        for(int i=1;i<=numRows;i++){
            pascal.add(GenarateRow(i));
        }
        return pascal;
    }
    public static List<Integer> majorityElement(int[] nums) {
        List<Integer> major=new ArrayList<>();
        int el1=-1,el2=-1;
        int cnt1=0,cnt2=0;
        for(int i=0;i<nums.length;i++){
            if(cnt1==0&&el2!=nums[i]){
                cnt1++;
                el1=nums[i];
            }
            else if(cnt2==0&&el1!=nums[i]){
                cnt2++;
                el2=nums[i];
            }
            else if(el1==nums[i]) cnt1++;
            else if(el2==nums[i]) cnt2++;
            else {cnt1--;cnt2--;}
        }
        int cntt1=0,cntt2=0;
        int n=nums.length/3+1;
        for(int k:nums){
            if(k==el1) cntt1++;
            else if(k==el2) cntt2++;
        }
        if(cntt1>=n) major.add(el1);
        if(cntt2>=n) major.add(el2);
        major.sort(null);
        return major;
    }
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> tsum=new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length-2;i++){
            if(i>0&&nums[i]==nums[i-1]) continue;
            int j=i+1;
            int k=nums.length-1;
            while(j<k){
                int sum=nums[i]+nums[j]+nums[k];
                if(sum<0) j++;
                else if(sum>0) k--;
                else{
                    List<Integer> temp=new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(nums[k]);
                    tsum.add(temp);
                    j++;
                    k--;
                    while(j<k&&nums[j]==nums[j-1]) j++;
                    while(j<k&&nums[k]==nums[k+1]) k--;
                }
            }
        }
        return tsum;
    }
    public static List<List<Integer>> fourSum(int[] nums, long target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int l = 0; l < nums.length - 3; l++) {
            if (l > 0 && nums[l] == nums[l - 1]) continue;
            for (int i = l + 1; i < nums.length - 2; i++) {
                if (i > l + 1 && nums[i] == nums[i - 1]) continue;
                int j = i + 1, k = nums.length - 1;
                while (j < k) {
                    long sum = (long) nums[l] + nums[i] + nums[j] + nums[k];
                    if (sum < target) {
                        j++;
                    } else if (sum > target) {
                        k--;
                    } else {
                        result.add(Arrays.asList(nums[l], nums[i], nums[j], nums[k]));
                        j++;
                        k--;
                        while (j < k && nums[j] == nums[j - 1]) j++;
                        while (j < k && nums[k] == nums[k + 1]) k--;
                    }
                }
            }
        }
        return result;
    }
    public static int LargestSubarray(int[] arr){
        int max=0;
        int sum=0;
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
            if(sum==0) max=i+1;
            else{
                if(hm.containsKey(sum)){
                    max=Math.max(max,i-hm.get(sum));
                }
                else{
                    hm.put(sum,i);
                }
            }
        }
        return max;
    }
    public static int maxProduct(int[] nums) {
        int pre=0,suf=0;
        int ans=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            if(pre==0) pre=1;
            if(suf==0) suf=1;
            pre=pre*nums[i];
            suf=suf*nums[nums.length-i-1];
            ans=Math.max(ans,Math.max(pre,suf));
        }
        return ans;
    }
    public static int[][] merge(int[][] intervals) {
        List<int[]> list = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        for(int i=0;i<intervals.length;i++){
            if(list.isEmpty()||intervals[i][0]>list.get(list.size() - 1)[1]){
                list.add(intervals[i]);
            }
            else{
                list.get(list.size() - 1)[1]=Math.max(list.get(list.size() - 1)[1],intervals[i][1]);
            }
        }
        int[][] ans = new int[list.size()][];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }
    public static void SwapGreater(int[] a1,int[] a2,int i1,int i2){
        if(a1[i1]>a2[i2]) swap(a1,a2,i1,i2);
    }
    public static void swap(int[] array1,int[] array2,int a,int b){
        int x=array1[a];
        array1[a]=array2[b];
        array2[b]=x;
    }
    public static void merge(int[] nums1, int n, int[] nums2, int m) {
        int len=n+m;
        int gap=(len/2)+len%2;
        while(gap>0){
            int left =0,right=left+gap;
            while(right<len){
                if(left<n&&right>=n){
                    if (nums1[left] > nums2[right - n]) {
                        int temp = nums1[left];
                        nums1[left] = nums2[right - n];
                        nums2[right - n] = temp;
                    }
                }
                else if(left>=n){
                     if (nums2[left - n] > nums2[right - n]) {
                        int temp = nums2[left - n];
                        nums2[left - n] = nums2[right - n];
                        nums2[right - n] = temp;
                    }
                }
                else{
                    if (nums1[left] > nums1[right]) {
                        int temp = nums1[left];
                        nums1[left] = nums1[right];
                        nums1[right] = temp;
                    }
                }
                left++;
                right++;
            }
                if(gap==1) break;
                gap=gap/2+gap%2;
        }
        for (int i = 0; i < m; i++) {
        nums1[n + i] = nums2[i];
        }
    }
    public static int Mergesort(int[] arr,int low,int high){
        int count=0;
        if(low>=high) return count;
        int mid=(low+high)/2;
        count+=Mergesort(arr,low,mid);
        count+=Mergesort(arr,mid+1,high);
        count+=Merge(arr,low,mid,high);
        return count;
    }
    public static int reversePairs(int[] arr,int low,int high){
        int count=0;
        if(low>=high) return count;
        int mid=(low+high)/2;
        count+=reversePairs(arr,low,mid);
        count+=reversePairs(arr,mid+1,high);
        count+=Reversepairs(arr, low, mid, high);
        Merge2(arr,low,mid,high);
        return count;
    }
    public static void Merge2(int[] arr,int low,int mid,int high){
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
    public static int Merge(int[] arr,int low,int mid,int high){
        int[] temp=new int[arr.length];
        int left=low;
        int right=mid+1;
        int k=0;
        int count=0;
        while(left<=mid&&right<=high){
            if(arr[left]<=arr[right]){
                temp[k++]=arr[left++];
            }
            else{
                temp[k++]=arr[right++];
                count+=(mid-left+1);
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
        return count;
    }
    public static int Inversion(int[] nums){
        int cnt=0;
        cnt=Mergesort(nums, 0,nums.length-1 );
        return cnt;
    }
    public static int Reversepairs(int[] arr,int low,int mid,int high){
        int count=0;
        int right=mid+1;
        for(int i=low;i<=mid;i++){
            while(right<=high&&arr[i]>2*arr[right]){
                right++;
            }
            count+=right-(mid+1);
        }
        return count;
    }
}
