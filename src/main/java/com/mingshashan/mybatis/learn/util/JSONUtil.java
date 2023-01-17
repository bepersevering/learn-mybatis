package com.mingshashan.mybatis.learn.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.apache.commons.lang3.StringUtils;

import java.text.SimpleDateFormat;
import java.util.TimeZone;

/**
 * @author mingshashan
 */
public class JSONUtil {

    private final static ObjectMapper objectMapper;

    static {
        objectMapper = new ObjectMapper();
        // 去掉默认的时间戳格式
        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        // 设置为东八区
        objectMapper.setTimeZone(TimeZone.getTimeZone("GMT+8"));
        // 设置输入:禁止把POJO中值为null的字段映射到json字符串中
        objectMapper.configure(SerializationFeature.WRITE_NULL_MAP_VALUES, false);
        // 空值不序列化
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        // 反序列化时，属性不存在的兼容处理
        objectMapper.getDeserializationConfig().withoutFeatures(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        // 序列化时，日期的统一格式
        objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        // 序列化日期时以timestamps输出，默认true
        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        // 序列化枚举是以toString()来输出，默认false，即默认以name()来输出
        objectMapper.configure(SerializationFeature.WRITE_ENUMS_USING_TO_STRING, true);
        // 序列化枚举是以ordinal()来输出，默认false
        objectMapper.configure(SerializationFeature.WRITE_ENUMS_USING_INDEX, false);
        // 类为空时，不要抛异常
        objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        // 反序列化时,遇到未知属性时是否引起结果失败
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        // 单引号处理
        objectMapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
        // 解析器支持解析结束符
        objectMapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true);
    }

    /**
     * 将对象转换为json字符串
     *
     * @param object 对象
     * @return json字符串
     * @throws JsonProcessingException
     */
    public static String toJSONString(Object object) throws JsonProcessingException {
        return objectMapper.writeValueAsString(object);
    }

    /**
     * 将json字符串转换为对象
     *
     * @param text  json字符串
     * @param clazz 对象类型
     * @return 转换后对象
     * @throws JsonProcessingException
     */
    public static <T> T parseObject(String text, Class<T> clazz) throws JsonProcessingException {
        if (StringUtils.isBlank(text)) {
            return null;
        }
        return objectMapper.readValue(text, clazz);
    }

}
