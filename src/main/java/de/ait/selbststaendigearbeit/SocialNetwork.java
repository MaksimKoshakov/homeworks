package de.ait.selbststaendigearbeit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Objects.hash;

public class SocialNetwork {

    private static final Logger LOGGER = LoggerFactory.getLogger(SocialNetwork.class);


    private Map<Integer,User> users = new HashMap<>();
    private Map<Integer,Group> groups = new HashMap<>();

    private List<Post> posts = new ArrayList<>();

    public User registerUser(int id, String name){
        if (name == null){
            LOGGER.error("Имя пользователя null. Id: {}", id);
            return null;
        }
        for (Map.Entry<Integer, User> user: users.entrySet()){
            if(user.getKey().equals(id)){
                return null;
            }
        }
        User user = new User(id, name);
        LOGGER.info("Пользователь с id {} успешно добавлен", id);
        users.put(id, user);
        return user;
    }

    public Group createGroup(int id, String name){
        if (name == null){
            LOGGER.error("Название группы null. Id: {}", id);
            return null;
        }

        for (Map.Entry<Integer, Group> group: groups.entrySet()){
            if(group.getKey().equals(id)){
                return null;
            }
        }

        Group group = new Group(id, name);
        LOGGER.info("Группа с id {} успешно создана и добавдена", id);
        groups.put(id, group);
        return group;

    }

    public void createPost(User author, String content){
        if (author == null || content == null){
            LOGGER.error("Данные поста не валидные");
        }
        else {
            int key = hash(content);
            Post post = new Post(key, content, author);
            LOGGER.info("Пост автора {} успешно добавлен", author.getName());
            posts.add(post);
        }
    }

    public Map<Integer, Group> getGroups() {
        return groups;
    }
}
