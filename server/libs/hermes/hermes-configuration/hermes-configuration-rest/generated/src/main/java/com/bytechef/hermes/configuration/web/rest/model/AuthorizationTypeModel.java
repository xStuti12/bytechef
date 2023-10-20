
/*
 * Copyright 2023-present ByteChef Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.bytechef.hermes.configuration.web.rest.model;

import com.fasterxml.jackson.annotation.JsonValue;
import jakarta.validation.constraints.*;

import java.util.*;
import jakarta.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Authorization type.
 */

@Generated(
    value = "org.openapitools.codegen.languages.SpringCodegen",
    date = "2023-10-06T20:36:49.034607+02:00[Europe/Zagreb]")
public enum AuthorizationTypeModel {

    API_KEY("API_KEY"),

    BASIC_AUTH("BASIC_AUTH"),

    BEARER_TOKEN("BEARER_TOKEN"),

    CUSTOM("CUSTOM"),

    DIGEST_AUTH("DIGEST_AUTH"),

    OAUTH2_AUTHORIZATION_CODE("OAUTH2_AUTHORIZATION_CODE"),

    OAUTH2_AUTHORIZATION_CODE_PKCE("OAUTH2_AUTHORIZATION_CODE_PKCE"),

    OAUTH2_CLIENT_CREDENTIALS("OAUTH2_CLIENT_CREDENTIALS"),

    OAUTH2_IMPLICIT_CODE("OAUTH2_IMPLICIT_CODE"),

    OAUTH2_RESOURCE_OWNER_PASSWORD("OAUTH2_RESOURCE_OWNER_PASSWORD");

    private String value;

    AuthorizationTypeModel(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    @JsonCreator
    public static AuthorizationTypeModel fromValue(String value) {
        for (AuthorizationTypeModel b : AuthorizationTypeModel.values()) {
            if (b.value.equals(value)) {
                return b;
            }
        }
        throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
}
