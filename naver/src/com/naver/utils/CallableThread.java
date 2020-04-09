package com.naver.utils;

import java.util.concurrent.Callable;

/**
 * 执行线程
 *
 * @author lihx23472
 * @create 2020-04-09 20:51
 */
public class CallableThread implements Callable {
    private String value;
    public CallableThread(String value){
        this.value = value;
    }
    @Override
    public Object call() throws Exception {
        try {
            //模拟任务
            System.out.print(value+",");
        }catch (Exception e){
            return 0;
        }
        return 1;
    }
}
