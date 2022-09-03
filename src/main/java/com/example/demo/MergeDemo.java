package com.example.demo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
class Job {
    String name;
    String subject;
    Integer score;

}

public class MergeDemo {
    public static void main(String[] args) {
        Job job = new Job("李四", "语文", 98);
        Job job1 = new Job("李四", "数学", 85);
        Job job2 = new Job("王五", "语文", 90);
        Job job3 = new Job("王五", "数学", 84);
        Job job4 = new Job("赵三", "语文", 89);
        Job job5 = new Job("赵三", "数学", 82);
        List<Job> list = new ArrayList<>();
        list.add(job);
        list.add(job1);
        list.add(job2);
        list.add(job3);
        list.add(job4);
        list.add(job5);
        Map<String, Integer> treeMap = new HashMap<>();
        list.forEach(jobs -> treeMap.merge(jobs.getName(), jobs.getScore(), Integer::sum));

        System.out.println("触发信息内容：" + treeMap);
    }
}
