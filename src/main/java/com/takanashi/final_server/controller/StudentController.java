package com.takanashi.final_server.controller;

import com.takanashi.final_server.constants.ResponseCode;
import com.takanashi.final_server.entity.StudentDTO;
import com.takanashi.final_server.exception.BaseException;
import com.takanashi.final_server.handler.Response;
import com.takanashi.final_server.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("")
public class StudentController {

    StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/user")
    public Response<Map<String, List<StudentDTO>>> getUser() {
        Map<String, List<StudentDTO>> responseData = new HashMap<>();
        try {
            List<StudentDTO> studentDTOS = studentService.getStudentMsg();
        } catch (BaseException exception) {

        }
        List<StudentDTO> studentDTOS = studentService.getStudentMsg();
        responseData.put("user", studentDTOS);
        return Response.SuccessResponse(responseData);
    }

    @PostMapping("/user")
    public Response SaveUser(@RequestBody StudentDTO studentDTO) throws BaseException {
       if( !studentService.saveStudent(studentDTO)){
           throw new BaseException(ResponseCode.USER_DATA_ERROR);
       }
       return Response.SuccessResponse(null);
    }

    @DeleteMapping("/user/{user_id}")
    public Response deleteUser(@PathVariable("user_id") String userID ){
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setUserID(userID);
        if(!studentService.deleteStudent(studentDTO)){
            throw new BaseException(ResponseCode.USER_DATA_ERROR);
        };
        return Response.SuccessResponse(null);
    }

    @GetMapping("/user/{user_id}")
    public Response getUserByUserID(@PathVariable("user_id")String userID){
        StudentDTO userByUserID = studentService.getStudentByStudentID(userID);
        if (userByUserID==null) {
            throw new BaseException(ResponseCode.USER_DATA_ERROR);
        }
        return Response.SuccessResponse(userByUserID);
    }

}