package com.eMart.zuul.filter;

import javax.servlet.http.HttpServletRequest;

import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class IdentityVerificationFilter extends ZuulFilter {

	@Override
	public boolean shouldFilter() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		// TODO Auto-generated method stub
		System.out.println("my filter");

		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();
		Object token = request.getHeader("token");
		System.out.println("token"+token);
		String requestUrl = request.getRequestURI();
		String loginUrl = "/user/unknownUser/login/";
		System.out.println("requestUrl:"+requestUrl);
//ignore login and register in Filter
		if (loginUrl.equals(requestUrl)) {
			return true;
		} else {
			// 校验token
			if (token == null) {
				// "token为空，禁止访问!"
				ctx.setSendZuulResponse(false);
				ctx.setResponseStatusCode(401);
				System.out.println("token:" + token);
				return null;
			} else {
				// TODO 根据token获取相应的登录信息，进行校验（略）
				System.out.println("token:" + token);
				return true;
			}
		}
	}

	@Override
	public String filterType() {
		// TODO Auto-generated method stub
		return FilterConstants.PRE_TYPE;
	}

	@Override
	public int filterOrder() {
		// TODO Auto-generated method stub
		return 0;
	}

}
