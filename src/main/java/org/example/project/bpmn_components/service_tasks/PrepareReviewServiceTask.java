package org.example.project.bpmn_components.service_tasks;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.example.project.model.Document;
import org.example.project.service.CreateDocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

@Component
public class PrepareReviewServiceTask implements JavaDelegate {
    private final Random random = new Random();
    private final CreateDocumentService service;

    @Autowired
    public PrepareReviewServiceTask(CreateDocumentService service) {
        this.service = service;
    }

    @Override
    public void execute(DelegateExecution delegateExecution) throws JsonProcessingException {
        Document document = service.createDocument();
        String stringDocument = service.documentToString(document);

        List docList = new ArrayList(Collections.nCopies(random.nextInt(50), stringDocument));

        delegateExecution.setVariable("flag", false);
        delegateExecution.setVariable("docList", docList);
    }
}
