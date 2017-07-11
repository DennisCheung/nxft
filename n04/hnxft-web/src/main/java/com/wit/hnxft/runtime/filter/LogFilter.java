package com.wit.hnxft.runtime.filter;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.filter.AbstractRequestLoggingFilter;

public class LogFilter extends AbstractRequestLoggingFilter {

    private static final Logger LOGGER = LoggerFactory.getLogger(LogFilter.class);
    private static Long count = 0L;

    private static final String NAME = LogFilter.class + "#COUNT";

    public LogFilter() {
        setIncludeClientInfo(true);
        setIncludePayload(true);
        setMaxPayloadLength(2048);
        setIncludeQueryString(true);

        setBeforeMessagePrefix("[");
        setBeforeMessageSuffix("]");
        setAfterMessagePrefix("[");
        setAfterMessageSuffix("]\n");
    }

    @Override
    protected void beforeRequest(HttpServletRequest request, String message) {
        long cnt;
        synchronized (count) {
            cnt = ++count;
        }

        request.setAttribute(NAME, cnt);
        LOGGER.debug("({})>>> 收到请求：{} {} {}", cnt, request.getMethod(), message, request.getRemoteHost());
    }

    @Override
    protected void afterRequest(HttpServletRequest request, String message) {
        long cnt = (long) request.getAttribute(NAME);
        LOGGER.debug("({})<<< 完成请求：{} {}", cnt, request.getMethod(), message);
    }

}
