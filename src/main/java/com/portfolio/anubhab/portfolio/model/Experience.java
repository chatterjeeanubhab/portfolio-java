package com.portfolio.anubhab.portfolio.model;

public class Experience {
    private String company;
    private String role;
    private String duration;
    private String description;

    public Experience() {}

    public Experience(String company, String role, String duration, String description) {
        this.company = company;
        this.role = role;
        this.duration = duration;
        this.description = description;
    }

    public String getCompany() { return company; }
    public void setCompany(String company) { this.company = company; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    public String getDuration() { return duration; }
    public void setDuration(String duration) { this.duration = duration; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}
