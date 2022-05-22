package de.starvalcity.base.api.def.faction;

import org.jetbrains.annotations.NotNull;

import java.util.HashSet;
import java.util.Set;

public class FactionRank implements Comparable<FactionRank> {

    private String name;
    private Set<String> permissions;

    public FactionRank(String name) {
        setName(name);
        permissions = new HashSet<String>();
    }

    public void setName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty or null.");
        }
    }

    public void setPermissions(Set<String> permissions) {
        if (permissions == null) {
            permissions = new HashSet<String>();
        }
        this.permissions = permissions;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        FactionRank other = (FactionRank) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }

    public String getName() {
        return name;
    }

    public Set<String> getPermissions() {
        return permissions;
    }

    @Override
    public int compareTo(@NotNull FactionRank other) {
        return Integer.compare(permissions.size(), other.permissions.size());
    }
}
