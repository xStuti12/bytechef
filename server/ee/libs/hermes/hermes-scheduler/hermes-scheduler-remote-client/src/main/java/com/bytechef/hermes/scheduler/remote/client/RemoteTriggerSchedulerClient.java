
/*
 * Copyright 2023-present ByteChef Inc.
 *
 * Licensed under the ByteChef Enterprise license (the "Enterprise License");
 * you may not use this file except in compliance with the Enterprise License.
 */

package com.bytechef.hermes.scheduler.remote.client;

import com.bytechef.commons.webclient.LoadBalancedWebClient;
import com.bytechef.hermes.scheduler.TriggerScheduler;
import com.bytechef.hermes.execution.WorkflowExecutionId;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Map;

/**
 * @author Ivica Cardic
 */
@Component
public class RemoteTriggerSchedulerClient implements TriggerScheduler {

    private static final String SCHEDULER_APP = "scheduler-app";
    private static final String TRIGGER_SCHEDULER = "/remote/trigger-scheduler";

    private final LoadBalancedWebClient loadBalancedWebClient;

    @SuppressFBWarnings("EI")
    public RemoteTriggerSchedulerClient(LoadBalancedWebClient loadBalancedWebClient) {
        this.loadBalancedWebClient = loadBalancedWebClient;
    }

    @Override
    public void cancelDynamicWebhookTriggerRefresh(String workflowExecutionId) {
        loadBalancedWebClient.post(
            uriBuilder -> uriBuilder
                .host(SCHEDULER_APP)
                .path(TRIGGER_SCHEDULER + "/cancel-dynamic-webhook-trigger-refresh")
                .build(),
            workflowExecutionId);
    }

    @Override
    public void cancelPollingTrigger(String workflowExecutionId) {
        loadBalancedWebClient.post(
            uriBuilder -> uriBuilder
                .host(SCHEDULER_APP)
                .path(TRIGGER_SCHEDULER + "/cancel-polling-trigger")
                .build(),
            workflowExecutionId);
    }

    @Override
    public void cancelScheduleTrigger(String workflowExecutionId) {
        loadBalancedWebClient.post(
            uriBuilder -> uriBuilder
                .host(SCHEDULER_APP)
                .path(TRIGGER_SCHEDULER + "/cancel-schedule-trigger")
                .build(),
            workflowExecutionId);
    }

    @Override
    public void scheduleDynamicWebhookTriggerRefresh(
        LocalDateTime webhookExpirationDate, String componentName, int componentVersion,
        WorkflowExecutionId workflowExecutionId) {

        loadBalancedWebClient.post(
            uriBuilder -> uriBuilder
                .host(SCHEDULER_APP)
                .path(TRIGGER_SCHEDULER + "/schedule-dynamic-webhook-trigger-refresh")
                .build(),
            new DynamicWebhookRefreshTaskRequest(
                workflowExecutionId, webhookExpirationDate, componentName, componentVersion));
    }

    @Override
    public void schedulePollingTrigger(WorkflowExecutionId workflowExecutionId) {
        loadBalancedWebClient.post(
            uriBuilder -> uriBuilder
                .host(SCHEDULER_APP)
                .path(TRIGGER_SCHEDULER + "/schedule-polling-trigger")
                .build(),
            workflowExecutionId);
    }

    @Override
    public void scheduleScheduleTrigger(
        String pattern, String zoneId, Map<String, Object> output, WorkflowExecutionId workflowExecutionId) {

        loadBalancedWebClient.post(
            uriBuilder -> uriBuilder
                .host(SCHEDULER_APP)
                .path(TRIGGER_SCHEDULER + "/schedule-schedule-trigger")
                .build(),
            new TriggerWorkflowTaskRequest(workflowExecutionId, pattern, zoneId, output));
    }

    @SuppressFBWarnings("EI")
    private record DynamicWebhookRefreshTaskRequest(
        WorkflowExecutionId workflowExecutionId, LocalDateTime webhookExpirationDate, String componentName,
        int componentVersion) {
    }

    @SuppressFBWarnings("EI")
    private record TriggerWorkflowTaskRequest(
        WorkflowExecutionId workflowExecutionId, String pattern, String zoneId, Map<String, Object> output) {
    }
}
