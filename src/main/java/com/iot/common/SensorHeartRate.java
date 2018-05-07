package com.iot.common;

public class SensorHeartRate extends Sensor {

	
	public SensorHeartRate() {
		super();
		mUnit = MeasureUnit.HEART_RATE;
	}
	
	public SensorHeartRate(int id, long time, int data) {
		this.id = id;
		this.time = time;
		this.data = data;
		
		this.mUnit = MeasureUnit.HEART_RATE;
	}
	
	@Override
	int getMinValue() {
		
		return Constants.HEART_RATE_MIN;
	}

	@Override
	int getMaxValue() {
		
		return Constants.HEART_RATE_MAX;
	}

}
