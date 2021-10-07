package org.example.project.bpmn_components.service_tasks.message_tasks;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Component
public class SendDailyMessageTask implements JavaDelegate {
    @Override
    public void execute(DelegateExecution execution) throws Exception {
        Map<String, Object> variables = new HashMap<String, Object>();
        variables.put("paymentInformation", execution.getVariable("paymentInformation"));

        String orderId = execution.getVariable("orderId").toString();

        execution.getProcessEngineServices().getRuntimeService()
                .createMessageCorrelation("MsgPaymentReceived")
                .processInstanceVariableEquals("orderId", orderId)
                .setVariables(variables)
                .correlate();
    }
}
