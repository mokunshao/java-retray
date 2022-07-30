package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.retry.RetryCallback;
import org.springframework.retry.RetryContext;
import org.springframework.retry.policy.SimpleRetryPolicy;
import org.springframework.retry.support.RetryTemplate;

public class SimpleDemo2 {

    private static final Logger LOGGER = LoggerFactory.getLogger(SimpleDemo2.class);

    public static void main(String[] args) throws Exception {
        RetryTemplate template = new RetryTemplate();

        // 策略
        SimpleRetryPolicy policy = new SimpleRetryPolicy();
        policy.setMaxAttempts(3);
        template.setRetryPolicy(policy);
        try {
            String result = template.execute(
                    (RetryCallback<String, Exception>) arg0 -> {
                        int retryCount = arg0.getRetryCount();
                        if (retryCount != 2) {
                            throw new NullPointerException();
                        }
                        return "haha";
                    }
            );
            LOGGER.info("result: {}", result);
        } catch (Exception e) {
            System.out.println("多次后失败了");
        }
    }

}