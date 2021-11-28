public class LeetCode_560 {
    //暴力法太费时，参考精选题解
    public int subarraySum(int[] nums, int k) {
        int len = nums.length;
        int[] s = new int[len + 1];
        s[0] = 0;
        for (int i = 0; i < len; i++) {
            s[i + 1] = s[i] + nums[i];
        }
        int count = 0;
        for (int left = 0; left < len; left++) {
            for (int right = left; right < len; right++) {
                if (s[right + 1] - s[left] == k) {
                    count++;
                }
            }
        }
        return count;
    }
}
