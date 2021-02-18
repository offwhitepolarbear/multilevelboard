package com.kihwangkwon.stock.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StockSource {
	private String stockName;
	private String stockCode;
	private int recentPrice;
	private int lastDayPrice;
	private int highestPriceToday;
	private int lowestPriceToday;
	private int priceDiffrence;
	private int increaseLimitPrice;
	private int decreaseLimitPrice;
	private int totalTradePrice;
	private int totalTradeAmount;
	private int bps;
	private int cnsEps;
	
}
