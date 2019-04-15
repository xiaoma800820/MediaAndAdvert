package com.xiaoma.utils;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * redis数据操作工具类
 * @author mmh
 * @date 2017/8/23
 */
@Slf4j
@Component
public class RedisClient<T> {

    public RedisClient() {
    }

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private JsonUtil jsonUtil;


    private ValueOperations<String, String> opsObject;
    private ListOperations opsList;
    private HashOperations opsHash;

    @PostConstruct
    private void init() {
        opsObject = stringRedisTemplate.opsForValue();
        opsList = stringRedisTemplate.opsForList();
        opsHash = stringRedisTemplate.opsForHash();
    }

    /**
     * 存储key-value(没有期限)
     * @param key
     * @param o
     */
    public void set(String key, Object o) {
        if (o instanceof String) {
            opsObject.set(key, o.toString());
        } else {
            String value = jsonUtil.toString(o);
            opsObject.set(key, value);
        }
    }

    /**
     * 存储key-value(有期限)
     * @param key
     * @param o
     * @param timeout
     * @param unit
     */
    public void set(String key, Object o,long timeout, TimeUnit unit) {
        if (o instanceof String) {
            opsObject.set(key, o.toString(),timeout, unit);
        } else {
            String value = jsonUtil.toString(o);
            opsObject.set(key, value,timeout, unit);
        }
    }

    /**
     * 删除
     * @param key
     */
    public void delete(String key) {
        stringRedisTemplate.delete(key);
    }

    /**
     * 存储key-value取值
     * @param key
     * @return
     */
    public Object get(String key, Class<T> tClass){
        Object o = opsObject.get(key);
        log.info("===key获取对象>>>"+ o.toString());
        if(o == null || "".equals(o)){
            return null;
        }else {
            return jsonUtil.toObject(o.toString(), tClass);
        }

    }

    /**
     * 存储list值(左遍历)
     * @param key
     * @param o
     */
    public void leftSet(String key, Object o) {
        if (o instanceof String) {
            opsList.leftPush(key, o.toString());
        } else {
            String value = jsonUtil.toString(o);
            opsList.leftPush(key, value);
        }
    }

    /**
     * 存储list值(右遍历)
     * @param key
     * @param o
     */
    public void rightSet(String key, Object o) {
        if (o instanceof String) {
            opsList.rightPush(key, o.toString());
        } else {
            String value = jsonUtil.toString(o);
            opsList.rightPush(key, value);
        }
    }

    /**
     * 存储list值(左遍历)
     * @param key
     * @param list
     */
    public void leftSetAll(String key, List list) {
        if (list != null && list.size() > 0) {
            opsList.leftPushAll(key, list);
        }
    }

    /**
     * 存储list值(右遍历)
     * @param key
     * @param list
     */
    public void rightSetAll(String key, List list) {
        if (list != null && list.size() > 0) {
            opsList.rightPushAll(key, list);
        }
    }

    /**
     * 存储list值取值
     * @param key
     * @return
     */
    public List<T> rangeList(String key, long start, long end){
        if(opsList.size(key) > 0 && start <= opsList.size(key) - 1 && end != -1 && end <= opsList.size(key) - 1 && end >= start){
            return opsList.range(key, start, end);
        }else if(opsList.size(key) > 0 && start <= opsList.size(key) - 1 && end == -1){
            return opsList.range(key, start, end);
        }else {
            return null;
        }
    }

    /**
     * 存储list值取值(下标从0开始)
     * @param key
     * @return
     */
    public Object indexList(String key, long index){
        if(opsList.size(key) > 0 && index <= opsList.size(key) - 1){
            return opsList.index(key, index);
        }else {
            return null;
        }
    }

    /**
     * 存储hash值(删除hash的指定key的value)
     * @param key
     * @param hashKey
     */
    public void deleteHash(String key, String hashKey){
        opsHash.delete(key, hashKey);
    }

    /**
     * 存储hash值(存储hash的单个value)
     * @param key
     * @param hashKey
     * @param object
     */
    public void putHash(String key,String hashKey, Object object){
        if(key != null && hashKey != null & object != null){
            opsHash.put(key, hashKey, jsonUtil.toString(object));
        }
    }

    /**
     * 存储hash值(存储整个hash)
     * @param key
     * @param map
     */
    public void putAllHash(String key, HashMap map){
        if(map != null && map.size() > 0){
            opsHash.putAll(key, map);
        }
    }

    /**
     * 存储hash值取值(整个hash的value集合)
     * @param key
     * @return
     */
    public List<T> getAllValue(String key, Class<T> tClass){
        List list = opsHash.values(key);
        List<T> newList = new ArrayList<T>();
        for (int i = 0 ; i < list.size() ; i++){
            newList.add(jsonUtil.toObject(list.get(i).toString(), tClass));
        }
        return newList;
    }

    /**
     * 存储hash值取值(整个hash)
     * @param key
     * @return
     */
    public Map<Object, Object> getAllMap(String key){
        return opsHash.entries(key);
    }

    /**
     * 存储hash值取值(hash的大小)
     * @param key
     * @return
     */
    public long sizeHash(String key){
        return opsHash.size(key);
    }

    /**
     * 存储hash值取值(指定hash的key的value集合)
     * @param key
     * @param keyList
     * @return
     */
    public List<T> getListValue(String key, List keyList, Class<T> tClass){
        List list = opsHash.multiGet(key, keyList);
        List<T> newList = new ArrayList<T>();
        for (int i = 0 ; i < list.size() ; i++){
            newList.add(jsonUtil.toObject(list.get(i).toString(), tClass));
        }
        return newList;
    }

    /**
     * 存储hash值取值(指定hash的key的value)
     * @param key
     * @param hashKey
     * @return
     */
    public Object get(String key, String hashKey, Class<T> tClass){
        Object o = opsHash.get(key, hashKey);
        if(o == null || "".equals(o)){
            return null;
        }else {
            return jsonUtil.toObject(o.toString(), tClass);
        }

    }

    /**
     * 判断是否包含key键
     * @param key key键
     * @return 存在 true 不包含false
     */
    public boolean hasKey(String key){
        return stringRedisTemplate.hasKey(key);
    }


}
