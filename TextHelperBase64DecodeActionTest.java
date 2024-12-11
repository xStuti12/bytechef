package com.bytechef.component.text.helper.action;

import static com.bytechef.component.text.helper.constant.TextHelperConstants.SEPARATOR;
import static com.bytechef.component.text.helper.constant.TextHelperConstants.TEXTS;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;

import com.bytechef.component.definition.ActionContext;
import com.bytechef.component.definition.Parameters;
import com.bytechef.component.test.definition.MockParametersFactory;
import java.util.List;
import java.util.Map;

import com.bytechef.component.text.helper.constant.TextHelperConstants;
import org.junit.jupiter.api.Test;
public class TextHelperBase64DecodeActionTest {
    @Test
    void testPerformWithEmptyContent() {
        Parameters parameters = MockParametersFactory.create(Map.of(TextHelperConstants.CONTENT, ""));
        String result = (String) TextHelperBase64DecodeAction.perform(parameters, parameters, mock(ActionContext.class));
        assertEquals("", result);
    }

    @Test
    void testPerformWithInvalidBase64() {
        Parameters parameters = MockParametersFactory.create(Map.of(
            TextHelperConstants.CONTENT, "invalid_base64",
            TextHelperConstants.ENCODING_SCHEMA, TextHelperConstants.ENCODING_SCHEMA_BASE64));

        assertThrows(IllegalArgumentException.class,
            () -> TextHelperBase64DecodeAction.perform(parameters, parameters, mock(ActionContext.class)));
    }


    @Test
    void testPerformWithBase64UrlEncoding() {
        Parameters parameters = MockParametersFactory.create(Map.of(
            TextHelperConstants.CONTENT, "SGVsbG9fd29ybGQ",
            TextHelperConstants.ENCODING_SCHEMA, TextHelperConstants.ENCODING_SCHEMA_BASE64URL));
        String result = (String) TextHelperBase64DecodeAction.perform(parameters, parameters, mock(ActionContext.class));
        assertEquals("Hello_world", result);
    }

}
