package de.starvalcity.utilities;

import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class FileWriter {

    private File file;
    private YamlConfiguration configuration;

    public FileWriter(String FilePath, String FileName) {
        this.file = new File(FilePath, FileName);
        this.configuration = YamlConfiguration.loadConfiguration(this.file);
    }

    public boolean exist() {
        return this.file.exists();
    }

    public FileWriter setValue(String ValuePath, Object Value) {
        this.configuration.set(ValuePath, Value);
        return this;
    }

    public FileWriter setDefaultValue(String ValuePath, Object Value) {
        if(!valueExist(ValuePath)){
            this.configuration.set(ValuePath, Value);
            save();
        }
        return this;
    }

    public Object getObject(String ValuePath) {
        return this.configuration.get(ValuePath);
    }

    public boolean valueExist(String value) {
        return this.getObject(value) != null;
    }

    public FileWriter save() {
        try {
            this.configuration.save(this.file);
        } catch (IOException var2) {
            var2.printStackTrace();
        }

        return this;
    }

    public boolean getBoolean(String ValuePath) {
        return this.configuration.getBoolean(ValuePath);
    }

    public String getString(String ValuePath) {
        return this.configuration.getString(ValuePath);
    }

    public Integer getInt(String ValuePath) {
        return this.configuration.getInt(ValuePath);
    }

    public List<String> getStringList(String ValuePath) {
        return this.configuration.getStringList(ValuePath);
    }

    public List<Integer> getIntList(String ValuePath) {
        return this.configuration.getIntegerList(ValuePath);
    }

    public Long getLong(String ValuePath) {
        return this.configuration.getLong(ValuePath);
    }

    public Float getFloat(String ValuePath) {
        return (float)this.configuration.getLong(ValuePath);
    }

    public Double getDouble(String ValuePath) {
        return this.configuration.getDouble(ValuePath);
    }

}
