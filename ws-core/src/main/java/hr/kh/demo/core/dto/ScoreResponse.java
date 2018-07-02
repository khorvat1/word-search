package hr.kh.demo.core.dto;

import java.io.Serializable;
import java.text.DecimalFormat;

public class ScoreResponse implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private static DecimalFormat df2 = new DecimalFormat("#.##");
	
	public ScoreResponse(String term, Double score) {
		this.term = term;
		this.score = df2.format(score);
	}
	
	private String term;
	private String score;
	
	public String getTerm() {
		return term;
	}
	public void setTerm(String term) {
		this.term = term;
	}
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
}
