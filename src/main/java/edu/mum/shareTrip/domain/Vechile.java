package edu.mum.shareTrip.domain;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

@Entity(name="VECHILE")
public class Vechile {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="ID")
	private int id;
    
	@NotEmpty(message="{edu.mum.shareTrip.domain.Vechile.vechileName.empty}")
	@Size(min=3, max=20, message="{edu.mum.shareTrip.domain.Vechile.vechileName.charcter}")
	@Column(name="VECHILE_NAME")
	private String vechileName;
	
	@NotEmpty(message="{edu.mum.shareTrip.domain.Vechile.type.empty}")
	@Column(name="TYPE")
	private String type;
	
	@Column(name="SEAT_TYPE")
	@NotNull(message="{edu.mum.shareTrip.domain.Vechile.seatNumber.null}")
	@Min(value=1, message="{edu.mum.shareTrip.domain.Vechile.seatNumber.min}")
	@Max(value=40, message="{edu.mum.shareTrip.domain.Vechile.seatNumber.max}")
	private int seatNumber;
	
	@Column(name="PRICE_PER_FAY")
	@NotNull(message="{edu.mum.shareTrip.domain.Vechile.pricePerDay.null}")
	@Min(value=5, message="{edu.mum.shareTrip.domain.Vechile.pricePerDay.min}")
	private double pricePerDay;
	@NotEmpty(message="{edu.mum.shareTrip.domain.Vechile.vechileImage.empty}")
	@Transient
	private MultipartFile vechileImage;
	
	public MultipartFile getVechileImage() {
		return vechileImage;
	}
	public void setVechileImage(MultipartFile vechileImage) {
		this.vechileImage = vechileImage;
	}
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
	
	

}
