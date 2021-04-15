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
                // group函数  0表示整个字符串匹配   1-表示第一个子模式的匹配 2-表示第二个子模式的匹配 以此类推
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

        // + 号    匹配至少出现一次的字符
        print(".+", "hello world");
        print("[a-z]+", "123 helloworld #");

        // ? 号   匹配出现0次或者1次的字符
        print("[ab]?c", "acc");

    }

    //-----------------{}号 限定一个或一组字符可以重复出现的次数---------------------
    public static void squareBrackets() {
        print("[0-9]{5,10}", "your qq is 927482058");

        print("[a-z]{3}", "MyName is joe");

        print("[a-z0-9]{8,}", "qweru4jus_jiu");
    }

    //---------------(...) 特征标群: 括号内代表一个整体需要匹配的字符串----------------------
    public static void parentheses() {
        print("(ba).+", "banana");
        //可以通过|表示或条件
        print("(b|c|d)at", "bat-dat-cat");

    }

    //--------------特殊字符---------------
    public static void specialCharacters() {
        print("\\.{1}", "today is thursday.");
    }

    //--------------锚点--------------------
    public static void anchor() {
        //^配置指定开头   $配置指定结尾
        print("^(the).+", "the player star is called james");

        print(".+(james)$", "the player star is called james");
    }

    //--------------------简写字符集-------------------------
    public static void abbreviationCharacterSet() {
        //. 匹配任意字符 除换行符
        print(".+", "the \n player star is called james");
        // \w 匹配所有字母数字，等同于 [a-zA-Z0-9_]
        print("\\w+", "lebron_James23");
        // \W 匹配所有非字母数字，等同于 [a-zA-Z0-9_]
        print("\\W+", "lebron_James#\n");
        // \d 匹配所有数字
        print("\\d+", "lebron_James23");
        // \D 匹配所有非数字
        print("\\D+", "lebron_James23#");
        // \s 匹配所有空格字符，等同于[\t\n\f\r\p{Z}]
        print("\\s+", " lebron  james  ");
        // \S 匹配所有非空格字符
        print("\\S+", " lebron  james  ");
        // \f 匹配一个换页符
        print("\\f", " lebron  james \f");
        // \n 匹配一个换行符
        print("\\n", "lebron james \n");
        // \t 匹配一个制表符
        print("\\t", " lebron  james \t");
        // \p 匹配一个制表符
        print("\\p", " lebron  james \r\n");
    }


    //----------------零宽度断言（前后预查）---------------
    public static void assertions() {
        //?=... 正先行断言(存在，用来预先判断想要匹配的字符紧接着的是否是?=后面的匹配的字符)
        print("\\w+(?=test)", "abc123test");
        //?!... 负先行断言(排除，用来预先判断想要匹配的字符紧接着的是否不是?=后面的匹配的字符)
        print("\\w+(?!test)", "abc123test");
        //?<=... 正后发断言(存在，用来预先判断想要匹配的字符前面是否是?=后面的匹配的字符)
        print("(?<=test)\\w+", "testabc123");
        //?<=... 负后发断言(存在，用来预先判断想要匹配的字符前面是否不是?=后面的匹配的字符)
        print("(?<!test)\\w+", "abctest123");
    }

    //--------------------------标志----------------------------
    public static void symbol() {
        //忽略大小写 (Case Insensitive)
        print("(?i)abc", "abc123AbcTest");

        print("(?mi)^abc.$", "abce" + "\n" +
                "abcd");
    }

    //-----------------------贪婪匹配与惰性匹配----------------------
    public static void mode() {
        //贪婪匹配模式(默认)
        print(".*at", "The fat cat sat on the mat. ");

        print(".*?at", "The fat cat sat on the mat. ");
    }


    public static void main(String[] args) {
//        baseMatch();
//        metacharacter();
//        squareBrackets();
//        parentheses();
//        specialCharacters();
//        anchor();
//        abbreviationCharacterSet();
//        assertions();
//        symbol();
        mode();
    }


}
