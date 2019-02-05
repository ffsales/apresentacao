package br.com.jbq.entrevista.apresentacao.business;

import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import br.com.jbq.entrevista.apresentacao.model.Cliente;

@Component
public class ClienteBusiness {

	public List<Cliente> findAll() {
		
		RestTemplate restTemplate = new RestTemplate();
		List<Cliente> clientes = restTemplate.getForObject("http://localhost:9090/clientes/listAll", List.class);
		return clientes;
	}
	
	public void salvar(Cliente cliente) {
		RestTemplate restTemplate = new RestTemplate();
		
		MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>(); 
		headers.add("Accept", "application/json"); 
		
		HttpEntity<Object> entity = new HttpEntity<Object>(cliente, headers); 
		
		ResponseEntity<Cliente> response = restTemplate.exchange("http://localhost:9090/clientes/add", HttpMethod.POST, entity, Cliente.class);
		
		response.getBody();
	}

}
