package cn._51even.efast.core.redis;

import org.springframework.context.annotation.Lazy;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * redis cache 工具类
 * Created by fymeven on 2017/7/23.
 */
@Lazy
@Component
public final class RedisUtil {

    private static RedisTemplate<Serializable, Object> redisTemplate;

    @Resource
    public void setRedisTemplate(RedisTemplate<Serializable, Object> redisTemplate) {
        RedisUtil.redisTemplate = redisTemplate;
    }

    /**
     * 批量删除对应的value
     *
     * @param keys
     */
    public static void remove(final String... keys) {
        for (String key : keys) {
            remove(key);
        }
    }

    /**
     * 批量删除key
     *
     * @param pattern
     */
    public static void removePattern(final String pattern) {
        Set<Serializable> keys = redisTemplate.keys(pattern);
        if (keys.size() > 0)
            redisTemplate.delete(keys);
    }

    /**
     * 删除对应的value
     *
     * @param key
     */
    public static void remove(final String key) {
        if (exists(key)) {
            redisTemplate.delete(key);
        }
    }

    /**
     * 获取表达式key的size
     * @param pattern
     * @return
     */
    public static int getSize(String pattern){
        Set<Serializable> keys = redisTemplate.keys(pattern);
        return keys.size();
    }

    /**
     * 获取表达式key的集合
     * @param pattern
     * @return
     */
    public static Set getKeys(String pattern){
        Set keys = redisTemplate.keys(pattern);
        return keys;
    }

    /**
     * 获取表达式value的集合
     * @param pattern
     * @return
     */
    public static Set getValues(String pattern) {
        Set values=new HashSet();
        Set keys = getKeys(pattern);
        for (Object key : keys) {
            Object value = get((String) key);
            values.add(value);
        }
        return values;
    }


    /**
     * 判断缓存中是否有对应的value
     *
     * @param key
     * @return
     */
    public static boolean exists(final String key) {
        return redisTemplate.hasKey(key);
    }

    /**
     * 读取缓存
     *
     * @param key
     * @return
     */
    public static Object get(final String key) {
        Object result = null;
        ValueOperations<Serializable, Object> operations = redisTemplate
                .opsForValue();
        result = operations.get(key);
        return result;
    }

    /**
     * 写入缓存
     *
     * @param key
     * @param value
     * @return
     */
    public static boolean set(final String key, Object value) {
        boolean result = false;
        try {
            ValueOperations<Serializable, Object> operations = redisTemplate
                    .opsForValue();
            operations.set(key, value);
            redisTemplate.expire(key, 60 * 60 * 8, TimeUnit.SECONDS);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 写入缓存
     *
     * @param key
     * @param value
     * @return
     */
    public static boolean set(final String key, Object value, Long expireTime) {
        boolean result = false;
        try {
            ValueOperations<Serializable, Object> operations = redisTemplate
                    .opsForValue();
            operations.set(key, value);
            redisTemplate.expire(key, expireTime, TimeUnit.SECONDS);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

}