package com.danverem.friendster.services;

import com.danverem.friendster.dtos.SearchResult;
import com.danverem.friendster.mappers.SearchMapper;
import com.danverem.friendster.models.User;
import com.danverem.friendster.repositories.UserRepository;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Stateless
@LocalBean
public class SearchService {

    @Inject
    UserRepository userRepository;

    public List<SearchResult> search(String param) {
        Map<String, Object> params = new HashMap<>();
        params.put("param", "%" + param + "%");

        return SearchMapper.mapTo(userRepository.findWithNamedQuery(User.SEARCH, params, 0));
    }
}
