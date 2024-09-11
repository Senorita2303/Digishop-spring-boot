package com.example.digishop.sequence.core.id;

import com.example.digishop.sequence.SequenceException;
import com.example.digishop.sequence.SequenceGenerator;
import com.example.digishop.sequence.SequenceGeneratorAware;

/**
 * ID 生成器默认实现
 *
 * @author SunTao
 * @since 2024-04-07
 */
public class IdGeneratorImpl implements SequenceGeneratorAware, IdGenerator {
	private SequenceGenerator sequenceGenerator;

	/**
	 * 设置序号生成器
	 *
	 * @param sequenceGenerator 序号生成器
	 */
	@Override
	public void setSequenceGenerator(SequenceGenerator sequenceGenerator) {
		this.sequenceGenerator = sequenceGenerator;
	}

	/**
	 * 生成一个序号
	 *
	 * @return 序号
	 */
	@Override
	public String generateId() {
		if (sequenceGenerator == null) {
			throw new SequenceException("ZSEQ002");
		}
		return sequenceGenerator.nextId();
	}
}