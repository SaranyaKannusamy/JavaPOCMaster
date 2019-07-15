package com.DBService.BusService.Services;

import java.util.List;

import com.DBService.BusService.bean.BusDao;





public interface BusService {
	public List<BusDao> getAvailableBuses();
	public BusDao findById(int id);
	public List<BusDao> findByBusRouteID(int busRouteID);
	public void createUser(BusDao busDao);


}