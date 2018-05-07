package com.iot.repo;

import java.io.Serializable;
import java.util.stream.Stream;

import org.springframework.data.repository.CrudRepository;

import com.iot.entities.SensorCrud;


public interface SensorsRepository extends
CrudRepository<SensorCrud,Serializable>{

	Stream<SensorCrud> findBySensorIdAndTimestampBetween
	(int sensorId,long timeFrom, long timeTo);
	Stream<SensorCrud> findByTimestampBetween(long timeFrom, long timeTo);

}
