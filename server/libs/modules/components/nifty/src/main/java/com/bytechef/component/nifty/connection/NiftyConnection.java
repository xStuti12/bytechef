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

package com.bytechef.component.nifty.connection;

import static com.bytechef.component.definition.ComponentDSL.authorization;
import static com.bytechef.component.definition.ComponentDSL.connection;
import static com.bytechef.component.definition.ComponentDSL.string;

import com.bytechef.component.definition.Authorization;
import com.bytechef.component.definition.ComponentDSL.ModifiableConnectionDefinition;
import java.util.List;

/**
 * @author Luka Ljubić
 */
public class NiftyConnection {
    public static final ModifiableConnectionDefinition CONNECTION_DEFINITION = connection()
        .baseUri(((connectionParameters, context) -> "https://openapi.niftypm.com/api/v1.0"))
        .authorizations(authorization(
            Authorization.AuthorizationType.OAUTH2_AUTHORIZATION_CODE.toLowerCase(),
            Authorization.AuthorizationType.OAUTH2_AUTHORIZATION_CODE)
                .title("OAuth2 Authorization Code")
                .properties(
                    string(Authorization.CLIENT_ID)
                        .label("Client id")
                        .required(true),
                    string(Authorization.CLIENT_SECRET)
                        .label("Client secret")
                        .required(true))
                .authorizationUrl((connection, context) -> "https://nifty.pm/authorize")
                .tokenUrl((connection, context) -> "https://openapi.niftypm.com/oauth/token")
                .scopes((connection, context) -> List.of(
                    "task",
                    "project",
                    "milestone",
                    "subtask",
                    "subteam",
                    "statuses")));

    private NiftyConnection() {
    }
}