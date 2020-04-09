package com.naver.utils;

import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 缓存
 *
 * @author lihx23472
 * @create 2020-04-09 21:15
 */
public class Cache {
    private final static long flowValid = 1000L;
    //模拟缓存
    public static volatile Map<String, Long> cache = new ConcurrentHashMap<>();

    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public void processCachedData(String key) {
        System.out.println("处理任务");
    }

    public boolean updateData(String key) {
        try {
            lock.writeLock().lock();
            Date date = new Date();
            //模拟处理 处理为当前最新时间错
            cache.put(key, date.getTime());
            System.out.println("更新数据");
        } catch (Exception e) {
            //增加异常处理，日志尽量使用 log  不要使用 e.printStackTrace();
            e.printStackTrace();
            return false;
        } finally {
            lock.writeLock().unlock();
        }
        return true;
    }

    public boolean validateCache(String key) {
        try {
            lock.readLock().lock();
            System.out.println("验证任务");
            Date date = new Date();
            //验证缓存是否存在
            if (cache.containsKey(key)) {
                if ((date.getTime() - cache.get(key)) <= flowValid) {
                    return true;
                }
            } else {
                return true;
            }
        } catch (Exception e) {
            //增加异常处理，日志尽量使用 log  不要使用 e.printStackTrace();
            e.printStackTrace();
        } finally {
            lock.readLock().unlock();
        }
        return false;
    }
}
