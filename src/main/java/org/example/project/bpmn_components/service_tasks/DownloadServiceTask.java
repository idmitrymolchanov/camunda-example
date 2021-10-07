package org.example.project.bpmn_components.service_tasks;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

import java.util.Random;

@Slf4j
@Component("download")
public class DownloadServiceTask implements JavaDelegate {

    @Override
    public void execute(DelegateExecution delegateExecution) {
        boolean isDownload = new Random().nextBoolean();
        delegateExecution.setVariable("isDownload", isDownload);

        log.info("in download service task");
        log.info("download var = " + isDownload);
    }
}
