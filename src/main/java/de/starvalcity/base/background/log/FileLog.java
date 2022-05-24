package de.starvalcity.base.background.log;

import org.bukkit.command.CommandSender;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

public class FileLog {

    private final DecimalFormat decimalFormat = new DecimalFormat("##.##");
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy - HH:mm:ss");

    private final CommandSender sender;
    private final Object object;
    private final String response;

    public FileLog(CommandSender sender, Object object, String response) {
        this.sender = sender;
        this.object = object;
        this.response = response;
    }

    public DecimalFormat getDecimalFormat() {
        return decimalFormat;
    }

    public SimpleDateFormat getDateFormat() {
        return dateFormat;
    }

    public CommandSender getSender() {
        return sender;
    }

    public Object getObject() {
        return object;
    }

    public String getResponse() {
        return response;
    }

    @Override
    public String toString() {
        return "[FileLog] >>> " + decimalFormat + dateFormat + "---" + sender + object + response;
    }
}
