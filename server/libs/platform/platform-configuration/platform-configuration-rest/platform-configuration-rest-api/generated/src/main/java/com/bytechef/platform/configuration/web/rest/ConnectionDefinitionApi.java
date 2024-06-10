/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (7.5.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package com.bytechef.platform.configuration.web.rest;

import com.bytechef.platform.configuration.web.rest.model.ConnectionDefinitionBasicModel;
import com.bytechef.platform.configuration.web.rest.model.ConnectionDefinitionModel;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import jakarta.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-06-10T08:47:34.098410+02:00[Europe/Zagreb]", comments = "Generator version: 7.5.0")
@Validated
@Tag(name = "connection-definition", description = "The Platform Connection Definition API")
public interface ConnectionDefinitionApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * GET /component-definitions/{componentName}/versions/{componentVersion}/connection-definition : Get connection definition for a component
     * Get connection definition for a component.
     *
     * @param componentName The name of a component. (required)
     * @param componentVersion The version of a component. (required)
     * @return Successful operation. (status code 200)
     */
    @Operation(
        operationId = "getComponentConnectionDefinition",
        summary = "Get connection definition for a component",
        description = "Get connection definition for a component.",
        tags = { "connection-definition" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Successful operation.", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = ConnectionDefinitionModel.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/component-definitions/{componentName}/versions/{componentVersion}/connection-definition",
        produces = { "application/json" }
    )
    
    default ResponseEntity<ConnectionDefinitionModel> getComponentConnectionDefinition(
        @Parameter(name = "componentName", description = "The name of a component.", required = true, in = ParameterIn.PATH) @PathVariable("componentName") String componentName,
        @Parameter(name = "componentVersion", description = "The version of a component.", required = true, in = ParameterIn.PATH) @PathVariable("componentVersion") Integer componentVersion
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"authorizationRequired\" : true, \"componentTitle\" : \"componentTitle\", \"baseUri\" : \"baseUri\", \"authorizations\" : [ { \"name\" : \"name\", \"description\" : \"description\", \"title\" : \"title\", \"properties\" : [ { \"displayCondition\" : \"displayCondition\", \"hidden\" : false, \"name\" : \"name\", \"description\" : \"description\", \"advancedOption\" : false, \"required\" : false, \"expressionEnabled\" : true }, { \"displayCondition\" : \"displayCondition\", \"hidden\" : false, \"name\" : \"name\", \"description\" : \"description\", \"advancedOption\" : false, \"required\" : false, \"expressionEnabled\" : true } ] }, { \"name\" : \"name\", \"description\" : \"description\", \"title\" : \"title\", \"properties\" : [ { \"displayCondition\" : \"displayCondition\", \"hidden\" : false, \"name\" : \"name\", \"description\" : \"description\", \"advancedOption\" : false, \"required\" : false, \"expressionEnabled\" : true }, { \"displayCondition\" : \"displayCondition\", \"hidden\" : false, \"name\" : \"name\", \"description\" : \"description\", \"advancedOption\" : false, \"required\" : false, \"expressionEnabled\" : true } ] } ], \"componentDescription\" : \"componentDescription\", \"componentName\" : \"componentName\", \"version\" : 0, \"properties\" : [ { \"displayCondition\" : \"displayCondition\", \"hidden\" : false, \"name\" : \"name\", \"description\" : \"description\", \"advancedOption\" : false, \"required\" : false, \"expressionEnabled\" : true }, { \"displayCondition\" : \"displayCondition\", \"hidden\" : false, \"name\" : \"name\", \"description\" : \"description\", \"advancedOption\" : false, \"required\" : false, \"expressionEnabled\" : true } ] }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * GET /component-definitions/{componentName}/versions/{componentVersion}/connection-definitions : Get all compatible connection definitions for a component
     * Get all compatible connection definitions for a component.
     *
     * @param componentName The name of a component. (required)
     * @param componentVersion The version of a component. (required)
     * @return Successful operation. (status code 200)
     */
    @Operation(
        operationId = "getComponentConnectionDefinitions",
        summary = "Get all compatible connection definitions for a component",
        description = "Get all compatible connection definitions for a component.",
        tags = { "connection-definition" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Successful operation.", content = {
                @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = ConnectionDefinitionBasicModel.class)))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/component-definitions/{componentName}/versions/{componentVersion}/connection-definitions",
        produces = { "application/json" }
    )
    
    default ResponseEntity<List<ConnectionDefinitionBasicModel>> getComponentConnectionDefinitions(
        @Parameter(name = "componentName", description = "The name of a component.", required = true, in = ParameterIn.PATH) @PathVariable("componentName") String componentName,
        @Parameter(name = "componentVersion", description = "The version of a component.", required = true, in = ParameterIn.PATH) @PathVariable("componentVersion") Integer componentVersion
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "[ { \"componentTitle\" : \"componentTitle\", \"componentDescription\" : \"componentDescription\", \"componentName\" : \"componentName\", \"version\" : 0 }, { \"componentTitle\" : \"componentTitle\", \"componentDescription\" : \"componentDescription\", \"componentName\" : \"componentName\", \"version\" : 0 } ]";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
