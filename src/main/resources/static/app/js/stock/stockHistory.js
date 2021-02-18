//am4core.useTheme(am4themes_animated);

var chart = am4core.create("chartdiv", am4charts.XYChart);
chart.paddingRight = 20;

chart.dateFormatter.inputDateFormat = "yyyy-MM-dd";

var dateAxis = chart.xAxes.push(new am4charts.DateAxis());
dateAxis.skipEmptyPeriods = true; 
dateAxis.renderer.grid.template.location = 0;
dateAxis.renderer.minGridDistance = 60;
dateAxis.dateFormats.setKey("day", "yy/MM/dd");

var valueAxis = chart.yAxes.push(new am4charts.ValueAxis());
valueAxis.tooltip.disabled = true;

var series = chart.series.push(new am4charts.CandlestickSeries());

series.dataFields.dateX = "date";
series.dataFields.valueY = "close";
series.dataFields.openValueY = "open";
series.dataFields.lowValueY = "low";
series.dataFields.highValueY = "high";

series.tooltipText = "종가: [bold]{valueY.value}원[/]"
					+"\n시가: [bold]{openValueY.value}원[/]"
					+"\n고가: [bold]{highValueY.value}원[/]"
					+"\n저가: [bold]{lowValueY.value}원[/]";
//하락 색
series.dropFromOpenState.properties.fill = am4core.color("#0A3CD0");
series.dropFromOpenState.properties.stroke = am4core.color("#0A3CD0");

//상승 색
series.riseFromOpenState.properties.fill = am4core.color("#EA3232");
series.riseFromOpenState.properties.stroke = am4core.color("#EA3232");

chart.cursor = new am4charts.XYCursor();

chart.scrollbarX = new am4core.Scrollbar();

function server_data_to_chartdata(server_data){
	var chart_data = new Array();
	var chart_data_index = 0;
	$.each(server_data, function(index, item){
		var daily_data = new Object();
		daily_data.date = item.date;
		daily_data.open = item.startPrice;
		daily_data.close = item.endPrice;
		daily_data.high = item.dailyHighestPrice;
		daily_data.low = item.dailyLowestPrice;
		daily_data.trade_amount = item.totalTradeAmount;
		daily_data.trade_price = item.totalTradePrice;
		chart_data[chart_data_index] = daily_data;
		chart_data_index++;
		console.log(item.date);
	});
	return chart_data;
}

var stock_id_url = window.location.href;
var start_of_stock_id = stock_id_url.indexOf("stockHistory")+13;
var target_stock_id  = stock_id_url.substring(start_of_stock_id);

$.ajax({
    type: 'POST',
    url: '/rest/stock/stockdata/stockHistory/'+target_stock_id,
    dataType: 'json',
    contentType:'application/json; charset=utf-8',
}).done(function(data) {
chart.data = server_data_to_chartdata(data);
}).fail(function (error) {
    console.log(error);
});

chart.dateFormatter.dateFormat = "yyyy-MM-dd";

//xAxis.dateFormatter = new am4core.DateFormatter();
//xAxis.dateFormatter.dateFormat = "yyyy-MM-dd";