package eMart_user;

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
public class UserControllerUnitTest {

	@Autowired
	private MockMvc mvc;

	@Test
	public void buyerJunitTest() throws Exception {
		this.mvc.perform(get("/buyer/getall")).andExpect(status().isOk());
			
}
	
	@Test
	public void sellerJunitTest() throws Exception {
		this.mvc.perform(get("/seller/getall")).andExpect(status().isOk());
			
}
}
