import java.util.Scanner;

public class HuiwenSub {
    public int countHuiwenSub(String s) {
//        public int cout(String s){
//            int leng = s.length();
//            char[] str = s.toCharArray();
//            int ans = 0;
//            for(int i = 0;i<leng;i++){
//                int left = i-1,right = i+1;
//                while(left>=0 && right<leng && str[left--] == str[right++]){
//
//                }
//                int j = i,m = i+1;
//                for(j>=0 && m<leng && str[j--]==str[m++]){
//
//                }
//            }
//        }
        int leng = s.length();
        char[] str = s.toCharArray();
        int ans = 0;
        for (int i = 0; i < leng; i++) {
            int left = i - 1, right = i + 1;
            while (left >= 0 && right < leng && str[left--] == str[right++]) {
                ans++;
            }
            int j = i, k = i + 1;

            while (j >= 0 && k < leng && str[j--] == str[k++]) {
                ans++;
            }
        }
        return ans + leng;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(new HuiwenSub().countHuiwenSub(str.substring(1,str.length()-1)));

    }
}


// DP 计数问题 或者  中心扩散法
//            int n = s.length();
//            int ans = 0;
//            for (int center = 0; center < n; center++) {
//                ans += expand(s, center, center) + expand(s, center, center + 1);
//            }
//            return ans;
//        }
//
//        private int expand(String s, int left, int right) {
//            int ans = 0;
//            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
//                ans++;
//                left--;
//                right++;
//            }
//            return ans;
//        }
//    }
//

