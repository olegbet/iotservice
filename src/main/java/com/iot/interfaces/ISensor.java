package com.iot.interfaces;

import java.util.List;

import com.iot.common.Sensor;

public interface ISensor {

	void addSensorData(Sensor sensor);
    int getMaximalData(int sensorId, String dataTimeFrom, String dataTimeTo);
    int getMinimalData(int sensorId, String dataTimeFrom, String dataTimeTo);
    double getAvgData(int sensorId, String dataTimeFrom, String dataTimeTo);
    double getMedianData(int sensorId, String dataTimeFrom, String dataTimeTo); 
    List<Sensor> getSensorsData(String dateTimeFrom, String dateTimeTo) ;

}
