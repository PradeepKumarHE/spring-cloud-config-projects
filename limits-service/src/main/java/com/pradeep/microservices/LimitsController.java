package com.pradeep.microservices;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class LimitsController {

	@Value("${limits-service.minimum}")
	private int minimum;
	
	@Value("${limits-service.maximum}")
	private int maximum;
	
	@GetMapping("/limits")
	public Limits retrieveLimits() {
		return new Limits(minimum, maximum);
	}
}
