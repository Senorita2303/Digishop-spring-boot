package com.example.digishop.base.util;

import java.util.ArrayList;
import java.util.List;

import com.example.digishop.core.util.SpringContextUtils;
import com.example.digishop.sequence.core.id.IdGenerator;

/**
 * ID生成工具类
 *
 * @author SunTao
 * @since 2021-12-17
 */
public class GenerateIdUtils {
	private static IdGenerator idGenerator;

	private static IdGenerator instance() {
		if (GenerateIdUtils.idGenerator == null) {
			GenerateIdUtils.idGenerator = SpringContextUtils.getBean("idGeneratorService", IdGenerator.class);
		}
		return GenerateIdUtils.idGenerator;
	}

	/**
	 * 生成唯一ID
	 *
	 * @return Long id
	 */
	public static Long getId() {
		return Long.valueOf(instance().generateId());
	}

	/**
	 * 生成唯一ID列表
	 *
	 * @param count 生成ID的个数
	 * @return List<Long> id列表
	 */
	public static List<Long> getIdList(Integer count) {
		List<Long> ids = new ArrayList<>(count);
		for (int i = 0; i < count; i++) {
			ids.add(getId());
		}
		return ids;
	}
}