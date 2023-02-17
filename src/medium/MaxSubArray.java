package medium;

import easy.ListNode;

import java.lang.reflect.Array;
import java.util.*;

public class MaxSubArray {
    public static void main(String[] args) {
     //   System.out.println(maxSubArray(new int[]{5,4,-1,7,8}));
    //    System.out.println(subarraySum(new int[]{1},0));

        // Prompt the player to enter their name. Use their name to print a greeting, ie “Welcome, <Name>!”.
        // The name should be alpha characters only, abc.., and the length should be 3-10 characters. No special characters are allowed.

  //     (new int[]{30,10,20,20,20,10,40,30,30}, 3);
//        String name = "Ars l a    n";
//        String s = name.replaceAll(" ","");
//        System.out.println(s);
 //       System.out.println(mostFrequentEven(new int[]{0,1,2,2,4,4,1}));;
        System.out.println(17%18);
        ListNode a = new ListNode(1);
        ListNode h = a;
        int c = 2;
        while(true){
            a.next = new ListNode(c);
            c++;
            a = a.next;
            if(c==5) break;
        }

        splitListToParts(h,2);
//        oddEvenList(h);
//
//        while(h != null){
//            System.out.println(h.val + "->");
//            h = h.next;
//        }



    }

    public static int mostFrequentEven(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();

        for(int n : nums){
            if(n%2==0){
                if(map.containsKey(n)){
                    map.put(n,map.get(n)+1);
                }else{
                    map.put(n,1);
                }
            }
        }

        if(map.size()==0) return -1;

        int max = -1;
        for(int value : map.values()){
            max = Math.max(max,value);
        }

        int minNum = Integer.MAX_VALUE;

        for(Map.Entry<Integer,Integer>entry: map.entrySet()){
            if(entry.getValue()==max) {
                minNum = Math.min(minNum, entry.getKey());
            }
        }

        return minNum;
    }

    public static int maxSubArray(int[] nums) {
        int sum = Integer.MIN_VALUE;
        int tempSum = 0;
        for (int i = 0; i < nums.length; i++) {
            tempSum = nums[i];
            for (int j = i+1; j < nums.length; j++) {
                sum = Math.max(sum, tempSum);
                tempSum+=nums[j];
            }
            sum = Math.max(sum, tempSum);
        }
        return sum;
    }

    public int findMaxLength(int[] nums) {
        int res = 0;
        Map<Integer,Integer> map = new HashMap<>();
        int prefixSum = 0;
        for (int i = 0; i< nums.length; i++) nums[i] = nums[i] == 0 ? -1 : 1;

        for (int i = 0; i < nums.length; i++){
            prefixSum = prefixSum + nums[i];
            if(prefixSum==0) res = i+1;
            if(!map.containsKey(prefixSum)){
                map.put(prefixSum,i);
            }
            if(map.containsKey(prefixSum)){
                res = Math.max(res,i-map.get(prefixSum));
            }
        }
        return res;
    }

    public static int subarraySum(int[] nums, int sum) {

        int res = 0, prefixSum = 0;
        Set<Integer> set = new HashSet<>();
        Map<Integer,Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            prefixSum = prefixSum + nums[i];
            if(prefixSum==sum) res++;
            if(!map.containsKey(prefixSum)) map.put(prefixSum,1);
            if(map.containsKey(prefixSum-sum)) res++;

        }
        return res;
    }

    public int longestConsecutive(int[] nums) {

        int res = 0;
        Set<Integer> set = new HashSet<>();
        for (int n:nums) set.add(n);

        for (int n:set) {
            if(set.contains(n-1)) continue;
            int count = 1;
            while(set.contains(n)){
                n++;
                count++;
            }
            res = Math.max(res,count);
        }
        return res;
    }

    public static int countDistinctElementsInWindow(int[] nums,int k) {

        int res = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < k; i++) map.put(nums[i],map.getOrDefault(nums[i],0)+1);

        for (int i = k; i< nums.length; i++){
            System.out.println(map.size());
            map.put(nums[i], map.getOrDefault(nums[i],0)+1);
            map.put(nums[i-k],map.get(nums[i-k])-1);
            if(map.get(nums[i-k])==0) map.remove(nums[i-k]);
        }

        System.out.println(map.size());

