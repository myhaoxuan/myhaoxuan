package com.naver.test;

import com.naver.utils.Cache;

/**
 * naver试题2
 *
 * @author lihx23472
 * @create 2020-04-09 21:18
 */
public class Test2 {
    public static void main(String[] args) throws InterruptedException {
        final Cache cache = new Cache();
        for(int i=0;i<100;i++) {
            Thread test = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (cache.validateCache("testKey")) {
                        if(cache.updateData("testKey")){
                            cache.processCachedData("testKey");
                        }
                    }
                }
            });
            test.start();
        }
    }
}
