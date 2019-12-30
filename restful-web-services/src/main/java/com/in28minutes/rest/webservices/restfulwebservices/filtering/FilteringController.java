package com.in28minutes.rest.webservices.restfulwebservices.filtering;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
@RequestMapping("/filterApi")
public class FilteringController {

	
	@GetMapping("/filtering")
	//@PreAuthorize("hasRole('USER')")
	public MappingJacksonValue retreiveSomeBean(){
		SomeBean someBean= new SomeBean("value1","value2","value3");
		SimpleBeanPropertyFilter beanPropFilters= SimpleBeanPropertyFilter.filterOutAllExcept("field1","field2");
		FilterProvider filterProvider= new SimpleFilterProvider().addFilter("SomeBeanFilter",beanPropFilters);
		MappingJacksonValue mapping= new MappingJacksonValue(someBean);
		mapping.setFilters(filterProvider);
		return mapping;
	}
	
	@GetMapping("/filtering-list")
	//@PreAuthorize("permitAll()")
	public MappingJacksonValue retreiveListSomeBean(){
		
		List<SomeBean> listSomeBean=Arrays.asList(new SomeBean("value1","value2","value3"),new SomeBean("value12","value22","value32"));
		//Here we are showing only "field1"
		SimpleBeanPropertyFilter beanPropFilters= SimpleBeanPropertyFilter.filterOutAllExcept("field1");
		FilterProvider filterProvider= new SimpleFilterProvider().addFilter("SomeBeanFilter",beanPropFilters);
		MappingJacksonValue mapping= new MappingJacksonValue(listSomeBean);
		mapping.setFilters(filterProvider);
		
		return mapping;
	}

}
