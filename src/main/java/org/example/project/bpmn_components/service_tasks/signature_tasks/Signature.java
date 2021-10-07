package org.example.project.bpmn_components.service_tasks.signature_tasks;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.project.model.Document;

import java.io.IOException;

public abstract class Signature {
    private final ObjectMapper mapper = new ObjectMapper();

    public Document deserializeJson(String jsonDocument) throws IOException {
        Document document = mapper.readValue(jsonDocument, Document.class);
        document.setSignature(true);
        return document;
    }

    public String serializeJson(Document document) throws JsonProcessingException {
        return mapper.writeValueAsString(document);
    }
}
