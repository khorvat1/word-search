package hr.kh.demo.core.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import hr.kh.demo.core.service.RestCallService;

@Service
public class RestCallServiceImpl implements RestCallService {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private RestTemplate restTemplate;
	
	public <T> T makeRestGetCall(String url, Class<T> type){
		ResponseEntity<T> response = null;
		
		try {
			response = this.restTemplate.getForEntity(url, type);
			return response.getBody();
			
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw e;
		}
	}

}
