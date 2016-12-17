package br.com.gumga.infrastructure.domain;

import java.io.Serializable;

public class RulesDomain implements Serializable{

	private static final long serialVersionUID = 6519257701497608266L;
	
	private String rule;
	private Integer count;
	private Integer bonus;
	
	public String getRule() {
		return rule;
	}
	public void setRule(String rule) {
		this.rule = rule;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public Integer getBonus() {
		return bonus;
	}
	public void setBonus(Integer bonus) {
		this.bonus = bonus;
	}
}
