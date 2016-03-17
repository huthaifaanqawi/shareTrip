package edu.mum.shareTrip.serviceImpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.shareTrip.domain.Vechile;
import edu.mum.shareTrip.repository.VechileRepository;
import edu.mum.shareTrip.service.VechileService;
@Service
@Transactional
public class VechileServiceImpl implements VechileService{
    @Autowired
    VechileRepository vechileRepository;
	@Override
	public List<Vechile> getAll() {
	return (List<Vechile>)vechileRepository.findAll();
	}
	@Override
	public Vechile getVehicleById(long id) {
		return vechileRepository.findOne((long)id);
	}
	@Override
	public Vechile save(Vechile vechile) {
		return vechileRepository.save(vechile)	;
		}
	@Override
	public List<Vechile> getUserVehicles(long member_Id) {
	return	vechileRepository.getUserVehicles(member_Id);
	}
	@Override
	public void updateStatus(long vechileId,String status) {	
	vechileRepository.updateStatus(vechileId, status);
	}
	@Override
	public List<Vechile> UserAvailableVechile(long member_Id) {
		return vechileRepository.getUserAvialbleVehicles(member_Id);
	}
	@Override
	public Vechile checkIfOwner(long vechileid, long memberid) {
		return vechileRepository.checkIfOwner(vechileid, memberid);
	}

}
