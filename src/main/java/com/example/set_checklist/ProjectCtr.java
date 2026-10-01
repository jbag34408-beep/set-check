package com.example.set_checklist;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProjectCtr {

    private final ProjectRe projectRe;
    private final ProcessMemoService processMemoService;

    public ProjectCtr(ProjectRe projectRe, ProcessMemoService processMemoService) {
        this.projectRe = projectRe;
        this.processMemoService = processMemoService;
    }

    @PostMapping("/projects")
    public Project addProject(@RequestBody Project project) {
        return projectRe.save(project);
    }

    @GetMapping("/projects")
    public List<Project> getProjects() {
        return projectRe.findAll();
    }

    @PostMapping("/projects/{projectId}/memos")
    public ProcessMemo addMemo(@PathVariable Long projectId,
                               @RequestBody ProcessMemo memo) {
        return processMemoService.addMemo(projectId, memo.getProcess(), memo.getCommitprocess());
    }

    @GetMapping("/projects/{projectId}/memos")
    public List<ProcessMemo> getMemos(@PathVariable Long projectId) {
        return processMemoService.findSettingBymemo(projectId);
    }
}