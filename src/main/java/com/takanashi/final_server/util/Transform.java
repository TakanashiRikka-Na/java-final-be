package com.takanashi.final_server.util;

import com.takanashi.final_server.entity.Home;
import com.takanashi.final_server.entity.HomeDTO;
import com.takanashi.final_server.entity.Student;
import com.takanashi.final_server.entity.StudentDTO;

public interface Transform {
     Student transform(StudentDTO studentDTO);
     StudentDTO transform(Student student);

     Home transform(HomeDTO homeDTO);

     HomeDTO transform(Home home);

}


