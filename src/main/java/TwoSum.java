import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TwoSum {
    public int[] sumTwo(int[] nums,int n){
        Map<Integer,Integer> ha = new HashMap<>();
        int[] temp = new int[2];
        int m = nums.length;
        for(int i = 0;i<m;i++){
            if(ha.containsKey(n-nums[i])){
                temp[0] = i;
                temp[1] = ha.get(n-nums[i]);
                return temp;

            }
            ha.put(nums[i],i);
        }
        return temp;
    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();
//       注意”“ 和 ” “区别
        String[] arrone = sc.nextLine().toString().split(" ");

        int[] bas = new int[arrone.length];
        for(int j = 0; j<bas.length;j++) {
            bas[j] = Integer.parseInt(arrone[j]);
//            System.out.println(bas[j]+" ");
        }


//        Arrays.toString(int[]) 将数组原模原样显示出来
        System.out.println(Arrays.toString(new TwoSum().sumTwo(bas, n)));

    }


}
