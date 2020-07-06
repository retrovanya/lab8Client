package Auth;

import PersonData.AllException;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ConnectException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.channels.SocketChannel;
import java.util.*;
import java.nio.*;
import java.util.concurrent.locks.ReentrantLock;

import PersonData.Flat;
import javafx.scene.Group;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.util.concurrent.ConcurrentSkipListSet;
public class CommandReader implements Runnable {
    public static VBox vBox = new VBox();
    public static VBox vBox1 = new VBox();
    public static VBox vertical = new VBox();
    public static HBox buttonBox = new HBox();
    private static ArrayList<String> history = new ArrayList<>();
    public static Text textInfo = new Text();
    public static Text textHelp = new Text();
    public static Text textScript = new Text();
    public static Text textRegistr = new Text();
    public static ComboBox<String> commandBox = new ComboBox<>();
    public static ComboBox<String> languageBox = new ComboBox<>();
    public static ArrayList<String> furnish = new ArrayList<>();
    public static ArrayList<String> transport = new ArrayList<>();
    public static ArrayList<String> view = new ArrayList<>();
    public static ComboBox<String> furnishBox = new ComboBox<>();
    public static ComboBox<String> viewBox = new ComboBox<>();
    public static ComboBox<String> transportBox = new ComboBox<>();
    static ArrayList<String> commands = new ArrayList<>();
    public static ArrayList<String> languages = new ArrayList<>();
    public static  Label textLbl = new Label();
    public static Group group = new Group();
    public static Group group1 = new Group();
    public static HBox hBox = new HBox();
    public static HBox adder = new HBox();
    public static HBox adder1 = new HBox();
    public static HBox remover = new HBox();
    static HBox registration = new HBox();
    public static String s ;
    public static String getLogin = "";
    public static String getPassword = "";
    public static String locale = "Русский";
    public static String flag = "";
    public static String userFlag = "";
    public static TextField login = new TextField();
    public static TextField password = new TextField();
    public static TextField toRemove = new TextField();
    public static TextField toAdd = new TextField();
    public static Text text6 = new Text();
    public static Long id22send;
    public static Text text66 = new Text();
    public static Text user = new Text();
    public static long removeId = 0;
    public static long height = 0;
    public static Flat fl;

