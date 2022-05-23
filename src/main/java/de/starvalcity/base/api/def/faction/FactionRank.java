package de.starvalcity.base.api.def.faction;

import de.starvalcity.base.api.def.StarvalPlayer;
import org.jetbrains.annotations.NotNull;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FactionRank implements Comparable<FactionRank> {

    private String name;
    private int level;
    private Set<String> permissions;
    private List<StarvalPlayer> members;

    public FactionRank(String name, int level) {
        this.name = name;
        this.level = level;
    }

    @Override
    public int compareTo(@NotNull FactionRank other) {
        return Integer.compare(other.level, level);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object)
            return true;
        if (object == null)
            return false;
        if (getClass() != object.getClass())
            return false;
        FactionRank other = (FactionRank) object;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }

    public void setPermissions(Set<String> permissions) {
        if (permissions == null) {
            permissions = new HashSet<String>();
        }
        this.permissions = permissions;
    }


    public Set<String> getPermissions() {
        return permissions;
    }

}
