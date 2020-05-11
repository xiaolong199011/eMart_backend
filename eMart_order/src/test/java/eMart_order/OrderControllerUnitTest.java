package eMart_order;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import com.eMart.App;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest (classes = App.class)
@WebAppConfiguration
@AutoConfigureMockMvc 
public class OrderControllerUnitTest {

	@Autowired
	private MockMvc mvc;

	@Test
	public void purchasehistoryJunitTest() throws Exception {
		this.mvc.perform(get("/purchasehistory/getall")).andExpect(status().isOk());
			
}
	
	@Test
	public void transactionsJunitTest() throws Exception {
		this.mvc.perform(get("/transactions/getall")).andExpect(status().isOk());
			
}
}
