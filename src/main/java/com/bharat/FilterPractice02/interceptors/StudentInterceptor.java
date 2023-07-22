package com.bharat.FilterPractice02.interceptors;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.io.BufferedReader;
import java.io.InputStreamReader;

@Component
public class StudentInterceptor implements HandlerInterceptor {
    private final Logger log = LogManager.getLogger(StudentInterceptor.class);
    /*
     * TODO: !IMPORTANT
     * Notice how the interceptor receives more data or information about what is going on like the handler that will
     * process the request, the ModelAndView that will be rendered and any exception that was thrown after rendering.
     * This is because well the Interceptor lies inside the MVC, and hence it gets this data, however in case of filters,
     * they lie before the DispatcherServlet outside MVC, so they get less data and rely on just the data in the request
     * i.e., headers, parameters and body!
     * */

    @Override
    //Runs after the DispatcherServlet assign the handler but before the invocation of the handler!
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //logging the request endpoint from the interceptor
        log.info("Intercepting at endpoint: {}", request.getRequestURI());

        //the handler is actually HandlerMethod in disguise. Although this is true only when we have controllers handling the request
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        log.info("Intercepting with handler method: {}()", handlerMethod.getMethod().getName());

        //this won't work either since we have already invoked the getInputStream() in the StudentFilter.
        BufferedReader reader = new BufferedReader(new InputStreamReader(request.getInputStream()));
        reader.lines().forEach(log::info);

        //writing to the response using the ServletOutputStream
        response.getOutputStream().println("Hello from before request was made in the preHandle()?");

        return HandlerInterceptor.super.preHandle(request, response, handler); //well this simply returns true in the parent method!
    }

    @Override
    //Runs after the response or view is processed but is not rendered!
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("Intercepting the response with headers: {}", response.getHeaderNames());

        HandlerMethod handlerMethod = (HandlerMethod) handler;
        log.info("Intercepting with handler method in postHandle(): {}()", handlerMethod.getMethod().getName());

        //notice that we can write to the response(or the ServletOutputStream) even after the response has been processed
        response.getOutputStream().println("What about the postHandle??");//this will write to the response

        //but this will not change the header since the response is already committed, but we can add more models(write more content) to the response!
        response.setHeader("X-Powered-By", "com.litchi");

        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView); //this doesn't do anything in the superclass
    }

    @Override
    //This is kind of a callback after the view is rendered
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

        log.info("Intercepted and sent the request to the filter with status: {}", response.getStatus());

        response.getOutputStream().println("What about the afterCompletion??");

        HandlerInterceptor.super.afterCompletion(request, response, handler, ex); //this doesn't do anything in the superclass either
    }
}
