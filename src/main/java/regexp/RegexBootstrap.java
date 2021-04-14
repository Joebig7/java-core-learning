package regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author JoeBig7
 * @date 2021/4/14 18:23:04
 * @description 正则表达式 demo
 */
public class RegexBootstrap {

    public static void print(String regexp, String str) {
        Pattern pattern = Pattern.compile(regexp);
        Matcher matcher = pattern.matcher(str);

        while (matcher.find()) {
            for (int i = 0; i <= matcher.groupCount(); i++) {
                String result = matcher.group(i);
                System.out.println(result);
            }
        }

        System.out.println("-----------------");
    }


    /**
     * 基本匹配
     */
    public static void baseMatch() {
        String str = "The fat cat sat on the mat.";
        print("the", str);
    }

    //--------------------元字符----------------------
    public static void metacharacter() {
        //点运算符 .   匹配任意单个字符（除换行符）
        print(".at", "cat bat");

        //字符集 []    方括号中的字符都是符合的
        print("[ak].be", "kobe's number is 24 and 8");

        //否定字符集 [^]  除了方括号内的都可以匹配
        print("[^c]og", "dog is very cute");

        // 重复次数  *号（表示匹配重复次数大于等于0次的）
        print(".*", "hello world");
        print("[a-z]*", "123 helloworld #");
        // + 号    至少出现一次
        print(".+", "hello world");
        print("[a-z]+", "123 helloworld #");


    }


    public static void main(String[] args) {
//        baseMatch();
        metacharacter();
    }


}
