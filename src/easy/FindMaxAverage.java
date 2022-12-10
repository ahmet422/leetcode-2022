package easy;
//https://leetcode.com/problems/maximum-average-subarray-i/
public class FindMaxAverage {
    public static void main(String[] args) {
        System.out.println(findMaxAverage2(new int[]{8860,-853,6534,4477,-4589,8646,-6155,
                -5577,-1656,-5779,-2619,-8604,-1358,-8009,4983,7063,3104,-1560,4080,2763,
                5616,-2375,2848,1394,-7173,-5225,-8244,-809,8025,-4072,-4391,-9579,1407,
                6700,2421,-6685,5481,-1732,-8892,-6645,3077,3287,-4149,8701,-4393,-9070,
                -1777,2237,-3253,-506,-4931,-7366,-8132,5406,-6300,-275,-1908,67,3569,1433,
                -7262,-437,8303,4498,-379,3054,-6285,4203,6908,4433,3077,2288,9733,-8067,3007,
                9725,9669,1362,-2561,-4225,5442,-9006,-429,160,-9234,-4444,3586,-5711,-9506,
                -79,-4418,-4348,-5891},93));
    }

    public static double findMaxAverage(int[] nums, int k) {
        if(nums.length == 1) return nums[0];
        int right = nums.length-1;
        double sum = 0;

        for (int i = 0; i < k; i++) {
            sum+=nums[i];
        }
        double max = sum;
        int l = 0, r = l + k -1;

        while(r < nums.length){
            max = Math.max(max,sum);
            sum = sum - nums[l];
            l++;
            r++;
            if(r >= nums.length) {

                break;}
            sum = sum + nums[r];
        }
        return max/k;
    }

    public static double findMaxAverage2(int[] nums, int k) {
        int sumk = 0;
        for (int i=0; i<k; ++i) sumk += nums[i];

        int maxSumK = sumk;

        for (int i=k; i<nums.length; ++i) {
            sumk += nums[i] - nums[i-k];
            maxSumK = Math.max(sumk, maxSumK);
        }

        return ((double) maxSumK) / k;
    }
}
