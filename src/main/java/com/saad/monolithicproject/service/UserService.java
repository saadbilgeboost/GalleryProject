package com.saad.monolithicproject.service;

import com.saad.monolithicproject.dto.request.UserSaveRequestDto;
import com.saad.monolithicproject.mapper.UserMapper;
import com.saad.monolithicproject.repository.IUserRepository;

import com.saad.monolithicproject.repository.entity.User;
import com.saad.monolithicproject.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService extends ServiceManager<User, Long> {
    private final IUserRepository userRepository;

    public UserService(IUserRepository userRepository) {
        super(userRepository);
        this.userRepository = userRepository;
    }
    public User save(User user) {
        user.setCreatedate(System.currentTimeMillis());
        return userRepository.save(user);
    }

    public User update(User user) {
        return userRepository.save(user);
    }

    public void delete(User user) {
        userRepository.delete(user);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public Iterable<User> saveAll(List<User> users) {
        users.forEach(user -> {
            user.setCreatedate(System.currentTimeMillis());
        });
        return userRepository.saveAll(users);
    }
    public Boolean isExistUser(String username, String password){
        return userRepository.isExistUser(username,password);
    }
    public User save (UserSaveRequestDto dto){
        User user = UserMapper.INSTANCE.toUser(dto);
        user.setCreatedate(System.currentTimeMillis());
        user.setIsactive(true);
        userRepository.save(user);
        return user;
    }
    public Optional<User> findOptionalByUsernameAndPassword(String username, String password){
        return userRepository.findOptionalByUsernameAndPassword(username, password);
    }

}
