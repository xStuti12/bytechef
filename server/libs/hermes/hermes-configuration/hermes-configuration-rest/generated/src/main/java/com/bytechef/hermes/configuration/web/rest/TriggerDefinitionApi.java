/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (7.1.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package com.bytechef.hermes.configuration.web.rest;

import com.bytechef.hermes.configuration.web.rest.model.ComponentOperationRequestModel;
import com.bytechef.hermes.configuration.web.rest.model.OptionModel;
import com.bytechef.hermes.configuration.web.rest.model.PropertyModel;
import com.bytechef.hermes.configuration.web.rest.model.TriggerDefinitionBasicModel;
import com.bytechef.hermes.configuration.web.rest.model.TriggerDefinitionModel;
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

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-11-21T21:27:09.819358+01:00[Europe/Zagreb]")
@Validated
@Tag(name = "trigger-definition", description = "The Core Trigger Definition API")
public interface TriggerDefinitionApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * GET /component-definitions/{componentName}/{componentVersion}/trigger-definitions/{triggerName} : Get a trigger definition of a component
     * Get a trigger definition of a component.
     *
     * @param componentName The name of the component. (required)
     * @param componentVersion The version of a component. (required)
     * @param triggerName The name of a trigger to get. (required)
     * @return Successful operation. (status code 200)
     */
    @Operation(
        operationId = "getComponentTriggerDefinition",
        summary = "Get a trigger definition of a component",
        description = "Get a trigger definition of a component.",
        tags = { "trigger-definition" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Successful operation.", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = TriggerDefinitionModel.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/component-definitions/{componentName}/{componentVersion}/trigger-definitions/{triggerName}",
        produces = { "application/json" }
    )
    
    default ResponseEntity<TriggerDefinitionModel> getComponentTriggerDefinition(
        @Parameter(name = "componentName", description = "The name of the component.", required = true, in = ParameterIn.PATH) @PathVariable("componentName") String componentName,
        @Parameter(name = "componentVersion", description = "The version of a component.", required = true, in = ParameterIn.PATH) @PathVariable("componentVersion") Integer componentVersion,
        @Parameter(name = "triggerName", description = "The name of a trigger to get.", required = true, in = ParameterIn.PATH) @PathVariable("triggerName") String triggerName
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"help\" : { \"body\" : \"body\", \"learnMoreUrl\" : \"learnMoreUrl\" }, \"outputSchema\" : { \"displayCondition\" : \"displayCondition\", \"hidden\" : true, \"name\" : \"name\", \"description\" : \"description\", \"advancedOption\" : true, \"label\" : \"label\", \"placeholder\" : \"placeholder\", \"required\" : true, \"expressionEnabled\" : true }, \"name\" : \"name\", \"description\" : \"description\", \"componentName\" : \"componentName\", \"componentVersion\" : 0, \"title\" : \"title\", \"sampleOutput\" : \"{}\", \"properties\" : [ { \"displayCondition\" : \"displayCondition\", \"hidden\" : true, \"name\" : \"name\", \"description\" : \"description\", \"advancedOption\" : true, \"label\" : \"label\", \"placeholder\" : \"placeholder\", \"required\" : true, \"expressionEnabled\" : true }, { \"displayCondition\" : \"displayCondition\", \"hidden\" : true, \"name\" : \"name\", \"description\" : \"description\", \"advancedOption\" : true, \"label\" : \"label\", \"placeholder\" : \"placeholder\", \"required\" : true, \"expressionEnabled\" : true } ] }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * GET /component-definitions/{componentName}/{componentVersion}/trigger-definitions : Get a list of trigger definitionss for a component
     * Get a list of trigger definitionss for a component.
     *
     * @param componentName The name of a component. (required)
     * @param componentVersion The version of a component. (required)
     * @return Successful operation. (status code 200)
     */
    @Operation(
        operationId = "getComponentTriggerDefinitions",
        summary = "Get a list of trigger definitionss for a component",
        description = "Get a list of trigger definitionss for a component.",
        tags = { "trigger-definition" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Successful operation.", content = {
                @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = TriggerDefinitionBasicModel.class)))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/component-definitions/{componentName}/{componentVersion}/trigger-definitions",
        produces = { "application/json" }
    )
    
    default ResponseEntity<List<TriggerDefinitionBasicModel>> getComponentTriggerDefinitions(
        @Parameter(name = "componentName", description = "The name of a component.", required = true, in = ParameterIn.PATH) @PathVariable("componentName") String componentName,
        @Parameter(name = "componentVersion", description = "The version of a component.", required = true, in = ParameterIn.PATH) @PathVariable("componentVersion") Integer componentVersion
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "[ { \"help\" : { \"body\" : \"body\", \"learnMoreUrl\" : \"learnMoreUrl\" }, \"name\" : \"name\", \"description\" : \"description\", \"title\" : \"title\" }, { \"help\" : { \"body\" : \"body\", \"learnMoreUrl\" : \"learnMoreUrl\" }, \"name\" : \"name\", \"description\" : \"description\", \"title\" : \"title\" } ]";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * POST /component-definitions/{componentName}/{componentVersion}/trigger-definitions/{triggerName}/editor-description : Get an trigger description shown in the editor
     * Get an trigger description shown in the editor.
     *
     * @param componentName The name of the component. (required)
     * @param componentVersion The version of a component. (required)
     * @param triggerName The name of a trigger. (required)
     * @param componentOperationRequestModel  (optional)
     * @return The editor description. (status code 200)
     */
    @Operation(
        operationId = "getComponentTriggerEditorDescription",
        summary = "Get an trigger description shown in the editor",
        description = "Get an trigger description shown in the editor.",
        tags = { "trigger-definition" },
        responses = {
            @ApiResponse(responseCode = "200", description = "The editor description.", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = String.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/component-definitions/{componentName}/{componentVersion}/trigger-definitions/{triggerName}/editor-description",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    
    default ResponseEntity<String> getComponentTriggerEditorDescription(
        @Parameter(name = "componentName", description = "The name of the component.", required = true, in = ParameterIn.PATH) @PathVariable("componentName") String componentName,
        @Parameter(name = "componentVersion", description = "The version of a component.", required = true, in = ParameterIn.PATH) @PathVariable("componentVersion") Integer componentVersion,
        @Parameter(name = "triggerName", description = "The name of a trigger.", required = true, in = ParameterIn.PATH) @PathVariable("triggerName") String triggerName,
        @Parameter(name = "ComponentOperationRequestModel", description = "") @Valid @RequestBody(required = false) ComponentOperationRequestModel componentOperationRequestModel
    ) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * POST /component-definitions/{componentName}/{componentVersion}/trigger-definitions/{triggerName}/output-schema : Get a trigger output schema shown in the editor
     * Get a trigger output schema shown in the editor.
     *
     * @param componentName The name of the component. (required)
     * @param componentVersion The version of a component. (required)
     * @param triggerName The name of a trigger. (required)
     * @param componentOperationRequestModel  (optional)
     * @return The output schema. (status code 200)
     */
    @Operation(
        operationId = "getComponentTriggerOutputSchema",
        summary = "Get a trigger output schema shown in the editor",
        description = "Get a trigger output schema shown in the editor.",
        tags = { "trigger-definition" },
        responses = {
            @ApiResponse(responseCode = "200", description = "The output schema.", content = {
                @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = PropertyModel.class)))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/component-definitions/{componentName}/{componentVersion}/trigger-definitions/{triggerName}/output-schema",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    
    default ResponseEntity<List<PropertyModel>> getComponentTriggerOutputSchema(
        @Parameter(name = "componentName", description = "The name of the component.", required = true, in = ParameterIn.PATH) @PathVariable("componentName") String componentName,
        @Parameter(name = "componentVersion", description = "The version of a component.", required = true, in = ParameterIn.PATH) @PathVariable("componentVersion") Integer componentVersion,
        @Parameter(name = "triggerName", description = "The name of a trigger.", required = true, in = ParameterIn.PATH) @PathVariable("triggerName") String triggerName,
        @Parameter(name = "ComponentOperationRequestModel", description = "") @Valid @RequestBody(required = false) ComponentOperationRequestModel componentOperationRequestModel
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "[ { \"displayCondition\" : \"displayCondition\", \"hidden\" : true, \"name\" : \"name\", \"description\" : \"description\", \"advancedOption\" : true, \"label\" : \"label\", \"placeholder\" : \"placeholder\", \"required\" : true, \"expressionEnabled\" : true }, { \"displayCondition\" : \"displayCondition\", \"hidden\" : true, \"name\" : \"name\", \"description\" : \"description\", \"advancedOption\" : true, \"label\" : \"label\", \"placeholder\" : \"placeholder\", \"required\" : true, \"expressionEnabled\" : true } ]";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * POST /component-definitions/{componentName}/{componentVersion}/trigger-definitions/{triggerName}/properties/{propertyName}/dynamic-properties : Get dynamic properties for a trigger property shown in the editor
     * Get dynamic properties for a trigger property shown in the editor.
     *
     * @param componentName The name of a component. (required)
     * @param componentVersion The version of a component. (required)
     * @param triggerName The name of a trigger. (required)
     * @param propertyName The name of a property. (required)
     * @param componentOperationRequestModel  (optional)
     * @return The list of options. (status code 200)
     */
    @Operation(
        operationId = "getComponentTriggerPropertyDynamicProperties",
        summary = "Get dynamic properties for a trigger property shown in the editor",
        description = "Get dynamic properties for a trigger property shown in the editor.",
        tags = { "trigger-definition" },
        responses = {
            @ApiResponse(responseCode = "200", description = "The list of options.", content = {
                @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = PropertyModel.class)))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/component-definitions/{componentName}/{componentVersion}/trigger-definitions/{triggerName}/properties/{propertyName}/dynamic-properties",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    
    default ResponseEntity<List<PropertyModel>> getComponentTriggerPropertyDynamicProperties(
        @Parameter(name = "componentName", description = "The name of a component.", required = true, in = ParameterIn.PATH) @PathVariable("componentName") String componentName,
        @Parameter(name = "componentVersion", description = "The version of a component.", required = true, in = ParameterIn.PATH) @PathVariable("componentVersion") Integer componentVersion,
        @Parameter(name = "triggerName", description = "The name of a trigger.", required = true, in = ParameterIn.PATH) @PathVariable("triggerName") String triggerName,
        @Parameter(name = "propertyName", description = "The name of a property.", required = true, in = ParameterIn.PATH) @PathVariable("propertyName") String propertyName,
        @Parameter(name = "ComponentOperationRequestModel", description = "") @Valid @RequestBody(required = false) ComponentOperationRequestModel componentOperationRequestModel
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "[ { \"displayCondition\" : \"displayCondition\", \"hidden\" : true, \"name\" : \"name\", \"description\" : \"description\", \"advancedOption\" : true, \"label\" : \"label\", \"placeholder\" : \"placeholder\", \"required\" : true, \"expressionEnabled\" : true }, { \"displayCondition\" : \"displayCondition\", \"hidden\" : true, \"name\" : \"name\", \"description\" : \"description\", \"advancedOption\" : true, \"label\" : \"label\", \"placeholder\" : \"placeholder\", \"required\" : true, \"expressionEnabled\" : true } ]";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * POST /component-definitions/{componentName}/{componentVersion}/trigger-definitions/{triggerName}/properties/{propertyName}/options : Get a trigger property options shown in the editor
     * Get a trigger property options shown in the editor.
     *
     * @param componentName The name of the component. (required)
     * @param componentVersion The version of a component. (required)
     * @param triggerName The name of a trigger. (required)
     * @param propertyName The name of a property. (required)
     * @param searchText Optional search text used to filter option items (optional)
     * @param componentOperationRequestModel  (optional)
     * @return The list of options. (status code 200)
     */
    @Operation(
        operationId = "getComponentTriggerPropertyOptions",
        summary = "Get a trigger property options shown in the editor",
        description = "Get a trigger property options shown in the editor.",
        tags = { "trigger-definition" },
        responses = {
            @ApiResponse(responseCode = "200", description = "The list of options.", content = {
                @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = OptionModel.class)))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/component-definitions/{componentName}/{componentVersion}/trigger-definitions/{triggerName}/properties/{propertyName}/options",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    
    default ResponseEntity<List<OptionModel>> getComponentTriggerPropertyOptions(
        @Parameter(name = "componentName", description = "The name of the component.", required = true, in = ParameterIn.PATH) @PathVariable("componentName") String componentName,
        @Parameter(name = "componentVersion", description = "The version of a component.", required = true, in = ParameterIn.PATH) @PathVariable("componentVersion") Integer componentVersion,
        @Parameter(name = "triggerName", description = "The name of a trigger.", required = true, in = ParameterIn.PATH) @PathVariable("triggerName") String triggerName,
        @Parameter(name = "propertyName", description = "The name of a property.", required = true, in = ParameterIn.PATH) @PathVariable("propertyName") String propertyName,
        @Parameter(name = "searchText", description = "Optional search text used to filter option items", in = ParameterIn.QUERY) @Valid @RequestParam(value = "searchText", required = false) String searchText,
        @Parameter(name = "ComponentOperationRequestModel", description = "") @Valid @RequestBody(required = false) ComponentOperationRequestModel componentOperationRequestModel
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "[ { \"displayCondition\" : \"displayCondition\", \"name\" : \"name\", \"description\" : \"description\", \"value\" : \"\" }, { \"displayCondition\" : \"displayCondition\", \"name\" : \"name\", \"description\" : \"description\", \"value\" : \"\" } ]";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * POST /component-definitions/{componentName}/{componentVersion}/trigger-definitions/{triggerName}/sample-output : Get a trigger sample output shown in the editor
     * Get a trigger sample output shown in the editor.
     *
     * @param componentName The name of the component. (required)
     * @param componentVersion The version of a component. (required)
     * @param triggerName The name of a trigger. (required)
     * @param componentOperationRequestModel  (optional)
     * @return The output schema. (status code 200)
     */
    @Operation(
        operationId = "getComponentTriggerSampleOutput",
        summary = "Get a trigger sample output shown in the editor",
        description = "Get a trigger sample output shown in the editor.",
        tags = { "trigger-definition" },
        responses = {
            @ApiResponse(responseCode = "200", description = "The output schema.", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Object.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/component-definitions/{componentName}/{componentVersion}/trigger-definitions/{triggerName}/sample-output",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    
    default ResponseEntity<Object> getComponentTriggerSampleOutput(
        @Parameter(name = "componentName", description = "The name of the component.", required = true, in = ParameterIn.PATH) @PathVariable("componentName") String componentName,
        @Parameter(name = "componentVersion", description = "The version of a component.", required = true, in = ParameterIn.PATH) @PathVariable("componentVersion") Integer componentVersion,
        @Parameter(name = "triggerName", description = "The name of a trigger.", required = true, in = ParameterIn.PATH) @PathVariable("triggerName") String triggerName,
        @Parameter(name = "ComponentOperationRequestModel", description = "") @Valid @RequestBody(required = false) ComponentOperationRequestModel componentOperationRequestModel
    ) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * GET /trigger-definitions : Get all trigger definitions
     * Get all trigger definitions.
     *
     * @param triggerTypes The list of trigger types defined in workflows.(E.g. mailchimp/v1/subscribe) (optional)
     * @return Successful operation. (status code 200)
     */
    @Operation(
        operationId = "getTriggerDefinitions",
        summary = "Get all trigger definitions",
        description = "Get all trigger definitions.",
        tags = { "trigger-definition" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Successful operation.", content = {
                @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = TriggerDefinitionModel.class)))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/trigger-definitions",
        produces = { "application/json" }
    )
    
    default ResponseEntity<List<TriggerDefinitionModel>> getTriggerDefinitions(
        @Parameter(name = "triggerTypes", description = "The list of trigger types defined in workflows.(E.g. mailchimp/v1/subscribe)", in = ParameterIn.QUERY) @Valid @RequestParam(value = "triggerTypes", required = false) List<String> triggerTypes
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "[ { \"help\" : { \"body\" : \"body\", \"learnMoreUrl\" : \"learnMoreUrl\" }, \"outputSchema\" : { \"displayCondition\" : \"displayCondition\", \"hidden\" : true, \"name\" : \"name\", \"description\" : \"description\", \"advancedOption\" : true, \"label\" : \"label\", \"placeholder\" : \"placeholder\", \"required\" : true, \"expressionEnabled\" : true }, \"name\" : \"name\", \"description\" : \"description\", \"componentName\" : \"componentName\", \"componentVersion\" : 0, \"title\" : \"title\", \"sampleOutput\" : \"{}\", \"properties\" : [ { \"displayCondition\" : \"displayCondition\", \"hidden\" : true, \"name\" : \"name\", \"description\" : \"description\", \"advancedOption\" : true, \"label\" : \"label\", \"placeholder\" : \"placeholder\", \"required\" : true, \"expressionEnabled\" : true }, { \"displayCondition\" : \"displayCondition\", \"hidden\" : true, \"name\" : \"name\", \"description\" : \"description\", \"advancedOption\" : true, \"label\" : \"label\", \"placeholder\" : \"placeholder\", \"required\" : true, \"expressionEnabled\" : true } ] }, { \"help\" : { \"body\" : \"body\", \"learnMoreUrl\" : \"learnMoreUrl\" }, \"outputSchema\" : { \"displayCondition\" : \"displayCondition\", \"hidden\" : true, \"name\" : \"name\", \"description\" : \"description\", \"advancedOption\" : true, \"label\" : \"label\", \"placeholder\" : \"placeholder\", \"required\" : true, \"expressionEnabled\" : true }, \"name\" : \"name\", \"description\" : \"description\", \"componentName\" : \"componentName\", \"componentVersion\" : 0, \"title\" : \"title\", \"sampleOutput\" : \"{}\", \"properties\" : [ { \"displayCondition\" : \"displayCondition\", \"hidden\" : true, \"name\" : \"name\", \"description\" : \"description\", \"advancedOption\" : true, \"label\" : \"label\", \"placeholder\" : \"placeholder\", \"required\" : true, \"expressionEnabled\" : true }, { \"displayCondition\" : \"displayCondition\", \"hidden\" : true, \"name\" : \"name\", \"description\" : \"description\", \"advancedOption\" : true, \"label\" : \"label\", \"placeholder\" : \"placeholder\", \"required\" : true, \"expressionEnabled\" : true } ] } ]";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
