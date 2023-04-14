import java.util.*;

public class AsList {

    public static void main(String[] args) {
        Integer[] data = {1, 4, 3, 1};

        System.out.println(data);
        System.out.println(data);
//整理代码格式 CTRL+ALT+L
  /*       作为JDK内置的API，Arrays.asList 能够将数组转化为List，非常有助于我们的日常开发。同时创建 java.util.ArrayList对象，允许传递一个集合对象。

            因此创建一个可变的list只需要两个步骤：

            第一步：使用Arrays.asList()将数组转化为不可变的list

            第二步：使用 java.util.ArrayList将不可变的list转为可变的list

        String[] strs = {"aaa", "bbb", "ccc"};
        List<String> list = new ArrayList<>(Arrays.asList(strs));

        list.add("ddd");*/

        List<Integer> list = new ArrayList(Arrays.asList(data));
        //可删可加
        list.add(9);
        for (Integer i : list) {
            System.out.println(i);
        }
//        System.out.println(list);
    }

}



