package com.takanashi.final_server.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.takanashi.final_server.constants.ResponseCode;
import com.takanashi.final_server.entity.Student;
import com.takanashi.final_server.entity.StudentDTO;
import com.takanashi.final_server.exception.BaseException;
import com.takanashi.final_server.mapper.StudentMapper;
import com.takanashi.final_server.service.StudentService;
import com.takanashi.final_server.util.Transform;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;


@Service
public class StudentServiceImpl implements StudentService {

    Transform transform;
     StudentMapper studentMapper;
     @Autowired
    public StudentServiceImpl(StudentMapper studentMapper, Transform transform){
         this.transform=transform;
         this.studentMapper = studentMapper;
    }
    @Override
    public List<StudentDTO> getStudentMsg() throws BaseException {
         List<Student> students = studentMapper.searchAll();
         if (students ==null) throw new BaseException(ResponseCode.SERVER_ERROR);
         List<StudentDTO> studentDTOList = new ArrayList<>();
        for (Student student : students) {
            studentDTOList.add(transform.transform(student));
        }

        return studentDTOList;
    }

    @Override
    public boolean saveStudent(StudentDTO studentDTO) {
         QueryWrapper<Student> queryWrapper = new QueryWrapper<>();
         queryWrapper.eq("user_id", studentDTO.getUserID());
         if (studentMapper.exists(queryWrapper)) throw new BaseException(ResponseCode.DATA_EXIST);
         return studentMapper.insert(transform.transform(studentDTO))==1;
    }

    @Override
    public boolean deleteStudent(StudentDTO studentDTO) {
         Student student = transform.transform(studentDTO);
        QueryWrapper<Student> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("user_id", student.getUserID());
        return studentMapper.delete(queryWrapper)==1;
    }

    @Override
    public StudentDTO getStudentByStudentID(String userID) {
        QueryWrapper<Student> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq("user_id",userID);
        Student student = studentMapper.selectOne(userQueryWrapper);
        return  transform.transform(student);
    }

}
