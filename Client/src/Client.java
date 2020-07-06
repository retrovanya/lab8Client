
import Auth.CommandReader;
import Auth.InterfaceOrganizer;
import Auth.Localize;
import PersonData.Flat;
import PersonData.Furnish;
import PersonData.Transport;
import PersonData.View;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.converter.DoubleStringConverter;
import javafx.util.converter.IntegerStringConverter;
import javafx.util.converter.NumberStringConverter;
import java.util.*;
import static Auth.CommandReader.*;
import static Auth.Localize.*;

import  Auth.*;


public class Client extends Application{
    public static void main(String[] args) {
        launch();
    }
    private InterfaceOrganizer intorg = new InterfaceOrganizer();
    private static Localize localize = new Localize();
    public static String string = "";
    TableView tableView;
    @Override
    public void start(Stage primaryStage) throws Exception {
        intorg.enumOrganize();
        intorg.registr();
        intorg.addCommands();
        intorg.setScene();
        FlowPane root = new FlowPane(group,group1);
        root.setBackground(new Background(new BackgroundFill(Color.CYAN, null, null))); // задаётся цвет фона
        Scene scene = new Scene(root,1000,700);
        currentUser.setOnAction(e->
        {
            if (getLogin.length()==0){
                user.setText(s1);
            }else {
                user.setText(getLogin);
            }
        });
        buttonGetHelp.setOnAction(e -> {
            CommandReader.s = "help";
            new CommandReader();
            FlowPane flowPane = new FlowPane();
            flowPane.setBackground(new Background(new BackgroundFill(Color.CYAN, null, null)));
            Scene secondScene = new Scene(flowPane, 565, 300);
            Stage newWindow = new Stage();
            newWindow.setTitle("HELP");
            newWindow.getIcons().add(new Image("help.png"));
            newWindow.setScene(secondScene);
            newWindow.show();
            flowPane.getChildren().add(textHelp);
        });
        primaryStage.setTitle("Клиент с графическим интерфейсом пользователя");
        primaryStage.setScene(scene);
        primaryStage.getIcons().add(new Image("company_logo.png"));
        primaryStage.show();
        buttonBox.setSpacing(10);
        buttonBox.getChildren().add(commandBox);
        buttonBox.getChildren().add(buttonGetInfo);
        Image image1 = new Image(getClass().getResourceAsStream("images.png"));
        buttonBox.getChildren().add(new ImageView(image1));
        buttonBox.getChildren().add(buttonGetHelp);
        Image image = new Image(getClass().getResourceAsStream("help.png"));
        buttonBox.getChildren().add(new ImageView(image));
        intorg.setLanguage();
        Image image2 = new Image(getClass().getResourceAsStream("language.png"));
        hBox.getChildren().add(new ImageView(image2));
        buttonBox.getChildren().add(buttonShow);
        Image image3 = new Image(getClass().getResourceAsStream("show.png"));
        buttonBox.getChildren().add(new ImageView(image3));
        buttonBox.getChildren().add(buttonVisual);
        Image image4 = new Image(getClass().getResourceAsStream("visual.png"));
        buttonBox.getChildren().add(new ImageView(image4));


        buttonGetLanguage.setOnAction(e -> {
            String string = languageBox.getSelectionModel().getSelectedItem();
            if (string == "Portugal") {
                primaryStage.setTitle("GUI client");
                localize.setPortugal();
            } else if (string == "Svenska") {
                primaryStage.setTitle("GUI-klient");
                localize.setSwedish();
            } else if (string == "Русский") {
                primaryStage.setTitle("Клиент с графическим интерфейсом пользователя");
                localize.setRussian();
            } else if (string == "Română") {
                primaryStage.setTitle("Client GUI");
                localize.setRomanian();
            }
        });
        buttonSendId.setOnAction(ep -> {
            if (string == "filter_greater_than_height") {
                if ((toRemove.getText() == "") || (toRemove.getText().trim().length() == 0) || (!toRemove.getText().matches("[\\d]+"))) {
                    text66.setText("Поле заполнено некорректно, повторите ввод");
                } else if ((Long.parseLong(toRemove.getText())) <= 0) {
                    text66.setText("Поле заполнено некорректно, повторите ввод");
                } else {
                    height = Long.parseLong(toRemove.getText());
                    remover.getChildren().remove(text6);
                    toRemove.clear();
                    remover.getChildren().remove(toRemove);
                    remover.getChildren().remove(buttonSendId);
                    remover.getChildren().remove(text66);
                    vBox.getChildren().remove(remover);
                    new CommandReader();
                }
            } else if (string == "execute_script") {
                if ((toRemove.getText() == "") || (toRemove.getText().trim().length() == 0)) {
                    text66.setText("Поле не может быть пустым");
                } else {
                    fileName = toRemove.getText();
                    remover.getChildren().remove(text6);
                    toRemove.clear();
                    remover.getChildren().remove(toRemove);
                    remover.getChildren().remove(buttonSendId);
                    remover.getChildren().remove(text66);
                    vBox.getChildren().remove(remover);
                    new CommandReader();
                    FlowPane flowPane = new FlowPane();
                    flowPane.setBackground(new Background(new BackgroundFill(Color.CYAN, null, null)));
                    ScrollPane scrollPane = new ScrollPane(textScript);
                    scrollPane.setPannable(true);
                    Scene secondScene = new Scene(scrollPane, 565, 300);
                    Stage newWindow = new Stage();
                    newWindow.setTitle("SCRIPT");
                    newWindow.getIcons().add(new Image("visual.png"));
                    newWindow.setScene(secondScene);
                    newWindow.show();
                }
            }else if (string == "add_name") {
                if ((toAdd.getText() == "")||(toAdd.getText().trim().length() == 0)){
                    text6.setText("Поле name не может быть пустым");
                }else {
                    if (s == "add") {

                        flat.setName(toAdd.getText());
                        fl.setName(toAdd.getText());
                        string = "add_area";
                        adder.setSpacing(20);
                        text6.setText("Введите площадь квартиры:");
                        buttonSendId.setText("Подтвердить");
                        intorg.dublicatedPart();
                    } else if (s == "update_id"){
                        fl.setName(toAdd.getText());
                        flat.setName(toAdd.getText());
                        string = "add_area";
                        adder1.setSpacing(20);
                        text6.setText("Введите площадь квартиры:");
                        buttonSendId.setText("Подтвердить");
                        intorg.dublicatedPart0();
                    }

                }
            }else if (string == "add_area") {
                if ((toAdd.getText() == "")|| (toAdd.getText().trim().length() == 0) || (!toAdd.getText().matches("[\\d]+"))) {
                    text6.setText("Поле не может быть пустым и не может содержать букв");
                } else if (Long.parseLong(toAdd.getText()) <= 0) {
                    text6.setText("Площадь не может быть отрицательной");
                } else {
                    if (s == "add") {
                        flat.setArea((double) Long.parseLong(toAdd.getText()));
                        fl.setArea((double) Long.parseLong(toAdd.getText()));
                        string = "add_numberOfRooms";
                        adder.setSpacing(20);
                        text6.setText("Введите количество комнат:");
                        buttonSendId.setText("Подтвердить");
                        intorg.dublicatedPart();
                    } else if (s == "update_id"){
                        fl.setArea((double) Long.parseLong(toAdd.getText()));
                        string = "add_numberOfRooms";
                        adder1.setSpacing(20);
                        text6.setText("Введите количество комнат:");
                        buttonSendId.setText("Подтвердить");
                        intorg.dublicatedPart0();
                    }
                }
            } else if (string == "add_numberOfRooms") {
                if ((toAdd.getText() == "") || (toAdd.getText().trim().length() == 0) || (!toAdd.getText().matches("[\\d]+"))) {
                    text6.setText("Количество комнат не может быть пустым\n" +
                            " и не может содержать букв");
                } else if (Long.parseLong(toAdd.getText()) <= 0) {
                    text6.setText("Количество комнат не может\n" +
                            " быть отрицательным");
                } else {
                    if (s == "add") {
                        flat.setNumberOfRooms(Long.parseLong(toAdd.getText()));
                        fl.setNumberOfRooms(Long.parseLong(toAdd.getText()));
                        string = "add_furnish";
                        adder.setSpacing(20);
                        text6.setText("Выберите отделку квартиры:");
                        buttonSendId.setText("Подтвердить");
                        toAdd.clear();
                        adder.getChildren().remove(text6);
                        adder.getChildren().remove(buttonSendId);
                        vBox.getChildren().remove(adder);
                        adder.getChildren().remove(toAdd);
                        adder.getChildren().add(text6);
                        adder.getChildren().add(furnishBox);
                        adder.getChildren().add(buttonSendId);
                        vBox.getChildren().add(adder);
                    } else if (s == "update_id"){
                        fl.setNumberOfRooms(Long.parseLong(toAdd.getText()));
                        string = "add_furnish";
                        adder1.setSpacing(20);
                        text6.setText("Выберите отделку квартиры:");
                        buttonSendId.setText("Подтвердить");
                        toAdd.clear();
                        adder1.getChildren().remove(text6);
                        adder1.getChildren().remove(buttonSendId);
                        vBox1.getChildren().remove(adder1);
                        adder1.getChildren().remove(toAdd);
                        adder1.getChildren().add(text6);
                        adder1.getChildren().add(furnishBox);
                        adder1.getChildren().add(buttonSendId);
                        vBox1.getChildren().add(adder1);
                    }
                }
            } else if (string == "add_furnish") {
                String strin = furnishBox.getSelectionModel().getSelectedItem();
                if ((strin == null)|| (strin == "") || (strin.trim().length() == 0)){
                    text6.setText("Выберите отделку квартиры");
                } else {
                    if (s == "add") {
                        flat.setFurnish(strin);
                        string = "add_transport";
                        adder.getChildren().remove(text6);
                        adder.getChildren().remove(furnishBox);
                        adder.getChildren().remove(buttonSendId);
                        vBox.getChildren().remove(adder);
                        text6.setText("Выберите активность движения автомобилей за окном:");
                        adder.getChildren().add(text6);
                        buttonSendId.setText("Подтвердить");
                        adder.getChildren().add(transportBox);
                        adder.getChildren().add(buttonSendId);
                        vBox.getChildren().add(adder);
                    } else if (s == "update_id"){
                        fl.setFurnish(strin);
                        string = "add_transport";
                        adder1.getChildren().remove(text6);
                        adder1.getChildren().remove(furnishBox);
                        adder1.getChildren().remove(buttonSendId);
                        vBox1.getChildren().remove(adder1);
                        text6.setText("Выберите активность движения автомобилей за окном:");
                        adder1.getChildren().add(text6);
                        buttonSendId.setText("Подтвердить");
                        adder1.getChildren().add(transportBox);
                        adder1.getChildren().add(buttonSendId);
                        vBox1.getChildren().add(adder1);
                    }
                }
            } else if (string == "add_transport") {
               String str = transportBox.getSelectionModel().getSelectedItem();

                if ((str == null)|| (str == "") || (str.trim().length() == 0)) {
                    text6.setText("транспорт не выбран,\n" +
                            " не может быть null");
                } else {
                    if (s == "add") {
                        flat.setTransport(str);
                       // fl.setTransport(str);
                        string = "add_x";
                        adder.setSpacing(20);
                        text6.setText("Введите x (Coordinate)");
                        buttonSendId.setText("Подтвердить");
                        adder.getChildren().remove(transportBox);
                        intorg.dublicatedPart();
                    } else if (s == "update_id"){
                        fl.setTransport(str);
                        string = "add_x";
                        adder1.setSpacing(20);
                        text6.setText("Введите x (Coordinate)");
                        buttonSendId.setText("Подтвердить");
                        adder1.getChildren().remove(transportBox);
                        intorg.dublicatedPart0();
                    }
                }
            } else if (string == "add_x") {
                if ((toAdd.getText() == "") || (toAdd.getText().trim().length() == 0) || (!toAdd.getText().matches("[\\d]+"))) {
                    text6.setText("Поле x не может быть пустым\n" +
                            " и не может содержать букв");
                } else {
                    x = Double.parseDouble(toAdd.getText());
                    string = "add_numberOfRooms";
                    if (s == "add") {
                        adder.setSpacing(20);
                        text6.setText("Введите y (Coordinate)");
                        buttonSendId.setText("Подтвердить");
                        intorg.dublicatedPart();
                        string = "add_y";
                    } else if (s == "update_id"){
                        adder1.setSpacing(20);
                        text6.setText("Введите y (Coordinate)");
                        buttonSendId.setText("Подтвердить");
                        intorg.dublicatedPart0();
                        string = "add_y";
                    }
                }
            } else if (string == "add_y") {
                if (!toAdd.getText().matches("[\\d]+")) {
                    text6.setText("Поле y не может содержать букв");
                } else {
                    text6.setText("Введите название дома");
                    string = "add_house_name";
                    buttonSendId.setText("Подтвердить");
                    y = Double.parseDouble(toAdd.getText());
                    if (s == "add") {
                        intorg.dublicatedPart();
                        flat.setCoordinates(x,  y);
                        fl.setCoordinates(x,  y);
                    } else if (s == "update_id"){
                        intorg.dublicatedPart0();
                        fl.setCoordinates(x,  y);
                    }
                }
            } else if (string == "add_house_name") {
                if ((toAdd.getText() == "") || (toAdd.getText().trim().length() == 0)) {
                    text6.setText("Поле house_name\n" +
                            " не может быть пустым");
                } else {
                    house = toAdd.getText();
                    string = "add_house_age";
                    if (s == "add"){
                        adder.setSpacing(20);
                        text6.setText("Введите возраст дома");
                        buttonSendId.setText("Подтвердить");
                        intorg.dublicatedPart();
                    } else if (s == "update_id"){
                        adder1.setSpacing(20);
                        text6.setText("Введите возраст дома");
                        buttonSendId.setText("Подтвердить");
                        intorg.dublicatedPart0();
                    }
                }
            } else if (string == "add_house_age") {
                if ((toAdd.getText() == "") || (toAdd.getText().trim().length() == 0)) {
                    text6.setText("Поле house_age\n" +
                            " не может быть пустым ");
                } else {
                    marines= Integer.valueOf(toAdd.getText());
                    string = "add_house_numberOfLifts";
                    if (s == "add"){
                        adder.setSpacing(20);
                        text6.setText("Введите количество лифтов в доме");
                        buttonSendId.setText("Подтвердить");
                        intorg.dublicatedPart();
                    } else if (s == "update_id"){
                        adder1.setSpacing(20);
                        text6.setText("Введите количество лифтов в доме");
                        buttonSendId.setText("Подтвердить");
                        intorg.dublicatedPart0();
                    }
                }
            }
            else if (string == "add_house_numberOfLifts"){
                if ((!toAdd.getText().matches("[\\d]+"))) {
                    text6.setText("Поле house_numberOfLifts\n" +
                            " не может содержать букв");
                } else if ((Long.parseLong(toAdd.getText()) <= 0) || (Long.parseLong(toAdd.getText()) > 20)) {
                    text6.setText("количество лифтов в доме\n" +
                            " должен быть больше 0,\n" +
                            " Максимальное количество лифтов в доме: 20");
                } else {
                    marines2 = Integer.parseInt(toAdd.getText());
                    if (s == "add") {
                        flat.setHouseType(house, marines, marines2);
                        flat.setCreationDate();
                        fl.setHouseType(house, marines, marines2);
                        fl.setCreationDate();
                       // flat.setView();
                        //flat.setTransport(str);
                       // flat.setFurnish();
                        adder.getChildren().remove(text6);
                        adder.getChildren().remove(buttonSendId);
                        vBox.getChildren().remove(adder);
                        toAdd.clear();
                        adder.getChildren().remove(toAdd);
                        new CommandReader();
                    } else if (s == "updated_id"){
                        fl.setHouseType(house, marines, marines2);
                        fl.setCreationDate();
                        adder1.getChildren().remove(text6);
                        adder1.getChildren().remove(buttonSendId);
                        vBox1.getChildren().remove(adder1);
                        toAdd.clear();
                        adder1.getChildren().remove(toAdd);
                        new CommandReader();
                    }
                }
            } else {
                if ((toRemove.getText() == "") || (toRemove.getText().trim().length() == 0) || (!toRemove.getText().matches("[\\d]+"))) {
                    text66.setText("Поле заполнено некорректно, повторите ввод");
                } else if ((Integer.parseInt(toRemove.getText())) <= 0) {
                    text66.setText("Поле заполнено некорректно, повторите ввод");
                } else {
                    removeId = Long.parseLong(toRemove.getText());
                    toAdd.clear();
                    remover.getChildren().remove(text6);
                    toRemove.clear();
                    remover.getChildren().remove(toRemove);
                    remover.getChildren().remove(buttonSendId);
                    remover.getChildren().remove(text66);
                    vBox.getChildren().remove(remover);
                    new CommandReader();
                }
            }
        });
        buttonGetInfo.setOnAction(e -> {
            s = commandBox.getSelectionModel().getSelectedItem();
            if (CommandReader.s != null) {
                if (s == "remove_by_id"){
                    textInfo.setText(null);
                    string =  "remove_by_id";
                    text6.setText("Введите id объекта, который хотите удалить.");
                    intorg.dublicatedPart2();
                }/*else if (s == "filter_greater_than_height"){
                    textInfo.setText(null);
                    string = "filter_greater_than_height";
                    text6.setText("Введите граничное значение для поля height");
                    intorg.dublicatedPart2();
                } */else if (s == "remove_greater") {
                    textInfo.setText(null);
                    string = "remove_greater";
                    text6.setText("Введите id граничного элемента.");
                    intorg.dublicatedPart2();
                } else if (s == "remove_lower") {

                    textInfo.setText(null);
                    string = "remove_lower";
                    text6.setText("Введите id граничного элемента.");
                    intorg.dublicatedPart2();
                } else if (s == "remove_by_house_age") {
                    string = "remove_by_house_age";
                    text6.setText("Введите возраст дома для его удаления элемента");
                    intorg.dublicatedPart2();
                }
                else if (s == "update_id") {
                    textInfo.setText(null);
                    string = "add_name";
                    adder.setSpacing(20);
                    text6.setText("Введите имя новой квартиры");
                    adder1.getChildren().remove(text6);
                    adder1.getChildren().add(text6);
                    buttonSendId.setText("Подтвердить");
                    adder1.getChildren().add(toAdd);
                    adder1.getChildren().add(buttonSendId);
                    vBox.getChildren().add(adder1);
                } else if (s == "add") {

                    textInfo.setText(null);
                    string = "add_name";
                    adder.setSpacing(20);
                    text6.setText("Введите имя новой квартиры");
                    adder.getChildren().remove(text6);
                    adder.getChildren().add(text6);
                    buttonSendId.setText("Подтвердить");
                   adder.getChildren().add(toAdd);
                    adder.getChildren().add(buttonSendId);
                    vBox.getChildren().add(adder);
                } else if (s == "execute_script") {
                    text6.setText("Введите имя файла с расширением .txt");
                    string = "execute_script";
                    intorg.getScriptName();
                } else{
                    new CommandReader();
                }
            } else {
                textInfo.setText(s2);
            }
        });
        buttonShow.setOnAction(e -> {
            vBox.getChildren().remove(tableView);
            textInfo.setText("Для появления таблицы нажмите ещё раз на кнопку SHOW");
            s = "show";
            new CommandReader();

            if (flag == "finish") {
                textInfo.setText("Для сортировки таблицы нажмите на название столбца с числовыми значениями\n" +
                        "поля id, creationDate и login не редактируются, для редактирования остальных\n" +
                        "дважды щёлкните по ячейке, а после нажмите enter.\n" +
                        "Если вводится некорректное значение, то поле не изменится и надо будет обновить таблицу.");
                ObservableList<Flat> flattyy = FXCollections.observableArrayList();
                flattyy.stream().filter(p->p.getLogin().length()<50).sorted();
                flattyy.stream().filter(p->p.getName().length()<50).sorted();
                flattyy.stream().filter(p->p.getHouse().getHouseName().length()<50).sorted();

                tableView = new TableView(flattyy);
                tableView.setEditable(true);
                TableColumn<Flat, String> column1 = new TableColumn<>("name");
                TableColumn<String, Flat> column2 = new TableColumn<>("id");
                TableColumn<Flat, Number> column3 = new TableColumn<>("area");
                TableColumn<Flat, Number> column4 = new TableColumn<>("numberOfRooms");
                TableColumn<Flat, Furnish> column5 = new TableColumn<>("furnish");
                TableColumn<Flat, Transport> column6 = new TableColumn<>("transport");
                TableColumn<Flat, View> column7 = new TableColumn<>("view");
                TableColumn<Flat, String> housename = new TableColumn<>("houseName");
                TableColumn<Flat, Integer> age = new TableColumn<>("houseAge");
                TableColumn<Flat, Integer>  lifts= new TableColumn<>("lifts");
                TableColumn<String, Flat> column9 = new TableColumn<>("login");
                TableColumn<Flat, Double> x = new TableColumn<>("x");
                TableColumn<Flat, Double> y = new TableColumn<>("y");
                for (Flat s : flats) {
                    flattyy.add(s);
                }

                column1.setCellValueFactory(new PropertyValueFactory<>("name"));
                column2.setCellValueFactory(new PropertyValueFactory<>("id"));
                column3.setCellValueFactory(new PropertyValueFactory<>("area"));
                column4.setCellValueFactory(new PropertyValueFactory<>("numberOfRooms"));
                column5.setCellValueFactory(new PropertyValueFactory<>("furnish"));
                column6.setCellValueFactory(new PropertyValueFactory<>("transport"));
                column7.setCellValueFactory(new PropertyValueFactory<>("view"));
                x.setCellValueFactory(new PropertyValueFactory<>("x"));
                y.setCellValueFactory(new PropertyValueFactory<>("y"));
                housename.setCellValueFactory(new PropertyValueFactory<>("houseName"));
                lifts.setCellValueFactory(new PropertyValueFactory<>("lifts"));
                age.setCellValueFactory(new PropertyValueFactory<>("houseAge"));
                column9.setCellValueFactory(new PropertyValueFactory<>("login"));

                tableView.getColumns().add(column1);
                tableView.getColumns().add(column2);
                tableView.getColumns().add(column3);
                tableView.getColumns().add(column4);
                tableView.getColumns().add(column5);
                tableView.getColumns().add(column6);
                tableView.getColumns().add(column7);
                tableView.getColumns().addAll(x,y);
                tableView.getColumns().addAll(housename,age,lifts);
                tableView.getColumns().add(column9);
                tableView.setMinSize(900, 250);
                tableView.setMaxSize(900, 300);
                vBox.getChildren().add(tableView);
                column1.setCellFactory(TextFieldTableCell.<Flat> forTableColumn());
                column1.setOnEditCommit((TableColumn.CellEditEvent<Flat, String> event) -> {
                    TablePosition<Flat, String> pos = event.getTablePosition();
                    String newName = event.getNewValue();
                    if ((newName == "")||(newName.trim().length() == 0)){
                        textInfo.setText("Поле name не может быть пустым");
                    } else {
                        int row = pos.getRow();
                        fl = event.getTableView().getItems().get(row);
                        fl.setName(newName);
                        fl.setCreationDate();
                        id2send = fl.getId();
                        System.out.println(id2send);
                        s = "update_id";
                        new CommandReader();
                    }
                });
                column3.setCellFactory(TextFieldTableCell.<Flat, Number> forTableColumn(new NumberStringConverter()));
                column3.setOnEditCommit((TableColumn.CellEditEvent<Flat, Number> event) -> {
                    TablePosition<Flat, Number> pos = event.getTablePosition();
                    Number height = event.getNewValue();
                    if ((height == null)){
                        textInfo.setText("Поле area не может быть пустым");
                    } else {
                        int row = pos.getRow();
                        Double lh = Double.parseDouble(height.toString());
                        fl = event.getTableView().getItems().get(row);
                        fl.setArea(lh);
                        fl.setCreationDate();
                        id2send = fl.getId();
                        s = "update_id";
                        new CommandReader();
                    }
                });
                column4.setCellFactory(TextFieldTableCell.<Flat, Number> forTableColumn(new NumberStringConverter()));
                column4.setOnEditCommit((TableColumn.CellEditEvent<Flat, Number> event) -> {
                    TablePosition<Flat, Number> pos = event.getTablePosition();
                    Number health = event.getNewValue();
                    if (health == null){
                        textInfo.setText("Поле rooms не может быть пустым");
                    } else {
                        int row = pos.getRow();
                        Long lh = Long.parseLong(health.toString());
                        if (lh <= 0){
                            textInfo.setText("Поле rooms не может быть отрицательным");
                        }else {
                            fl = event.getTableView().getItems().get(row);
                            fl.setNumberOfRooms(lh);
                            fl.setCreationDate();
                            id2send = fl.getId();
                            s = "update_id";
                            new CommandReader();
                        }
                    }
                });
                ObservableList<Furnish> weaponList = FXCollections.observableArrayList(Furnish.values());
                column5.setCellFactory(ComboBoxTableCell.<Flat, Furnish> forTableColumn(weaponList));
                column5.setOnEditCommit((TableColumn.CellEditEvent<Flat, Furnish> event) -> {
                    TablePosition<Flat, Furnish> pos = event.getTablePosition();
                    Furnish newName = event.getNewValue();
                    System.out.println(newName);
                    int row = pos.getRow();
                    fl = event.getTableView().getItems().get(row);
                    fl.setFurnish(newName.toString());
                    fl.setCreationDate();
                    id2send = fl.getId();

                    s = "update_id";
                    new CommandReader();
                });
                ObservableList<Transport> meleeWeaponList = FXCollections.observableArrayList(Transport.values());
                column6.setCellFactory(ComboBoxTableCell.<Flat, Transport> forTableColumn(meleeWeaponList));
                column6.setOnEditCommit((TableColumn.CellEditEvent<Flat, Transport> event) -> {
                    TablePosition<Flat, Transport> pos = event.getTablePosition();
                    Transport newName = event.getNewValue();
                    System.out.println(newName);
                    int row = pos.getRow();
                    fl = event.getTableView().getItems().get(row);
                    fl.setTransport(newName.toString());
                    fl.setCreationDate();
                    id2send = fl.getId();
                    s = "update_id";
                    new CommandReader();
                });
                ObservableList<View> transportssss = FXCollections.observableArrayList(View.values());
                column7.setCellFactory(ComboBoxTableCell.<Flat, View> forTableColumn(transportssss));
                column7.setOnEditCommit((TableColumn.CellEditEvent<Flat, View> event) -> {
                    TablePosition<Flat, View> pos = event.getTablePosition();
                    View newName = event.getNewValue();
                    int row = pos.getRow();
                    fl = event.getTableView().getItems().get(row);
                    fl.setView(newName.toString());
                    fl.setCreationDate();
                    id2send = fl.getId();
                    s = "update_id";
                    new CommandReader();
                });
                x.setCellFactory(TextFieldTableCell.<Flat, Double> forTableColumn(new DoubleStringConverter()));
                x.setOnEditCommit((TableColumn.CellEditEvent<Flat, Double> event) -> {
                    TablePosition<Flat, Double> pos = event.getTablePosition();
                    Double xx = event.getNewValue();
                    if ((xx == null)){
                        textInfo.setText("Поле x не может быть пустым");
                    } else {
                        int row = pos.getRow();
                        fl = event.getTableView().getItems().get(row);
                        Double f = fl.getY();
                        fl.setCoordinates(xx, f);
                        fl.setCreationDate();
                        id2send = fl.getId();
                        s = "update_id";
                        new CommandReader();
                    }
                });
                y.setCellFactory(TextFieldTableCell.<Flat, Double> forTableColumn(new DoubleStringConverter()));
                y.setOnEditCommit((TableColumn.CellEditEvent<Flat, Double> event) -> {
                    TablePosition<Flat, Double> pos = event.getTablePosition();
                    Double yy = event.getNewValue();
                    if ((yy == null)){
                        textInfo.setText("Поле y не может быть пустым");
                    } else {
                        int row = pos.getRow();
                        fl = event.getTableView().getItems().get(row);
                        Double f = fl.getX();
                        fl.setCoordinates(f,yy);
                        fl.setCreationDate();
                        id2send = fl.getId();
                        s = "update_id";
                        new CommandReader();
                    }
                });
                age.setCellFactory(TextFieldTableCell.<Flat, Integer> forTableColumn(new IntegerStringConverter()));
                age.setOnEditCommit((TableColumn.CellEditEvent<Flat, Integer> event) -> {
                    TablePosition<Flat, Integer> pos = event.getTablePosition();
                    Integer count = Math.toIntExact(event.getNewValue());
                    Integer count2 = Math.toIntExact(event.getNewValue());
                    if ((count == null)){
                        textInfo.setText("Поле age не может быть пустым");
                    } else if ((count <= 0)||(count > 1000)){
                        textInfo.setText("Поле age должно быть больше 0, Максимальное значение поля: 1000");
                    } else {
                        int row = pos.getRow();
                        fl = event.getTableView().getItems().get(row);
                        String n = fl.getHouse().getHouseName();
                        System.out.println(n);
                        fl.setHouseType(n,count, count2 );
                        fl.setCreationDate();
                        id2send = fl.getId();
                        s = "update_id";
                        new CommandReader();
                    }
                });
                housename.setCellFactory(TextFieldTableCell.<Flat> forTableColumn());
                housename.setOnEditCommit((TableColumn.CellEditEvent<Flat, String> event) -> {
                    TablePosition<Flat, String> pos = event.getTablePosition();
                    String newName = event.getNewValue();
                    if ((newName == "")||(newName.trim().length() == 0)){
                        textInfo.setText("Поле housename не может быть пустым");
                    } else {
                        int row = pos.getRow();
                        fl = event.getTableView().getItems().get(row);
                        Integer xr = fl.getHouse().getYear();
                        Integer xr2 = fl.getHouse().getNumberOfLifts();

                        fl.setHouseType(newName,xr, xr2);
                        fl.setCreationDate();
                        id2send = fl.getId();
                        s = "update_id";
                        new CommandReader();
                    }
                });
                FilteredList<Flat> filteredData = new FilteredList(flattyy);
                SortedList<Flat> sortableData = new SortedList<>(filteredData);
                tableView.setItems(sortableData);
                sortableData.comparatorProperty().bind(tableView.comparatorProperty());
                try {
                    buttonBox.getChildren().add(buttonEndShow);
                    buttonEndShow.setOnAction(exp -> {
                        tableView.getColumns().remove(column1);
                        tableView.getColumns().remove(column2);
                        tableView.getColumns().remove(column3);
                        tableView.getColumns().remove(column4);
                        tableView.getColumns().remove(column5);
                        tableView.getColumns().remove(column6);
                        tableView.getColumns().remove(x);
                        tableView.getColumns().remove(y);
                        tableView.getColumns().remove(housename);
                        tableView.getColumns().remove(age);
                        tableView.getColumns().remove(column9);
                        vBox.getChildren().remove(tableView);
                        buttonBox.getChildren().remove(buttonEndShow);
                        flag = "";
                        textInfo.setText(null);
                    });
                }catch(IllegalArgumentException ex){}
            }
        });
        buttonVisual.setOnAction(act ->{
            if (userFlag != "finish") {
                s = "users";
                new CommandReader();
                textInfo.setText("Для появления квартир нажмите трижды на кнопку КВАРТИРЫ");
            }
            if (userFlag == "finish") {
                s = "show";
                new CommandReader();
                textInfo.setText("Для появления квартир нажмите ещё раз на кнопку КВАРТИРЫ");
                if (flag == "finish") {
                    Group group = new Group();
                    PannableCanvas canvas = new PannableCanvas();
                    canvas.setTranslateX(100);
                    canvas.setTranslateY(100);
                    NodeGestures nodeGestures = new NodeGestures(canvas);
                    Label label = new Label("Для перемещения по сетке удерживайте правую кнопку\n" +
                            "Для увеличения и уменьшения поддерживается функция зума");
                    label.setTranslateX(60);
                    label.setTranslateY(60);

                    List<String> loginSet = new ArrayList<>(ReceiveDataFromServer.loginList);
                    List<ColorSet> colorSetList = new ArrayList<>();
                    for (String s: loginSet){
                        Random rand = new Random();
                        float r = rand.nextFloat();
                        float g = rand.nextFloat();
                        float b = rand.nextFloat();
                        Color randomColor = new Color(r, g, b, 1);
                        ColorSet colorSet = new ColorSet(s, randomColor);
                        colorSetList.add(colorSet);
                    }

                    for (Flat s : flats) {
                        Circle circle = new Circle();
                        for (ColorSet c: colorSetList){
                            if (s.getLogin().trim().equals(c.getLogin().trim())){
                                circle.setStroke(c.getColor());
                            }
                        }

                        if (s.getArea() > 10000) {
                            circle.setRadius(60);
                        } else {
                            circle.setRadius(30);
                        }
                        circle.setTranslateX(s.getX());
                        circle.setTranslateY(s.getY());
                        canvas.getChildren().addAll(circle);

                        circle.setFill(Color.ORANGE);
                        circle.setStrokeWidth(10);
                        circle.addEventFilter(MouseEvent.MOUSE_PRESSED, nodeGestures.getOnMousePressedEventHandler());
                        circle.addEventFilter(MouseEvent.MOUSE_DRAGGED, nodeGestures.getOnMouseDraggedEventHandler());

                    }
                    canvas.getChildren().add(label);
                    group.getChildren().add(canvas);
                    Scene scene33 = new Scene(group, 660, 660);
                    SceneGestures sceneGestures = new SceneGestures(canvas);
                    scene33.addEventFilter(MouseEvent.MOUSE_PRESSED, sceneGestures.getOnMousePressedEventHandler());
                    scene33.addEventFilter(MouseEvent.MOUSE_DRAGGED, sceneGestures.getOnMouseDraggedEventHandler());
                    scene33.addEventFilter(ScrollEvent.ANY, sceneGestures.getOnScrollEventHandler());
                    Stage newWindow = new Stage();
                    newWindow.setScene(scene33);
                    newWindow.setTitle("КВАРТИРЫ");
                    newWindow.getIcons().add(new Image("visual.png"));
                    newWindow.show();
                    canvas.addGrid(5000, 5000);
                    EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent e) {
                            for (Flat s : flats) {
                                if (s.getArea() > 10000) {
                                    if ((e.getX() >= s.getX() - 60) && (e.getX() <= s.getX() + 60) && (e.getY() >= s.getY() - 60) && (e.getY() <= s.getY() + 60)) {
                                        Text t = new Text();
                                        t.setText(s.toString());
                                        FlowPane flowPane = new FlowPane();
                                        flowPane.getChildren().add(t);
                                        flowPane.getChildren().add(editButton);
                                        flowPane.getChildren().add(vBox1);
                                        vBox1.setSpacing(20);
                                        flowPane.setBackground(new Background(new BackgroundFill(Color.CYAN, null, null)));
                                        editButton.setOnAction(acr -> {
                                            CommandReader.s = "update_id";
                                            id2send = s.getId();
                                            textInfo.setText(null);
                                            string = "add_name";
                                            adder1.setSpacing(20);
                                            text6.setText("Введите новое имя");
                                            adder1.getChildren().remove(text6);
                                            adder1.getChildren().add(text6);
                                            buttonSendId.setText("Подтвердить");
                                            adder1.getChildren().add(toAdd);
                                            adder1.getChildren().add(buttonSendId);
                                            vBox1.getChildren().add(adder1);
                                        });
                                        Scene thirdScene = new Scene(flowPane, 600, 400);
                                        Stage wind = new Stage();
                                        wind.setScene(thirdScene);
                                        wind.show();
                                    }
                                } else {
                                    if ((e.getX() >= s.getX() - 30) && (e.getX() <= s.getX() + 30) && (e.getY() >= s.getY() - 30) && (e.getY() <= s.getY() + 30)) {
                                        Text t = new Text();
                                        t.setText(s.toString());
                                        FlowPane flowPane = new FlowPane();
                                        flowPane.getChildren().add(t);
                                        flowPane.getChildren().add(editButton);
                                        flowPane.getChildren().add(vBox1);
                                        vBox1.setSpacing(20);
                                        flowPane.setBackground(new Background(new BackgroundFill(Color.CYAN, null, null)));
                                        editButton.setOnAction(acr -> {
                                            CommandReader.s = "update_id";
                                            id2send = s.getId();
                                            textInfo.setText(null);
                                            string = "add_name";
                                            adder1.setSpacing(20);
                                            text6.setText("Введите новое имя");
                                            adder1.getChildren().remove(text6);
                                            adder1.getChildren().add(text6);
                                            buttonSendId.setText("Подтвердить");
                                            adder1.getChildren().add(toAdd);
                                            adder1.getChildren().add(buttonSendId);
                                            vBox1.getChildren().add(adder1);
                                        });
                                        Scene thirdScene = new Scene(flowPane, 600, 400);
                                        Stage wind = new Stage();
                                        wind.setScene(thirdScene);
                                        wind.show();
                                    }
                                }
                            }
                        }
                    };
                    canvas.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
                    textInfo.setText(null);
                }
            }
        });
    }
}