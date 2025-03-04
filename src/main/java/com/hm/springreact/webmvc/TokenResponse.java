package com.hm.springreact.webmvc;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TokenResponse extends ApiResponse {
    @JsonProperty("access_token")
    private String accessToken;

    @JsonProperty("refresh_token")
    private String refreshToken;

    public TokenResponse(Object body, String accessToken, String refreshToken) {
        super(body);
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
    }

    public static TokenResponse of(Object body, String accessToken, String refreshToken) {
        return new TokenResponse(body, accessToken, refreshToken);
    }
}
