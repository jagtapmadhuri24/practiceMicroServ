package com.in28minutes.rest.webservices.restfulwebservices.filtering;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilteringController {

	
	@GetMapping("/filtering")
	public MappingJacksonValue retreiveSomeBean(){
		SomeBean bean= new SomeBean("value1","value2","value3");
		SimpleBeanPropertyFilter beanPropFilters= SimpleBeanPropertyFilter.filterOutAllExcept("field1","field2");
		FilterProvider filterProvider= new SimpleFilterProvider().addFilter("");
		MappingJacksonValue mapping= new MappingJacksonValue(bean);
		mapping.setFilters(filterProvider);
		return mapping;
	}
	
	@GetMapping("/filtering-list")
	public List<SomeBean> retreiveListSomeBean(){
		return Arrays.asList(new SomeBean("value1","value2","value3"),new SomeBean("value12","value22","value32"));
	}

}
