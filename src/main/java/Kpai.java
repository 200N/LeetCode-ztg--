// 小红书 K排序
// 注意此题 并不复杂,下面进行推广
//举例:              1       100 1000 10000 900      2
//举例:              50      40 1000 10000 900      90
//                此时内部有序无序并不重要,最终按题目都会变成有序
    import java.util.*;
    public class Kpai {

        public static void main(String[] args) {
            Map<Integer,Integer> ha = new HashMap<>();
            Scanner scan = new Scanner(System.in);
            int t = scan.nextInt();
            while (t-- > 0){
                int n = scan.nextInt(), k = scan.nextInt();
                int ans;
                int cnt = 1;
                int res = Integer.MAX_VALUE;
                System.out.println("-----------------");

//                String[] arr = scan.next().toString().split();

                int[] b = new int[n];
                int[] c = new int[n];
                for(int j = 0; j<b.length;j++) {

                    b[j] = Integer.parseInt(scan.next());
                    ha.put(b[j], j);
//                  打印输入数组值
//                    System.out.println(b[j] + " ");
                }

//              保存排序前数组
                c = b.clone();
//              对排序
                Arrays.sort(b);
//                System.out.println(b[0]);
//                System.out.println(res);

                int m = ha.get(res);
                System.out.println("最小值对应排序前数组下标:"+m);

                for (int i = m+1,j=1; i < n; i++) {
//                    if (c[i]>c[m]) {
                        if(c[i]==b[j]) {
                            j++;
                            cnt++;
                        }

                }
                ans = (int) Math.ceil((n - cnt) * 1. / k);
                System.out.println(ans);
            }
        }
    }

//题目描述：
//
//        在算法中，有各种各样的排序算法，例如归并排序，冒泡排序，快速排序等等。本题中，我们会使用一种新的排序算法：K排序。
//        K排序算法描述如下：首先，算法需要按照某种规则选择该数列上至多K个位置，将其对应的数抽出来，其他的数都往左对齐，之后这K个数排好序之后依次放在原数列未尾。以上过程算作一次操作。
//        例如，对于数列[1,3,5,4,2]，当K=2时可以选择数字5和4，之后数列变成[1,3,2,4,5]。
//        你的任务是：对于给定的数列，你需要计算出最少需要多少次上述操作，使得整个数列从小到大排好序？
//
//        输入描述
//        第一行一个正整数T，表示有T组数据。
//        对于每一组数据，第一行输入两个正整数n,k；第二行输入n个数a1,a2,…,an。该序列是一个1~n的排列。
//        对于所有数据：1≤k≤n≤10^5, 1≤ai≤n, ai≠aj, 1≤T≤5  等价于 1到n  全排列,范围相当小 简单
//
//        输出描述
//        对于每一组数据，输出一行一个整数，表示答案。

//
//    import java.util.*;
//    public class Kpai {
//        public static void main(String[] args) {
//            Scanner scan = new Scanner(System.in);
//            int t = scan.nextInt();
//            while (t-- > 0){
//                int n = scan.nextInt(), k = scan.nextInt();
//                int ans, cnt = 0;
//                for (int i = 0, j = 1; i < n; i++) {
//                    if (j == scan.nextInt()) {
//                        cnt++;
//                        j++;
//                    }
//                }
//                ans = (int) Math.ceil((n - cnt) * 1. / k);
//                System.out.println(ans);
//            }
//        }
//    }


