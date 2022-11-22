package easy;
// https://leetcode.com/problems/climbing-stairs/
public class ClimbStairs {
    public static void main(String[] args) {
        System.out.println(climbStairs(4));
    }

    public static int climbStairs(int n) {
        int steps = n-1;
        int one = 1;
        int two = 1;

        while(steps>0){
            int temp = one + two;
            two = one;
            one = temp;
            steps--;
        }

        return one;
    }
}
