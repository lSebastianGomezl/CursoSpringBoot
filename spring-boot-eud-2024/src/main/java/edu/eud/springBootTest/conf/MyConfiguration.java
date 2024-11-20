package edu.eud.springBootTest.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.github.dozermapper.core.DozerBeanMapper;
import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.google.gson.Gson;

@Configuration
@PropertySource("classpath:myproperties.properties")
public class MyConfiguration {
	
	@Bean("myGson")
	public Gson getGson() {
		Gson gson = new Gson();
		return gson;
	}
	
	@Bean
	DozerBeanMapper getMapper() {
		DozerBeanMapperBuilder builder = DozerBeanMapperBuilder.create();
		return (DozerBeanMapper) builder.build();
	}

}
