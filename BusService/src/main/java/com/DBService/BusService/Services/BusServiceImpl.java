package com.DBService.BusService.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.DBService.BusService.Repo.DBRepository;
import com.DBService.BusService.bean.BusDao;
@Service
@Transactional
public class BusServiceImpl implements BusService{
	@Autowired
	DBRepository dbRepository;
	
	public List<BusDao> getAvailableBuses() {

		return (List<BusDao>) dbRepository.findAll();
	}

	public BusDao findById(int id) {
		
		return dbRepository.findOne(id);
	}
	
	public List<BusDao> findByBusRouteID(int busRouteID)
	{
		return (List<BusDao>) dbRepository.findByBusRouteID(busRouteID);
	}
	
	public void createUser(BusDao busDao)
	{
		dbRepository.save(busDao);
	}

}
