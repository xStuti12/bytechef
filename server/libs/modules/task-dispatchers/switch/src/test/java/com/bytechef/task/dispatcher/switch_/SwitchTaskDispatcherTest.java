
/*
 * Copyright 2016-2018 the original author or authors.
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
 *
 * Modifications copyright (C) 2021 <your company/name>
 */

package com.bytechef.task.dispatcher.switch_;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.bytechef.atlas.domain.Context;
import com.bytechef.atlas.domain.TaskExecution;
import com.bytechef.atlas.message.broker.MessageBroker;
import com.bytechef.atlas.service.ContextService;
import com.bytechef.atlas.service.TaskExecutionService;
import com.bytechef.atlas.task.WorkflowTask;
import com.bytechef.atlas.task.dispatcher.TaskDispatcher;
import com.bytechef.atlas.task.evaluator.TaskEvaluator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

/**
 * @author Arik Cohen
 * @author Ivica Cardic
 */
public class SwitchTaskDispatcherTest {

    private final ContextService contextService = mock(ContextService.class);
    private final MessageBroker messageBroker = mock(MessageBroker.class);
    private final TaskExecutionService taskExecutionService = mock(TaskExecutionService.class);
    private final TaskDispatcher taskDispatcher = mock(TaskDispatcher.class);

    @Test
    public void test1() {
        when(contextService.peek(any())).thenReturn(new Context());

        SwitchTaskDispatcher switchTaskDispatcher = new SwitchTaskDispatcher(
            contextService, messageBroker, taskDispatcher, taskExecutionService, TaskEvaluator.create());
        TaskExecution taskExecution = new TaskExecution(new WorkflowTask(Map.of(
            "cases", List.of(Map.of("key", "k1", "tasks", List.of(Map.of("type", "print")))), "expression", "k1")));

        taskExecution.setId("id");
        taskExecution.setJobId("jobId");

        when(taskExecutionService.create(any()))
            .thenReturn(new TaskExecution(new WorkflowTask(Map.of("type", "print"))));

        switchTaskDispatcher.dispatch(taskExecution);

        ArgumentCaptor<TaskExecution> argument = ArgumentCaptor.forClass(TaskExecution.class);

        verify(taskDispatcher, times(1)).dispatch(argument.capture());
        Assertions.assertEquals("print", argument.getValue()
            .getType());
    }

    @Test
    public void test2() {
        when(contextService.peek(any())).thenReturn(new Context());

        SwitchTaskDispatcher switchTaskDispatcher = new SwitchTaskDispatcher(
            contextService, messageBroker, taskDispatcher, taskExecutionService, TaskEvaluator.create());
        TaskExecution taskExecution = new TaskExecution(new WorkflowTask(Map.of(
            "cases", List.of(Map.of("key", "k1", "tasks", List.of(Map.of("type", "print")))), "expression", "k2")));

        switchTaskDispatcher.dispatch(taskExecution);

        verify(taskDispatcher, times(0)).dispatch(any());
    }

    @Test
    public void test3() {
        when(contextService.peek(any())).thenReturn(new Context());

        SwitchTaskDispatcher switchTaskDispatcher = new SwitchTaskDispatcher(
            contextService, messageBroker, taskDispatcher, taskExecutionService, TaskEvaluator.create());
        TaskExecution taskExecution = new TaskExecution(new WorkflowTask(Map.of(
            "cases",
            Arrays.asList(
                Map.of("key", "k1", "tasks", List.of(Map.of("type", "print"))),
                Map.of("key", "k2", "tasks", List.of(Map.of("type", "sleep")))),
            "expression",
            "k2")));

        taskExecution.setId("id");
        taskExecution.setJobId("jobId");

        when(taskExecutionService.create(any()))
            .thenReturn(new TaskExecution(new WorkflowTask(Map.of("type", "sleep"))));

        switchTaskDispatcher.dispatch(taskExecution);

        ArgumentCaptor<TaskExecution> argument = ArgumentCaptor.forClass(TaskExecution.class);

        verify(taskDispatcher, times(1)).dispatch(argument.capture());
        Assertions.assertEquals("sleep", argument.getValue()
            .getType());
    }

    @Test
    public void test4() {
        when(contextService.peek(any())).thenReturn(new Context());

        SwitchTaskDispatcher switchTaskDispatcher = new SwitchTaskDispatcher(
            contextService, messageBroker, taskDispatcher, taskExecutionService, TaskEvaluator.create());
        TaskExecution taskExecution = new TaskExecution(new WorkflowTask(Map.of(
            "cases",
            Arrays.asList(
                Map.of("key", "k1", "tasks", List.of(Map.of("type", "print"))),
                Map.of("key", "k2", "tasks", List.of(Map.of("type", "sleep")))),
            "default",
            Collections.singletonMap("value", "1234"),
            "expression",
            "k99")));

        switchTaskDispatcher.dispatch(taskExecution);

        ArgumentCaptor<String> arg1 = ArgumentCaptor.forClass(String.class);
        ArgumentCaptor<TaskExecution> arg2 = ArgumentCaptor.forClass(TaskExecution.class);

        verify(messageBroker, times(1)).send(arg1.capture(), arg2.capture());
        Assertions.assertEquals("1234", arg2.getValue()
            .getOutput());
    }
}
