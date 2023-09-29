package com.devmountain.gasTracker.services;

import com.devmountain.gasTracker.dtos.UserDto;
import com.devmountain.gasTracker.entities.User;
import jakarta.transaction.Transactional;
import java.util.List;

public interface UserService {
    @Transactional
    List<String> addUser(UserDto userDto);

    List<String> userLogin(UserDto userDto);
}
