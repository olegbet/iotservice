package com.iot.IoTService;



import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iot.interfaces.ISensor;

import com.iot.common.Constants;
import com.iot.common.Sensor;



@Configuration
@ComponentScan
@EnableAutoConfiguration
@SpringBootApplication
@RestController
@ImportResource("classpath:sensors.xml")
public class IoTServiceApplication {

	@Autowired
	ISensor sensors;
	
	
	@RequestMapping(value=Constants.ADD_SENSOR,method=RequestMethod.PUT)
	void addSensor(@RequestBody Sensor sensor){
		sensors.addSensorData(sensor);
	}
	
	@GetMapping(value=Constants.AVG_DATA)
	int getAvgData(@RequestParam(name=Constants.SENSOR_ID) int id,
			@RequestParam(name=Constants.DATE_TIME_FROM,
			required=false,defaultValue="")
	String dateTimeFrom,@RequestParam(name=Constants.DATE_TIME_TO,
	required=false,defaultValue="")
	String dateTimeTo){
		return (int) sensors.getAvgData
				(id, dateTimeFrom, dateTimeTo);
	}
	
	@GetMapping(value=Constants.MEDIAN_DATA)
	int getMedianData(@RequestParam(name=Constants.SENSOR_ID) int id,
			@RequestParam(name=Constants.DATE_TIME_FROM,
			required=false,defaultValue="")
	String dateTimeFrom,@RequestParam(name=Constants.DATE_TIME_TO,
	required=false,defaultValue="")
	String dateTimeTo){
		return (int) sensors.getMedianData
				(id, dateTimeFrom, dateTimeTo);
	}
	
	@GetMapping(value=Constants.MIN_DATA)
	int getMinData(@RequestParam(name=Constants.SENSOR_ID) int id,
			@RequestParam(name=Constants.DATE_TIME_FROM,
			required=false,defaultValue="")
	String dateTimeFrom,@RequestParam(name=Constants.DATE_TIME_TO,
	required=false,defaultValue="")
	String dateTimeTo){
		return sensors.getMinimalData
				(id, dateTimeFrom, dateTimeTo);
	}
	@GetMapping(value=Constants.MAX_DATA)
	int getMaxData(@RequestParam(name=Constants.SENSOR_ID) int id,
			@RequestParam(name=Constants.DATE_TIME_FROM,
			required=false,defaultValue="")
	String dateTimeFrom,@RequestParam(name=Constants.DATE_TIME_TO,
	required=false,defaultValue="")
	String dateTimeTo){
		return sensors.getMaximalData
				(id, dateTimeFrom, dateTimeTo);
	}
	@GetMapping(value=Constants.SENSORS_DATE)
	List<Sensor> getSensorsData(@RequestParam(name=Constants.DATE_TIME_FROM,
			required=false,defaultValue="")
	String dateTimeFrom,@RequestParam(name=Constants.DATE_TIME_TO,
	required=false,defaultValue="")
	String dateTimeTo){
		return sensors.getSensorsData(dateTimeFrom, dateTimeTo);
	}
	
	
	public static void main(String[] args) {
		ConfigurableApplicationContext ctx=
		SpringApplication.run(IoTServiceApplication.class, args);
		Scanner scanner=new Scanner(System.in);
		while(true){
			System.out.println("Enter quit for exit from the service");
			if(scanner.nextLine().equals("quit"))
				break;
		}
		scanner.close();
		ctx.close();

	}
	
   /* @Bean
    CommandLineRunner init(final AccountRepository accountRepository) {
      
      return new CommandLineRunner() {

        @Override
        public void run(String... arg0) throws Exception {
          accountRepository.save(new Account("oleg", new BCryptPasswordEncoder().encode("1234567")));
          
        }
        
      };

    }*/


}
