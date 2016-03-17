package edu.mum.shareTrip.service;

import java.util.List;

import edu.mum.shareTrip.domain.Vechile;

public interface VechileService {
List<Vechile> getAll();
List<Vechile> getAvialble();
Vechile getVehicleById(long vechileId);
Vechile save(Vechile vechile);
List<Vechile> getUserVehicles(long member_Id);
void updateStatus(long vechileId,String status);
List<Vechile>  UserAvailableVechile(long member_Id);
Vechile checkIfOwner(long vechileid,long memberid);
Vechile CheckPlateFound(String plateNumber);
}
