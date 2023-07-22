package com.bharat.FilterPractice02.filters;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.*;

@Component
@Order(1)
@Log4j2
public class StudentFilter implements Filter{
    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain chain) throws IOException, ServletException {

        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpServletRequest request = (HttpServletRequest) servletRequest;

        //logging the request
        log.info("Filtering the student request at: {}", request.getRequestURI());

        //chaining a buffered reader to the ServletInputStream to read the input stream or request body.
        //appending all the input into a StringBuilder then getting the string from it!
        log.info("Logging request body:- ");
        StringBuilder stringBuilder = new StringBuilder();

        BufferedReader reader = new BufferedReader(new InputStreamReader(request.getInputStream()));
        reader.lines().forEach(stringBuilder::append);

        log.info(stringBuilder.toString());

        //Setting the response header.
        response.setHeader("X-Powered-By", "com.bharat");

        //writing to the response
        response.getOutputStream().println("Hello from before request was made in the Filter?");

        //this won't work. We can only call the getInputStream() once.
        //reason -> https://topic.alibabacloud.com/a/the-reason-that-a-stream-in-httpservletrequest-can-only-be-read-font-colorredoncefont_1_11_30518178.html
        reader.lines().forEach(log::info);

        //passing the request and response down the chain to do the actual processing of the request.
        //Note than we can actually (kind of) change the request object by creating our own 'Wrapper' classes for request!
        chain.doFilter(request, response);

        //again writing to the response after processing and logging the response header names!
        response.getOutputStream().println("Hello from after request was made in the Filter?");
        log.info("Filtered the student request with headers: {}", response.getHeaderNames());
    }
}
