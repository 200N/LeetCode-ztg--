class Twopoints {
    public boolean isPalindrome(String s) {
        // double points  简单型
        StringBuffer one = new StringBuffer();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char ch = s.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                one.append(Character.toLowerCase(ch));
            }
        }
        int n = one.length();
        int left = 0, right = n - 1;
        while (left < right) {
            if (Character.toLowerCase(one.charAt(left)) != Character.toLowerCase(one.charAt(right))) {
                return false;
            }
            ++left;
            --right;
        }
        return true;
    }


    public static void main(String[] args) {
        Twopoints tw = new Twopoints();
        System.out.println(tw.isPalindrome("A B CCC CCC"));
    }


}

