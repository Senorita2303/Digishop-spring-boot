package com.example.digishop.context.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import com.example.digishop.context.properties.HeaderProperties;
import com.example.digishop.context.util.EnvironmentHelper;

/**
 * Configuration class for Header properties.
 * <p>
 * This configuration class is used to inject the HeaderProperties object into
 * EnvironmentHelper.
 * </p>
 *
 * @since 2024-05-05
 * @author SunTao
 */
@Configuration
@EnableConfigurationProperties({ HeaderProperties.class })
public class HeaderPropertiesConfig {
	/**
	 * Constructor used to inject the HeaderProperties object.
	 *
	 * @param properties HeaderProperties object
	 */
	public HeaderPropertiesConfig(HeaderProperties properties) {
		EnvironmentHelper.setHeaderProperties(properties);
	}
}