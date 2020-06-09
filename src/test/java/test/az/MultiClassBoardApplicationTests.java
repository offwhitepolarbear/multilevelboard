package test.az;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;

import com.kihwangkwon.stock.domain.StockHistory;
import com.kihwangkwon.stock.repository.StockHistoryRepository;

@SpringBootTest
@WebAppConfiguration
public class MultiClassBoardApplicationTests {
	StockHistoryRepository stockHistoryRepository;
	@Test
	void contextLoads() {
	}

}
