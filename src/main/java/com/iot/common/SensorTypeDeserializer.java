package com.iot.common;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

public class SensorTypeDeserializer extends StdDeserializer<MeasureUnit> {

		 
	    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

		public SensorTypeDeserializer() { 
	        this(null); 
	    } 
	 
	    public SensorTypeDeserializer(Class<?> vc) { 
	        super(vc); 
	    }
	 
	    @Override
	    public MeasureUnit deserialize(JsonParser jp, DeserializationContext ctxt) 
	      throws IOException, JsonProcessingException {
	        JsonNode node = jp.getCodec().readTree(jp);
	        
	        String name = node.get("name").asText();
	        String unit = node.get("unit").asText();
	 
	        for (final MeasureUnit enumValue : MeasureUnit.values())
	        {
	            if (enumValue.getUnit().equals(unit))
	            {
	                return enumValue;
	            }
	        }
			return null;
	        
	        
	    }
	
	
		
}
