package easy;
// link: https://leetcode.com/problems/valid-perfect-square/
public class ValidPerfectSquare {
    public static void main(String[] args) {

        System.out.println(isPerfectSquare(16));;

    }

    public static boolean isPerfectSquare(int num) {
        // max square root of Ineteger
        int right = 46340;
        int left = 1;
        while(left <= right){
            int mid = (left + right)/2;
            int square = mid*mid;
            if(square == num){
                return true;
            }else if(square > num){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return false;
    }
}
