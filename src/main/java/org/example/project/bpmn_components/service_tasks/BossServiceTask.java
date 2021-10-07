package org.example.project.bpmn_components.service_tasks;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Slf4j
@Component("boss_service")
public class BossServiceTask implements JavaDelegate {
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        boolean approved = (boolean) delegateExecution.getVariable("approved");
        log.info("in boss service task");
        log.info("signal received: " + approved);
    }
}
