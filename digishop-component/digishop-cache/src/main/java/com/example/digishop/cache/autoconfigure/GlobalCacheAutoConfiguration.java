package com.example.digishop.cache.autoconfigure;

import javax.annotation.Resource;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;

import com.example.digishop.cache.Cache;
import com.example.digishop.cache.autoconfigure.properties.GlobalCacheConfigProperties;
import com.example.digishop.cache.memory.MemoryCache;
import com.example.digishop.cache.redis.RedisCache;
import com.example.digishop.cache.util.GlobalCacheHelper;

import lombok.extern.slf4j.Slf4j;

/**
 * 自动配置全局缓存。
 * <p>
 * 根据配置属性 {@code zblog.global.cache.type} 的值自动配置缓存类型。 支持内存缓存和 Redis 缓存。
 * </p>
 *
 * @author SunTao
 * @since 2024-08-24
 */
@Slf4j
@Configuration
@EnableConfigurationProperties(GlobalCacheConfigProperties.class)
public class GlobalCacheAutoConfiguration {
	@Resource
	private RedisTemplate<String, Object> redisTemplate;

	/**
	 * 创建内存缓存 Bean。
	 *
	 * @return 配置好的 MemoryCache 实例
	 */
	@Bean("globalCache")
	@ConditionalOnProperty(name = "zblog.global.cache.type", havingValue = "memory")
	public Cache<String, Object> memoryCache() {
		log.info("Global Cache Type: memory");
		MemoryCache<String, Object> memoryCache = new MemoryCache<>();
		GlobalCacheHelper.setCache(memoryCache);
		return memoryCache;
	}

	/**
	 * 创建 Redis 缓存 Bean。
	 *
	 * @return 配置好的 RedisCache 实例
	 */
	@Bean("globalCache")
	@ConditionalOnProperty(name = "zblog.global.cache.type", havingValue = "redis")
	public Cache<String, Object> redisCache() {
		log.info("Global Cache Type: redis");
		RedisCache<String, Object> redisCache = new RedisCache<>();
		redisCache.setRedisTemplate(redisTemplate);
		GlobalCacheHelper.setCache(redisCache);
		return redisCache;
	}
}