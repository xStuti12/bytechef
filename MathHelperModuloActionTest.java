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

package com.bytechef.component.math.helper.action;

import static com.bytechef.component.math.helper.constants.MathHelperConstants.FIRST_NUMBER;
import static com.bytechef.component.math.helper.constants.MathHelperConstants.SECOND_NUMBER;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

import com.bytechef.component.definition.ActionContext;
import com.bytechef.component.definition.Parameters;
import com.bytechef.component.test.definition.MockParametersFactory;
import java.util.Map;
import org.junit.jupiter.api.Test;

/**
 * @author Monika Kušter
 */
class MathHelperModuloActionTest {

    private final Parameters mockedParameters =
        MockParametersFactory.create(Map.of(FIRST_NUMBER, 10, SECOND_NUMBER, 3));

    @Test
    void testPerform() {
        Double result = MathHelperModuloAction.perform(mockedParameters, mockedParameters, mock(ActionContext.class));

        assertEquals(1.0, result);
    }
    @Test
    void testPerformWithZeroDividend() {
        Parameters mockedParameters = MockParametersFactory.create(Map.of(FIRST_NUMBER, 0, SECOND_NUMBER, 5));
        Double result = MathHelperModuloAction.perform(mockedParameters, mockedParameters, mock(ActionContext.class));
        assertEquals(0.0, result);
    }
    @Test
    void testPerformWithPrimes() {
        Parameters mockedParameters = MockParametersFactory.create(Map.of(FIRST_NUMBER, 17, SECOND_NUMBER, 5));
        Double result = MathHelperModuloAction.perform(mockedParameters, mockedParameters, mock(ActionContext.class));
        assertEquals(2.0, result);
    }

}
