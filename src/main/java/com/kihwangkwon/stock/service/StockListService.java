package com.kihwangkwon.stock.service;

import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kihwangkwon.stock.domain.Stock;
import com.kihwangkwon.stock.domain.StockHistory;
import com.kihwangkwon.stock.domain.StockList;
import com.kihwangkwon.stock.repository.StockListRepository;
import com.kihwangkwon.stock.repository.StockHistoryRepository;

import common.dataparse.ExternalDataToDTO;
import common.externalapi.RequestRestApiData;

@Service
public class StockListService {

	@Autowired
	StockListRepository stockListRepository;
	
	@Autowired
	StockHistoryRepository stockHistoryRepository;
	
	public void addStockList(String stockNames, String stockCodes ) {
		String[] stockName = stockNames.split("\\r\\n");
		String[] stockCode = stockCodes.split("\\r\\n");
		for (int i=0;i<stockName.length;i++) {
			StockList stockInfo = new StockList();
			stockInfo.setNation("한국");
			stockInfo.setStockCode(stockCode[i]);
			stockInfo.setStockName(stockName[i]);
			stockListRepository.save(stockInfo);
		}
	}
	
	public void test() {
		List<StockList> list= stockListRepository.findAll();
		for(StockList stockList : list) {
			System.out.println(stockList.getStockCode());
		}
	}
	
	public List<StockList> getAllStockList() {
		return stockListRepository.findAll();
	}
	
	
}

