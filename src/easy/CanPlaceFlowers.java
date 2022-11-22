package easy;
// https://leetcode.com/problems/can-place-flowers/
public class CanPlaceFlowers {
    public static void main(String[] args) {
        System.out.println(canPlaceFlowers(new int[]{0,0,0}, 2));
    }

    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        if(flowerbed.length==1 && flowerbed[0]==0) return true;
        int i = 0;
        int canHold = 0;
        if(flowerbed[i] == 0){
            int j = i+1;
            while(j<flowerbed.length && flowerbed[j] != 1 ){
                if(j == flowerbed.length-1 && flowerbed[j] == 0){
                    j++;
                }
                j++;
            }
            int diff = j - i - 0;
            canHold = canHold + diff/2;
            if(canHold>=n) return true;
            i=j;
        }

        while(i < flowerbed.length){
            int j = i+1;
            if(j == flowerbed.length) {break;}
            while(j<flowerbed.length && flowerbed[j] != 1 ){
                if(j == flowerbed.length-1 && flowerbed[j] == 0){
                    j++;
                }
                j++;
            }
            int diff = j - i - 1;
            if(diff%2==0){
                diff = diff/2-1;
            }else{
                diff = diff/2;
            }
            canHold = canHold + diff;
            if(canHold>=n) return true;
            i = j;
        }

        return canHold>=n;
    }
}
