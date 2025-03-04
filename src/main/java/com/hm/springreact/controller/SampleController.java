package com.hm.springreact.controller;

import com.hm.springreact.VO.SampleVO;
import com.hm.springreact.webmvc.ApiRequest;
import com.hm.springreact.webmvc.ApiResponse;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class SampleController {

    @PostMapping("/api/hello")
    public ApiResponse getHello(ApiRequest request) {
        SampleVO vo = request.adaptTo(SampleVO.class);


        return ApiResponse.of(vo);
//        return "Hello " + vo.getName() + ", Age: " + vo.getAge();
    }
}
