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

package com.bytechef.platform.user.web.rest;

import com.bytechef.platform.user.domain.SigningKey;
import com.bytechef.platform.user.web.rest.config.PlatformUserMapperSpringConfig;
import com.bytechef.platform.user.web.rest.model.SigningKeyModel;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.extensions.spring.DelegatingConverter;
import org.springframework.core.convert.converter.Converter;

/**
 * @author Ivica Cardic
 */
@Mapper(config = PlatformUserMapperSpringConfig.class)
public interface SigningKeyMapper extends Converter<SigningKey, SigningKeyModel> {

    @Override
    SigningKeyModel convert(SigningKey signingKey);

    @InheritInverseConfiguration
    @DelegatingConverter
    @Mapping(target = "publicKey", ignore = true)
    @Mapping(target = "type", ignore = true)
    @Mapping(target = "userId", ignore = true)
    SigningKey invertConvert(SigningKeyModel signingKeyModel);
}
