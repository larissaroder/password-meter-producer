package br.com.gumga.infrastructure.domain;

import java.io.Serializable;
import java.util.List;

public class ScoreDomain implements Serializable{

	private static final long serialVersionUID = -128333720116930039L;
	
	private Integer score;
	private List<RulesDomain> rules;
	private String message;

	public Integer getScore() {
		return score;
	}
	public void setScore(Integer score) {
		if (score > 100) {
			score =100;
		}
		this.score = score;
	}
	public List<RulesDomain> getRules() {
		return rules;
	}
	public void setRules(List<RulesDomain> rules) {
		this.rules = rules;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
