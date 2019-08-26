package com.upen.microservices.currencyconversionservice;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//NOTE Alternative to @RibbonClient - @LoadBalanced with REST Template 
@RibbonClient(name="currency-exchange-service")
//@FeignClient(name="currency-exchange-service")
@FeignClient(name="netflix-zuul-api-gateway-server")
public interface CurrencyExchangeServiceProxy {

	//@GetMapping(("/currencyexchange/from/{from}/to/{to}"))
	@GetMapping(("/currency-exchange-service/currencyexchange/from/{from}/to/{to}"))
	public CurrencyConversionBean retrieveExchangeValue
			(@PathVariable String from, @PathVariable String to);
}
