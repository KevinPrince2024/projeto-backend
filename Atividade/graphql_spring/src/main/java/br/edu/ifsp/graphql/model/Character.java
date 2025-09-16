package br.edu.ifsp.graphql.model;

import java.util.List;

public abstract class Character {
    abstract String getId();
    abstract String getName();
    abstract List<Episode> getAppearsIn();
    abstract List<Character> getFriends();
}
