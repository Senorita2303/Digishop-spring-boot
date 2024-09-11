package com.example.digishop.captcha.autoconfigure;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.digishop.captcha.CaptchaConfig;
import com.example.digishop.captcha.CaptchaException;
import com.example.digishop.captcha.factory.CacheCaptchaFactory;
import com.example.digishop.captcha.factory.CaptchaFactory;
import com.example.digishop.captcha.handler.CaptchaHandler;
import com.example.digishop.captcha.handler.CaptchaHandlerImpl;
import com.example.digishop.util.collection.CollectionUtils;
import com.example.digishop.util.io.FileUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnResource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.core.io.ClassPathResource;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * 验证码加载自动配置
 *
 * @author SunTao
 * @since 2024-08-16
 */
@Slf4j
@Configuration
@Order(Ordered.HIGHEST_PRECEDENCE)
public class CaptchaLoadAutoConfigure {
    @Bean
    @ConditionalOnResource(resources = "classpath:kaptchaConfig.json")
    public CacheCaptchaFactory captchaFactory() {
        try (InputStream is = new ClassPathResource("kaptchaConfig.json").getInputStream()) {
            String jsonStr = FileUtils.readFileFromStream(is);
            JSONArray configs = JSON.parseObject(jsonStr, JSONArray.class);
            Map<String, CaptchaConfig> captchaConfigMap = new HashMap<>(CollectionUtils.mapSize(configs.size()));
            for (Object config : configs) {
                JSONObject jsonConfig = JSON.parseObject(JSON.toJSONString(config));
                String name = jsonConfig.getString("name");
                String properties = jsonConfig.getString("properties");
                CaptchaConfig captchaConfig = JSON.parseObject(properties, CaptchaConfig.class);
                if (captchaConfig == null) {
                    captchaConfig = new CaptchaConfig();
                }
                captchaConfigMap.put(name, captchaConfig);
                log.info("Load captcha {}: {}", name, captchaConfig);
            }

            return new CacheCaptchaFactory(captchaConfigMap);
        } catch (Exception e) {
            throw new CaptchaException("Load captcha from file catch error", e);
        }
    }

    @Bean
    @ConditionalOnBean(CaptchaFactory.class)
    public CaptchaHandler captchaHandler() {
        return new CaptchaHandlerImpl(captchaFactory());
    }
}