package edu.mum.shareTrip.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.shareTrip.domain.Rental;
import edu.mum.shareTrip.repository.RentalRepository;
import edu.mum.shareTrip.service.RentalService;
@Service
@Transactional
public class RentalServiceImpl   implements RentalService {

	@Autowired 
	RentalRepository rentalrepository;
	
	@Override
	public void saveRental(Rental rental) {
		rentalrepository.save(rental);
	}

	@Override
	public List<Rental> getUserRental(long memberid) {
		return rentalrepository.getUserRentalList(memberid);
	}

}