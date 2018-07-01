package hr.kh.demo.core.dao;

import hr.kh.demo.core.model.SearchTerm;

public interface SearchTermDao extends GenericDao<SearchTerm, Long> {
	
	public SearchTerm getLastValidSearchTerm(String term);
	
}
