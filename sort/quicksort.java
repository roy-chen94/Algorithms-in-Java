package sort;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> sortArray(int[] nums) {
        if (nums.length != 0) return sort(nums, 0, nums.length - 1);
        else return new ArrayList<>(0);
    }

    private List<Integer> sort (int[] nums, int from, int to) {
        List<Integer> rtn = new ArrayList<>(to - from + 1);
        if (from < to) {
            int i = from;
            for (int j = from; j < to; j++) {
                if (nums[j] < nums[to]) {
                    int tmp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = tmp;
                    i++;
                }
            }
            int tmp = nums[to];
            nums[to] = nums[i];
            nums[i] = tmp;
            List<Integer> left = sort(nums, from, i - 1);
            List<Integer> right = sort(nums, i + 1, to);
            rtn.addAll(left);
            rtn.add(nums[i]);
            rtn.addAll(right);
        } else if (from == to) rtn.add(nums[from]);
        return rtn;
    }

    public static void main(String[] args) {
        Solution sl = new Solution();
        int[] st = {5,2,3,1};
        System.out.println(sl.sortArray(st));
    }
}