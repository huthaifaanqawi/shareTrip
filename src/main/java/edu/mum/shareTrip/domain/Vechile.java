package edu.mum.shareTrip.domain;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlTransient;


import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity(name="VECHILE")
public class Vechile implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="ID")
	private long id;
    
	@NotEmpty
	@Size(min=3, max=20)
	@Column(name="VECHILE_NAME")
	private String vechileName;
	
	
	@NotEmpty
	@Column(name="TYPE")
	private String type;
	
	@Column(name="SEAT_NUMBER")
	@NotNull
	@Min(value=1)
	@Max(value=40)
	private int seatNumber;
	
	@Column(name="PRICE_PER_DAY")
	@NotNull
	@Min(value=5)
	private double pricePerDay;
	
	
	@JsonIgnore 
	@Transient
	private MultipartFile vechileImage;
	
	@Size(min=3, max=20)
	@Column(name="PLATE_NUMER")
	private String plateNumber;
	
	@Size(min=5)
	@Column(name="DESCRIPTION")
	private String description;

	@Column(name="DATE_REGISTER")
	private Date addDate;
	
    @NotEmpty 
    @Column(name="STATUS")
  private String status;
	    
	    
		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}
	@ManyToOne
	@JoinColumn(name="MEMBER_ID",referencedColumnName="ID")
	private Member member;
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getAddDate() {
		return addDate;
	}

	public void setAddDate(Date addDate) {
		this.addDate = addDate;
	}
	@XmlTransient  
	public MultipartFile getVechileImage() {
		return vechileImage;
	}
	public String getPlateNumber() {
		return plateNumber;
	}
	public void setPlateNumber(String plateNumber) {
		this.plateNumber = plateNumber;
	}
	public void setVechileImage(MultipartFile vechileImage) {
		this.vechileImage = vechileImage;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
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
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	
	

}
