package com.takanashi.final_server.util;

import com.takanashi.final_server.entity.*;
import org.springframework.stereotype.Component;

@Component
public class TransformUtil implements Transform{
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

    @Override
    public UserDTO transform(User user) {
        return new UserDTO(user.getPasswd(), user.getName(), user.getUserID(), user.isTeacher());
    }

    @Override
    public User transform(UserDTO userDTO) {
        return new User(userDTO.getPasswd(), userDTO.getName(), userDTO.getUserID(), userDTO.isTeacher());
    }
}
