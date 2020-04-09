package com.naver.utils;

import com.sun.scenario.effect.Offset;

/**
 * 数据队列
 *
 * @author lihx23472
 * @create 2020-04-09 22:11
 */
public class ArrayQueue {
    private int offset = 0;
    private int flag = 0;
    //默认队列
    private String[] strings;
    public ArrayQueue(int size){
        strings = new String[size];
    }
    public ArrayQueue(){
        strings = new String[100];
    }
    public String pop(){
        if(offset == 0) {
            return null;
        }
        String str = strings[flag];
        if(flag==offset-1){
            flag=0;
        }
        strings[flag] = null;
      return strings[flag];
    }
    public void push(String str){
        if(offset<strings.length){
            if (flag==0) {
                strings[offset] = str;
                offset++;
            }else{
                strings[flag-1] = str;
                offset++;
            }
        }
    }
    public String peek(){
       return offset==0?null:strings[0];
    }
    public boolean empty(){
        if(offset>0){
            return false;
        }
        return true;
    }
}
