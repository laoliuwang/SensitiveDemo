package com.cw.standdata;

import com.cw.service.StandDataService;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.ContextualSerializer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

@Slf4j
public class StandCodeSerializer extends JsonSerializer<Object> implements ContextualSerializer {

    private String fieldName;

    private String standDataType;


    @Autowired
    private StandDataService standDataService;

    @Override
    public void serialize(Object o, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeObject(o);
        jsonGenerator.writeStringField(fieldName, standDataService.getStandDataDesc(fieldName, o));
    }

    @Override
    public JsonSerializer<?> createContextual(SerializerProvider serializerProvider, BeanProperty beanProperty) throws JsonMappingException {
        if (beanProperty != null) {
            log.info("standcode beanProperty:" + beanProperty.getName());
            StandData standData = beanProperty.getAnnotation(StandData.class);
            if (standData != null && standData.value() != null) {
                this.fieldName = beanProperty.getName() + "_desc";
                this.standDataType = standData.value();
                return this;
            }
        }
        return null;
    }
}
