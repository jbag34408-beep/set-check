package com.example.set_checklist;


import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Checkctr {
    private final ComputerSettingService computerSettingService;
    private final ComputerRe computerRe;
    private final SettingRe settingRe;


    public Checkctr(ComputerSettingService computerSettingService
                     ,ComputerRe computerRe , SettingRe settingRe)
    {
        this.computerSettingService = computerSettingService;
        this.computerRe=computerRe ;
        this.settingRe=settingRe ;
    }

    @PutMapping("/computers/{computerId}/setting/{settingId}/{completed}")
    public ComputerSetting checkSetting(@PathVariable long computerId,
                                        @PathVariable long settingId,
                                        @PathVariable boolean completed) {
        return computerSettingService.checkSetting(computerId,settingId,completed);
    }
    @PostMapping("/computers")
    public Computer addComputer(@RequestBody Computer computer){
        return computerRe.save(computer);
    }
    @PostMapping("/setting")
    public Setting addSetting(@RequestBody Setting setting){
        return settingRe.save(setting);
    }
    @GetMapping("/computers/{computerId}/settings")
        public List<ComputerSetting> findSettingByComputer(@PathVariable long computerId){
        return computerSettingService.findSettingByComputer(computerId);
    }
    @GetMapping("/computers")
    public List<Computer> getComputers() {
        return computerRe.findAll();
    }

    @GetMapping("/setting")
    public List<Setting> getSettings() {
        return settingRe.findAll();
    }
}