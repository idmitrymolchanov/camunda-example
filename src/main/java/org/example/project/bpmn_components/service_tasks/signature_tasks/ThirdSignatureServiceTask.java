package org.example.project.bpmn_components.service_tasks.signature_tasks;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.example.project.model.Document;
import org.springframework.stereotype.Component;

@Slf4j
@Component("third_signature")
public class ThirdSignatureServiceTask extends Signature implements JavaDelegate {
    private static final String SIGNATURE_LEVEL = "LOW";

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        log.info("in low level signature task");
        String jsonDoc = delegateExecution.getVariable("document").toString();

        Document document = deserializeJson(jsonDoc);
        document.setSignatureLevel(SIGNATURE_LEVEL);
        delegateExecution.setVariable("document", serializeJson(document));
    }
}
