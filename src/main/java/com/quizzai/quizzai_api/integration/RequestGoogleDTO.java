package com.quizzai.quizzai_api.integration;

import java.util.List;

public class RequestGoogleDTO {

    private List<Content> contents;

    // Getters e setters

    public List<Content> getContents() {
        return contents;
    }

    public void setContents(List<Content> contents) {
        this.contents = contents;
    }
}

class Content {
    private List<Part> parts;

    // Getters e setters

    public List<Part> getParts() {
        return parts;
    }

    public void setParts(List<Part> parts) {
        this.parts = parts;
    }
}

class Part {
    private String text;

    // Getters e setters

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
