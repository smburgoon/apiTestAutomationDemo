package com.smburgoo.api.validation.petstore;

import java.util.List;
import java.util.Objects;

public class CreateTicket {
    private String title;
    private String applicationArea;
    private String description;
    private String contactEmail;
    private String dateCreated;
    private String dateTime;
    private String videoUrl;

    private Boolean resolved;

    private List<String> tags;

    public CreateTicket() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getApplicationArea() {
        return applicationArea;
    }

    public void setApplicationArea(String applicationArea) {
        this.applicationArea = applicationArea;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public Boolean getResolved() {
        return resolved;
    }

    public void setResolved(Boolean resolved) {
        this.resolved = resolved;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreateTicket ticket = (CreateTicket) o;
        return Objects.equals(title, ticket.title) && Objects.equals(applicationArea, ticket.applicationArea) && Objects.equals(description, ticket.description) && Objects.equals(contactEmail, ticket.contactEmail) && Objects.equals(dateCreated, ticket.dateCreated) && Objects.equals(dateTime, ticket.dateTime) && Objects.equals(videoUrl, ticket.videoUrl) && Objects.equals(resolved, ticket.resolved) && Objects.equals(tags, ticket.tags);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, applicationArea, description, contactEmail, dateCreated, dateTime, videoUrl, resolved, tags);
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "title='" + title + '\'' +
                ", applicationArea='" + applicationArea + '\'' +
                ", description='" + description + '\'' +
                ", contactEmail='" + contactEmail + '\'' +
                ", dateCreated='" + dateCreated + '\'' +
                ", dateTime='" + dateTime + '\'' +
                ", videoUrl='" + videoUrl + '\'' +
                ", resolved=" + resolved +
                ", tags=" + tags +
                '}';
    }
}
