package io.file;

import com.google.common.collect.Lists;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * @version 1.0
 * @author: JoeBig7
 * @date: 2020/2/6 21:40
 * @description 本demo用来展示File类和FileFilterName类型的主要作用，File代表的是文件或者文件路径名，FileFilterName可以用来过滤文件
 */
public class FileDemo1 {



    public static void main(String[] args) {

        // 获取文件路径下所有文件并且进行过滤

        String regexp = "^Pro.*";
        File file = new File("D:/");
        String[] list = file.list((dir, name) -> {
            Pattern pattern = Pattern.compile(regexp);
            return pattern.matcher(name).matches();
        });
        System.out.println(Arrays.toString(list));
    }

}