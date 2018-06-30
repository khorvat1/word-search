package hr.kh.demo.core.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;


@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class GithubResponse implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer totalCount;
	private Boolean incompleteResults;
	
	public GithubResponse() {
		
	}
	
	public GithubResponse(Integer totalCount, Boolean incompleteResults) {
		super();
		this.totalCount = totalCount;
		this.incompleteResults = incompleteResults;
	}
	
	public Integer getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}
	public Boolean getIncompleteResults() {
		return incompleteResults;
	}
	public void setIncompleteResults(Boolean incompleteResults) {
		this.incompleteResults = incompleteResults;
	}

}
