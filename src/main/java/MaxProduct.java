public class MaxProduct {

    public int maxMuli(int[] nums) {
//       两个变量维护     滚动数组思想: 滚动数组：本质就是显示屏  典型例子 斐波那契数列  F[3] 3个空间搞定

        int maxF = nums[0], minF = nums[0], ans = nums[0];
        int length = nums.length;
        for (int i = 1; i < length; ++i) {
            int mx = maxF, mn = minF;
            // 计算最大值--针对nums[i]是正数 和 最小值->针对nums[i]是负数 ，然后三数相比,两层max()或者min()
            maxF = Math.max(mx * nums[i], Math.max(nums[i], mn * nums[i]));
            minF = Math.min(mn * nums[i], Math.min(nums[i], mx * nums[i]));
            ans = Math.max(maxF, ans);
        }
        return ans;


        //   错误代码如下:
     /*   int maxF = nums[0], minF = nums[0], ans = nums[0];
        int length = nums.length;
        for (int i = 1; i < length; ++i) {
//            int mx = maxF, mn = minF;
            // 计算最大值--针对nums[i]是正数 和 最小值->针对nums[i]是负数 ，然后三数相比
            maxF = Math.max(minF * nums[i], Math.max(nums[i], maxF * nums[i]));
            minF = Math.min(maxF * nums[i], Math.min(nums[i], minF * nums[i]));
            ans = Math.max(maxF, ans);
        }
        return ans;*/
    }

    public static void main(String[] args) {
        MaxProduct mp = new MaxProduct();
        int[] nums = new int[] {2,3,-2,4};
        System.out.println(mp.maxMuli(nums));
    }


}


