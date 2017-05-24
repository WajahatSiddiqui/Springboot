package com.wajahat.learn.spring.zuul.gateway.springbootzuulproxy.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by wajahat on 23/5/17.
 */
public class StaticFilter extends ZuulFilter {
    Logger logger = LoggerFactory.getLogger(StaticFilter.class);
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
        HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
        logger.info("%s request to %s", request.getMethod(), request.getRequestURL().toString());
        return null;
    }
}
