package com.example.digishop.sequence.core.id;

/**
 * ID 生成器
 *
 * @author SunTao
 * @since 2024-04-03
 */
public interface IdGenerator {
	/**
	 * 生成一个序号
	 *
	 * @return 序号
	 */
	String generateId();
}