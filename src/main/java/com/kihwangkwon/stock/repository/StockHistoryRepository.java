package com.kihwangkwon.stock.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kihwangkwon.stock.domain.StockHistory;

public interface StockHistoryRepository extends JpaRepository<StockHistory, Long> {
	StockHistory findByStockIdAndDate(String stockId, Date date);
	StockHistory findByStockNameOrStockId(String stockName, String stockId);
	List<StockHistory> findByStockIdOrderByDateAsc (String stockId);
	StockHistory findTop1ByStockIdOrderByDateDesc(String stockId);
}
