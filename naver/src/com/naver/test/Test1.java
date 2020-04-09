package com.naver.test;

import com.naver.utils.CallableThread;
import com.naver.utils.ThreadPoolUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 *
 *
 * @author lihx23472
 * @create 2020-04-09 20:18
 */
public class Test1 {
    public static void main(String[] args) {
        //模拟测试数据
        String[] testData = {"任务A","任务B","任务C","任务D","任务E","任务F","任务G","任务H"};
        List<Future<Integer>> results;
        //校验测试数据长度
        if(testData.length>0){
            results = new ArrayList<Future<Integer>>();
            for(int i=0;i<testData.length-1;i++) {
                Future<Integer> result = ThreadPoolUtil.getInstance().submit(new CallableThread(testData[i]));
                results.add(result);
            }
            do{
                //此处可以对任务执行的结果集做监控
            }while(((ThreadPoolExecutor)ThreadPoolUtil.getInstance()).getCompletedTaskCount() < results.size());
        }
        if(testData.length>0){
            System.out.print(testData[testData.length-1]);
        }
        ThreadPoolUtil.getInstance().shutdown();
    }
}
