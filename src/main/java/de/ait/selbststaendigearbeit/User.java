package de.ait.selbststaendigearbeit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class User {

    private static final Logger LOGGER = LoggerFactory.getLogger(User.class);


    private int id;

    private String name;

    private List<User> friends = new ArrayList<>();

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }


    public boolean addFriend(User newFriend) {
        if (newFriend == null) {
            LOGGER.error("Пользователь равен null");
            return false;
        }
        for (User friend : friends) {
            if (friend.equals(newFriend)) {
                LOGGER.error("Пользователь с id {} существует в списке друзей", friend.getId());
                return false;
            }
        }

        LOGGER.info("Новый пользователь с id {} успешно добавлен в друзья", newFriend.getId());


        LOGGER.warn("Новый пользователь с id {} успешно добавлен в друзья", newFriend.getId());


        return friends.add(newFriend);
    }


    public int getId() {
        return id;
    }


    public String getName() {
        return name;
    }


    public List<User> getFriends() {
        return new ArrayList<>(friends);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User user)) return false;
        return id == user.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
