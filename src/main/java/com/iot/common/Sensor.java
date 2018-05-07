package com.iot.common;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

@JsonTypeInfo(use=Id.CLASS)
public abstract class Sensor {
	public int id;
	public long time;
	public int data;
	
	@JsonFormat(shape=Shape.OBJECT)
	public MeasureUnit mUnit;
	
	
	abstract int getMinValue();
	abstract int getMaxValue();
	
	MeasureUnit getMeasureUnit() 
	{
		return mUnit;
		
	};
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public long getTime() {
		return time;
	}
	public void setTime(long time) {
		this.time = time;
	}
	
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public Sensor(int id, long time, MeasureUnit type, int data) {
		super();
		this.id = id;
		this.time = time;
		
		this.data = data;
	}
	
	public MeasureUnit getmUnit() {
		return mUnit;
	}
	public void setmUnit(MeasureUnit mUnit) {
		this.mUnit = mUnit;
	}
	public Sensor() {
		super();
		
	}
	
	
}
