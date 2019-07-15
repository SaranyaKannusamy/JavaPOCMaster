package com.consumer.BusServiceConsumer.Controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import yahoofinance.Stock;
import yahoofinance.YahooFinance;

@RestController
@RequestMapping("/busConsumer")
public class ConsumerController {
	
	

	@Autowired
	private DiscoveryClient discoveryClient;
	@RequestMapping(value = "/list", method= RequestMethod.GET, produces = "application/json")
	public String getBuses() throws RestClientException, IOException {
		
		List<ServiceInstance> instances=discoveryClient.getInstances("db_Service");
		ServiceInstance serviceInstance=instances.get(0);
		
		
		String baseUrl=serviceInstance.getUri().toString();
		
		baseUrl=baseUrl+"/bus/list";
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response=null;
		try{
		response=restTemplate.exchange(baseUrl,
				HttpMethod.GET, getHeaders(),String.class);
		
		}catch (Exception ex)
		{
			System.out.println(ex);
		}
	
		return response.getBody();
	}
	
	@RequestMapping(value = "/getById/{id}", method= RequestMethod.GET, produces = "application/json")
	public String getBusesById(@PathVariable("id") final int id) throws RestClientException, IOException {
		
		List<ServiceInstance> instances=discoveryClient.getInstances("db_Service");
		ServiceInstance serviceInstance=instances.get(0);
		
		
		String baseUrl=serviceInstance.getUri().toString();
		System.out.println("baseUrl --->"+baseUrl);
		
		baseUrl=baseUrl+"/bus/getByRouteId/"+id;
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response=null;
		
		try{
		response=restTemplate.exchange(baseUrl,
				HttpMethod.GET, getHeaders(),String.class);
		System.out.println("Response from DBService ----->"+response.getBody().toString());
		BigDecimal quotes = getStockPrice(response.getBody().trim());
		 System.out.println("Final Repsonse"+quotes);
			return quotes.toString();
			
			 
		
		}catch (Exception ex)
		{
			System.out.println("Exception Occured------------->"+ex);
			return "Exception Occured";
		}
		
		
		
	
	}


	private BigDecimal getStockPrice(String quote) {

		try {
			quote = quote.replaceAll("[^a-zA-Z0-9]", "");
			System.out.println("symbol Value is ----> "+quote);
			
			Stock stock = YahooFinance.get(quote);
			BigDecimal price = stock.getQuote(true).getPrice();
			System.out.println("Proce value of INTC stock ----------->"+price);
			return price;
			

		} catch (IOException e) {

			e.printStackTrace();

			return BigDecimal.ZERO;

		}

	    }
	
	private static HttpEntity<?> getHeaders() throws IOException {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		return new HttpEntity<>(headers);
	}
	
}



