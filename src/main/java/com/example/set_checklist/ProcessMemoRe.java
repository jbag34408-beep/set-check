package com.example.set_checklist;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProcessMemoRe extends JpaRepository<ProcessMemo,Long> {

   List<ProcessMemo> findByProject(Project project);

}