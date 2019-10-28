package com.edu.untils;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * 基于Guava Cache缓存类
 */
public class TokenCache {
    private  static LoadingCache<String,String> loadingCache= CacheBuilder.newBuilder().
            initialCapacity(1000)//初始化缓存项
            .maximumSize(10000)//设置缓存项最大值不超过10000
    .expireAfterAccess(12, TimeUnit.HOURS)//定时回收
    .build(new CacheLoader<String,String>(){
        //当缓存没有值时执行load方法
        @Override
        public String load(String s) throws Exception {
            return "null";
        }
    });


    public  static  void set(String key,String value){
        loadingCache.put(key, value);
    }
    public static String get(String key){
        String value=null;

        try {
            value=loadingCache.get(key);
            if ("null".equals(value)){
                return  null;
            }
            return value;
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return null;
    }
}
