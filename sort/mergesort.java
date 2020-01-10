package sort;
import java.util.ArrayList;
import java.util.List;

public class mergesort {
    private int[] unsorted;

    public mergesort(int[] nums) {
        unsorted = nums;
    }

    public List<Integer> sortArray() {
        if (unsorted.length != 0) return mergeSort(unsorted, 0, unsorted.length - 1);
        else return new ArrayList<>(0);
    }

    private List<Integer> mergeSort (int[] nums, int from, int to) {
        int n = to - from + 1;
        if (n == 1) {
            List<Integer> rst = new ArrayList<>(n);
            rst.add(nums[from]);
            return rst;
        }
        int q = (from + to) / 2;
        List<Integer> left = mergeSort(nums, from, q);
        List<Integer> right = mergeSort(nums, q+1, to);
        return merge(left, right);
    }

    private List<Integer> merge (List<Integer> a, List<Integer> b) {
        List<Integer> rst = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < a.size() && j < b.size()){
            if (a.get(i) <= b.get(j)) rst.add(a.get(i++));
            else rst.add(b.get(j++));
        }
        if (i == a.size()) while (j < b.size()) rst.add(b.get(j++));
        if (j == b.size()) while (i < a.size()) rst.add(a.get(i++));
        return rst;
    }

    public static void main(String[] args) {
        int[] sort = {1,3,5,2,4,6};
        mergesort srt = new mergesort(sort);
        System.out.println(srt.sortArray());
    }
}