package com.example.digishop.base.domain.vo.echarts;

import java.util.List;

import lombok.Data;
import lombok.ToString;

/**
 * 折线图
 *
 * @author SunTao
 * @since 2022-07-19
 */
@Data
@ToString
public class LineChartDataVo {
	/**
	 * X轴下标
	 */
	private String[] xAxisData;

	/**
	 * Y轴数据信息
	 */
	private List<LegendData> legendDataList;

	/**
	 * 每个折线图的标题
	 */
	private String[] legendData;

	public LineChartDataVo(String[] xAxisData, List<LegendData> legendDataList) {
		this.xAxisData = xAxisData;
		this.legendDataList = legendDataList;
	}

	public String[] getLegendData() {
		if (legendDataList == null || legendDataList.size() < 1) {
			return new String[0];
		}

		String[] legendData = new String[legendDataList.size()];
		for (int i = 0; i < legendDataList.size(); i++) {
			legendData[i] = legendDataList.get(i).getLegendName();
		}

		this.legendData = legendData;
		return legendData;
	}

	@Data
	public static class LegendData {
		/**
		 * 折现名称
		 */
		private String legendName;

		/**
		 * 折现类型，默认是折现图
		 */
		private String type = "line";

		/**
		 * Y轴数据
		 */
		private int[] legendData;
	}
}