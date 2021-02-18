package common.externalapi;

import java.io.IOException;

import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class RequestRestApiData {

	public static String getDataFromApi(String restApiURL) {

		final String USER_AGENT = "Mozila/5.0";
		final String GET_URL = restApiURL;
		String responseData = null;

		// http client 생성
		CloseableHttpClient httpClient = HttpClients.createDefault();

		// get 메서드와 URL 설정
		HttpGet httpGet = new HttpGet(GET_URL);

		// agent 정보 설정
		httpGet.addHeader("User-Agent", USER_AGENT);
		httpGet.addHeader("Content-type", "application/json");
		
		// get 요청
		CloseableHttpResponse httpResponse = null;
		try {
			httpResponse = httpClient.execute(httpGet);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			responseData = EntityUtils.toString(httpResponse.getEntity(), "UTF-8");
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			httpClient.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return responseData;
	}
}
