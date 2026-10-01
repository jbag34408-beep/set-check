package com.example.set_checklist;


import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity

public class ProcessMemo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private LocalDateTime time;
    private String process;
    private String commitprocess;


    @ManyToOne
    @JoinColumn(name = "Project_id" )
    private Project project;

    public ProcessMemo() {}

    public Long getId()
    {return id;}

    public LocalDateTime getTime() {
        return time;
    }
    public void setTime(LocalDateTime time){
        this.time=time;
    }

    public String getProcess() {
        return process;
    }

    public void setProcess(String process) {
        this.process = process;
    }

    public String getCommitprocess() {
        return commitprocess;
    }

    public void setCommitprocess(String commitprocess) {
        this.commitprocess = commitprocess;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}