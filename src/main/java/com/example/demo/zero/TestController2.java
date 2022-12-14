package com.example.demo.zero;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
public class TestController2 {
    @Autowired
    private IRecursiveCallService recursiveCallService;

    private static final Integer RETRY_MAX_TIMES = 3;

    @GetMapping("test22")
    public Object test22() {
        return call();
    }

    public Object call() {
        int times = 0;
        while (times < RETRY_MAX_TIMES) {
            try {
                System.out.println("第" + times + "次尝试");
                return innerCall();
            } catch (Exception e) {
                times++;
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException ex) {
//                    throw new RuntimeException(ex);
//                }
//                if (times >= RETRY_MAX_TIMES) {
//                    return "没有结果";
//                }
            }
        }

        return "no result";
    }

    public Object innerCall (){
//        return "123";
        throw new RuntimeException();
    }
}