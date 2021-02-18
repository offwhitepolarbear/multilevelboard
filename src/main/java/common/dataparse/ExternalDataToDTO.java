package common.dataparse;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.XML;

import com.kihwangkwon.stock.domain.Stock;
import com.kihwangkwon.stock.domain.StockHistory;
import com.kihwangkwon.stock.domain.StockSource;

public class ExternalDataToDTO {
	
	
	public StockSource jsonToStockDTO(JSONObject jsonObj) {
		StockSource ss = new StockSource();
		return ss;
	}
	
	//주식으로 만드는 거랑 매일기록으로 만드는 거 두개 메서드 필요.
	public static Map<String, Object> xmlStringToStock (String krxXML,String stockId) {
		Map<String, Object> result = new HashMap<String, Object>();
		JSONObject jsonObj;
		try {
			jsonObj = XML.toJSONObject(krxXML);
		} catch(Exception e) {
			//xml이 이상해요;
			return null;
		}
		JSONObject stockJSON = jsonObj.getJSONObject("stockprice").getJSONObject("TBL_StockInfo");
		
		//종목명을 출력할 수 있을 때 (데이터가 제대로 왔을 때)만 실행
		if (!stockJSON.getString("JongName").equals("")) {
			Stock todayStock = getStockInfomation(stockJSON, stockId);
			result.put("stock", todayStock);
			JSONArray dailyStocks = jsonObj.getJSONObject("stockprice").getJSONObject("TBL_DailyStock").getJSONArray("DailyStock");
			if(dailyStocks.length()>0) {
				List<StockHistory> stockHistorys = dailyStockInfomations(dailyStocks, stockId);
				result.put("stockHistoryList", stockHistorys);
			}
			
		}
		else {
			result = null;
		}
		
		return result;
	}
	
	private static Stock getStockInfomation(JSONObject stockJson, String stockId) {
		
		Stock stock = new Stock();
		stock.setStockId(stockId);
		//int endPrice = todayStock.getInt("CurJuka");
		stock.setStockName(stockJson.getString("JongName"));
		stock.setPriceNow(getInt(stockJson,"CurJuka"));
		stock.setDifferenceYesterday(getInt(stockJson,"Debi"));
		stock.setDirection(getInt(stockJson,("DungRak")));
		stock.setYesterdayPrice(getInt(stockJson,"PrevJuka"));
		stock.setTotalTradeAmount(getLong(stockJson,"Volume"));
		stock.setTotalTradePrice(getLong(stockJson,"Money"));
		stock.setStartPrice(getInt(stockJson,"StartJuka"));
		//stock.setEndPrice(endPrice);
		stock.setDaillyHighestPrice(getInt(stockJson,("HighJuka")));
		stock.setDailyLowestPrice(getInt(stockJson,("LowJuka")));
		stock.setHighest52(getInt(stockJson,("High52")));
		stock.setLowest52(getInt(stockJson,("Low52")));
		stock.setLimitHighestPrice(getInt(stockJson,"UpJuka"));
		stock.setLimitLowestPrice(getInt(stockJson,"DownJuka"));
		stock.setPer(getDouble(stockJson,"Per"));
		stock.setPublishedAmount(getLong(stockJson,"Amount"));
		stock.setPublishedPrice(getInt(stockJson,"FaceJuka"));
		
		return stock;
	}
	
	private static List<StockHistory> dailyStockInfomations(JSONArray xmlStockInfomations, String stockId) {
		List<StockHistory> stockInfos = new ArrayList<StockHistory>();
		
		for(int i=0;i<xmlStockInfomations.length();i++) {
			JSONObject stockInfo = xmlStockInfomations.getJSONObject(i);
			StockHistory stockHistory = new StockHistory();
			stockHistory.setStockId(stockId);
			Date date = Date.valueOf(dateStringMaker(stockInfo.getString("day_Date")));
			stockHistory.setDate(date);
			
			stockHistory.setDifferenceYesterday(getInt(stockInfo,"day_getDebi"));
				
			stockHistory.setDirection(getInt(stockInfo,"day_Dungrak"));
			stockHistory.setStartPrice(getInt(stockInfo,"day_Start"));
			stockHistory.setEndPrice(getInt(stockInfo,"day_EndPrice"));
			stockHistory.setDailyHighestPrice(getInt(stockInfo,"day_High"));
			stockHistory.setDailyLowestPrice(getInt(stockInfo,"day_Low"));
			stockHistory.setTotalTradeAmount(getLong(stockInfo,"day_Volume"));
			stockHistory.setTotalTradePrice(getLong(stockInfo,"day_getAmount"));
			
			stockInfos.add(stockHistory);
		}
		
		return stockInfos;
	}
	
	private static int getInt(JSONObject jsonObject, String key) {
		int resultInt;
		try{
			resultInt = jsonObject.getInt(key);
		}catch(Exception e){
			resultInt = stringToInt(jsonObject.getString(key));
		}
		return resultInt;
	}
	
	private static Long getLong(JSONObject jsonObject, String key) {
		Long resultLong;
		try{
			resultLong = jsonObject.getLong(key);
		}catch(Exception e){
			resultLong = stringToLong(jsonObject.getString(key));
		}
		return resultLong;
	}
	
	private static double getDouble(JSONObject jsonObject, String key) {
		double resultDouble;
		try{
			resultDouble = jsonObject.getDouble(key);
		}catch(Exception e){
			resultDouble = (double) 0;
		}
		return resultDouble;
	}
	
	private static int stringToInt(String string) {
		string = string.replaceAll(",", "");
		if(string.equals("")) {
			return 0;
		}
		return Integer.parseInt(string);
	}
	
	private static Long stringToLong(String string) {
		string = string.replaceAll(",", "");
		return Long.parseLong(string);
	}
	
	private static String dateStringMaker (String date) {
		date = "20"+date;
		return date.replaceAll("/", "-");
	}
	
}
