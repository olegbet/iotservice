package com.iot.common;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

public class SensorTypeSerializer extends StdSerializer {

	     
	    public SensorTypeSerializer() {
	        super(MeasureUnit.class);
	    }
	 
	    public SensorTypeSerializer(Class t) {
	        super(t);
	    }

		@Override
		public void serialize(Object type, JsonGenerator generator,
			      SerializerProvider provider) throws IOException {
			generator.writeStartObject();
	        generator.writeFieldName("name");
	        generator.writeString(((Enum<MeasureUnit>) type).name());
	        generator.writeFieldName("unit");
	        generator.writeString(((MeasureUnit) type).getUnit());
	        
	        generator.writeEndObject();
			
		}


	
	
}
