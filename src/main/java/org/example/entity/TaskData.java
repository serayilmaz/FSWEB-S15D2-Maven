package org.example.entity;

import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

public class TaskData {

    private Set<Task> annsTasks;
    private Set<Task> bobsTasks;
    private Set<Task> carolsTasks;
    private Set<Task> unassignedTasks;

    public TaskData(Set<Task> annsTasks, Set<Task> bobsTasks, Set<Task> carolsTasks, Set<Task> unassignedTasks) {
        this.annsTasks = (annsTasks != null) ? annsTasks : new HashSet<>();
        this.bobsTasks = (bobsTasks != null) ? bobsTasks : new HashSet<>();
        this.carolsTasks = (carolsTasks != null) ? carolsTasks : new HashSet<>();
        this.unassignedTasks = (unassignedTasks != null) ? unassignedTasks : new HashSet<>();
    }

    public Set<Task> getTasks(String who) {
        if (who == null) return new HashSet<>();

        switch (who.toLowerCase(Locale.ROOT)) {
            case "ann":
                return annsTasks;
            case "bob":
                return bobsTasks;
            case "carol":
                return carolsTasks;
            case "all":
                Set<Task> all = new HashSet<>();
                all.addAll(annsTasks);
                all.addAll(bobsTasks);
                all.addAll(carolsTasks);
                all.addAll(unassignedTasks);
                return all;
            default:
                return new HashSet<>();
        }
    }

    // Test bunu istiyor: getUnion(Set, Set)
    public Set<Task> getUnion(Set<Task> set1, Set<Task> set2) {
        Set<Task> result = new HashSet<>();
        if (set1 != null) result.addAll(set1);
        if (set2 != null) result.addAll(set2);
        return result;
    }

    // Test bunu istiyor: getIntersection(Set, Set)
    public Set<Task> getIntersection(Set<Task> set1, Set<Task> set2) {
        Set<Task> result = new HashSet<>();
        if (set1 == null || set2 == null) return result;

        result.addAll(set1);
        result.retainAll(set2);
        return result;
    }

    // Test bunu istiyor: getDifferences(Set, Set)  => set1 - set2
    public Set<Task> getDifferences(Set<Task> set1, Set<Task> set2) {
        Set<Task> result = new HashSet<>();
        if (set1 == null) return result;

        result.addAll(set1);
        if (set2 != null) result.removeAll(set2);
        return result;
    }
}