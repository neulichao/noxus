package com.netease.springbootDemo.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 全局异常捕捉
 * @author bjchenyuan
 *
 */
@ControllerAdvice
public class GlobalDefaultExceptionHandler {

	private static final Logger logger = LoggerFactory.getLogger(GlobalDefaultExceptionHandler.class);

	@ExceptionHandler(value = Exception.class)
	public void defaultErrorHandler(HttpServletRequest request, Exception e) {
		HttpSession session = request.getSession();
		String requestUrl = getFullURL(request);
		logger.error("requestUrl:{} error.", e);
	}

	private String getFullURL(HttpServletRequest request) {
		StringBuffer url = request.getRequestURL();
		if (request.getQueryString() != null) {
			url.append('?');
			url.append(request.getQueryString());
		}
		return url.toString();
	}
}
