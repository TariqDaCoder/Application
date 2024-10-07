package edu.metrostate.ApplicationModel;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

public interface SportsTeam{
    int getTeamID();
    String getTeamName();
    String getTeamLogo();
}

class LinkedNode<T> {
    private LinkedNode<T> next;
    private T data;

    public LinkedNode(T data, LinkedNode<T> next) {
        this.data = data;
        this.next = next;
    }

    public void setNext(LinkedNode<T> next) {
        this.next = next;
    }

    public LinkedNode<T> getNext() {
        return next;
    }

    public T getData() {
        return data;
    }
}

class TeamFilter {
    public static <T extends SportsTeam> Map<Integer, T> teamFilterMapBySport(Map<Integer, T> teamMap, Predicate<T> filter) {
        Map<Integer, T> filteredTeams = new HashMap<>();

        for (Map.Entry<Integer, T> entry : teamMap.entrySet()) {
            T team = entry.getValue();

            if (filter.test(team)) {
                filteredTeams.put(entry.getKey(), team); // Use team ID as key
            }
        }

        return filteredTeams; // Return the map of filtered teams
    }
}

