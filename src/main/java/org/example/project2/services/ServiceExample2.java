package org.example.project2.services;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Slf4j
@Component("another_service")
public class ServiceExample2 implements JavaDelegate {

    @Override
    public void execute(DelegateExecution delegateExecution) {
        log.info("in another service");
        int testVar = (int) delegateExecution.getVariable("testVar");
        System.out.println(testVar);
    }
}
