package org.example.project2.services;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

import java.util.Random;

@Slf4j
@Component("service")
public class ServiceExample implements JavaDelegate {

    @Override
    public void execute(DelegateExecution delegateExecution) {
        Random random = new Random();
        int var1 = random.nextInt(10);
        String var2 = "var";
        delegateExecution.setVariable("var1", var1);
        delegateExecution.setVariable("var2", var2);
        log.info("In Service example!!!!!!!!!!");
    }
}
