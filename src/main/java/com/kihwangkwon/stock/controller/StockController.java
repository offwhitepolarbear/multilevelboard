package com.kihwangkwon.stock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/stock/*")
public class StockController {
	
	@RequestMapping("stockHistory/{stockId}")
	public String getStockHistoryView() {
		return "/stock/stockHistory";
	}
	
}
