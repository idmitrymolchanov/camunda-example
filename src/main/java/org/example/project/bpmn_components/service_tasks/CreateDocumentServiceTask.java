package org.example.project.bpmn_components.service_tasks;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.BpmnError;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.example.project.model.Document;
import org.example.project.service.CreateDocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component("create")
public class CreateDocumentServiceTask implements JavaDelegate {
    private final CreateDocumentService service;

    @Autowired
    public CreateDocumentServiceTask(CreateDocumentService service) {
        this.service = service;
    }

    @Override
    public void execute(DelegateExecution delegateExecution) {
        try {
            log.info("In CreateDocument service task");
            Document document = service.createDocument();
            String jsonDocument = service.documentToString(document);
            delegateExecution.setVariable("document", jsonDocument);
            delegateExecution.setVariable("mark", document.getMark());
        } catch (Exception e) {
            log.error("Error in create document task");
            throw new BpmnError("firstError", "This is Error");
        }
    }
}
