package Auth;

import PersonData.Flat;

import java.io.File;
import java.io.Serializable;
public class ComplicatedObject implements Serializable {
    private String command;
    private Flat flat;
    private long id;
    private Long param;
    private long p;
    private String history;
    private String name;
    private String login;
    private File fileName;
    String locale;
    public ComplicatedObject(String command){
        this.command = command;
    }
    public  ComplicatedObject(String command, Flat flat){
        this.command = command;
        this.flat = flat;
    }
    public ComplicatedObject(String command, Flat flat, String login){
        this.command = command;
        this.flat = flat;
        this.login = login;
    }
    public ComplicatedObject(String command,String login, String password){
        this.login = login;
        this.command = command;
    }
    public ComplicatedObject(String command, File fileName, String login, String locale){
        this.command = command;
        this.fileName = fileName;
        this.login = login;
        this.locale = locale;
    }
    public ComplicatedObject(String command, long id, Flat flat, String login){
        this.command = command;
        this.id = id;
        this.flat = flat;
        this.login = login;
    }

    public ComplicatedObject(String command, int p, String login){
        this.command = command;
        this.p = p;
        this.login = login;
    }
    public ComplicatedObject(String command, Long param, String login){
        this.command = command;
        this.param = param;
        this.login = login;
    }
    public ComplicatedObject(String command, String locale, String password, String login){
        this.command = command;
        this.locale = locale;
    }
   public ComplicatedObject(String command, long id, Flat flat){
        this.command = command;
        this.id = id;
        this.flat = flat;
    }
    public ComplicatedObject(String command,String history ){
        this.command = command;
        this.history = history;
    }
    public ComplicatedObject(String command, long id){
        this.command = command;
        this.id = id;
    }
    public ComplicatedObject(String command, long id, String login){
        this.command = command;
        this.id = id;
    }
    public String getCommand(){
        return command;
    }
    public Flat getFlat(){
        return flat;
    }
    public Long getParam(){return param;}
    public long getId(){
        return id;
    }
    public long getP(){return p;}
    public String getHistory(){return history;}
    public String getName () {return name;}
    public String getLocale(){
        return locale;
    }
    public String getLogin(){return login;}
    public File getFileName(){return fileName;}
    @Override
    public String toString() {
        return ("command: " + command + "\n" );
    }
}

