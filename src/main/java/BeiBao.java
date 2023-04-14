import java.util.Scanner;

public class BeiBao {

    // 记忆法搜索 回溯
//     int count = 0;
//     // int count  = 0;
//     // int sum = 0;
//     // backtrace(nums,target,0,0);

// //    public void backtrace(int[] nums, int target,int sum,int index){
// //        if(index==length){
// //            if(target==sum){
// //                count++;
// //            }
// //        }
// //        backtrace(nums,target,sum+nums[index],index+1);
// //        backtrace(nums,target,sum-nums[index],index+1);

// //    })

//     public int findTargetSumWays(int[] nums, int target) {
//         // DP 计数问题 或者  回溯法递归遍历DFS   左子树sum +  右子树sum -

//         backtrack(nums, target, 0, 0);
//         return count;
//     }

//     public void backtrack(int[] nums, int target, int index, int sum) {
//         if (index == nums.length) {

//             if (sum == target) {
//                 count++;
//             }
//             // if 条件下  此时return 加不加都一样
//             // return;
//         } else {
//             // 看作左右子树
//             backtrack(nums, target, index + 1, sum + nums[index]);
//             backtrack(nums, target, index + 1, sum - nums[index]);
// }
// }

    // class Solution {
//    目标和
    public int findTargetSumWays(int[] nums, int target) {
        int leng = nums.length;
        int sum = 0;
        for (int num : nums) sum += num;
        if ((sum + target) % 2 == 1 || Math.abs(sum) < target) return 0;
        int pos = (sum + target) / 2;
        int[] dp = new int[pos + 1];
        dp[0] = 1;
//       普适性：确立变量个数  分别循环遍历 正序或者逆序
        for (int num : nums) {
            for (int j = pos; j >= num; j--) {
                //         滚动数组接连覆盖作用
                dp[j] += dp[j - num];
            }
        }
        return dp[pos];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        for()

        String[] str = sc.nextLine().toString().split(",");
        int[] nums = new int[str.length];
        for (int i = 0; i < str.length; i++) {
            nums[i] = Integer.parseInt(str[i]);
        }
        int m = sc.nextInt();
        sc.close();
        System.out.println(new BeiBao().findTargetSumWays(nums, m));

    }
}


    /*
    背包问题总结:放不放 ，不放是一种：顺延之前 ；放进去（前提是能放进去）是一种  ：dp[j-num] 代表j-nums 创造的最大价值

    类01背包问题:
    设pos为取+的数字和,neg为取-的数字和(均为正数),则target=pos-neg=pos-(sum-pos)=2*pos-sum
    故pos=(sum+target)/2>=0且为常数,因此此问题等价于求有多少种方式用nums[i]凑成和为pos

    进而该问题抽象为:用价值与体积均为nums[i]的物品,恰好凑满容量为pos的背包方案数
    1.状态定义:dp[j]为恰好能凑满容量为j的背包方案数
    2.状态转移:背包容量能或者不能装下nums[i]
        2.1 当不能装下nums[i]时,方案数直接继承之前的dp[j]
        2.2 当能装下nums[i]时,总的方案数为不考虑nums[i]的方案数+有nums[i]参与新增的方案数
            dp[j] += dp[j - nums[i]],dp[j - nums[i]]种方案与nums[i]共同凑成pos,即1*dp[j - nums[i]]
    3.状态初始化:dp[0]=1,因为后面总会一直查找至j=0,如dp[3] += dp[3-3],空集是任意一条有效路径的起点,当属一条

    4.遍历顺序:i正序,j倒序，注意：正序会产生覆盖 污染数据，所以不可取。参考链接：https://www.youtube.com/watch?v=AFspvwnCcK4

    5.返回形式:dp[pos]就是凑成pos总的方案数
    */
/*    int len = nums.length;
    int sum = 0;
            for(
    int num :nums)sum +=num;
    // pos为小数||target绝对值比sum还大
            if((sum +target)%2==1||Math.abs(target)>sum)return 0;
    int pos = (sum + target) / 2;

    int[] dp = new int[pos + 1];
    dp[0]=1;
    //    画出DP table 便于理解 00000000000
    //                         0
    //                         0
    //                         0
            for(
    int num :nums)

    { // 注意此处逆序 对于此类问题具有普适性  可以这样理解：因为在计算过程中，针对某个nums[i]代表的行，该行后面的结果由前面的数得出，所以逆序不影响前面的原始数据。
        // j是主角 for循环外表示nums[i]放不进去背包，则顺延之前
        for (int j = pos; j >= num; j--) {
            dp[j] += dp[j - num];
        }
    }
            return dp[pos];
}
    }*/


// 暴力破解 超出时间
//         int leng = nums.length;
//         List<List<Integer>>  ls = new ArrayList<>();
//         ls.add(new ArrayList<>());
//         ls.get(0).add(nums[0]);
//         ls.get(0).add(-nums[0]);
//         int res =0;
//         // int[] dp = new int[leng+1];

//         for(int i = 1 ;i<leng;i++){
//             ls.add(new ArrayList<>());
//             for(int j =0;j<ls.get(i-1).size();j++){
//             ls.get(i).add(ls.get(i-1).get(j)+nums[i]);
//             ls.get(i).add(ls.get(i-1).get(j)-nums[i]);
//             }
//         // for (int i = leng-1;i>=0;i--){

// dp[i][target] = dp[i-1][target-nums[i]]+dp[i-1][target+nums[i]];

//         // }

//         }
//         for(int i = 0;i<ls.get(leng-1).size();i++){
//             if(ls.get(leng-1).get(i)==target){
//                 res++;
//             }
//         }
//         return res;
//     }
// }

