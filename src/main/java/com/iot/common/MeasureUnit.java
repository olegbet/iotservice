package com.iot.common;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.iot.interfaces.IMeasureUnit;

@JsonSerialize(using = SensorTypeSerializer.class)
@JsonDeserialize(using = SensorTypeDeserializer.class)
public enum MeasureUnit implements IMeasureUnit {
	TEMPERATURE("°F"), 
	HEART_RATE("bpm"), 
	CAR_FUEL("litres"),
	PRESSURE("Ba");

	
	private String unit;
	
	private MeasureUnit(String unit) 
	{
		this.unit = unit;
	}
	
	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}
	
	@Override
	public IMeasureUnit convertTo(IMeasureUnit unit) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
