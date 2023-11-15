package de.ait.selbststaendigearbeit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Group {

    private static final Logger LOGGER = LoggerFactory.getLogger(Group.class);


    private int id;

    private String name;

    private Set<User> members = new HashSet<>();

    public Group(int id, String name) {
        this.id = id;
        this.name = name;
    }


    public boolean addMember(User user) {
        if (user == null) {
            LOGGER.error("Пользователь равен null");
            return false;
        }
        if (!members.contains(user)) {
            LOGGER.info("Новый пользователь с id {} успешно добавлен в группу", user.getId());
            return members.add(user);
        } else {
            LOGGER.error("Пользователь с id {} существует в группе", user.getId());
            return false;
        }
    }


    public int getId() {
        return id;
    }


    public String getName() {
        return name;
    }


    public Set<User> getMembers() {
        return new HashSet<>(members);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Group group)) return false;
        return id == group.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Group{" +
                "name='" + name + '\'' +
                '}';
    }
}
