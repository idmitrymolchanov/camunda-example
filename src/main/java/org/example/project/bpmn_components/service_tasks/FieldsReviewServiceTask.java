package org.example.project.bpmn_components.service_tasks;

import org.camunda.bpm.engine.delegate.BpmnError;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component("fieldsReview")
public class FieldsReviewServiceTask implements JavaDelegate {

    @Override
    public void execute(DelegateExecution delegateExecution) {
        ArrayList docList = (ArrayList) delegateExecution.getVariable("docList");
        boolean flag = (boolean) delegateExecution.getVariable("flag");

        if(docList.size() < 10) flag = true;

        try {
            System.out.println("docList process...");
            docList.remove(docList.size() - 1);
        } catch (Exception e) {
            throw new BpmnError("forthError", "All removed");
        }

        delegateExecution.setVariable("flag", flag);
        delegateExecution.setVariable("doc", docList.size());
        delegateExecution.setVariable("docList", docList);
    }
}