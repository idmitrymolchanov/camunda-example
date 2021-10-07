package org.example.project.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Document {
    private int id;
    private String name;
    private String mark;
    private boolean created;
    private boolean signature;
    private String signatureLevel;

    public Document(int id, String name, String mark) {
        this.id = id;
        this.name = name;
        this.mark = mark;
        this.created = true;
    }
}
