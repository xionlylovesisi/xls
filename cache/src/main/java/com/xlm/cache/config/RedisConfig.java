package com.xlm.cache.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xlm.cache.model.SkuLevelModel;
import com.xlm.common.util.CrypUtil;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.util.CollectionUtils;

import java.time.Duration;
import java.util.List;
import java.util.Objects;

/**
 * @author xls
 * @date 2019-04-29
 * @description redis config
 */
@Configuration
@EnableCaching
public class RedisConfig {
    // redis缓存的有效时间单位是秒 默认一小时
    private long redisDefaultExpiration = 3600;
    private String SEPARATOR = "_";
    private String SEPARATOR_AS_ITEM = "#";
    private String NULL_PARAM = "null_param";

    @Bean
    public KeyGenerator keyGenerator() {
        return (target, method, params) -> {
            StringBuilder sb = new StringBuilder();
            sb.append(target.getClass().getSimpleName()).append(".").append(method.getName()).append(":");
            for (Object obj : params) {
                if (obj instanceof List) {
                    List<SkuLevelModel> list = ((List<SkuLevelModel>) obj);
                    if (!CollectionUtils.isEmpty(list)) {
                        list.forEach(skuLevelModel -> {
                            sb.append(SEPARATOR_AS_ITEM + skuLevelModel.getSkuId() + SEPARATOR + skuLevelModel.getLevelId());
                        });
                    } else {
                        sb.append(NULL_PARAM);
                    }
                } else if (obj instanceof SkuLevelModel) {
                    SkuLevelModel skuLevelModel = (SkuLevelModel) obj;
                    if (Objects.nonNull(skuLevelModel)) {
                        sb.append(skuLevelModel.getSkuId() + SEPARATOR + skuLevelModel.getLevelId());
                    } else {
                        sb.append(NULL_PARAM);
                    }
                } else {
                    sb.append(obj.toString());
                }
            }
            return CrypUtil.MD5_Encrypt(sb.toString());
        };
    }

    @Bean
    public RedisCacheManager cacheManager(RedisConnectionFactory redisConnectionFactory) {

        Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<Object>(Object.class);
        ObjectMapper om = new ObjectMapper();
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        jackson2JsonRedisSerializer.setObjectMapper(om);

        RedisSerializationContext.SerializationPair<Object> objectSerializationPair = RedisSerializationContext.SerializationPair
                .fromSerializer(jackson2JsonRedisSerializer);
        RedisSerializationContext.SerializationPair<String> stringSerializationPair = RedisSerializationContext.SerializationPair.fromSerializer(new StringRedisSerializer());
        return RedisCacheManager.builder(redisConnectionFactory).
                cacheDefaults(RedisCacheConfiguration.defaultCacheConfig()
                        .serializeKeysWith(stringSerializationPair)
                        .serializeValuesWith(objectSerializationPair)
                        .entryTtl(Duration.ofSeconds(redisDefaultExpiration))).build();
    }
}
