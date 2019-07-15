package com.DBService.BusService.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.DBService.BusService.Services.BusService;
import com.DBService.BusService.bean.BusDao;





@RestController
@RequestMapping(value={"/bus"})
public class DBController {
	@Autowired
	BusService busService;
    
	@RequestMapping(value = "/list", method= RequestMethod.GET, produces = "application/json")
	 public List<BusDao> getBuses() {	 
	  List<BusDao> buses=busService.getAvailableBuses();
	  
	  return buses;
	
	 }
	

	@RequestMapping(value = "/getID/{id}", method= RequestMethod.GET, produces = "application/json")
	 public BusDao getUserById(@PathVariable("id") int id) {
	   
	  BusDao busDao = busService.findById(id); 
	  System.out.println(busDao.getBusName());
	 return busDao;
	 
}
	
	@RequestMapping(value = "/getByRouteId/{busRouteID}", method= RequestMethod.GET, produces = "application/json")
	 public List<BusDao> getByRouteId(@PathVariable("busRouteID") int busRouteID) {
	  
	  List<BusDao> busDao = busService.findByBusRouteID(busRouteID);
	 
	 return busDao;
	 
}
	
	
    
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity addData(@RequestBody BusDao busDao) {
		busService.createUser(busDao);
		return new ResponseEntity("Bus Data Saved Successfully", HttpStatus.CREATED);

	}

}

	