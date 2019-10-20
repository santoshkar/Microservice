package com.learning.proxy;

import javax.servlet.http.HttpServletRequest;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

public class PreFilter extends ZuulFilter {
	@Override
	public String filterType() {
		System.out.println("in pre-filterType()");
		return "pre";
	}

	@Override
	public int filterOrder() {
		System.out.println("In pre-filterOrder()");
		return 1;		//Order is applied when the filter type is same
	}

	@Override
	public boolean shouldFilter() {
		System.out.println("In pre-shouldFilter()");
		return true;
	}

	@Override
	public Object run() {
		System.out.println("In pre-run");
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();
		System.out.println(String.format("%s request to %s", request.getMethod(), request.getRequestURL().toString()));
		return null;
	}
}
