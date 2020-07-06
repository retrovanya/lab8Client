package Auth;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.ConnectException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Random;
import java.util.Scanner;

import static Auth.CommandReader.*;
public class Authorization implements Serializable {
    public String logg;
    public String passw;

    Scanner scanner;
    private boolean isConnected = false;
    public Authorization(){}
    public Authorization(String login,String password){
        this.logg = login;
        this.passw = password;
    }
    public void checkLog(String log) throws InterruptedException {
        if ((log == null) || (log.trim().length() == 0)) {
            textRegistr.setText("Логин не может быть пустым.");
            getLog(log);
        }
    }
    public void getLog(String log) throws InterruptedException {
        getLogin = login.getText();
        checkLog(log);
    }
    public void getPass(String pass) throws InterruptedException {
        getPassword = password.getText();
        checkPass(pass);
    }
    public void checkPass(String pass) throws InterruptedException {
        if ((pass == null) || (pass.trim().length() == 0)) {
            textRegistr.setText("Пароль не может быть пустым.");
            getPass(pass);
        }
    }
    /*public void authorize() throws IOException, InterruptedException {
        scanLogin();
        System.out.println("Если Вы уже авторизованы, введите пароль, а если нет - можете придумать его."+
                "Чтобы пароль сгенерировался автоматически нажмите enter: ");
        password = scanner.nextLine();
        if ((password == null) ||(password.trim().length()==0)){
            password = Password();
            System.out.println("Ваш пароль: " + password);
        }
        Authorization user = new Authorization(login,password);
        while (!isConnected) {
            isConnected = true;
            SocketChannel socketChannel = createChannel();
            ObjectOutputStream outputStream = new ObjectOutputStream(socketChannel.socket().getOutputStream());
            outputStream.writeObject(user);
            socketChannel.close();
            outputStream.close();
        }
        isConnected = false;
    }*/
    public void authorize(String log, String pass) throws IOException, InterruptedException {
        getLog(log);
        getPass(pass);
        Authorization user = new Authorization(log,pass);
        while (!isConnected) {
            isConnected = true;
            SocketChannel socketChannel = createChannel();
            ObjectOutputStream outputStream = new ObjectOutputStream(socketChannel.socket().getOutputStream());
            outputStream.writeObject(user);
            socketChannel.close();
            outputStream.close();
        }
        isConnected = false;
    }

    private SocketChannel createChannel() throws IOException {
        ByteBuffer bf = ByteBuffer.allocate(16384);
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.configureBlocking(true);
        SocketAddress socketAddress = new InetSocketAddress("localhost", 7070);
        try {
            socketChannel.connect(socketAddress);
        }catch (ConnectException e){
            createChannel();
        }
        return socketChannel;
    }
    public  String getLogin(){
        return logg;
    }
    public String getPassword(){
        return passw;
    }

}
