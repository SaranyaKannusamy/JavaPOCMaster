package com.DBService.BusService.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.DBService.BusService.bean.BusDao;


public interface DBRepository extends JpaRepository<BusDao,Integer>
{

	/*public static final String getStock = "SELECT busname FROM bus_service";

	@Query(value = getStock, nativeQuery = true)
	List<BusDao> findByBusRouteID(int busRouteID);*/
	
	@Query("select u.busName from BusDao u where u.busRouteID "
			+ "= :busRouteID")
	List<BusDao> findByBusRouteID(@Param("busRouteID")int busRouteID);
	
	
	

}