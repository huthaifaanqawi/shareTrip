package edu.mum.shareTrip.domain;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

@Entity(name="RENTAL")
public class Rental {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID")
	private int id;
	
	@Column(name="FROM_DATE")
	private Date fromDate;
	
	@Column(name="TO_DATE")
	private Date toDate;
	
	@Column(name="COST")
	@NumberFormat(style=Style.CURRENCY)
	private BigDecimal unitPrice;
	
	@OneToOne
	@JoinColumn(name="VECHILE_ID",referencedColumnName="ID")
	private Vechile veichle;
	
	public BigDecimal getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}

	public Vechile getVeichle() {
		return veichle;
	}

	public void setVeichle(Vechile veichle) {
		this.veichle = veichle;
	}

	@ManyToOne
	@JoinColumn(name="MEMBER_ID",referencedColumnName="ID")
	private Member member;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	public Date getToDate() {
		return toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}



	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}
	
}
