/* tslint:disable */
/* eslint-disable */
/**
 * The Platform Workflow Execution API
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
 * A component contains a set of reusable code(actions) that accomplish specific tasks, triggers and connections if there is a need for a connection to an outside service.
 * @export
 * @interface ComponentDefinitionBasicModel
 */
export interface ComponentDefinitionBasicModel {
    /**
     * 
     * @type {number}
     * @memberof ComponentDefinitionBasicModel
     */
    actionsCount?: number;
    /**
     * The description.
     * @type {string}
     * @memberof ComponentDefinitionBasicModel
     */
    description?: string;
    /**
     * The icon.
     * @type {string}
     * @memberof ComponentDefinitionBasicModel
     */
    icon?: string;
    /**
     * The name of a component.
     * @type {string}
     * @memberof ComponentDefinitionBasicModel
     */
    name: string;
    /**
     * The title
     * @type {string}
     * @memberof ComponentDefinitionBasicModel
     */
    title?: string;
    /**
     * 
     * @type {number}
     * @memberof ComponentDefinitionBasicModel
     */
    triggersCount?: number;
    /**
     * The version of a component.
     * @type {number}
     * @memberof ComponentDefinitionBasicModel
     */
    version: number;
}

/**
 * Check if a given object implements the ComponentDefinitionBasicModel interface.
 */
export function instanceOfComponentDefinitionBasicModel(value: object): boolean {
    if (!('name' in value)) return false;
    if (!('version' in value)) return false;
    return true;
}

export function ComponentDefinitionBasicModelFromJSON(json: any): ComponentDefinitionBasicModel {
    return ComponentDefinitionBasicModelFromJSONTyped(json, false);
}

export function ComponentDefinitionBasicModelFromJSONTyped(json: any, ignoreDiscriminator: boolean): ComponentDefinitionBasicModel {
    if (json == null) {
        return json;
    }
    return {
        
        'actionsCount': json['actionsCount'] == null ? undefined : json['actionsCount'],
        'description': json['description'] == null ? undefined : json['description'],
        'icon': json['icon'] == null ? undefined : json['icon'],
        'name': json['name'],
        'title': json['title'] == null ? undefined : json['title'],
        'triggersCount': json['triggersCount'] == null ? undefined : json['triggersCount'],
        'version': json['version'],
    };
}

export function ComponentDefinitionBasicModelToJSON(value?: ComponentDefinitionBasicModel | null): any {
    if (value == null) {
        return value;
    }
    return {
        
        'actionsCount': value['actionsCount'],
        'description': value['description'],
        'icon': value['icon'],
        'name': value['name'],
        'title': value['title'],
        'triggersCount': value['triggersCount'],
        'version': value['version'],
    };
}

