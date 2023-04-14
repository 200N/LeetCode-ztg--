class Lis {
//    最长递增子序列
    // 贪心 + 二分算法  O(nlogn) 介绍参考链接：https://www.bilibili.com/video/BV1ub411Q7sB/

    public int lengthOfLIS(int[] nums) {
        int leng = nums.length;

        if (leng == 0) {
            return 0;
        }
        int[] dp = new int[leng + 1];
        // 可以从 0 下标 或者 1下标
        // index 用于表示最长递增子序列的长度 ,最少为1 ,所以初始化为1
        int index = 1;
        dp[index] = nums[0];
        // nums[1]开始比对
        for (int i = 1; i < leng; i++) {
            if (nums[i] > dp[index]) {
                // 加
                dp[++index] = nums[i];
            } else {
                int left = 1, pos = 0;
                int right = index;
                // 二分
                while (left <= right) {
                    int mid = (left + right) / 2;
//                       注意此处是 nums[i]、dp[mid]之间的比较 与下文对应
                    if (nums[i] > dp[mid]) {
                        // 找到第一个比nums[i]小的数 保存下标
                        pos = mid;
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }
                // 这里注意 left 和 pos+1 同样效果 注意此处是 nums[i]、dp[mid]之间的比较
                dp[left] = nums[i];
            }
            // 改
        }

        return index;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{10, 9, 2, 5, 3, 4};
        System.out.println(new Lis().lengthOfLIS(nums));
    }
}


