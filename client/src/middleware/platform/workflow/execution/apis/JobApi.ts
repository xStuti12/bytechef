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


import * as runtime from '../runtime';
import type {
  CreateJob200ResponseModel,
  JobModel,
  JobParametersModel,
  PageModel,
  TriggerExecutionModel,
} from '../models/index';
import {
    CreateJob200ResponseModelFromJSON,
    CreateJob200ResponseModelToJSON,
    JobModelFromJSON,
    JobModelToJSON,
    JobParametersModelFromJSON,
    JobParametersModelToJSON,
    PageModelFromJSON,
    PageModelToJSON,
    TriggerExecutionModelFromJSON,
    TriggerExecutionModelToJSON,
} from '../models/index';

export interface CreateJobRequest {
    jobParametersModel: JobParametersModel;
}

export interface GetJobRequest {
    id: number;
}

export interface GetJobsPageRequest {
    pageNumber?: number;
}

export interface RestartJobRequest {
    id: number;
}

export interface StopJobRequest {
    id: number;
}

/**
 * 
 */
export class JobApi extends runtime.BaseAPI {

    /**
     * Create a request for running a new job.
     * Create a request for running a new job
     */
    async createJobRaw(requestParameters: CreateJobRequest, initOverrides?: RequestInit | runtime.InitOverrideFunction): Promise<runtime.ApiResponse<CreateJob200ResponseModel>> {
        if (requestParameters['jobParametersModel'] == null) {
            throw new runtime.RequiredError(
                'jobParametersModel',
                'Required parameter "jobParametersModel" was null or undefined when calling createJob().'
            );
        }

        const queryParameters: any = {};

        const headerParameters: runtime.HTTPHeaders = {};

        headerParameters['Content-Type'] = 'application/json';

        const response = await this.request({
            path: `/jobs`,
            method: 'POST',
            headers: headerParameters,
            query: queryParameters,
            body: JobParametersModelToJSON(requestParameters['jobParametersModel']),
        }, initOverrides);

        return new runtime.JSONApiResponse(response, (jsonValue) => CreateJob200ResponseModelFromJSON(jsonValue));
    }

    /**
     * Create a request for running a new job.
     * Create a request for running a new job
     */
    async createJob(requestParameters: CreateJobRequest, initOverrides?: RequestInit | runtime.InitOverrideFunction): Promise<CreateJob200ResponseModel> {
        const response = await this.createJobRaw(requestParameters, initOverrides);
        return await response.value();
    }

    /**
     * Get a job by id.
     * Get a job by id
     */
    async getJobRaw(requestParameters: GetJobRequest, initOverrides?: RequestInit | runtime.InitOverrideFunction): Promise<runtime.ApiResponse<JobModel>> {
        if (requestParameters['id'] == null) {
            throw new runtime.RequiredError(
                'id',
                'Required parameter "id" was null or undefined when calling getJob().'
            );
        }

        const queryParameters: any = {};

        const headerParameters: runtime.HTTPHeaders = {};

        const response = await this.request({
            path: `/jobs/{id}`.replace(`{${"id"}}`, encodeURIComponent(String(requestParameters['id']))),
            method: 'GET',
            headers: headerParameters,
            query: queryParameters,
        }, initOverrides);

        return new runtime.JSONApiResponse(response, (jsonValue) => JobModelFromJSON(jsonValue));
    }

    /**
     * Get a job by id.
     * Get a job by id
     */
    async getJob(requestParameters: GetJobRequest, initOverrides?: RequestInit | runtime.InitOverrideFunction): Promise<JobModel> {
        const response = await this.getJobRaw(requestParameters, initOverrides);
        return await response.value();
    }

    /**
     * Get a page of jobs.
     * Get a page of jobs
     */
    async getJobsPageRaw(requestParameters: GetJobsPageRequest, initOverrides?: RequestInit | runtime.InitOverrideFunction): Promise<runtime.ApiResponse<PageModel>> {
        const queryParameters: any = {};

        if (requestParameters['pageNumber'] != null) {
            queryParameters['pageNumber'] = requestParameters['pageNumber'];
        }

        const headerParameters: runtime.HTTPHeaders = {};

        const response = await this.request({
            path: `/jobs`,
            method: 'GET',
            headers: headerParameters,
            query: queryParameters,
        }, initOverrides);

        return new runtime.JSONApiResponse(response, (jsonValue) => PageModelFromJSON(jsonValue));
    }

