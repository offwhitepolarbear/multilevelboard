package com.kihwangkwon.stock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kihwangkwon.stock.domain.StockHistory;
import com.kihwangkwon.stock.repository.StockHistoryRepository;

@Service
public class StockHistoryService {
	
	private StockHistoryRepository stockHistoryRepository;
	
	@Autowired
	public void setStockHistoryRepository (StockHistoryRepository stockHistoryRepository) {
		this.stockHistoryRepository = stockHistoryRepository;
	}
	
	public List<StockHistory> getStockHistory(String stockId) {
		return stockHistoryRepository.findByStockIdOrderByDateAsc(stockId);
	}
	
	public StockHistory getLatestStockHistory(String stockId) {
		return stockHistoryRepository.findTop1ByStockIdOrderByDateDesc(stockId);
	}
	
}
