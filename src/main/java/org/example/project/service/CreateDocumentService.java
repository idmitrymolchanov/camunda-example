package org.example.project.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.example.project.model.Document;
import org.springframework.stereotype.Service;

import java.util.Random;

@Slf4j
@Service
public class CreateDocumentService {
    private final String[] documentMarks = {"high", "average", "low"};
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final Random random = new Random();

    public Document createDocument() {
        log.info("In CreateDocumentService");

        return new Document(random.nextInt(100),
                "main_doc" + random.nextInt(20),
                documentMarks[random.nextInt(documentMarks.length)]);
    }

    public String documentToString(Document document) throws JsonProcessingException {
        return objectMapper.writeValueAsString(document);
    }
}