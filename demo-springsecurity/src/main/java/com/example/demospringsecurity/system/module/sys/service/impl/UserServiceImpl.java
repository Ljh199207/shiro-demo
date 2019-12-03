package com.example.demospringsecurity.system.module.sys.service.impl;

import com.example.demospringsecurity.exception.handle.EntityNotFoundException;
import com.example.demospringsecurity.system.module.sys.entity.User;
import com.example.demospringsecurity.system.module.sys.repository.UserRepository;
import com.example.demospringsecurity.system.module.sys.service.UserService;
import com.example.demospringsecurity.system.module.sys.service.dto.UserDTO;
import com.example.demospringsecurity.system.module.sys.service.dto.UserQueryCriteria;
import com.example.demospringsecurity.system.module.sys.service.mapper.UserMapper;
import com.example.demospringsecurity.util.PageUtil;
import com.example.demospringsecurity.util.QueryHelp;
import com.example.demospringsecurity.util.ValidationUtil;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
* @author LJH
* @date 2019-11-21
*/
@Service
@CacheConfig(cacheNames = "user")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final UserMapper userMapper;


    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public UserDTO findById(long id) {
        return null;
    }

    @Override
    public UserDTO create(User resources) {
        return null;
    }

    @Override
    public void update(User resources) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public UserDTO findByName(String userName) {
        User user;
        if(ValidationUtil.isEmail(userName)){
            user = userRepository.findByEmail(userName);
        } else {
            user = userRepository.findByUsername(userName);
        }
        if (user == null) {
            throw new EntityNotFoundException(User.class, "name", userName);
        } else {
            return userMapper.toDto(user);
        }
    }

    @Override
    public void updatePass(String username, String encryptPassword) {

    }

    @Override
    public void updateAvatar(MultipartFile file) {

    }

    @Override
    public void updateEmail(String username, String email) {

    }

    @Override
    public Map<String,Object> queryAll(UserQueryCriteria criteria, Pageable pageable) {
        Page<User> page = userRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder),pageable);
        return PageUtil.toPage(page.map(userMapper::toDto));
    }

    @Override
    public List<UserDTO> queryAll(UserQueryCriteria criteria){
        return userMapper.toDto(userRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder)));
    }

    @Override
    public void download(List<UserDTO> queryAll, HttpServletResponse response) throws IOException {

    }
}