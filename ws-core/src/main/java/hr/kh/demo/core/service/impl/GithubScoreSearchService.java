package hr.kh.demo.core.service.impl;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestClientException;

import hr.kh.demo.core.dao.SearchTermDao;
import hr.kh.demo.core.dto.GithubResponse;
import hr.kh.demo.core.model.SearchTerm;
import hr.kh.demo.core.model.enums.SearchPlatform;
import hr.kh.demo.core.service.RestCallService;
import hr.kh.demo.core.service.ScoreSearchService;

@Service
public class GithubScoreSearchService implements ScoreSearchService {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Value("${target.github.url:}")
	private String targetUrl;
	
	@Value("${target.github.positive:}")
	private String targetPositive;
	
	@Value("${target.github.negative:}")
	private String tergetNegative;
	
	@Autowired
	private RestCallService restCallService;
	
	@Autowired
	private SearchTermDao searchTermDao;

	@Override
	@Transactional
	public Double getTermScore(String term) {
		//get existing result
		SearchTerm searchTerm = searchTermDao.getLastValidSearchTerm(term, SearchPlatform.GITHUB);
		
		if (searchTerm != null) {
			return calculateScore(searchTerm.getPositiveScore(), searchTerm.getNegativeScore());
			
		} else {
			Integer positive = getPositiveCount(term);
			Integer negative = getNegativeCount(term);
			
			searchTerm = new SearchTerm(term, positive, negative, SearchPlatform.GITHUB);
			searchTermDao.create(searchTerm);
			return calculateScore(positive, negative);
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
	
	private Double calculateScore(Integer positiveScore, Integer negativeScore) {
		Double positive = positiveScore != null ? positiveScore.doubleValue() : null;
		Double negative = negativeScore != null ? negativeScore.doubleValue() : null;
		
		if (positive == null || negative == null) {
			return 0d;
		} else {
			return (positive / (positive + negative));
		}
	}
	
	private Integer makeRestCall(String url) {
		GithubResponse response = null;
		try {
			response = restCallService.makeRestGetCall(url, GithubResponse.class);
			if (response != null) {
				return response.getTotalCount();
			}
		} catch (RestClientException e) {
			log.error(e.getMessage(), e);
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
