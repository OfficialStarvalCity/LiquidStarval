package de.starvalcity.base.api.def.economy;

import de.starvalcity.base.api.def.UniqueObject;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Job implements UniqueObject {

    private String name;
    private int id;
    private double salary;

    public Job(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }
}
