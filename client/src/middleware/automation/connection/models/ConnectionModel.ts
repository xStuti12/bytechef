/* tslint:disable */
/* eslint-disable */
/**
 * The Automation Connection API
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
import type { CredentialStatusModel } from './CredentialStatusModel';
import {
    CredentialStatusModelFromJSON,
    CredentialStatusModelFromJSONTyped,
    CredentialStatusModelToJSON,
} from './CredentialStatusModel';
import type { EnvironmentModel } from './EnvironmentModel';
import {
    EnvironmentModelFromJSON,
    EnvironmentModelFromJSONTyped,
    EnvironmentModelToJSON,
} from './EnvironmentModel';
import type { TagModel } from './TagModel';
import {
    TagModelFromJSON,
    TagModelFromJSONTyped,
    TagModelToJSON,
} from './TagModel';

/**
 * Contains all required information to open a connection to a service defined by componentName parameter.
 * @export
 * @interface ConnectionModel
 */
export interface ConnectionModel {
    /**
     * If a connection is used in any of active workflows.
     * @type {boolean}
     * @memberof ConnectionModel
     */
    readonly active?: boolean;
    /**
     * The name of an authorization used by this connection. Used for HTTP based services.
     * @type {string}
     * @memberof ConnectionModel
     */
    authorizationName?: string;
    /**
     * The name of a component that uses this connection.
     * @type {string}
     * @memberof ConnectionModel
     */
    componentName: string;
    /**
     * The version of a component that uses this connection.
     * @type {number}
     * @memberof ConnectionModel
     */
    connectionVersion?: number;
    /**
     * The created by.
     * @type {string}
     * @memberof ConnectionModel
     */
    readonly createdBy?: string;
    /**
     * The created date.
     * @type {Date}
     * @memberof ConnectionModel
     */
    readonly createdDate?: Date;
    /**
     * 
     * @type {CredentialStatusModel}
     * @memberof ConnectionModel
     */
    credentialStatus?: CredentialStatusModel;
    /**
     * 
     * @type {EnvironmentModel}
     * @memberof ConnectionModel
     */
    environment?: EnvironmentModel;
    /**
     * The name of a connection.
     * @type {string}
     * @memberof ConnectionModel
     */
    name: string;
    /**
     * The id of a connection.
     * @type {number}
     * @memberof ConnectionModel
     */
    readonly id?: number;
    /**
     * The last modified by.
     * @type {string}
     * @memberof ConnectionModel
     */
    readonly lastModifiedBy?: string;
    /**
     * The last modified date.
     * @type {Date}
     * @memberof ConnectionModel
     */
    readonly lastModifiedDate?: Date;
    /**
     * The parameters of a connection.
     * @type {{ [key: string]: object; }}
     * @memberof ConnectionModel
     */
    parameters: { [key: string]: object; };
    /**
     * 
     * @type {Array<TagModel>}
     * @memberof ConnectionModel
     */
    tags?: Array<TagModel>;
    /**
     * 
     * @type {number}
     * @memberof ConnectionModel
     */
    version?: number;
}

/**
 * Check if a given object implements the ConnectionModel interface.
 */
export function instanceOfConnectionModel(value: object): boolean {
    if (!('componentName' in value)) return false;
    if (!('name' in value)) return false;
    if (!('parameters' in value)) return false;
    return true;
}

export function ConnectionModelFromJSON(json: any): ConnectionModel {
    return ConnectionModelFromJSONTyped(json, false);
}

export function ConnectionModelFromJSONTyped(json: any, ignoreDiscriminator: boolean): ConnectionModel {
    if (json == null) {
        return json;
    }
    return {
        
        'active': json['active'] == null ? undefined : json['active'],
        'authorizationName': json['authorizationName'] == null ? undefined : json['authorizationName'],
        'componentName': json['componentName'],
        'connectionVersion': json['connectionVersion'] == null ? undefined : json['connectionVersion'],
        'createdBy': json['createdBy'] == null ? undefined : json['createdBy'],
        'createdDate': json['createdDate'] == null ? undefined : (new Date(json['createdDate'])),
        'credentialStatus': json['credentialStatus'] == null ? undefined : CredentialStatusModelFromJSON(json['credentialStatus']),
        'environment': json['environment'] == null ? undefined : EnvironmentModelFromJSON(json['environment']),
        'name': json['name'],
        'id': json['id'] == null ? undefined : json['id'],
        'lastModifiedBy': json['lastModifiedBy'] == null ? undefined : json['lastModifiedBy'],
        'lastModifiedDate': json['lastModifiedDate'] == null ? undefined : (new Date(json['lastModifiedDate'])),
        'parameters': json['parameters'],
        'tags': json['tags'] == null ? undefined : ((json['tags'] as Array<any>).map(TagModelFromJSON)),
        'version': json['__version'] == null ? undefined : json['__version'],
    };
}

export function ConnectionModelToJSON(value?: ConnectionModel | null): any {
    if (value == null) {
        return value;
    }
    return {
        
        'authorizationName': value['authorizationName'],
        'componentName': value['componentName'],
        'connectionVersion': value['connectionVersion'],
        'credentialStatus': CredentialStatusModelToJSON(value['credentialStatus']),
        'environment': EnvironmentModelToJSON(value['environment']),
        'name': value['name'],
        'parameters': value['parameters'],
        'tags': value['tags'] == null ? undefined : ((value['tags'] as Array<any>).map(TagModelToJSON)),
        '__version': value['version'],
    };
}

