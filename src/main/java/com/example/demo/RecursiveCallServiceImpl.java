package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Collections;
import java.util.List;

@Service
public class RecursiveCallServiceImpl implements IRecursiveCallService {

    @Override
    @Retryable(recover = "testService3")
    public List<Integer> testService() {
        System.out.println("到此一游！");
        System.out.println(1 / 0);
        return null;
    }

    @Recover
    public List<String> testService1(Throwable throwable) {
        System.out.println("错误的返回");
        return Collections.singletonList("S");
    }

    @Recover
    public List<Integer> testService2(Throwable throwable, String id) {
        System.out.println("正确的返回");
        return Collections.singletonList(22);
    }

    @Recover
    public List<Integer> testService3(Throwable throwable) {
        System.out.println("正确的返回2");
        return Collections.singletonList(2);
    }
}