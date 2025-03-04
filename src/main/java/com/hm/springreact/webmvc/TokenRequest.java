package com.hm.springreact.webmvc;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter @Setter
public class TokenRequest implements Serializable {
    private static final long serialVersionUID = 5338008127053143246L;

    public static final String GRANT_TYPE_REFRESH_TOKEN = "refresh_token";

    @JsonProperty("grant_type")
    private String grantType;

    private String id;

    private String password;

    private String token;
}
