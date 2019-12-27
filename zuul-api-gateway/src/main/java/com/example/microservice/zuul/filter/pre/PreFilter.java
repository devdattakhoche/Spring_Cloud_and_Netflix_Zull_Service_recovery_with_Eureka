package com.example.microservice.zuul.filter.pre;


import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

public class PreFilter extends ZuulFilter{
	private static Logger log = LoggerFactory.getLogger(PreFilter.class);

	  @Override
	  public String filterType() {
	    return "pre";
	  }

	  @Override
	  public int filterOrder() {
	    return 1;
	  }

	  @Override
	  public boolean shouldFilter() {
	    return true;
	  }

	  @Override
	  public Object run() {
		  RequestContext ctx = RequestContext.getCurrentContext();
		    HttpServletRequest request = ctx.getRequest();

		    log.info("this is pre filter");
		    log.info(String.format("%s request to %s in port %d", request.getMethod(), request.getRequestURL().toString(),request.getLocalPort()));

	    return null;
	  }

}
