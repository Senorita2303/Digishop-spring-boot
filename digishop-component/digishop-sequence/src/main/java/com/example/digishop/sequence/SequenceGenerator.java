package com.example.digishop.sequence;

/**
 * 序号生成器
 *
 * @author SunTao
 * @since 2021-12-12
 */
public interface SequenceGenerator {
	/**
	 * 获取下一个序号
	 *
	 * @return 序号，需要保证唯一性
	 */
	String nextId();
}