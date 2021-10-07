package org.example.project.bpmn_components.service_tasks.message_tasks;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Component
public class SendSimpleMessageTask implements JavaDelegate {
    @Override
    public void execute(DelegateExecution execution) {
        log.info("in simple message server task - start");

        Map<String, Object> variables = new HashMap<>();
        variables.put("messageId", execution.getVariable("messageId"));

        execution
                .getProcessEngineServices()
                .getRuntimeService()
                .startProcessInstanceByKey("messageEx", variables);

        log.info("in simple message server task  - end");
    }
}
