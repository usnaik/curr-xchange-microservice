package com.upen.microservices.currencyconversionservice;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/currency-converter")
public class CurrencyConversionController {

	@Autowired
	private CurrencyExchangeServiceProxy cxProxy;
	
//	@GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
//	public CurrencyConversionBean converCurrency(
//			@PathVariable String from, @PathVariable String to, 
//			@PathVariable BigDecimal quantity) {
//		
//		Map<String, String> uriVariables = new HashMap<>();
//		uriVariables.put("from", from);
//		uriVariables.put("to", to);
//		
//		ResponseEntity<CurrencyConversionBean> responseEntity = new RestTemplate().getForEntity(
//				"http://localhost:8000//currencyexchange/from/{from}/to/{to}", 
//				CurrencyConversionBean.class, uriVariables);
//		
//		CurrencyConversionBean response = responseEntity.getBody();
//		
//		return new CurrencyConversionBean(
//				response.getId(),from,to,response.getConversionMultiple(),quantity,
//				quantity.multiply(response.getConversionMultiple()),response.getPort());
//
//	}

	@GetMapping("/currency-converter-feign/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionBean converCurrencyFeign(
			@PathVariable String from, @PathVariable String to, 
			@PathVariable BigDecimal quantity) {
		
		CurrencyConversionBean response = cxProxy.retrieveExchangeValue(from, to);
		
		return new CurrencyConversionBean(
				response.getId(),from,to,response.getConversionMultiple(),quantity,
				quantity.multiply(response.getConversionMultiple()),response.getPort());

	}
	
}
