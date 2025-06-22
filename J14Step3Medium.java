import java.util.*;  

public class J14Step3Medium {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.print("Enter number of rows in array : ");
        int n=sc.nextInt();
        // int[] array1=new int[n];
        // for(int j=0;j<n;j++){
        //     System.err.print("Enter element "+j);
        //     array1[j]=sc.nextInt();
        // }
        System.out.print("Enter number of cols in array : ");
        int m=sc.nextInt();
        int[][] array1=new int[n][m];
        // System.err.print("Enter elements in array 1: ");
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                System.err.print("Enter element "+i+j+" ");
                array1[i][j]=sc.nextInt();
            }
        }
        // sortColors(array1);
        // print(array1);
        // System.out.println("Majority element is "+majorityElement(array1));        
        // System.out.println("Maximum SubArray sum is "+maxSubArray(array1));        
        // System.out.println("Maximum Profit is "+maxProfit(array1));
        System.err.println();
        // nextPermutation(array1);
        // ArrayList<Integer> leader=(Leader(array1));
        // for(int i=0;i<leader.size();i++){
        //     System.out.print(" "+leader.get(i));
        // }
        // System.out.println("Number of elements in long squence is: "+longestConsecutive(array1));
        // print(array1);
         System.out.println("Before: ");
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                System.err.print(array1[i][j]+" ");
            }
            System.out.println();
        }
        // SetMatrix(array1);
        // List<Integer> ls=spiralOrder(array1);
        // for(int i:ls) System.out.print(i+" ");
        rotate(array1);
        // reverseColumns(array1);
        System.out.println("After ");
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                System.err.print(array1[i][j]+" ");
            } 
            System.out.println();       
        // System.out.println("Enter the Target : ");
        // int k=sc.nextInt();
        // System.out.println(subarraySum(array1,k));
        }
    }
    public static void swap(int[] array,int a,int b){
        int x=array[a];
        array[a]=array[b];
        array[b]=x;
    }
    public static void print(int[] arr){
        for(int nums:arr){
            System.out.println(nums+" ");
        }
    }
    public static void sortColors(int[] arr) {
        int low=0,mid=0,high=arr.length-1;
        while(mid<=high){
            if(arr[mid]==0) swap(arr,mid++,low++);
            else if(arr[mid]==1) mid++;
            else if(arr[mid]==2) swap(arr,mid,high--);
        }
    }
    public static int majorityElement(int[] arr){
        int count=0;
        int ele=-1;
        for(int i=0;i<arr.length;i++){
            if(count==0){
                count++;
                ele=arr[i];
            }
            else if(ele==arr[i]) count++;
            else count--;
        }
        int count1=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==ele) count1++;
        }
        if(count1>arr.length/2) return ele;
        return -1;
    }
    public static int maxSubArray(int[] arr) {
        int sum=0;
        int max=arr[0]; 
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
            if(sum>max) max=sum;
            if(sum<0) sum=0;
        }
        return max;
    }
    public static int maxProfit(int[] prices) {
        int min=prices[0];
        int profit=0;
        for(int i=1;i<prices.length;i++){
            int cost=prices[i]-min;
            profit=Math.max(cost,profit);
            min=Math.min(prices[i],min);
        }
        return profit;
    }
    public static int[] rearrangeArray(int[] arr) {
        int[] pos=new int[arr.length/2];
        int[] neg=new int[arr.length/2];
        int j=0,k=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>0) pos[j++]=arr[i];
            else neg[k++]=arr[i];
        }
        for(int i=0;i<arr.length/2;i++){
            arr[i*2]=pos[i];
            arr[i*2+1]=neg[i];
        }       
        return arr;
    }
    public static void nextPermutation(int[] arr) {
        int ind=-1;
        int n=arr.length;
        for(int i=n-2;i>=0;i--){
            if(arr[i]<arr[i+1]){
                ind=i;
                break;
            }
        }
        if(ind==-1) { reverseArray(arr, 0, n - 1);;return;}
        for(int i=n-1;i>ind;i--){
            if(arr[i]>arr[ind]) {swap(arr, ind, i);break;};
        }
        reverseArray(arr, ind + 1, n - 1);
    }
    static void reverseArray(int[] arr, int left, int right) {
        while(left < right) {
            swap(arr, left++, right--);
        }
    }
    public static ArrayList Leader(int[] arr){
        ArrayList<Integer> leader=new ArrayList<>();
        int max=0;
        for(int i=arr.length-1;i>=0;i--){
            if(arr[i]>max) leader.add(arr[i]);
            max=Math.max(arr[i],max);
        }
        return leader;
    }
    public static int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }
        int longestStreak = 0;
        for (int num : numSet) {
            if (!numSet.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;
                while (numSet.contains(currentNum + 1)) {
                    currentNum++;
                    currentStreak++;
                }
                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }
        // for(int n:numSet){
        //     System.out.print(n+" ");
        // }
        return longestStreak;
    }
    public static void SetMatrix(int[][] arr){
        int col=1,row=1;
        int n=arr.length,m=arr[0].length;
        for (int j = 0; j < m; j++) {
            if (arr[0][j] == 0) {
                row = 0;
                break;
            }
        }
        for (int i = 0; i < n; i++) {
            if (arr[i][0] == 0) {
                col = 0;
                break;
            }
        }
        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                if (arr[i][j] == 0) {
                    arr[0][j] = 0;
                    arr[i][0] = 0;
                }
            }
        }
        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                    if(arr[0][j]==0||arr[i][0]==0){
                        arr[i][j]=0;
                    }
                }
        }
        if (row == 0) {
            for (int j = 0; j < m; j++) {
                arr[0][j] = 0;
            }
        }
        if (col == 0) {
            for (int i = 0; i < n; i++) {
                arr[i][0] = 0;
            }
        }
        return;
    }
    public static int subarraySum(int[] nums,int k) {
        Map<Integer,Integer> hm=new HashMap<>();
        int count=0,presum=0;
        hm.put(0,1);
        for(int i=0;i<nums.length;i++){
            presum+=nums[i];
            int remove=presum-k;
            count += hm.getOrDefault(remove, 0);
            hm.put(presum, hm.getOrDefault(presum, 0) + 1);
        }
        return count;
    }
    public static List<Integer> spiralOrder(int[][] mat) {
        List<Integer> ls=new ArrayList();
        int n=mat.length;
        int m=mat[0].length;
        int left=0,right=m-1,top=0,bottom=n-1;
        while(top<=bottom&&left<=right){
            for(int i=left;i<=right;i++){
                 ls.add(mat[top][i]);
            }
            top++;
            for(int i=top;i<=bottom;i++){
                 ls.add(mat[i][right]);
            }
            right--;
            if (top <= bottom) {
            for (int i = right; i >= left; i--) {
                ls.add(mat[bottom][i]);
            }
            bottom--;
            }
            if (left <= right) {
            for (int i = bottom; i >= top; i--) {
                ls.add(mat[i][left]);
            }
            left++;
            }
        }
        return ls;
    }
    public static void rotate(int[][] mat) {
        int n=mat.length;
        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }
        for(int i=0;i<n;i++){
            reverseColumns(mat);
        }
    }
        public static void reverseColumns(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;

        for (int colLeft = 0, colRight = cols - 1; colLeft < colRight; colLeft++, colRight--) {
            for (int row = 0; row < rows; row++) {
                int temp = mat[row][colLeft];
                mat[row][colLeft] = mat[row][colRight];
                mat[row][colRight] = temp;
            }
        }
    }
}