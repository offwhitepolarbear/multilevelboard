package com.kihwangkwon.stock.service;

import java.sql.Date;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kihwangkwon.stock.domain.Stock;
import com.kihwangkwon.stock.domain.StockHistory;
import com.kihwangkwon.stock.domain.StockList;
import com.kihwangkwon.stock.repository.StockHistoryRepository;

import common.dataparse.ExternalDataToDTO;
import common.externalapi.RequestRestApiData;

@Service
public class StockCrawlingService {
	
	private StockHistoryRepository stockHistoryRepository;
	@Autowired
	public void setStockHistoryRepository(StockHistoryRepository stockHistoryRepository) {
		this.stockHistoryRepository = stockHistoryRepository;
	}
	
	private StockListService stockListService;
	@Autowired
	public void setStockListService(StockListService stockListService) {
		this.stockListService = stockListService;
	}
	public boolean checkStockHistory() {
		return false;
	}
	
	//배치로 처리하자 나중에
		public void stockCrawling() {
			String krxURL = "http://asp1.krx.co.kr/servlet/krx.asp.XMLSise?code=";
			List<StockList> stockList = stockListService.getAllStockList();
			for(StockList stock : stockList) {
				String stockId = stock.getStockCode();
				System.out.println(stockId);
				stockHistoryCrawling(RequestRestApiData.getDataFromApi(krxURL+stockId), stockId);
				//연속 요청으로 차단 당해서 0.05초 딜레이(3천개라 10분 정도 내에 처리하게)
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
	
	@Transactional
	public void stockHistoryCrawling(String rawXMLData, String stockId) {
		Map<String, Object> map = ExternalDataToDTO.xmlStringToStock(rawXMLData, stockId);
		if(map !=null) {
		
			Stock stock = (Stock) map.get("stock");
			List<StockHistory> stockHistoryList = (List<StockHistory>) map.get("stockHistoryList");
			saveStockHistorys(stockHistoryList);
			
		}
		
	}
	
	@Transactional
	private void saveStockHistorys(List<StockHistory> stockHistorys) {
		
		String stockId = stockHistorys.get(0).getStockId();
		StockHistory lastStockHistory = stockHistoryRepository.findTop1ByStockIdOrderByDateDesc(stockId);
		//기존 기록이 없는경우 그냥 다 넣음
		if (lastStockHistory==null) {
			for(StockHistory stockHistory : stockHistorys) {
				stockHistoryRepository.save(stockHistory);
			}
		}
		//기존 기록이 있을 경우 날짜 확인 후 등록
		else {
			for(StockHistory stockHistory : stockHistorys) {
				if(stockHistory.getDate().after(lastStockHistory.getDate())) {
					stockHistoryRepository.save(stockHistory);
				}
			}
		}
	}
}
