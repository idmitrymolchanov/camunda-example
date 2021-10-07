package org.example.project.bpmn_components.service_tasks.signature_tasks;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.delegate.BpmnError;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.example.project.model.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Component("first_signature")
public class FirstSignatureServiceTask extends Signature implements JavaDelegate {
    private static final String SIGNATURE_LEVEL = "HIGH";
    private ProcessEngine processEngine;

    @Autowired
    public FirstSignatureServiceTask(ProcessEngine processEngine) {
        this.processEngine = processEngine;
    }

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        log.info("in high level signature task");
        String jsonDoc = delegateExecution.getVariable("document").toString();
        Document document = deserializeJson(jsonDoc);
        document.setSignatureLevel(SIGNATURE_LEVEL);

        if (document.getSignatureLevel().isEmpty())
            throw new BpmnError("thirdError", "This is a third error");

        delegateExecution.setVariable("document", serializeJson(document));

        sendSignal();
    }

    private void sendSignal() {
        log.info("send signal to bossServiceTask");
        RuntimeService runtimeService = processEngine.getRuntimeService();
        Map<String, Object> variables = new HashMap<String, Object>();
        variables.put("approved", true);
        runtimeService
                .createSignalEvent("signalName")
                .setVariables(variables)
                .send();
    }
}
