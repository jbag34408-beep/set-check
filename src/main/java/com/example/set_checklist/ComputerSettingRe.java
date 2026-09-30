package com.example.set_checklist;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ComputerSettingRe extends JpaRepository < ComputerSetting, Long> {

    List<ComputerSetting> findByComputer(Computer computer);
}
