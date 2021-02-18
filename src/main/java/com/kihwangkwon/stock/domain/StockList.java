package com.kihwangkwon.stock.domain;

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
public class StockList {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column (length=50)
	private String stockName;
	
	@Column (length=10)
	private String stockCode;
	
	@Column (length=50)
	private String nation;
}
