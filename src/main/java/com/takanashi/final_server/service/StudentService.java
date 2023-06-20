package com.takanashi.final_server.service;

import com.takanashi.final_server.entity.StudentDTO;
import com.takanashi.final_server.exception.BaseException;
import java.util.List;

public interface StudentService {
    List<StudentDTO> getStudentMsg() throws BaseException;

    boolean saveStudent(StudentDTO studentDTO);
    boolean deleteStudent(StudentDTO studentDTO);

    StudentDTO getStudentByStudentID(String userID);
}
