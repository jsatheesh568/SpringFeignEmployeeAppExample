package in.satheeshtech.employeeapp.config;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class EmployeeAppConfig {

	@Value("${addressservice.base.url}")
	private String baseAddressURL;
	
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
	
	
	  @Bean public RestTemplate restTemplate() { return new RestTemplate(); }
	 
	
	
}
