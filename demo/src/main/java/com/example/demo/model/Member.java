package com.example.demo.model;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="MemberRest")
public class Member {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Integer pk;
	String  id;
	String  name;
	Double  balance;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone="Asia/Taipei")
//	@JsonFormat(pattern="yyyy-MM-dd")
	Date   birthday;
//  以下為測試用欄位，模擬系統產生而使用者不能修改的欄位	
    String extra;				// 最原始的測試欄位，可視為註解
	Timestamp createTime;		// 建檔時間(紀錄寫入表格的時間)
	Integer totalPoints;		// 購買總點數
	Integer totalAmount;		// 購買總金額
	Double  averageAmount;		// 平均購買金額
	String  memberGrade;		// 系統給定之會員評等
	Double  memberScore;		// 系統給定之會員分數
	
	public Member() {
	}

	public Member(Integer pk, String id, String name, Double balance, Date birthday, String extra) {
		super();
		this.pk = pk;
		this.id = id;
		this.name = name;
		this.balance = balance;
		this.birthday = birthday;
		this.extra = extra;
	}

	public Member(Integer ipk) {
		this.pk = ipk;
	}

	public Integer getPk() {
		return pk;
	}

	public void setPk(Integer pk) {
		this.pk = pk;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getExtra() {
		return extra;
	}

	public void setExtra(String extra) {
		this.extra = extra;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Member [pk=");
		builder.append(pk);
		builder.append(", id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", balance=");
		builder.append(balance);
		builder.append(", birthday=");
		builder.append(birthday);
		builder.append(", extra=");
		builder.append(extra);
		builder.append("]");
		return builder.toString();
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public Integer getTotalPoints() {
		return totalPoints;
	}

	public void setTotalPoints(Integer totalPoints) {
		this.totalPoints = totalPoints;
	}

	public Integer getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Integer totalAmount) {
		this.totalAmount = totalAmount;
	}

	public Double getAverageAmount() {
		return averageAmount;
	}

	public void setAverageAmount(Double averageAmount) {
		this.averageAmount = averageAmount;
	}

	public String getMemberGrade() {
		return memberGrade;
	}

	public void setMemberGrade(String memberGrade) {
		this.memberGrade = memberGrade;
	}

	public Double getMemberScore() {
		return memberScore;
	}

	public void setMemberScore(Double memberScore) {
		this.memberScore = memberScore;
	}
	
	
	
}
