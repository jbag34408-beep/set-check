package com.example.set_checklist;


import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ProcessMemoService {
    private final ProcessMemoRe processMemoRe;
    private final ProjectRe projectRe;

    public ProcessMemoService(ProjectRe projectRe, ProcessMemoRe processMemoRe) {
        this.projectRe = projectRe;
        this.processMemoRe = processMemoRe;
    }

    public ProcessMemo addMemo(Long projectid, String process, String commitprocess) {
        Project project = projectRe.findById(projectid)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "프로젝트를 찾을 수 없습니다 id=" + projectid));

        ProcessMemo processMemo = new ProcessMemo();
        processMemo.setCommitprocess(commitprocess);
        processMemo.setTime(LocalDateTime.now());
        processMemo.setProcess(process);
        processMemo.setProject(project);

        return processMemoRe.save(processMemo);
    }
    public List<ProcessMemo> findSettingBymemo(Long projectid) {
        Project project = projectRe.findById(projectid)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "프로젝트를 찾을 수 없습니다 id=" + projectid));

        return processMemoRe.findByProject(project);
    }
}