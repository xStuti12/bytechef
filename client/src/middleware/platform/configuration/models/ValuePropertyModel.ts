/* tslint:disable */
/* eslint-disable */
/**
 * The Platform Configuration API
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
import type { ControlTypeModel } from './ControlTypeModel';
import {
    ControlTypeModelFromJSON,
    ControlTypeModelFromJSONTyped,
    ControlTypeModelToJSON,
} from './ControlTypeModel';
import type { PropertyModel } from './PropertyModel';
import {
    PropertyModelFromJSON,
    PropertyModelFromJSONTyped,
    PropertyModelToJSON,
} from './PropertyModel';
import type { PropertyTypeModel } from './PropertyTypeModel';
import {
    PropertyTypeModelFromJSON,
    PropertyTypeModelFromJSONTyped,
    PropertyTypeModelToJSON,
} from './PropertyTypeModel';

/**
 * A base property for all value based properties.
 * @export
 * @interface ValuePropertyModel
 */
export interface ValuePropertyModel extends PropertyModel {
    /**
     * 
     * @type {ControlTypeModel}
     * @memberof ValuePropertyModel
     */
    controlType: ControlTypeModel;
    /**
     * The property label.
     * @type {string}
     * @memberof ValuePropertyModel
     */
    label?: string;
    /**
     * The property placeholder.
     * @type {string}
     * @memberof ValuePropertyModel
     */
    placeholder?: string;
}

/**
 * Check if a given object implements the ValuePropertyModel interface.
 */
export function instanceOfValuePropertyModel(value: object): boolean {
    if (!('controlType' in value)) return false;
    return true;
}

export function ValuePropertyModelFromJSON(json: any): ValuePropertyModel {
    return ValuePropertyModelFromJSONTyped(json, false);
}

export function ValuePropertyModelFromJSONTyped(json: any, ignoreDiscriminator: boolean): ValuePropertyModel {
    if (json == null) {
        return json;
    }
    return {
        ...PropertyModelFromJSONTyped(json, ignoreDiscriminator),
        'controlType': ControlTypeModelFromJSON(json['controlType']),
        'label': json['label'] == null ? undefined : json['label'],
        'placeholder': json['placeholder'] == null ? undefined : json['placeholder'],
    };
}

export function ValuePropertyModelToJSON(value?: ValuePropertyModel | null): any {
    if (value == null) {
        return value;
    }
    return {
        ...PropertyModelToJSON(value),
        'controlType': ControlTypeModelToJSON(value['controlType']),
        'label': value['label'],
        'placeholder': value['placeholder'],
    };
}

