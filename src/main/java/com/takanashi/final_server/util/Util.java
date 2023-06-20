package com.takanashi.final_server.util;

import com.takanashi.final_server.entity.Home;
import com.takanashi.final_server.entity.HomeDTO;
import com.takanashi.final_server.entity.Student;
import com.takanashi.final_server.entity.StudentDTO;
import org.springframework.stereotype.Component;

@Component
public class Util implements Transform{
    @Override
    public Student transform(StudentDTO studentDTO) {
        return new Student(studentDTO.getHomeID(), studentDTO.getName(), studentDTO.getUserID());
    }

    @Override
    public StudentDTO transform(Student student) {
        return new StudentDTO(student.getName(), student.getUserID(), student.getHomeID());
    }

    @Override
    public Home transform(HomeDTO homeDTO) {
        return new Home(homeDTO.getHomeID(),homeDTO.getLeader());
    }

    @Override
    public HomeDTO transform(Home home) {
        return new HomeDTO(home.getHomeID(),home.getLeader());
    }
}
