package org.example.project.repository;

import org.example.project.model.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class DocumentRepository {
    private final String sql = "insert into DOCUMENT (id, name, mark, created, signature, signature_level) values (?,?,?,?,?,?)";

    @Autowired
    JdbcTemplate jdbcTemplate;

    public void save(Document document) {
        jdbcTemplate.update(sql,
                document.getId(),
                document.getName(),
                document.getMark(),
                document.isCreated(),
                document.isSignature(),
                document.getSignatureLevel());
    }
}