package easy;
//link: https://leetcode.com/problems/pascals-triangle/
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalsTriangle {
    public static void main(String[] args) {
        System.out.println(generate(5));
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();

        tempList.add(1);
        list.add(tempList);
        // 1
        if(numRows==1){
            return list;
        }

        tempList = new ArrayList<>(Arrays.asList(1,1));
        list.add(tempList);

        if (numRows == 2){
            return list;
        }

        for (int i = 2; i < numRows; i++){
            tempList = new ArrayList<>();
            tempList.add(1);
            for (int j = 0; j < list.get(i-1).size()-1; j++){
                int k = j+1;
                int sum = list.get(i-1).get(j) + list.get(i-1).get(k);
                tempList.add(sum);
            }
            tempList.add(1);
            list.add(tempList);
        }

        return list;
    }
}
