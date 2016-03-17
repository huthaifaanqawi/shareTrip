package edu.mum.shareTrip.service;

import java.util.List;

import edu.mum.shareTrip.domain.Rental;

public interface RentalService {
void saveRental(Rental rental);
List<Rental> getUserRental(long id);
}