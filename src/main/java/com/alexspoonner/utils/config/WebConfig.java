package com.alexspoonner.utils.config;

import com.alexspoonner.service.AcademicGroupFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by spoonner on 7/8/17.
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan(value = {"com.alexspoonner"})
public class WebConfig extends WebMvcConfigurerAdapter {

    private AcademicGroupFormatter academicGroupFormatter;

    @Autowired
    public void setAcademicGroupFormatter(AcademicGroupFormatter academicGroupFormatter) {
        this.academicGroupFormatter = academicGroupFormatter;
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addFormatter(academicGroupFormatter);
    }
}
