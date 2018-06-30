package hr.kh.demo.core.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import hr.kh.demo.core.service.RestCallService;

@Service
public class RestCallServiceImpl implements RestCallService {
	
	@Autowired
	private RestTemplate restTemplate;
	
	public <T> T makeRestGetCall(String url, Class<T> type){
		ResponseEntity<T> response = this.restTemplate.getForEntity(url, type);
		//TODO logger
		return response != null ? response.getBody() : null;
	}

}
