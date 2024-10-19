/**You are given an integer array nums. The range of a subarray of nums is the difference between the largest and smallest element in the subarray.

Return the sum of all subarray ranges of nums.

A subarray is a contiguous non-empty sequence of elements within an array.**/class Solution {

    private int[] getNSE(int[] a) {

        Stack<Integer> s = new Stack<>();

        int[] ans = new int[a.length];

        for (int i = a.length - 1; i >= 0; i--) {

            while (!s.isEmpty() && a[s.peek()] >= a[i]) {

                s.pop();

            }

            ans[i] = s.isEmpty() ? a.length : s.peek();

            s.push(i);

        }

        return ans;

    }

    private int[] getPSE(int[] a) {

        Stack<Integer> s = new Stack<>();

        int[] ans = new int[a.length];

        for (int i = 0; i < a.length; i++) {

            while (!s.isEmpty() && a[s.peek()] > a[i]) {

                s.pop();

            }

            ans[i] = s.isEmpty() ? -1 : s.peek();

            s.push(i);

        }

        return ans;

    }

    private int[] getPGE(int[] a) {

        Stack<Integer> s = new Stack<>();

        int[] ans = new int[a.length];

        for (int i = 0; i < a.length; i++) {

            while (!s.isEmpty() && a[s.peek()] <a[i]) {

                s.pop();

            }

            ans[i] = s.isEmpty() ? -1 : s.peek();

            s.push(i);

        }

        return ans;

    }

    private int[] getNGE(int[] a) {

        Stack<Integer> s = new Stack<>();

        int[] ans = new int[a.length];

        for (int i = a.length - 1; i >= 0; i--) {

            while (!s.isEmpty() && a[s.peek()] <= a[i]) {

                s.pop();

            }

            ans[i] = s.isEmpty() ? a.length : s.peek();

            s.push(i);

        }

        return ans;

    }

    public long subArrayRanges(int[] nums) {

        int[] nge = getNGE(nums);

        int[] pge = getPGE(nums);

        int[] nse = getNSE(nums);

        int[] pse = getPSE(nums);

        long min = 0, max = 0;

        int m = (int) (1e9 + 7);

        for (int i = 0; i < nums.length; i++) {

            int gr = i - pge[i];

            int gl = nge[i] - i;

            int sr = i - pse[i];

            int sl = nse[i] - i;

            min = min + ((long) sl * sr * nums[i]);

            max = max + ((long) gl * gr * nums[i]);

        }

        return (max - min );

    }

}
