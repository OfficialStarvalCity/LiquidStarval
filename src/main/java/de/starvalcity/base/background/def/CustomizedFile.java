package de.starvalcity.base.background.def;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class CustomizedFile {

    private final File file;
    private final YamlConfiguration yamlConfiguration;

    public CustomizedFile(String FilePath, String FileName) {
        this.file = new File(FilePath, FileName);
        this.yamlConfiguration = YamlConfiguration.loadConfiguration(this.file);
    }

    public File getFile() {
        return file;
    }

    public YamlConfiguration getYamlConfiguration() {
        return yamlConfiguration;
    }

    public void reload() {
        try {
            yamlConfiguration.save(file);
            yamlConfiguration.load(file);
        } catch (IOException | InvalidConfigurationException exception) {
            exception.printStackTrace();
        }
    }

    public boolean exist() {
        return this.file.exists();
    }

    public CustomizedFile setValue(String ValuePath, Object Value) {
        this.yamlConfiguration.set(ValuePath, Value);
        return this;
    }

    public CustomizedFile setDefaultValue(String ValuePath, Object Value) {
        if(!valueExist(ValuePath)){
            this.yamlConfiguration.set(ValuePath, Value);
            save();
        }
        return this;
    }

    public Object getObject(String ValuePath) {
        return this.yamlConfiguration.get(ValuePath);
    }

    public boolean valueExist(String value) {
        return this.getObject(value) != null;
    }

    public CustomizedFile save() {
        try {
            this.yamlConfiguration.save(this.file);
        } catch (IOException var2) {
            var2.printStackTrace();
        }

        return this;
    }

    public boolean getBoolean(String ValuePath) {
        return this.yamlConfiguration.getBoolean(ValuePath);
    }

    public String getString(String ValuePath) {
        return this.yamlConfiguration.getString(ValuePath);
    }

    public Integer getInt(String ValuePath) {
        return this.yamlConfiguration.getInt(ValuePath);
    }

    public List<String> getStringList(String ValuePath) {
        return this.yamlConfiguration.getStringList(ValuePath);
    }

    public List<Integer> getIntList(String ValuePath) {
        return this.yamlConfiguration.getIntegerList(ValuePath);
    }

    public Long getLong(String ValuePath) {
        return this.yamlConfiguration.getLong(ValuePath);
    }

    public Float getFloat(String ValuePath) {
        return (float)this.yamlConfiguration.getLong(ValuePath);
    }

    public Double getDouble(String ValuePath) {
        return this.yamlConfiguration.getDouble(ValuePath);
    }


}
