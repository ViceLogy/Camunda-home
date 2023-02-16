package com.example.workflow.listeners;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.TaskService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.DelegateTask;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.bpm.engine.delegate.TaskListener;
import org.camunda.bpm.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class TestSup implements TaskListener {
    @Autowired
    private TaskService taskService;
    //@Override
    //public void execute(DelegateExecution delegateExecution) throws Exception {
    //    log.info("Value {}", delegateExecution.getVariables());
    //    Task task = taskService.createTaskQuery().processInstanceId(delegateExecution.getProcessInstanceId()).singleResult();
    //    log.info("task {}", task);
    //}

    @Override
    public void notify(DelegateTask delegateTask) {
        String taskDefinitionKey = delegateTask.getTaskDefinitionKey();
        String assignee = delegateTask.getAssignee();
        log.info("task {}, assignee {}", taskDefinitionKey, assignee);
    }
}
