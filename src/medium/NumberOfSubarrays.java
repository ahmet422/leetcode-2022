package medium;
//https://leetcode.com/problems/count-number-of-nice-subarrays/
public class NumberOfSubarrays {
    public static void main(String[] args) {
        System.out.println( numberOfSubarrays2(new int[]{2,2,2,1,2,2,1,2,2,2}, 2));;
    }

    public static int numberOfSubarrays(int[] nums, int k) {
        int l=0, r = 0;
        int oddCount = 0;
        int niceCount = 0;

        while(r < nums.length && l <= r){

            if(oddCount == k){
                niceCount++;
                if(nums[l]%2 == 1){
                    if(r == nums.length-1){
                        l++;
                        continue;
                    }
                    r++;
                    continue;
                }
                else if(nums[l]%2==0){
                    l++;
                    continue;
                }
            }

            if(oddCount<k){
                if(nums[r]%2==1) oddCount++;
                r++;
                continue;
            }

            if(oddCount > k){
                if(nums[l]%2==1 ) oddCount--;
                l++;
                continue;
            }

        }

        return niceCount;
    }

    public static int numberOfSubarrays2(int[] A, int k) {
        int res = 0, i = 0, j = 0, count = 0;
        while(j < A.length) {
            if (A[j] % 2 == 1) {
                k--;
                count = 0;
            }
            while (k == 0) {
                //k += A[i++] & 1     Replacing this line with the below two lines:
                if(A[i] % 2 == 1) {
                    k++;
                }
                count++;
                i++;
            }
            j++;
            res += count;
        }
        return res;
    }


}
