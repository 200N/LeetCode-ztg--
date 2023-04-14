import java.util.LongSummaryStatistics;
/*贪心算法和动态规划算法都是常见的算法设计方法，它们在解决某些问题时具有一定的相似性，但也存在一些显著的区别。以下是它们的主要区别：

        状态转移方程不同：贪心算法通常只考虑当前局部最优解，而不考虑全局最优解。因此，贪心算法的状态转移方程是单向的，不可逆的，不能回溯。而动态规划算法则会维护一个全局最优解的状态转移方程，需要记录所有状态，并在计算过程中进行回溯。

        算法复杂度不同：在某些问题上，贪心算法通常具有较低的时间和空间复杂度，而动态规划算法则可能需要更多的计算和存储资源。

        适用问题不同：贪心算法通常适用于一些可分割、子问题独立且具有贪心选择性质的问题，例如最小生成树、最短路径等。而动态规划算法则适用于一些具有最优子结构性质的问题，例如背包问题、最长公共子序列等。

        求解结果不同：贪心算法可以得到一个近似最优解，但不能保证得到全局最优解。而动态规划算法则可以保证得到全局最优解。*/


public class Lcs {
        public void LcsLength(char[] x,char[] y,int[][] Rec){
            //初始化

            int [][]c=new int[x.length+1][y.length+1];
            for(int i=0;i<=x.length;i++){
                c[i][0]=0;
                Rec[i][0]=0;
            }
            for(int j=0;j<=y.length;j++){
                c[0][j]=0;
                Rec[0][j]=0;
            }
            //动态规划
            for(int i=1;i<=x.length;i++){
                for(int j=1;j<=y.length;j++){
//                    核心代码
//                    if(x[i-1]==y[j-1]){
//                        c[i][j] = c[i-1][j-1]+1;
//                    }else if(c[i-1][j] >= c[i][j-1]) {
//                        c[i][j] = c[i-1][j];
//                    }else {
//                        c[i][j] = c[i][j-1];
//                    }

                    if(x[i-1]==y[j-1]){
                        c[i][j]=c[i-1][j-1]+1;
                        //当Rec为1时，表示Xi和Yi的最长公共子序列是由Xi-1和Yi-1的最长公共子序列在尾部加上Xi所得的子序列。
                        Rec[i][j]=1;
                    }else if(c[i-1][j]>=c[i][j-1]){
                        c[i][j]=c[i-1][j];
                        //当Rec为2时，表示Xi和Yi的最长公共子序列与Xi-1和Yi的最长公共子序列相同。
                        Rec[i][j]=2;
                    }else{
                        c[i][j]=c[i][j-1];
                        //当Rec为3时，表示Xi和Yi的最长公共子序列与Xi和Yi-1的最长公共子序列相同。
                        Rec[i][j]=3;
                    }
                }
            }

            System.out.println("动态规划表格为：");
            for(int i=0;i<=x.length;i++){
                for(int j=0;j<=y.length;j++){
                    System.out.print(c[i][j]+" ");
                }
                System.out.print("\n");
            }
            System.out.println("bdbd");
            System.out.println("记录子问题解的来源的数组为：");
            for(int i=0;i<=x.length;i++){
                for(int j=0;j<=y.length;j++){
                    System.out.print(Rec[i][j]+" ");
                }
                System.out.print("\n");
            }
            System.out.println("最长公共子序列为：");
            lcs(x.length,y.length,x,Rec);
        }

        //递归 回溯
        public void lcs(int i,int j,char[] x,int[][] Rec){
            if(i==0||j==0) return ;
            if(Rec[i][j]==1){
                lcs(i-1,j-1,x,Rec);
                //注意此处输出x[i-1] 末尾下标为 i-1,参考链接>https://blog.csdn.net/qq_58668057/article/details/123774788
                System.out.print(x[i-1]);

            }else if(Rec[i][j]==2) lcs(i-1,j,x,Rec);
            else lcs(i,j-1,x,Rec);
        }

        public static void main(String[] args){
            Lcs object=new Lcs();
            char[] x={'A','A','G','A'};
            char[] y={'A','T','A','G','C','G','T','C'};
            //定义一个数组用来记录c[i][j]的值是由哪一个子问题的解得到的
            int [][] Rec=new int[x.length+1][y.length+1];
            object.LcsLength(x,y,Rec);
        }

    }
