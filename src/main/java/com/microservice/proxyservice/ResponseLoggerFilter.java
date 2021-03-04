package com.microservice.proxyservice;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class ResponseLoggerFilter extends ZuulFilter {
  private static final Logger logger = LoggerFactory.getLogger(ResponseLoggerFilter.class);
  @Override
  public boolean shouldFilter() {
    return FilterUtil.SHOULD_FILTER;
  }
  @Override
  public String filterType() {
    return FilterUtil.FILTER_TYPE_POST;
  }
  @Override
  public int filterOrder() {
    return FilterUtil.FILTER_ORDER;
  }
  @Override
  public Object run() throws ZuulException {
    RequestContext ctx = RequestContext.getCurrentContext();
    logger.info("response status logged " + ctx.getResponse().getStatus());
    return null;
  }
}
