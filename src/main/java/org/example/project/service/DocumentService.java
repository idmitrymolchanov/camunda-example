package org.example.project.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.project.model.Document;
import org.example.project.repository.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class DocumentService {
    private final ObjectMapper mapper = new ObjectMapper();
    private final DocumentRepository repository;

    @Autowired
    public DocumentService(DocumentRepository repository) {
        this.repository = repository;
    }

    public void save(String documentJson) throws IOException {
        Document document = mapper.readValue(documentJson, Document.class);
        repository.save(document);
    }
}
