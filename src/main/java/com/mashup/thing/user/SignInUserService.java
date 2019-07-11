package com.mashup.thing.user;

import com.mashup.thing.exception.BaseException;
import com.mashup.thing.search.SearchRepository;
import com.mashup.thing.search.domain.Search;
import com.mashup.thing.user.domain.User;
import com.mashup.thing.user.dto.ResSignInDto;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SignInUserService {

    private final UserRepository userRepository;
    private final SearchRepository searchRepository;
    private final UserMapper userMapper;

    public SignInUserService(UserRepository userRepository,
                             SearchRepository searchRepository,
                             UserMapper userMapper) {
        this.userRepository = userRepository;
        this.searchRepository = searchRepository;
        this.userMapper = userMapper;
    }

    public ResSignInDto signIn(String uid) {
        User user = userRepository.findByUid(uid).orElseThrow(() -> new BaseException(HttpStatus.BAD_REQUEST));
        List<Search> searches = searchRepository.findByUserId(user.getId()).orElse(new ArrayList<>());
        return userMapper.toResSignInDto(user, searches);
    }

}