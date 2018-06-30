package hr.kh.demo.core.service.impl;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;

import hr.kh.demo.core.dto.GithubResponse;
import hr.kh.demo.core.service.RestCallService;
import hr.kh.demo.core.service.ScoreSearchService;

@Service
public class GithubScoreSearchService implements ScoreSearchService {
	
	@Value("${target.github.url:}")
	private String targetUrl;
	
	@Value("${target.github.positive:}")
	private String targetPositive;
	
	@Value("${target.github.negative:}")
	private String tergetNegative;
	
	@Autowired
	private RestCallService restCallService;

	@Override
	public Double getTermScore(String term) {
		Double positive = getPositiveCount(term) != null ? getPositiveCount(term).doubleValue() : null;
		Double negative = getNegativeCount(term) != null ? getNegativeCount(term).doubleValue() : null;
		
		if (positive == null || negative == null) {
			//TODO logger
			return 0d;
		} else {
			return (positive / (positive + negative));
		}
	}

	@Override
	public Integer getPositiveCount(String term) {
		String url = getTermUrl(term, targetPositive);
		return makeRestCall(url);
	}

	@Override
	public Integer getNegativeCount(String term) {
		String url = getTermUrl(term, tergetNegative);
		return makeRestCall(url);
	}
	
	private Integer makeRestCall(String url) {
		GithubResponse response = null;
		try {
			response = restCallService.makeRestGetCall(url, GithubResponse.class);
			if (response != null) {
				response.getTotalCount();
			}
		} catch (RestClientException e) {
			//TODO logger
			e.printStackTrace();
		}
		
		return null;
	}
	
	private String getTermUrl(String term, String search) {
		try {
			return targetUrl + URLEncoder.encode(term + " " + search, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return null;
		}
	}
	

}
