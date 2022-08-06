package com.example.demo.another;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Demo5 {

    public static void main(String[] args) {

        // 老公组
        List<Couple> husbands = new ArrayList<>();
        husbands.add(new Couple(1, "梁山伯"));
        husbands.add(new Couple(2, "牛郎"));
        husbands.add(new Couple(3, "干将"));
        husbands.add(new Couple(4, "工藤新一"));
        husbands.add(new Couple(5, "罗密欧"));

        // 老婆组
        List<Couple> wives = new ArrayList<>();
        wives.add(new Couple(1, "祝英台"));
        wives.add(new Couple(2, "织女"));
        wives.add(new Couple(3, "莫邪"));
        wives.add(new Couple(4, "毛利兰"));
        wives.add(new Couple(5, "朱丽叶"));

        String collect = husbands.stream()
                .flatMap(husband -> wives
                        .stream()
                        .filter(wife ->
                                husband.getFamilyId().equals(wife.getFamilyId()))
                        .map(wife -> husband.getUserName() + "爱" + wife.getUserName())
                )
                .collect(Collectors.joining("\r\n"));
        System.out.println(collect);
    }
}
