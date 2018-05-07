package com.iot.common;



public class SensorCarFuel extends Sensor {

	
	
	
	public SensorCarFuel() {
		super();
		mUnit = MeasureUnit.CAR_FUEL;
	}
	
	public SensorCarFuel(int id, long time, int data) {
		this.id = id;
		this.time = time;
		this.data = data;
		
		this.mUnit = MeasureUnit.HEART_RATE;
	}
	
	@Override
	int getMinValue() {
		
		return Constants.FUEL_MIN;
	}

	@Override
	int getMaxValue() {
		
		return Constants.FUEL_MAX;
	}

}
