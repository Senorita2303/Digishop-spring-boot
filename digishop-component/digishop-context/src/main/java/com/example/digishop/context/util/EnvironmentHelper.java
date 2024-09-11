package com.example.digishop.context.util;

import com.example.digishop.context.properties.HeaderProperties;
import com.example.digishop.util.StringUtils;
import com.example.digishop.util.net.IpUtils;

import lombok.extern.slf4j.Slf4j;

/**
 * Zblog Frame environment variable utility class for managing zblog-related
 * environment variable information.
 *
 * @since 2024-05-05
 * @author SunTao
 */
@Slf4j
public class EnvironmentHelper {
	private static String deployCode;

	private static HeaderProperties headerProperties;

	/**
	 * Sets the HeaderProperties.
	 * <p>
	 * This method sets the HeaderProperties object and determines the deployment
	 * code based on deployment information.
	 * </p>
	 *
	 * @param headerProperties The MusesHeaderProperties object
	 */
	public static void setHeaderProperties(HeaderProperties headerProperties) {
		if (EnvironmentHelper.headerProperties == null) {
			EnvironmentHelper.headerProperties = headerProperties;

			// Set deployment code
			HeaderProperties.Deploy deploy = EnvironmentHelper.headerProperties.getDeploy();
			if (deploy != null && StringUtils.isNotBlank(deploy.getDeployIp())) {
				deployCode = IpUtils.get7CharFromIpString(deploy.getDeployIp(), deploy.getDeployUnit());
				log.info("Set application deployment code: " + deployCode);
			}
		}
	}

	/**
	 * Retrieves the system code.
	 *
	 * @return The system code
	 */
	public static String getSysCode() {
		return headerProperties.getSysCode();
	}

	/**
	 * Retrieves the application code.
	 *
	 * @return The application code
	 */
	public static String getAppCode() {
		return headerProperties.getAppCode();
	}

	/**
	 * Retrieves the deployment code.
	 *
	 * @return The deployment code
	 */
	public static String getDeployCode() {
		return deployCode;
	}
}