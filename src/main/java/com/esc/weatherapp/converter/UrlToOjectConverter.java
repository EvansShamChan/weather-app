package com.esc.weatherapp.converter;

import com.esc.weatherapp.entity.WeatherDesc;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URL;

@Component
public class UrlToOjectConverter {
    public WeatherDesc getObjectByUrl(URL url) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        WeatherDesc weatherDesc = mapper.readValue(url, WeatherDesc.class);
        return weatherDesc;
    }
}
