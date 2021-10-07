package org.example.project.bpmn_components.service_tasks;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.example.project.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component("database_single")
public class DatabaseSingleServiceTask implements JavaDelegate {
    private final DocumentService service;

    @Autowired
    public DatabaseSingleServiceTask(DocumentService service) {
        this.service = service;
    }

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        log.info("in database single service task");

        String documentJson = delegateExecution.getVariable("document").toString();
        service.save(documentJson);
        log.info("document: " + documentJson + " saved");
    }
}
