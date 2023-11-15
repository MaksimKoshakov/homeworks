package de.ait.selbststaendigearbeit;

import java.util.Iterator;
import java.util.Map;

public class TestSocialNetwork {

    private static SocialNetwork socialNetwork = new SocialNetwork();

    public static void main(String[] args) {

        User micki = socialNetwork.registerUser(1, "Micki Maus");
        User guffi = socialNetwork.registerUser(2, "Guffi");

        micki.addFriend(guffi);

        Group disneyGroup = socialNetwork.createGroup(10, "Disney");
        disneyGroup.addMember(micki);
        disneyGroup.addMember(guffi);

        socialNetwork.createPost(micki, "Hallo Micki");
        socialNetwork.createPost(guffi, "Ufff");


        for (User user : micki.getFriends()) {
            System.out.println("Друг пользователя " + micki.getName() + " --> " + user.getName());
        }

        Iterator<Map.Entry<Integer, Group>> iterator = socialNetwork.getGroups().entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, Group> next = iterator.next();
            if (next.getValue().getMembers().contains(micki))
                System.out.println(next.getValue().toString());
        }
    }
}

