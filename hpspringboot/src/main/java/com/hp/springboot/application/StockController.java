package com.hp.springboot.application;




import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stocks")
public class StockController {
	
	@Autowired
	private StockRepository stockRepository;
							
	@GetMapping	
	public List<Stock> getAllStocks() {
		Iterator<Stock> itr = stockRepository.findAll().iterator();
		List<Stock> stockList = new ArrayList<Stock>();
		
		while (itr.hasNext()) {
			stockList.add(itr.next());
		}
		return stockList;
		
	}

	@GetMapping (path="/{stockid}",  consumes = {MediaType.APPLICATION_XML_VALUE,
            MediaType.APPLICATION_JSON_VALUE} , produces= {MediaType.APPLICATION_XML_VALUE,
                    MediaType.APPLICATION_JSON_VALUE})		
	public ResponseEntity<Stock> getStockById(@PathVariable(name = "stockid") int stockid) {
		Stock stock = stockRepository.findById(new Integer(stockid)).get();
		return ResponseEntity.status(HttpStatus.CREATED).body(stock);
	}
	
	@GetMapping (path="/stockname/{stockname}",  consumes = {MediaType.APPLICATION_XML_VALUE,
            MediaType.APPLICATION_JSON_VALUE} , produces= {MediaType.APPLICATION_XML_VALUE,
                    MediaType.APPLICATION_JSON_VALUE})		
	public ResponseEntity<Stock> getStockByName(@PathVariable(name = "stockname") String stockname) {
		Stock stock = stockRepository.findByStockName(stockname).get(0);
		return ResponseEntity.status(HttpStatus.CREATED).body(stock);
	}
	
	
	@GetMapping (path="/{stockid}/person/{personid}",  consumes = {MediaType.APPLICATION_XML_VALUE,
            MediaType.APPLICATION_JSON_VALUE} , produces= {MediaType.APPLICATION_XML_VALUE,
                    MediaType.APPLICATION_JSON_VALUE})		
	public String getStockByPersonId(@PathVariable(name = "stockid") int stockid, 
						@PathVariable(name = "personid") int personid) {
		return "Hi using path param person also...." + stockid;
	}
	
	@PostMapping(consumes = {MediaType.APPLICATION_XML_VALUE,
            MediaType.APPLICATION_JSON_VALUE} , produces= {MediaType.APPLICATION_XML_VALUE,
                    MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Stock> insertStock (@RequestBody Stock stock) {
		stockRepository.save(stock);
		return ResponseEntity.status(HttpStatus.CREATED).body(stock);
	}
	
	@PutMapping(consumes = {MediaType.APPLICATION_XML_VALUE,
            MediaType.APPLICATION_JSON_VALUE} , produces= {MediaType.APPLICATION_XML_VALUE,
                    MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Stock> updateStock (@RequestBody Stock stock) {
		stockRepository.save(stock);
		return ResponseEntity.status(HttpStatus.CREATED).body(stock);
	}
	
	@DeleteMapping(path="/{stockid}", consumes = {MediaType.APPLICATION_XML_VALUE,
            MediaType.APPLICATION_JSON_VALUE} , produces= {MediaType.APPLICATION_XML_VALUE,
                    MediaType.APPLICATION_JSON_VALUE})
	public String deleteStock (@PathVariable(name = "stockid") int stockid) {
		stockRepository.deleteById(new Integer(stockid));
		return "success";
	}
	
	
}
