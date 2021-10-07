package org.example.project.bpmn_components.service_tasks;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.example.project.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Slf4j
@Component("database_multi")
public class DatabaseMultiServiceTask implements JavaDelegate {
    private final DocumentService service;

    @Autowired
    public DatabaseMultiServiceTask(DocumentService service) {
        this.service = service;
    }

    @Override
    public void execute(DelegateExecution delegateExecution) {
        try {
            ArrayList docList = (ArrayList) delegateExecution.getVariable("docList");
            String document = docList.get(docList.size() - 1).toString();
            service.save(document);
            log.info("document from list: " + document + " saved");
            docList.remove(docList.size() - 1);

            delegateExecution.setVariable("doc", docList.size());
            delegateExecution.setVariable("docList", docList);
        } catch (Exception ignored) { }
    }
}
