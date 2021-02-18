package com.kihwangkwon.stock.domain;

import java.sql.Date;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class StockHistory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long Id;
	
	@Column (length=10)
	private String stockId;
	
	//@ManyToOne
	@Column (length=50)
	private String stockName;
	
	@Column
	private Date date;
	
	@Column
	private int direction;
	
	@Column
	private Long totalTradePrice;
	
	@Column
	private Long totalTradeAmount;
	
	@Column
	private int startPrice;
	
	@Column
	private int endPrice;
	
	@Column
	private int dailyLowestPrice;

	@Column
	private int dailyHighestPrice;
	
	@Column
	private int differenceYesterday;

	@Override
	public String toString() {
		return "StockHistory [Id=" + Id + ", stockId=" + stockId + ", stockName=" + stockName + ", date=" + date
				+ ", direction=" + direction + ", totalTradePrice=" + totalTradePrice + ", totalTradeAmount="
				+ totalTradeAmount + ", startPrice=" + startPrice + ", endPrice=" + endPrice + ", dailyLowestPrice="
				+ dailyLowestPrice + ", dailyHighestPrice=" + dailyHighestPrice + ", differenceYesterday="
				+ differenceYesterday + "]";
	}

}
