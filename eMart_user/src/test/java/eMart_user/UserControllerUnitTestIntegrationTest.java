package eMart_user;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.eMart.App;

@RunWith(SpringRunner.class)
@SpringBootTest (classes = App.class)
@WebAppConfiguration
public class UserControllerUnitTestIntegrationTest {

		private TestRestTemplate template = new TestRestTemplate();

		@Test
		public void testRequest() throws Exception {
			ResponseEntity<String> resposne = this.template.getForEntity(
					"http://localhost:8080/buyer/getall", String.class);
			assertThat(resposne.getStatusCode().OK);
		}

	

}
