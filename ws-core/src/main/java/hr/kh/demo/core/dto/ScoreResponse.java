package hr.kh.demo.core.dto;

import java.io.Serializable;

public class ScoreResponse implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	public ScoreResponse(String term, Double score) {
		this.term = term;
		this.score = score;
	}
	
	private String term;
	private Double score;
	
	public String getTerm() {
		return term;
	}
	public void setTerm(String term) {
		this.term = term;
	}
	public Double getScore() {
		return score;
	}
	public void setScore(Double score) {
		this.score = score;
	}
}
