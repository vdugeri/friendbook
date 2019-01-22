package com.danverem.friendster.services;

import com.danverem.friendster.dtos.UserLogin;
import com.danverem.friendster.dtos.UserToken;
import com.danverem.friendster.mappers.UserMapper;
import com.danverem.friendster.models.User;
import com.danverem.friendster.repositories.UserRepository;
import com.danverem.friendster.utils.JWTTokenGenerator;
import com.danverem.friendster.utils.PasswordHash;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Stateless
@LocalBean
public class AuthService {

    @Inject
    private UserRepository userRepository;

    @Inject
    private JWTTokenGenerator tokenGenerator;

    public boolean logIn(UserLogin userLogin) {
        Map<String, Object> params = new HashMap<>();
        params.put("username", userLogin.getUsername());

        List<User> userList = userRepository.findWithNamedQuery(User.FIND_BY_USERNAME, params, 1);

        if (userList.isEmpty()) {
            return false;
        }

        User user = userList.get(0);

        System.out.println("###" + userLogin.getPassword() + "$$$" + user.getPassword());

        return new PasswordHash().compare(userLogin.getPassword().toCharArray(), user.getPassword());
    }

    public UserToken issueToken(UserLogin userLogin) {
        Map<String, Object> params = new HashMap<>();
        params.put("username", userLogin.getUsername());

        List<User> userList = userRepository.findWithNamedQuery(User.FIND_BY_USERNAME, params, 1);

        User user = userList.get(0);

        String token = tokenGenerator.issueToken(user);

        return new UserToken().setToken(token).setUser(UserMapper.mapTo(user));
    }
}
