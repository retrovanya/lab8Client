package Auth;

import PersonData.AllException;
import PersonData.Flat;
import java.io.IOException;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.locks.ReentrantLock;
import static Auth.CommandReader.*;
public class ReceiveDataFromServer{
    int k = 0;
    String n ="";
    String name = "";
    String id ="";
    String creation ="";
    String area ="";
    String numberOfRooms ="";
    String transport ="";
    String furnish ="";
    String view ="";
    String x ="";
    String y ="";
    String houseName ="";
    String houseAge ="";
    String houseNumberOfLifts ="";
    String login ="";
    public static String data;
    public static ReentrantLock locker = new ReentrantLock();
    public static List<String> loginList = new ArrayList<>();
    private DatagramSocket ds;
    public ReceiveDataFromServer(){}
    public void receive() {

        try {

            locker.lock();

            ds  = new DatagramSocket(7070);

            byte[] buf = new byte[65535];

            DatagramPacket packet = new DatagramPacket(buf, buf.length);

            ds.receive(packet);
            ds.close();


            data = new String(buf, StandardCharsets.UTF_8);
            data = data.replaceAll("�","");
            if (!data.contains("00010010")) {
                if (s == "show") {
                    flats.clear();
                    Scanner scanner = new Scanner(data);
                    while (scanner.hasNext()) {
                        if (k == 0) {
                            n = scanner.nextLine();
                            if (scanner.hasNext()) {
                                name = scanner.nextLine();
                                id = scanner.nextLine();
                                creation = scanner.nextLine();
                                area = scanner.nextLine();
                                numberOfRooms = scanner.nextLine();
                                transport = scanner.nextLine();
                                furnish = scanner.nextLine();
                                view = scanner.nextLine();
                                x = scanner.nextLine();
                                y = scanner.nextLine();
                                houseName = scanner.nextLine();
                                houseAge = scanner.nextLine();
                                houseNumberOfLifts = scanner.nextLine();
                                login = scanner.nextLine();
                                showCol();
                            }
                        } else {
                            name = scanner.nextLine();
                            id = scanner.nextLine();
                            creation = scanner.nextLine();
                            area = scanner.nextLine();
                            numberOfRooms = scanner.nextLine();
                            transport = scanner.nextLine();
                            furnish = scanner.nextLine();
                            view = scanner.nextLine();
                            x = scanner.nextLine();
                            y = scanner.nextLine();
                            houseName = scanner.nextLine();
                            houseAge = scanner.nextLine();
                            houseNumberOfLifts = scanner.nextLine();
                            login = scanner.nextLine();
                            showCol();
                        }
                    }
                    flag = "finish";
                    k = 0;
                } else if (s == "help") {
                    textHelp.setText(data);
                } else if (s == "execute_script") {
                    textScript.setText(data);
                } else if (s == "users"){
                    loginList.clear();
                    Scanner scanner = new Scanner(data);
                    while (scanner.hasNext()) {
                        if (k == 0) {
                            n = scanner.nextLine();
                            if (scanner.hasNext()) {
                                loginList.add(scanner.nextLine());
                                k++;
                            }
                        } else {
                            loginList.add(scanner.nextLine());
                            k++;
                        }
                    }
                    userFlag = "finish";
                    k = 0;
                }else {
                    textInfo.setText(data);
                }
            }
            else if (data.contains("00010010")) {
                textRegistr.setText("Пользователь с таким логином уже существует\n" +
                        " или пароль был введён неправильно.\n" +
                        " Повторите авторизацию.");
                Authorization a = new Authorization();
                a.authorize(getLogin,getPassword);
            }
        }catch (IOException | InterruptedException | AllException e){
            e.printStackTrace();
        }finally {
            locker.unlock();
        }
    }
    public void showCol() throws IOException, AllException {
        Flat flaT = new Flat();
        flaT.setName(name);
        flaT.setId(Integer.parseInt(id));
        flaT.setLogin(login);
        flaT.setHouseType(houseName, Integer.parseInt(houseAge), Integer.parseInt(houseNumberOfLifts) );
        flaT.setCoordinates(Double.parseDouble(x), Double.parseDouble(y));
        flaT.setArea(Double.parseDouble(area));
        flaT.setNumberOfRooms(Long.parseLong(numberOfRooms));
        flaT.setFurnish(furnish);
        flaT.setTransport(transport);
        flaT.setView(view);
        flats.add(flaT);
        k++;
    }
}