    static {
        try {
            fl = new Flat();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (AllException e) {
            e.printStackTrace();
        }
    }

    public static Flat flat;

    static {
        try {
            flat = new Flat();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (AllException e) {
            e.printStackTrace();
        }
    }

    public static long id2send;
    public static HashSet<Flat> flats = new HashSet<>();
    public static Double x = 0.0;
    public static String fileName;
    public static Double y =0.0;
   // public static String str = "";
    public static Integer marines = 0;
    public static Integer marines2 = 0;
    public static String house = "";
    public static String scriptFlag = "";
    Thread thread;
    Integer integer =0;
    private boolean isConnected = false;
    ReentrantLock locker;
    public CommandReader() {
       // locker = new ReentrantLock(); // создаем блокировку
        thread=new Thread(this, "Поток клиента с отправкой команд");
        thread.start(); //запускаем поток

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

                            @Override
                            public void run() {
        try {
           switch (s){

                                                case "info":
                                                    history.add(s);
                                                    ComplicatedObject info = new ComplicatedObject("info", locale, "", "");
                                                    SocketChannel socketchannel = createChannel(); // 2 new lines 2 try
                                                    ObjectOutputStream outputStream = new ObjectOutputStream(socketchannel.socket().getOutputStream());
                                                    outputStream.writeObject(info);
                                                    ReceiveDataFromServer receiveDataFromServer = new ReceiveDataFromServer();
                                                    receiveDataFromServer.receive();
                                                    socketchannel.close();
                                                    outputStream.close();
                                                    break;
                                                case "help":
                                                    SocketChannel socketchannel1 = createChannel(); // 2 new lines 2 try
                                                    System.out.println(integer);
                                                    ObjectOutputStream outputStream1 = new ObjectOutputStream(socketchannel1.socket().getOutputStream());
                                                    ReceiveDataFromServer receiveDataFromServer1 = new ReceiveDataFromServer();
                                                    history.add(s);
                                                    ComplicatedObject help = new ComplicatedObject("help");
                                                    outputStream1.writeObject(help);
                                                    receiveDataFromServer1.receive();
                                                    socketchannel1.close();
                                                    outputStream1.close();
                                                    break;
                                                case "clear":
                                                    SocketChannel socketchannel3 = createChannel(); // 2 new lines 2 try
                                                    integer=1;
                                                    ObjectOutputStream outputStream3 = new ObjectOutputStream(socketchannel3.socket().getOutputStream());
                                                    ReceiveDataFromServer receiveDataFromServer3 = new ReceiveDataFromServer();
                                                    history.add(s);
                                                    ComplicatedObject clear = new ComplicatedObject("clear", getLogin, getPassword);
                                                    outputStream3.writeObject(clear);
                                                    receiveDataFromServer3.receive();
                                                    socketchannel3.close();
                                                    outputStream3.close();
                                                    break;
                                                case "show":
                                                    SocketChannel socketchannel4 = createChannel(); // 2 new lines 2 try
                                                    ObjectOutputStream outputStream4 = new ObjectOutputStream(socketchannel4.socket().getOutputStream());
                                                    ReceiveDataFromServer receiveDataFromServer4 = new ReceiveDataFromServer();
                                                    history.add(s);
                                                    ComplicatedObject show = new ComplicatedObject("show");
                                                    outputStream4.writeObject(show);
                                                    receiveDataFromServer4.receive();
                                                    socketchannel4.close();
                                                    outputStream4.close();
                                                    break;
                                                case "add":

                                                    ReceiveDataFromServer receiveDataFromServer5 = new ReceiveDataFromServer();
                                                    history.add(s);
                                                    ComplicatedObject co = new ComplicatedObject("add", flat, getLogin);

                                                    SocketChannel socketchannel5 = createChannel(); // 2 new lines 2 try
                                                    ObjectOutputStream outputStream5 = new ObjectOutputStream(socketchannel5.socket().getOutputStream());
                                                    outputStream5.writeObject(co);
                                                    receiveDataFromServer5.receive();
                                                    socketchannel5.close();
                                                    outputStream5.close();


                                                    break;
                                                case "update_id":

                                                    ReceiveDataFromServer receiveDataFromServer6 = new ReceiveDataFromServer();

                                                    history.add(s); //сначала получаю все данные, а потом отправляю

                                                    ComplicatedObject obj = new ComplicatedObject("update_id", id2send, fl, getLogin);
                                                    SocketChannel socketchannel6 = createChannel(); // 2 new lines 2 try
                                                    ObjectOutputStream outputStream6 = new ObjectOutputStream(socketchannel6.socket().getOutputStream());

                                                    outputStream6.writeObject(obj);

                                                    receiveDataFromServer6.receive();

                                                    outputStream6.close();

                                                    socketchannel6.close();

                                                    break;
               case "users":
                   SocketChannel socketchannel44 = createChannel();
                   ObjectOutputStream outputStream44 = new ObjectOutputStream(socketchannel44.socket().getOutputStream());
                   ComplicatedObject users = new ComplicatedObject("users");
                   outputStream44.writeObject(users);
                   ReceiveDataFromServer r44 = new ReceiveDataFromServer();
                   r44.receive();
                   socketchannel44.close();
                   outputStream44.close();
                   break;
                                                case "remove_by_id":

                                                    ReceiveDataFromServer receiveDataFromServer7 = new ReceiveDataFromServer();
                                                    history.add(s);

                                                    ComplicatedObject remove = new ComplicatedObject("remove_by_id", removeId, getLogin);

                                                    SocketChannel socketchannel7 = createChannel(); // 2 new lines 2 try
                                                    ObjectOutputStream outputStream7 = new ObjectOutputStream(socketchannel7.socket().getOutputStream());

                                                    outputStream7.writeObject(remove);

                                                    receiveDataFromServer7.receive();

                                                    outputStream7.close();
                                                    socketchannel7.close();

                                                    break;
                                                case "countByRooms":

                                                    history.add(s);
                                                    long ii = 2;
                                                    ComplicatedObject heightSum = new ComplicatedObject("countByRooms", ii);
                                                    SocketChannel socketchannel8 = createChannel(); // 2 new lines 2 try
                                                    ObjectOutputStream outputStream8 = new ObjectOutputStream(socketchannel8.socket().getOutputStream());
                                                    ReceiveDataFromServer receiveDataFromServer8 = new ReceiveDataFromServer();
                                                    outputStream8.writeObject(heightSum);
                                                    receiveDataFromServer8.receive();
                                                    outputStream8.close();
                                                    socketchannel8.close();
                                                    break;
                        case "remove_greater":
                            ReceiveDataFromServer receiveDataFromServer10 = new ReceiveDataFromServer();
                            history.add(s);
                            ComplicatedObject filter = new ComplicatedObject("remove_greater", removeId, getLogin);
                            SocketChannel socketchannel10 = createChannel(); // 2 new lines 2 try
                            ObjectOutputStream outputStream10 = new ObjectOutputStream(socketchannel10.socket().getOutputStream());



                            outputStream10.writeObject(filter);
                            receiveDataFromServer10.receive();
                            outputStream10.close();
                            socketchannel10.close();
                            break;
                        case "remove_lower":
                            ReceiveDataFromServer receiveDataFromServer11 = new ReceiveDataFromServer();
                            history.add(s);
                            ComplicatedObject removeGr = new ComplicatedObject("remove_lower", removeId, getLogin);
                            SocketChannel socketchannel11 = createChannel(); // 2 new lines 2 try
                            ObjectOutputStream outputStream11 = new ObjectOutputStream(socketchannel11.socket().getOutputStream());


                            outputStream11.writeObject(removeGr);
                            receiveDataFromServer11.receive();
                            outputStream11.close();
                            socketchannel11.close();
                            break;
                        case "history":
                            SocketChannel socketchannel12 = createChannel(); // 2 new lines 2 try
                            ObjectOutputStream outputStream12 = new ObjectOutputStream(socketchannel12.socket().getOutputStream());
                            ReceiveDataFromServer receiveDataFromServer12 = new ReceiveDataFromServer();
                            history.add(s);
                            ComplicatedObject history1 = new ComplicatedObject("history", history.toString());
                            outputStream12.writeObject(history1);
                            receiveDataFromServer12.receive();
                            outputStream12.close();
                            socketchannel12.close();
                            break;
                        /*case "exit":
                            SocketChannel socketchanne101 = createChannel(); // 2 new lines 2 try
                            ObjectOutputStream outputStream101 = new ObjectOutputStream(socketchanne101.socket().getOutputStream());
                            ComplicatedObject exit = new ComplicatedObject("exit");
                            outputStream101.writeObject(exit);
                            outputStream101.close();
                            socketchanne101.close();
                            break;*/
                        case "script":
                            history.add(s);
                            ComplicatedObject executeScript = new ComplicatedObject("script");
                            SocketChannel socketchanne100 = createChannel(); // 2 new lines 2 try
                            ObjectOutputStream outputStream100 = new ObjectOutputStream(socketchanne100.socket().getOutputStream());
                            ReceiveDataFromServer receiveDataFromServer100 = new ReceiveDataFromServer();
                            outputStream100.writeObject(executeScript);
                            receiveDataFromServer100.receive();
                            outputStream100.close();
                            socketchanne100.close();
                            break;
                        case "remove_by_house_age":
                            ReceiveDataFromServer receiveDataFromServer70 = new ReceiveDataFromServer();
                            history.add(s);

                            ComplicatedObject removeByHouseAge = new ComplicatedObject("remove_by_house_age", removeId, getLogin );
                            SocketChannel socketchannel70 = createChannel(); // 2 new lines 2 try
                            ObjectOutputStream outputStream70 = new ObjectOutputStream(socketchannel70.socket().getOutputStream());

                            outputStream70.writeObject(removeByHouseAge);
                            receiveDataFromServer70.receive();
                            outputStream70.close();
                            socketchannel70.close();
                            break;

                        default:
                            System.out.println("Такой команды нет, повторите ввод. Чтобы узнать список доступных команд введите help.");
                    }
                }
             catch (IllegalStateException e) {
                System.out.println("Программа завершена");
            } catch (NoSuchElementException e) {
                e.getMessage();
            } catch (IOException e) {
                System.out.println("Удаленный хост принудительно разорвал существующее подключение. Клиенту необходимо повторить подключение.");
                e.printStackTrace();
            }
                            }}



