package hr.kh.demo.core.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hr.kh.demo.core.service.ScoreSearchService;
import hr.kh.demo.core.service.ScoreService;

@Service
public class ScoreServiceImpl implements ScoreService {
	
	@Autowired
	private ScoreSearchService scoreSearch;
	
	

	@Override
	public Double getScore(String term) {
		//TODO expand logic after adding new providers
		Double score = scoreSearch.getTermScore(term);
		
		return score;
	}
}
