package hr.kh.demo.core.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hr.kh.demo.core.dao.SearchTermDao;
import hr.kh.demo.core.model.SearchTerm;
import hr.kh.demo.core.service.ScoreSearchService;
import hr.kh.demo.core.service.ScoreService;

@Service
public class ScoreServiceImpl implements ScoreService {
	
	@Autowired
	private ScoreSearchService scoreSearch;
	
	@Autowired
	private SearchTermDao searchTermDao;

	@Override
	public Double getScore(String term) {
		
		SearchTerm list = searchTermDao.getLastValidSearchTerm(term);
		System.out.println(list);
		
//		Double score = scoreSearch.getTermScore(term);
		
		return 1d;
	}
}
