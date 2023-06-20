package com.takanashi.final_server.util;

import com.takanashi.final_server.entity.*;

public interface Transform {
     Student transform(StudentDTO studentDTO);
     StudentDTO transform(Student student);

     Home transform(HomeDTO homeDTO);

     HomeDTO transform(Home home);

     UserDTO transform(User user);
     User transform(UserDTO userDTO);
}