//            for(int j = i; j < i+k; j++){
//                map.put(nums[j],map.getOrDefault(nums[j],0)+1);
//                if(j-i+1==k){
//                    System.out.println(map.size());
//                    map.replace(nums[j+1-k], map.get(nums[j+1-k])-1);
//
//                    if(map.get(nums[j+1-k]) == 0) map.remove(nums[j+1-k]);
//                }
//            }


        return res;
    }

    public static List<Integer> majorityElement(int[] arr) {
        List<Integer> list = new ArrayList<>();
        Arrays.sort(arr);
        return list;
    }

    public static ListNode oddEvenList(ListNode head) {
        if (head == null) return null;
        int counter = 1;
        ListNode cur = head, even = head.next, prev = cur;
        while (cur.next != null) {
            ListNode next = cur.next;
            cur.next = next.next;
            prev = cur;
            cur = next;
            ++counter;
        }
        System.out.println(counter);
        System.out.println("prev: " + prev.val);
        System.out.println("curr: " + cur.val);
        if (counter % 2 != 0)
            cur.next = even;
        else
            prev.next = even;
        return head;
    }

    public static ListNode[] splitListToParts(ListNode head, int k) {

        ListNode temp = head;
        int count = 0;
        while(temp != null){
            count++;
            temp = temp.next;
        }
        ListNode[] arr = new ListNode[k];
        if(k==1){
            arr[0] = head;
            return arr;
        }
        int rem = count%k;
        double part = Math.ceil((double) count/(double) k);
        double numBigPartitions = rem;
        ListNode curr = head;
        int index = 0;

        while(index<arr.length){
            int counter = 1;
            part = Math.ceil((double) count/(double) k);
          //  if(rem == 0) counter = 0;
            ListNode temp2 = curr;
            part = numBigPartitions > 0 ? part + 1 : part;
            if(rem==0) counter = 0;
            while(counter < part-1){
                temp2 = temp2.next;
                counter++;
            }
            numBigPartitions--;

            if(null!=temp2){
                ListNode temp3 = temp2.next;
                temp2.next = null;
                arr[index] = curr;
                index++;
                curr = temp3;
            }else{
                arr[index] = curr;
                index++;
                break;
            }

        }
        return arr;
    }

    private static int getCount(ListNode head) {
        ListNode temp = head;
        int count = 0;
        while(temp != null){
            count++;
            temp = temp.next;
        }
        return count;
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode resHead = null;
        ListNode curr = null;
        ListNode node = null;
        boolean hasExtra = false;
        boolean firstTime = true;
        boolean endRiched = false;
        int sum = 0;

        while(!endRiched){
            sum = 0;
            if(hasExtra) sum++;
            int val1 = l1 == null ? 0 : l1.val;
            int val2 = l2 == null ? 0 : l2.val;
            sum = sum + val1 + val2;
            hasExtra = sum > 9;
            if(firstTime){
                sum = sum%10;
                curr = new ListNode(sum);
                resHead = curr;
                firstTime = false;
            }else{
                sum = sum%10;
                node = new ListNode(sum);
                curr.next = node;
                curr = node;
            }

            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
            endRiched = l1 == null && l2 == null;
        }

        if(l1 == null && l2 == null && hasExtra) {
            node = new ListNode(1);
            curr.next = node;
            return resHead;
        }

        return resHead;
    }

    public static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        Stack<ListNode> s1 = new Stack<>();
        Stack<ListNode> s2 = new Stack<>();

        ListNode temp = l1;
        fillStack(s1, temp);

        temp = l2;
        fillStack(s2,temp);

        int carry = 0, sum = 0;
        Stack<ListNode> longSt = s1.size() >= s2.size() ? s1 : s2;
        Stack<ListNode> shortSt = s1.size() < s2.size() ? s1 : s2;

        ListNode head = null;
        ListNode s = null;
        while(!shortSt.isEmpty()){
            head = longSt.pop();
            s = shortSt.pop();
            sum = head.val + s.val + carry;
            carry = getCarry(sum, head);
        }

        while (!longSt.isEmpty()){
            head = longSt.pop();
            sum = head.val + carry;
            carry = getCarry(sum, head);
        }

        if(carry == 1){
            temp = new ListNode(1);
            temp.next = head;
            head = temp;
        }
        return head;
    }

    private static int getCarry(int sum, ListNode head) {
        int carry;
        carry = sum > 9 ? 1 : 0;
        head.val = sum % 10;
        return carry;
    }

    private static void fillStack(Stack<ListNode> s1, ListNode temp) {
        while(temp != null){
            s1.push(temp);
            temp = temp.next;
        }
    }
}

