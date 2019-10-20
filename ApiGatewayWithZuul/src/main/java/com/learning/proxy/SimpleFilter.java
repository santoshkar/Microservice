package com.learning.proxy;

import javax.servlet.http.HttpServletRequest;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

public class SimpleFilter extends ZuulFilter {
	@Override
	public String filterType() {
		System.out.println("in filterType()");
		return "pre";
	}

	@Override
	public int filterOrder() {
		System.out.println("In filterOrder()");
		return 1;
	}

	@Override
	public boolean shouldFilter() {
		System.out.println("In shouldFilter()");
		return true;
	}

	@Override
	public Object run() {
		System.out.println("In run");
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();
		System.out.println(String.format("%s request to %s", request.getMethod(), request.getRequestURL().toString()));
		return null;
	}
}
