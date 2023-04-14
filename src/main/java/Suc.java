import com.sun.deploy.util.StringUtils;

import java.util.*;

//小红书  加密 往后移动三位
public class Suc {

    public static void main(String[] args) {

        List<String> res = new ArrayList<>();
        Map<Character, Character> hs = new HashMap<>();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

//        System.out.println(n);
 /*      在下面这个例子中，我们首先使用Scanner类读取整数输入。
        由于nextInt()方法只读取整数部分，而不包括回车符，
        因此我们需要在接下来的nextLine()方法调用之前添加一个额外的scanner.nextLine()，
        以读取回车符。接下来，我们使用nextLine()方法读取字符串输入，并将输入的整数和字符串输出到控制台上。

        请注意，在读取整数输入后，我们需要使用额外的nextLine()方法来读取回车符。
        如果不这样做，下一次的nextLine()调用将会立即结束，因为它会读取回车符，而不是等待用户输入字符串。

        在 Java 中，nextLine()和next()都是Scanner可用于读取用户输入的类的方法。

        nextLine()读取输入直到当前行的末尾，而next()读取输入直到下一个空白字符（例如空格、制表符或换行符）。

        1.next()不会读取字符前/后的空格/Tab键，只读取字符（忽略空格回车等等），开始读取字符（字符前后不算）直到遇到空格/Tab键/回车截止吸取；(包括nextInt()、nextDouble()、nextFloat()等)遇到了空格, 就不再录入数据了 。
        结束标记: 空格, tab键。
        2.nextLine()读取字符前后的空格/Tab键，直到回车键截止。可以将数据完整的接收过来 。读取一行，注意到如果是一行的话，空格不作为分割符，一行一行的取，以回车（换行）结束一次取值。
        结束标记: 回车换行符。
            原文链接：https://blog.csdn.net/Gin_2000/article/details/118633856
          */

//        import java.util.Scanner;
//        public class Main {
//            public static void main(String[] args) {
//                Scanner scanner = new Scanner(System.in);
//                System.out.print("请输入整数：");
//                int num = scanner.nextInt();
//                scanner.nextLine(); // 读取整数后需要加一个nextLine()，以读取回车符
//                System.out.print("请输入字符串：");
//                String str = scanner.nextLine();
//                System.out.println("你输入的整数是：" + num);
//                System.out.println("你输入的字符串是：" + str);
//            }
//        }
//      此处用next()

        char[] s = sc.next().toCharArray();
        for (int i = 3; i < 26; ++i) {
//            此处使用(char) 将ASCII转换成对应字符
            hs.put((char) ('a' + i - 3), (char) ('a' + i));
        }

        hs.put('z', 'c');
        hs.put('y', 'b');
        hs.put('x', 'a');

        for (int i = 0; i < s.length; ++i) {

//            Character.toString()方法,将字符转换成字符串，此方法也可将ASCII转换为对应字符
            res.add(Character.toString(hs.get(s[i])));
        }
        System.out.println(res);
/*      经常遇到需要将List转为字符串的场景，如下举例两种使用：

        1.使用逗号分隔拼接。
        2.以及直接将List中的元素拼接。——此种方式经常使用。*/

//        StringUtils.join(res,"分隔符") 经常使用
        System.out.println(StringUtils.join(res,""));

        //转换成String对象
        System.out.println(res.toString());

    }
}


