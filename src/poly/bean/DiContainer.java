package poly.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import poly.service.impl.HomeServiceImpl;

@Configuration
public class DiContainer 
{
	@Bean(name = "homeServicePrimary")
	public HomeServiceImpl getHomeServiceImpl() 
	{
		return new HomeServiceImpl();
	}
}
