package edu.mum.shareTrip.service;

import java.util.List;

import edu.mum.shareTrip.domain.Vechile;

public interface VechileService {
List<Vechile> getAll();
Vechile getVehicleById(int vechileId);
Vechile save(Vechile vechile);
List<Vechile> getUserVehicles(int member_Id);
}
