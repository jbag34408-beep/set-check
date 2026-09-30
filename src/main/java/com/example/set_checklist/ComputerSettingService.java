package com.example.set_checklist;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
    public class ComputerSettingService {

    private  final  ComputerSettingRe computerSettingRe;
    private  final ComputerRe computerRe;
    private  final SettingRe settingRe;

        public ComputerSettingService(ComputerSettingRe computerSettingRe,
                                      ComputerRe computerRe,
                                      SettingRe settingRe)

        {
            this.computerSettingRe = computerSettingRe;
            this.computerRe=computerRe;
            this.settingRe=settingRe;
        }

    public ComputerSetting checkSetting (Long computerId,
                                         Long settingId,
                                         boolean completed ){
            Computer computer = computerRe.findById(computerId)
                    .orElseThrow(() -> new ResponseStatusException(
                            HttpStatus.NOT_FOUND,
                            "컴퓨터를 찾을 수 없습니다 . id=" + computerId));
            Setting setting = settingRe.findById(settingId)
                    .orElseThrow(()-> new ResponseStatusException(
                            HttpStatus.NOT_FOUND,
                            "컴퓨터를 찾을 수 없습니다 . id= "  + settingId));
            ComputerSetting computerSetting = new ComputerSetting();
            computerSetting.setCompleted(completed);
            computerSetting.setSetting(setting);
            computerSetting.setComputer(computer);
                return computerSettingRe.save(computerSetting);

    }

    public List<ComputerSetting>findSettingByComputer(Long computerId){
            Computer computer = computerRe.findById(computerId)
                    .orElseThrow(()->new ResponseStatusException(
                            HttpStatus.NOT_FOUND, "컴퓨터를 찾을 수 없습니다.id="+computerId));
                return computerSettingRe.findByComputer(computer);
        }
}
