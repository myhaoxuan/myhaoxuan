package com.naver.utils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程池工具
 * @author lihx23472
 */
public class ThreadPoolUtil {
    private static volatile ExecutorService executorService;
    private final static int THREAD_NUM = 5;
    public static ExecutorService getInstance() {
        if (executorService == null) {
            synchronized (ExecutorService.class) {
                if (executorService == null) {
                    executorService = Executors.newFixedThreadPool(THREAD_NUM);
                }
            }
        }
        return executorService;
    }
}
