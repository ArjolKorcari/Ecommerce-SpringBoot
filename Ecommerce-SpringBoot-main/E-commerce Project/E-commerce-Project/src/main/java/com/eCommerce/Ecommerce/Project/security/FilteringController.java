//package com.eCommerce.Ecommerce.Project.security;
//
//import java.util.Arrays;
//import java.util.List;
//
//import org.springframework.http.converter.json.MappingJacksonValue;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.fasterxml.jackson.databind.ser.FilterProvider;
//import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
//import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
//
//
//@RestController
//public class FilteringController {
//
//	@GetMapping("/filterig")
//	public MappingJacksonValue filtering() {
//		
//		
//		
//		
//		SomeBean someBean = new SomeBean("value1","value2","value3");
//		
//		MappingJacksonValue jacksonValue = new MappingJacksonValue(someBean);
//		
//		SimpleBeanPropertyFilter filter= SimpleBeanPropertyFilter.filterOutAllExcept("fiel1","fiel3");    // kjo eshte logjik e filterit per nje url specifik
//		
//		FilterProvider filters=new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
//		jacksonValue.setFilters(filters);
//		
//		return jacksonValue;
//		
//		
//	
//	}
//	
//	@GetMapping("/filterig-list") // filed2 field 3
//	public MappingJacksonValue filteringList() {
//		
//		List<SomeBean> list = Arrays.asList(new SomeBean("value1","value2","value3"),
//				new SomeBean("value4","value5","value6") );
//		MappingJacksonValue jacksonValue = new MappingJacksonValue(list);
//SimpleBeanPropertyFilter filter= SimpleBeanPropertyFilter.filterOutAllExcept("fiel2","fiel3");    // kjo eshte logjik e filterit per nje url specifik
//		
//		FilterProvider filters=new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
//		jacksonValue.setFilters(filters);
//
//		
//		return jacksonValue;
//	
//	}
//}
