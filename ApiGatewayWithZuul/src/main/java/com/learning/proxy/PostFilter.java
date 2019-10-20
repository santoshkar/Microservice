package com.learning.proxy;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

import javax.servlet.http.HttpServletRequest;

public class PostFilter extends ZuulFilter {
	@Override
	public String filterType() {
		System.out.println("in post-filterType()");
		return "post";
	}

	@Override
	public int filterOrder() {
		System.out.println("In post-filterOrder()");
		return 1;
	}

	@Override
	public boolean shouldFilter() {
		System.out.println("In post-shouldFilter()");
		return true;
	}

	@Override
	public Object run() {
		System.out.println("In post-run");
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();
		System.out.println(String.format("%s request to %s", request.getMethod(), request.getRequestURL().toString()));
		return null;
	}
}
