package com.iot.common;

public interface Constants {
	String ADD_SENSOR="/sensor/add";
	String MIN_DATA="/sensors/min/get";
	String MAX_DATA="/sensors/max/get";
	String MEDIAN_DATA="/sensors/median/get";
	String AVG_DATA="/sensors/avg/get";
	String SENSORS_DATE = "/sensors/date/get";
	String SENSOR_ID="sensorid";
	String DATE_TIME_FROM="datetimefrom";
	String DATE_TIME_TO="datetimeto";
	
	public final int TEMP_MIN = 0;
	public final int TEMP_MAX = 200;
	public final int FUEL_MIN = 0;
	public final int FUEL_MAX = 10000;
	public final int HEART_RATE_MIN = 0;
	public final int HEART_RATE_MAX = 200;
	
}
