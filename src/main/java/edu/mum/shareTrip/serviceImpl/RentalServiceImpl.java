package edu.mum.shareTrip.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.shareTrip.repository.RentalRepository;
import edu.mum.shareTrip.service.RentalService;
@Service
@Transactional
public class RentalServiceImpl implements RentalService{
@Autowired
RentalRepository rentalRepository;
}
