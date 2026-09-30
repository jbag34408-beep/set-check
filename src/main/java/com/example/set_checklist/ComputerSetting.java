package com.example.set_checklist;

import jakarta.persistence.*;
import org.springframework.data.jpa.repository.JpaRepository;




@Entity
public class ComputerSetting {

    @ManyToOne
    @JoinColumn(name = "Setting_id")
    private Setting setting;

    @ManyToOne
    @JoinColumn(name = "Computer_id")
    private Computer computer;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private boolean completed;

        public boolean getCompleted()
            {return completed;}
        public Long getId()
            {return id;}
         public void setCompleted(boolean completed)
            {this.completed = completed;}

    public ComputerSetting() {}

    public Setting getSetting()
        {return setting;}
    public void setSetting(Setting setting)
        {this.setting = setting;}
    public Computer getComputer()
        {return computer;}
    public void setComputer(Computer computer)
        {this.computer = computer;}
}
