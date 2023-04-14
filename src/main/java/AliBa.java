import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AliBa {
    public int distinctPrimeFactors(int[] nums, int s) {
        int n = nums.length;
        int flag = 0;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if(i==j){
                    dp[i][j]=nums[i];
                }else{
                    dp[i][j] = dp[i][j - 1] * nums[j];
                }
            }
        }

        for (int k = 0; k < n; k++) {
            for (int l = 0; l < n; l++) {
                int res = 1;
                for (int m = 1; m <= dp[k][l] / 2; m++) {
                    if (dp[k][l] % m == 0) {
                        res+=1;
                    }
                }
                if (res >= s) {
                    flag += 1;
                }
            }
        }
        return flag;
    }

    public static void main(String[] args) {
        AliBa cd = new AliBa();

        List<String> strone = new ArrayList<>();

//        strone.add("vdfb");
//        System.out.println(strone.size());

//        int[] nums = new int[]{2, 6};
        Scanner sc = new Scanner(System.in);
        System.out.println("输入值并用逗号隔开");
        String[] arrone = sc.next().toString().split(",");
//        String str1 = sc.next().toString();
//        String[] arrone = str1.split(",");

        int[] bas = new int[arrone.length];
        for(int j = 0; j<bas.length;j++) {
            bas[j] = Integer.parseInt(arrone[j]);
            System.out.println(bas[j]+" ");
        }


        
        
        
        
        System.out.println("请输入"+bas[0]+"个数并用逗号隔开：");
        String str = sc.next().toString();
        String[] arr  = str.split(",");
        int[] b = new int[arr.length];
        for(int j = 0; j<b.length;j++) {
            b[j] = Integer.parseInt(arr[j]);
            System.out.println(b[j]+" ");
        }

        System.out.println(cd.distinctPrimeFactors(b, bas[1]));

    }
}



//        HashSet res = new HashSet();
//        for (int num : nums) {
//            res.addAll(getPrimeFactor(num).keySet());
//        }
//        return res.size();
//    }

//
//    private static HashMap<Integer, Integer> getPrimeFactor(int num) {
//
//        HashMap<Integer, Integer> res = new HashMap<>();
//        for (int i = 2; i < (Math.sqrt(num) + 2); i++) {
//            int cnt = 0;
//            while (num % i == 0) {
//                num /= i;
//                cnt++;
//            }
//            if (cnt != 0) {
//                res.put(i, cnt);
//            }
//            if (i > num) {
//                break;
//            }
//        }
//        if (num != 1 || res.isEmpty()) {
//            res.put(num, 1);
//        }
//        return res;
//    }
//
//}

