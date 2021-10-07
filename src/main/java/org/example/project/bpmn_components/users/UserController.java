package org.example.project.bpmn_components.users;

import org.springframework.stereotype.Controller;

import java.util.Map;
import org.camunda.bpm.engine.TaskService;

@Controller
public class UserController {
    private TaskService taskService;

    public void completeUserTask(String processInstanceId, String taskName, Map<String, Object> variables) {
        String taskId = taskService.createTaskQuery()
                .processInstanceId(processInstanceId)
                .list()
                .stream()
                .filter(task -> task.getTaskDefinitionKey().equals(taskName))
                .findFirst()
                .orElseThrow(() -> new RuntimeException(
                        String.format("Could not find task with name %s on processInstanceId %s",
                                taskName,
                                processInstanceId))).getId();
        taskService.complete(taskId, variables);
    }
}
