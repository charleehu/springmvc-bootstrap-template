package com.renren.game.lyz.gmserver.domain;

public class CardLog extends BaseLog {

	private Long cardDictId;
	private Long cardId;
	private Integer cardLevel;
	private Integer cardExp;	
	private Integer charLevel;
	private Integer characterType;
	private Integer hp;
	private Integer mp;
	private Integer attack;
	private Integer defence;
	private Integer hpCrystal;
	private Integer mpCrystal;
	private Integer attackCrystal;
	private Integer defenceCrystal;
	private String cardName;
	private String skill;
		
	public String getSkill() {
		return skill;
	}
	public void setSkill(String skill) {
		this.skill = skill;
	}
	public Long getCardDictId() {
		return cardDictId;
	}
	public void setCardDictId(Long cardDictId) {
		this.cardDictId = cardDictId;
	}
	public Long getCardId() {
		return cardId;
	}
	public void setCardId(Long cardId) {
		this.cardId = cardId;
	}
	public Integer getCardLevel() {
		return cardLevel;
	}
	public void setCardLevel(Integer cardLevel) {
		this.cardLevel = cardLevel;
	}
	public Integer getCardExp() {
		return cardExp;
	}
	public void setCardExp(Integer cardExp) {
		this.cardExp = cardExp;
	}
	public Integer getCharLevel() {
		return charLevel;
	}
	public void setCharLevel(Integer charLevel) {
		this.charLevel = charLevel;
	}
	public Integer getCharacterType() {
		return characterType;
	}
	public void setCharacterType(Integer characterType) {
		this.characterType = characterType;
	}
	public Integer getHp() {
		return hp;
	}
	public void setHp(Integer hp) {
		this.hp = hp;
	}
	public Integer getMp() {
		return mp;
	}
	public void setMp(Integer mp) {
		this.mp = mp;
	}
	public Integer getAttack() {
		return attack;
	}
	public void setAttack(Integer attack) {
		this.attack = attack;
	}
	public Integer getDefence() {
		return defence;
	}
	public void setDefence(Integer defence) {
		this.defence = defence;
	}
	public Integer getHpCrystal() {
		return hpCrystal;
	}
	public void setHpCrystal(Integer hpCrystal) {
		this.hpCrystal = hpCrystal;
	}
	public Integer getMpCrystal() {
		return mpCrystal;
	}
	public void setMpCrystal(Integer mpCrystal) {
		this.mpCrystal = mpCrystal;
	}
	public Integer getAttackCrystal() {
		return attackCrystal;
	}
	public void setAttackCrystal(Integer attackCrystal) {
		this.attackCrystal = attackCrystal;
	}
	public Integer getDefenceCrystal() {
		return defenceCrystal;
	}
	public void setDefenceCrystal(Integer defenceCrystal) {
		this.defenceCrystal = defenceCrystal;
	}

	public String getCardName() {
		return cardName;
	}
	public void setCardName(String cardName) {
		this.cardName = cardName;
	}

}

