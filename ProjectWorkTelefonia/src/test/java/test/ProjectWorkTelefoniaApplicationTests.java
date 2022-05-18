package test;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import com.google.gson.Gson;

import telefonia.ProjectWorkTelefoniaApplication;
import telefonia.model.ClienteModel;

//@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ProjectWorkTelefoniaApplication.class, webEnvironment= SpringBootTest.WebEnvironment.DEFINED_PORT)
public class ProjectWorkTelefoniaApplicationTests {

	@LocalServerPort
	private int port=8082;

	@Autowired
	private TestRestTemplate restTemplate;

	
	
	@Test
	public void greetingShouldReturnDefaultMessage() throws Exception {
		String rislutato=this.restTemplate.getForObject("http://localhost:" + port + "/clienti",String.class);
//		assertThat("test", anyOf(is("testing"), containsString("est")));
		assertEquals(rislutato.toLowerCase().contains("zxdsrefd"),true);
//		assertThat((Boolean)rislutato.contains("mari231dzo"), is(true));
//		assertThat(rislutato.contains("mari231dzo"));
//		System.out.println(rislutato.contains("mario"));
//		System.out.println(rislutato);
	}
	@Test
	public void testInserimento() throws Exception {
		Gson gson= new Gson();
		ClienteModel cliente = new ClienteModel("mario","rossi","qwertyyuiop", 14233369L,"attivo","mobile");
		HttpEntity<ClienteModel> request = new HttpEntity<>(cliente);
		System.out.println(request.getBody().toString());
		ResponseEntity<ClienteModel> risultato =this.restTemplate.exchange("http://localhost:" + port + "/clienti", HttpMethod.PUT, request, ClienteModel.class);
		assertEquals(risultato.getBody().getNome(),"mario");
	
	
	}
}
