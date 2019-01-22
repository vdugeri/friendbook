package com.danverem.friendster.mappers;

import com.danverem.friendster.dtos.SearchResult;
import com.danverem.friendster.models.User;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class SearchMapper {

    public static List<SearchResult> mapTo(List<User> users) {
        if (users.isEmpty()) {
            return Collections.EMPTY_LIST;
        }

        return users.stream().map(user -> mapTo(user)).filter(results -> results != null).collect(Collectors.toList());
    }

    private static SearchResult mapTo(User user) {
        if (user == null) {
            return null;
        }

        SearchResult result = new SearchResult();
        result.setEmailAddress(user.getEmailAddress());
        result.setFirstName(user.getFirstName());
        result.setLastName(user.getLastName());
        result.setUsername(user.getUsername());

        return result;
    }
}
