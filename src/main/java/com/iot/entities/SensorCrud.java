package com.iot.entities;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.iot.common.MeasureUnit;
import com.iot.common.Sensor;




@Document(collection="sensors")
public class SensorCrud {
	@Indexed
	public int sensorId;
	@Indexed
	public long timestamp;
	@JsonFormat(shape = JsonFormat.Shape.OBJECT)
	public MeasureUnit mUnit;
	public int data;
	
	public SensorCrud() {
		super();
	}
	public SensorCrud(Sensor sensor) {
		super();
		this.sensorId = sensor.getId();
		this.timestamp = sensor.getTime();
		this.mUnit = sensor.getmUnit();
		this.data = sensor.getData();
	}
	public int getSensorId() {
		return sensorId;
	}
	public void setSensorId(int sensorId) {
		this.sensorId = sensorId;
	}
	public long getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	public MeasureUnit getmUnit() {
		return mUnit;
	}
	public void setmUnit(MeasureUnit mUnit) {
		this.mUnit = mUnit;
	}
	public double getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}

}
