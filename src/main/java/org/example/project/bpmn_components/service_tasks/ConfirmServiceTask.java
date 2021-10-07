package org.example.project.bpmn_components.service_tasks;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Slf4j
@Component("confirm")
public class ConfirmServiceTask implements JavaDelegate {

    @Override
    public void execute(DelegateExecution delegateExecution) {
        log.info("in confirm service task!");
        log.info("simple message arrived");
    }
}
