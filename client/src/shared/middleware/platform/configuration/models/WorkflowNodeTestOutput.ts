/* tslint:disable */
/* eslint-disable */
/**
 * The Platform Configuration Internal API
 * No description provided (generated by Openapi Generator https://github.com/openapitools/openapi-generator)
 *
 * The version of the OpenAPI document: 1
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

import { mapValues } from '../runtime';
/**
 * Contains test output of a workflow node.
 * @export
 * @interface WorkflowNodeTestOutput
 */
export interface WorkflowNodeTestOutput {
    /**
     * The workflow test node output id
     * @type {number}
     * @memberof WorkflowNodeTestOutput
     */
    id?: number;
    /**
     * The workflow node name.
     * @type {string}
     * @memberof WorkflowNodeTestOutput
     */
    workflowNodeName?: string;
    /**
     * The workflow id.
     * @type {string}
     * @memberof WorkflowNodeTestOutput
     */
    workflowId?: string;
}

/**
 * Check if a given object implements the WorkflowNodeTestOutput interface.
 */
export function instanceOfWorkflowNodeTestOutput(value: object): value is WorkflowNodeTestOutput {
    return true;
}

export function WorkflowNodeTestOutputFromJSON(json: any): WorkflowNodeTestOutput {
    return WorkflowNodeTestOutputFromJSONTyped(json, false);
}

export function WorkflowNodeTestOutputFromJSONTyped(json: any, ignoreDiscriminator: boolean): WorkflowNodeTestOutput {
    if (json == null) {
        return json;
    }
    return {
        
        'id': json['id'] == null ? undefined : json['id'],
        'workflowNodeName': json['workflowNodeName'] == null ? undefined : json['workflowNodeName'],
        'workflowId': json['workflowId'] == null ? undefined : json['workflowId'],
    };
}

export function WorkflowNodeTestOutputToJSON(value?: WorkflowNodeTestOutput | null): any {
    if (value == null) {
        return value;
    }
    return {
        
        'id': value['id'],
        'workflowNodeName': value['workflowNodeName'],
        'workflowId': value['workflowId'],
    };
}
