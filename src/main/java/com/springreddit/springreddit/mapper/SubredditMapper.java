package com.springreddit.springreddit.mapper;


import com.springreddit.springreddit.dto.SubredditDto;
import com.springreddit.springreddit.model.Post;
import com.springreddit.springreddit.model.Subreddit;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SubredditMapper {

    @Mapping(target = "numberOfPosts", expression = "java(mapPosts(subreddit.getPosts()))")
    SubredditDto mapSubredditToDto(Subreddit subreddit);

    default Integer mapPosts(List<Post> numberOfPosts) {
        return numberOfPosts.size();
    }

    @InheritInverseConfiguration
    @Mapping(target = "posts", ignore = true)
    @Mapping(target = "createdDate", expression = "java(java.time.Instant.now())")
    //@Mapping(target = "user", source = "user")
    Subreddit mapDtoToSubreddit(SubredditDto subreddit);
}
