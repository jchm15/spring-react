package com.hm.springreact.webmvc;

//import com.kt.draround.security.HospitalIdPrincipal;

import com.hm.springreact.util.Beans;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class ApiRequest implements Serializable {
    private static final long serialVersionUID = -3985108491760680185L;
    private final Map<String, Object> parameters;

    public ApiRequest(Map<String, Object> parameters) {
        this.parameters = parameters;
    }

    public Map<String, Object> getParameters() {
        return parameters;
    }

    public String getParameter(String parameterName) {
        return (String) parameters.get(parameterName);
    }

    /**
     * 주어진 파라미터 이름으로 List<T>를 반환하고, null이 아닌 값만 필터링하여 반환합니다.
     *
     * @param parameterName 파라미터 이름
     * @param type          원하는 타입
     * @param <T>           제네릭 타입
     * @return List<T>
     */
    public <T> List<T> adaptTo(String parameterName, Class<T> type) {
        // 파라미터에서 데이터를 가져와 필터링
        List<T> list = (List<T>) parameters.get(parameterName);
        return list.stream()
                .filter(Objects::nonNull)
                .map(item -> Beans.clone(item, type))
                .collect(Collectors.toList());
    }

    /**
     * Map<String, Object> 데이터를 T 타입의 객체로 변환합니다.
     *
     * @param type 원하는 타입
     * @param <T>  제네릭 타입
     * @return T 타입의 객체
     */
    public <T> T adaptTo(Class<T> type) {
        // Map 데이터를 T 타입 객체로 변환
        return Beans.clone(parameters, type);
    }
}
