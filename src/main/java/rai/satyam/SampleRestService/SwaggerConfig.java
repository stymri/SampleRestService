package rai.satyam.SampleRestService;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

//configuration
//Enable Swagger
@Configuration
@EnableSwagger2
public class SwaggerConfig {
	//Bean Docket
	@Bean
	public Docket api() {
		//Swagger2
		return new Docket(DocumentationType.SWAGGER_2);
	}
}
