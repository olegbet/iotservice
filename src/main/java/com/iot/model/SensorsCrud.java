package com.iot.model;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.iot.common.MeasureUnit;
import com.iot.common.Sensor;
import com.iot.common.SensorCarFuel;
import com.iot.common.SensorHeartRate;
import com.iot.common.SensorTemp;
import com.iot.entities.SensorCrud;
import com.iot.interfaces.ISensor;
import com.iot.repo.SensorsRepository;



public class SensorsCrud implements ISensor {
	@Autowired
SensorsRepository sensors;

	@Override
	public void addSensorData(Sensor sensor) {
		sensors.save(new SensorCrud(sensor));

	}

	@Override
	public double getAvgData(int sensorId, String dataTimeFrom, String dataTimeTo) {
		long timeFrom=getTimestamp(dataTimeFrom);
		long timeTo=getTimestamp(dataTimeTo);
		if(timeTo==0)
			timeTo=Long.MAX_VALUE;
		
		
		List<Sensor> sensorsList = sensors.findByTimestampBetween(timeFrom,timeTo)
				.map(this::toSensor)
				.collect(Collectors.toList());
		
		if(sensorsList.size() == 0) return 0;
		int sum = 0;
		for(Sensor s : sensorsList)
		{
			sum = sum + s.data;	
		}
		
		return sum/sensorsList.size();
	}

	
	@Override
	public double getMedianData(int sensorId, String dataTimeFrom, String dataTimeTo) {
		long timeFrom=getTimestamp(dataTimeFrom);
		long timeTo=getTimestamp(dataTimeTo);
		if(timeTo==0)
			timeTo=Long.MAX_VALUE;
		
		
		List<Sensor> sensorsList = sensors.findByTimestampBetween(timeFrom,timeTo)
				.map(this::toSensor)
				.collect(Collectors.toList());
		
		List<Integer> numbersList = new ArrayList<>();
		
		for(Sensor s : sensorsList)
		{
			numbersList.add(s.data);
			
		}
		
		
	    Collections.sort(numbersList);
	    int middle = numbersList.size()/2;
	    if(numbersList.size() % 2 == 0){
	        return (0.5 * (numbersList.get(middle).doubleValue() + numbersList.get(middle-1).doubleValue()));
	    } else {
	        return numbersList.get(middle).doubleValue();
	    }
	}
	
	@Override
	public int getMaximalData(int sensorId, String dataTimeFrom, String dataTimeTo) {
		return getMinMax(sensorId, dataTimeFrom, dataTimeTo,
		(x,y)->Integer.compare(x.data, y.data));
	}

	private int getMinMax(int sensorId, String dataTimeFrom, String dataTimeTo,
			Comparator<? super SensorCrud> comparator) {
		long timeFrom=getTimestamp(dataTimeFrom);
		long timeTo=getTimestamp(dataTimeTo);
		if(timeTo==0)
			timeTo=Long.MAX_VALUE;
		
		
		return sensors.findBySensorIdAndTimestampBetween
				(sensorId,timeFrom, timeTo)
				.max(comparator).orElse(new SensorCrud()).data;
	}
	private long getTimestamp(String dataTime) {
		DateTimeFormatter dtf=DateTimeFormatter
				.ofPattern("yyyy-MM-dd:HH.mm");
		try {
			LocalDateTime ldt=LocalDateTime.parse
					(dataTime, dtf);
			return ldt.toInstant(ZoneOffset.UTC).toEpochMilli();
		} catch (Exception e) {
			
		}
		
		return 0;
	}

	private Sensor toSensor(SensorCrud sensorCrud){
		Sensor sensor;
		
		MeasureUnit mUnit = sensorCrud.getmUnit();
		
		if(mUnit.equals(MeasureUnit.TEMPERATURE))
			return new SensorTemp(sensorCrud.sensorId,
					sensorCrud.timestamp,
					sensorCrud.data);
		if(mUnit.equals(MeasureUnit.HEART_RATE))
			return new SensorHeartRate(sensorCrud.sensorId,
					sensorCrud.timestamp,
					sensorCrud.data);
		return new SensorCarFuel(sensorCrud.sensorId,
				sensorCrud.timestamp,
				sensorCrud.data);
	}
	@Override
	public int getMinimalData(int sensorId, String dataTimeFrom, String dataTimeTo) {
		return getMinMax(sensorId, dataTimeFrom, dataTimeTo,
				(x,y)->Integer.compare(y.data, x.data));
	}

	@Override
	public List<Sensor> getSensorsData(String dataTimeFrom, String dataTimeTo) {
		long timeFrom=getTimestamp(dataTimeFrom);
		long timeTo=getTimestamp(dataTimeTo);
		if(timeTo==0)
			timeTo=Long.MAX_VALUE;
		return sensors.findByTimestampBetween(timeFrom,timeTo)
				.map(this::toSensor)
				.collect(Collectors.toList());
	}

	
	
}
