package hr.kh.demo.core.model;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import hr.kh.demo.core.model.enums.SearchPlatform;

@Entity
@Table(name="ws_schema.search_term")
public class SearchTerm {
	
	private Long id;
	private String term;
	private Timestamp searchDate;
	private Integer positiveScore;
	private Integer negativeScore;
	private SearchPlatform platform;
	
	public SearchTerm() { }
	
	public SearchTerm(String term, Integer positiveScore, Integer negativeScore, SearchPlatform platform) {
		this.term = term;
		this.positiveScore = positiveScore;
		this.negativeScore = negativeScore;
		this.platform = platform;
		this.searchDate = Timestamp.valueOf(LocalDateTime.now());
	}
	
	@Id
	@GeneratedValue(generator="ws_sequence")
	@SequenceGenerator(name="ws_sequence", sequenceName="ws_schema.ws_sequence", allocationSize=1)
	@Column(name="id", nullable=false, unique=true)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name="term", nullable=false)
	public String getTerm() {
		return term;
	}
	public void setTerm(String term) {
		this.term = term;
	}
	
	@Column(name="search_date", nullable=false)
	public Timestamp getSearchDate() {
		return searchDate;
	}
	public void setSearchDate(Timestamp searchDate) {
		this.searchDate = searchDate;
	}
	
	@Column(name="positive_score")
	public Integer getPositiveScore() {
		return positiveScore;
	}
	public void setPositiveScore(Integer positiveScore) {
		this.positiveScore = positiveScore;
	}
	
	@Column(name="negative_score")
	public Integer getNegativeScore() {
		return negativeScore;
	}
	public void setNegativeScore(Integer negativeScore) {
		this.negativeScore = negativeScore;
	}
	
	@Column(name="platform")
	public SearchPlatform getPlatform() {
		return platform;
	}
	public void setPlatform(SearchPlatform platform) {
		this.platform = platform;
	}

}