    /**
     * Get a page of jobs.
     * Get a page of jobs
     */
    async getJobsPage(requestParameters: GetJobsPageRequest = {}, initOverrides?: RequestInit | runtime.InitOverrideFunction): Promise<PageModel> {
        const response = await this.getJobsPageRaw(requestParameters, initOverrides);
        return await response.value();
    }

    /**
     * Get the latest job.
     * Get the latest job
     */
    async getLatestJobRaw(initOverrides?: RequestInit | runtime.InitOverrideFunction): Promise<runtime.ApiResponse<JobModel>> {
        const queryParameters: any = {};

        const headerParameters: runtime.HTTPHeaders = {};

        const response = await this.request({
            path: `/jobs/latest`,
            method: 'GET',
            headers: headerParameters,
            query: queryParameters,
        }, initOverrides);

        return new runtime.JSONApiResponse(response, (jsonValue) => JobModelFromJSON(jsonValue));
    }

    /**
     * Get the latest job.
     * Get the latest job
     */
    async getLatestJob(initOverrides?: RequestInit | runtime.InitOverrideFunction): Promise<JobModel> {
        const response = await this.getLatestJobRaw(initOverrides);
        return await response.value();
    }

    /**
     * Get the latest trigger execution.
     * Get the latest trigger execution
     */
    async getLatestTriggerExecutionRaw(initOverrides?: RequestInit | runtime.InitOverrideFunction): Promise<runtime.ApiResponse<TriggerExecutionModel>> {
        const queryParameters: any = {};

        const headerParameters: runtime.HTTPHeaders = {};

        const response = await this.request({
            path: `/trigger-executions/latest`,
            method: 'GET',
            headers: headerParameters,
            query: queryParameters,
        }, initOverrides);

        return new runtime.JSONApiResponse(response, (jsonValue) => TriggerExecutionModelFromJSON(jsonValue));
    }

    /**
     * Get the latest trigger execution.
     * Get the latest trigger execution
     */
    async getLatestTriggerExecution(initOverrides?: RequestInit | runtime.InitOverrideFunction): Promise<TriggerExecutionModel> {
        const response = await this.getLatestTriggerExecutionRaw(initOverrides);
        return await response.value();
    }

    /**
     * Restart a job.
     * Restart a job
     */
    async restartJobRaw(requestParameters: RestartJobRequest, initOverrides?: RequestInit | runtime.InitOverrideFunction): Promise<runtime.ApiResponse<void>> {
        if (requestParameters['id'] == null) {
            throw new runtime.RequiredError(
                'id',
                'Required parameter "id" was null or undefined when calling restartJob().'
            );
        }

        const queryParameters: any = {};

        const headerParameters: runtime.HTTPHeaders = {};

        const response = await this.request({
            path: `/jobs/{id}/restart`.replace(`{${"id"}}`, encodeURIComponent(String(requestParameters['id']))),
            method: 'PUT',
            headers: headerParameters,
            query: queryParameters,
        }, initOverrides);

        return new runtime.VoidApiResponse(response);
    }

    /**
     * Restart a job.
     * Restart a job
     */
    async restartJob(requestParameters: RestartJobRequest, initOverrides?: RequestInit | runtime.InitOverrideFunction): Promise<void> {
        await this.restartJobRaw(requestParameters, initOverrides);
    }

    /**
     * Stop a job.
     * Stop a job
     */
    async stopJobRaw(requestParameters: StopJobRequest, initOverrides?: RequestInit | runtime.InitOverrideFunction): Promise<runtime.ApiResponse<void>> {
        if (requestParameters['id'] == null) {
            throw new runtime.RequiredError(
                'id',
                'Required parameter "id" was null or undefined when calling stopJob().'
            );
        }

        const queryParameters: any = {};

        const headerParameters: runtime.HTTPHeaders = {};

        const response = await this.request({
            path: `/jobs/{id}/stop`.replace(`{${"id"}}`, encodeURIComponent(String(requestParameters['id']))),
            method: 'PUT',
            headers: headerParameters,
            query: queryParameters,
        }, initOverrides);

        return new runtime.VoidApiResponse(response);
    }

    /**
     * Stop a job.
     * Stop a job
     */
    async stopJob(requestParameters: StopJobRequest, initOverrides?: RequestInit | runtime.InitOverrideFunction): Promise<void> {
        await this.stopJobRaw(requestParameters, initOverrides);
    }

}
