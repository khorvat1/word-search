package hr.kh.demo.core.dao;

import hr.kh.demo.core.model.SearchTerm;
import hr.kh.demo.core.model.enums.SearchPlatform;

public interface SearchTermDao extends GenericDao<SearchTerm, Long> {
	
	public SearchTerm getLastValidSearchTerm(String term, SearchPlatform platform);
	
}
