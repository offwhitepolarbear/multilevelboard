package com.kihwangkwon.stock.domain;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Stock {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long Id;
	
	@Column (length=10)
	private String stockId;
	
	@Column (length=50)
	private String stockName;
	
	@Column
	private Timestamp date;

	@Column
	private int priceNow;

	@Column
	private int yesterdayPrice;

	@Column
	private int startPrice;

	@Column
	private int endPrice;

	@Column
	private int dailyLowestPrice;

	@Column
	private int daillyHighestPrice;

	@Column
	private int limitHighestPrice;

	@Column
	private int limitLowestPrice;

	@Column
	private Long totalTradePrice;

	@Column
	private Long totalTradeAmount;

	@Column
	private int direction;

	@Column
	private int differenceYesterday;

	@Column
	private int publishedPrice;

	@Column
	private Long publishedAmount;

	@Column
	private int highest52;

	@Column
	private int lowest52;

	@Column
	private Double per;

	@Override
	public String toString() {
		return "Stock [Id=" + Id + ", stockId=" + stockId + ", stockName=" + stockName + ", date=" + date
				+ ", priceNow=" + priceNow + ", yesterdayPrice=" + yesterdayPrice + ", startPrice=" + startPrice
				+ ", endPrice=" + endPrice + ", dailyLowestPrice=" + dailyLowestPrice + ", daillyHighestPrice="
				+ daillyHighestPrice + ", limitHighestPrice=" + limitHighestPrice + ", limitLowestPrice="
				+ limitLowestPrice + ", totalTradePrice=" + totalTradePrice + ", totalTradeAmount=" + totalTradeAmount
				+ ", direction=" + direction + ", differenceYesterday=" + differenceYesterday + ", publishedPrice="
				+ publishedPrice + ", publishedAmount=" + publishedAmount + ", highest52=" + highest52 + ", lowest52="
				+ lowest52 + ", per=" + per + "]";
	}
	
}
