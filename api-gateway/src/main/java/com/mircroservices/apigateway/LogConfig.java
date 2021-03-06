package com.mircroservices.apigateway;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;

@Component
public class LogConfig implements GlobalFilter{

	private Logger logger=LoggerFactory.getLogger(LogConfig.class);
	
	
	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

		logger.info("Request ->{}",exchange.getRequest().getURI());
		
		return chain.filter(exchange);
	}

	
	
}
