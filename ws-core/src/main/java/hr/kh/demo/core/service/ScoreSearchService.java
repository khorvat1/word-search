package hr.kh.demo.core.service;

public interface ScoreSearchService {
	
	public Double getTermScore(String term);
	
	public Integer getPositiveCount(String term);
	
	public Integer getNegativeCount(String term);

}
