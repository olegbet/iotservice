package com.iot.common;

public class SensorTemp extends Sensor {

	
	public SensorTemp() {
		super();
		this.mUnit = MeasureUnit.TEMPERATURE;
	}

	public SensorTemp(int id, long time, int data) {
		this.id = id;
		this.time = time;
		this.data = data;
		
		this.mUnit = MeasureUnit.TEMPERATURE;
	}
	
	@Override
	int getMinValue() {
		return Constants.TEMP_MIN;
	}

	@Override
	int getMaxValue() {
		
		return Constants.TEMP_MAX;
	}

}
