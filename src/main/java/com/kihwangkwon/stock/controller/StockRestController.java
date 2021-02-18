package com.kihwangkwon.stock.controller;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.XML;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kihwangkwon.stock.domain.Stock;
import com.kihwangkwon.stock.domain.StockHistory;
import com.kihwangkwon.stock.service.StockHistoryService;
import com.kihwangkwon.stock.service.StockListService;

import common.dataparse.ExternalDataToDTO;
import common.externalapi.RequestRestApiData;

@RestController
@RequestMapping("/rest/stock/*")
public class StockRestController {
	
	@Autowired
	public void setStockHistoryService(StockHistoryService stockHistoryService) {
		this.stockHistoryService = stockHistoryService;
	}
	
	private StockHistoryService stockHistoryService;
	
	@Autowired
	private StockListService stockListService;

	String stockApiUrlTwo = "http://asp1.krx.co.kr/servlet/krx.asp.XMLSise?code=";
	String naverURL = "https://api.finance.naver.com/service/itemSummary.nhn?itemcode=217770";
	String stockApiUrl = "https://polling.finance.naver.com/api/realtime.nhn?query=SERVICE_ITEM:";
	@RequestMapping("{stockId}")
	public String xxcont(@PathVariable String stockId) {
		
	    final String GET_URL = stockApiUrl+stockId;
	    
	    String responseData = RequestRestApiData.getDataFromApi(GET_URL);
	  //오브젝트에 담음
	
	  //Json 으로 변경
	  JSONObject jsonObj = new JSONObject(responseData);
	  JSONArray jsonA = jsonObj.getJSONObject("result").getJSONArray("areas");
		System.out.println(responseData);
		System.out.println("줄바꿈");
		System.out.println(jsonA.getJSONObject(0).getJSONArray("datas").getJSONObject(0));
		System.out.println("어디주식인데?"+jsonA.getJSONObject(0).getJSONArray("datas").getJSONObject(0).getString("nm"));
		
		//String stockName = json.getJSONObject("stockprice").getJSONObject("TBL_StockInfo").getString("JongName");
		//System.out.println(stockName);
		return "/stock";
	}
	
	
	@RequestMapping("xml/{stockId}")
	public String xmlcont(@PathVariable String stockId) {
		
	    final String GET_URL = stockApiUrlTwo+stockId;
	    
	    String responseDataFromApi = RequestRestApiData.getDataFromApi(GET_URL);
	  //오브젝트에 담음
	    //stockListService.stockHistoryCrawling(responseDataFromApi, stockId);
	  //Json 으로 변경
		
		//System.out.println(jsonA.getJSONObject(0).getJSONArray("datas").getJSONObject(0));
		//System.out.println("어디주식인데?"+jsonA.getJSONObject(0).getJSONArray("datas").getJSONObject(0).getString("nm"));
		//Stock stock = ExternalDataToDTO.xmlStringToStock(responseData);
		//stock.setStockId(stockId);
		//System.out.println(stock);
		return "/stock";
	}
	
	@RequestMapping("stockdata/stockHistory/{stockId}")
	public List<StockHistory> getStockHistoryByStockId(@PathVariable String stockId) {
		System.out.println("stockdata/stockHistory/{stockId}");
		System.out.println(stockId);
		System.out.println(stockHistoryService.getLatestStockHistory(stockId));
		List list = stockHistoryService.getStockHistory(stockId);
		System.out.println(list);
		System.out.println("전송직전");
		return list;
	}
	
}
