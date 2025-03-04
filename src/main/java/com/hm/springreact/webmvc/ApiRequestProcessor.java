package com.hm.springreact.webmvc;

import com.hm.springreact.util.Jsons;
import com.google.common.collect.Maps;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpMethod;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.servlet.HandlerMapping;

import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;

public class ApiRequestProcessor implements HandlerMethodArgumentResolver {
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return ApiRequest.class.isAssignableFrom(parameter.getParameterType());
    }

    @SuppressWarnings("unchecked")
    @Override
    public Object resolveArgument(@NonNull MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        HttpServletRequest request = (HttpServletRequest) webRequest.getNativeRequest();
        Map<String, Object> parameters = Maps.newHashMap();

        if (HttpMethod.GET.matches(request.getMethod())) {
            Enumeration<String> parameterNames = request.getParameterNames();
            while (parameterNames.hasMoreElements()) {
                String parameterName = parameterNames.nextElement();
                if (request.getParameterValues(parameterName).length > 1) {
                    parameters.put(parameterName, Arrays.asList(request.getParameterValues(parameterName)));
                } else {
                    parameters.put(parameterName, request.getParameter(parameterName));
                }

            }
        } else if (HttpMethod.POST.matches(request.getMethod())) {
            if (request.getContentLength() > 0) {
                parameters.putAll(Jsons.readValueAsMap(request.getInputStream()));
            }
        }
        // path variable top sort.
        parameters.putAll((Map<String, String>) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE));
        return new ApiRequest(parameters);
    }
}
