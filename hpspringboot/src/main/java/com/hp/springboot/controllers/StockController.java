package com.hp.springboot.controllers;




import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stocks")
public class StockController {
	
	@GetMapping (consumes = {MediaType.APPLICATION_XML_VALUE,
            MediaType.APPLICATION_JSON_VALUE} , produces= {MediaType.APPLICATION_XML_VALUE,
                    MediaType.APPLICATION_JSON_VALUE})		
	public String getStock(@RequestParam(name = "stockid") int stockid) {
		return "Hi...." + stockid;
	}

	@GetMapping (path="/{stockid}",  consumes = {MediaType.APPLICATION_XML_VALUE,
            MediaType.APPLICATION_JSON_VALUE} , produces= {MediaType.APPLICATION_XML_VALUE,
                    MediaType.APPLICATION_JSON_VALUE})		
	public String getStockById(@PathVariable(name = "stockid") int stockid) {
		return "Hi using path param...." + stockid;
	}
	
	@GetMapping (path="/{stockid}/person/{personid}",  consumes = {MediaType.APPLICATION_XML_VALUE,
            MediaType.APPLICATION_JSON_VALUE} , produces= {MediaType.APPLICATION_XML_VALUE,
                    MediaType.APPLICATION_JSON_VALUE})		
	public String getStockByPersonId(@PathVariable(name = "stockid") int stockid, 
						@PathVariable(name = "personid") int personid) {
		return "Hi using path param person also...." + stockid;
	}
	
}
