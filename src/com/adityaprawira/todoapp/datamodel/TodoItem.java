package com.adityaprawira.todoapp.datamodel;

import java.time.LocalDate;

public class TodoItem {
    private String shortDescription;
    private String details;
    private LocalDate deadline;

    public TodoItem(String shortDescription, String details, LocalDate deadline) {
        this.shortDescription = shortDescription;
        this.details = details;
        this.deadline = deadline;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public String getDetails() {
        return details;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    @Override
    public String toString() {
        return shortDescription;
    }


}
