package edu.mum.shareTrip.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Transient;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

@Entity(name="VECHILE")
public class Vechile {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="ID")
	private int id;
    
	@NotEmpty
	@Column(name="VECHILE_NAME")
	private String vechileName;
	
	@NotEmpty(message="edu.mum.domain.vechile.type")
	@Column(name="TYPE")
	private String type;
	
	@Column(name="SEAT_TYPE")
	private int seatNumber;
	
	@Column(name="PRICE_PER_FAY")
	private double pricePerDay;
	
	@Transient
	private MultipartFile productImage;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getVechileName() {
		return vechileName;
	}
	public void setVechileName(String vechileName) {
		this.vechileName = vechileName;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getSeatNumber() {
		return seatNumber;
	}
	public void setSeatNumber(int seatNumber) {
		this.seatNumber = seatNumber;
	}
	public double getPricePerDay() {
		return pricePerDay;
	}
	public void setPricePerDay(double pricePerDay) {
		this.pricePerDay = pricePerDay;
	}
	
	
	public MultipartFile getProductImage() {
		return productImage;
	}

	public void setProductImage(MultipartFile productImage) {
		this.productImage = productImage;
	}
}
