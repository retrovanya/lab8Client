package Auth;

import javafx.scene.control.Button;
import javafx.scene.text.Text;
public class Localize {
    public static Text text1 = new Text("Сменить язык:");
    public static Text text2 = new Text("Логин: ");
    public static Text text3 = new Text("Пароль: ");
    public static Text text4 = new Text("Выберите команду: ");
    public static Text text5 = new Text("Для начала\n" +
            "работы необходимо\n" +
            "зарегистрироваться/\n" +
            "авторизоваться ");
    public static String s1 = "Гость";
    public static String s2 = "Команда не выбрана";
    public static Button buttonGetInfo = new Button("Выбрать");
    public static Button buttonGetLanguage = new Button("Выбрать");
    public static Button buttonAddUser = new Button("Войти/\n"
            +"Зарегистроваться");
    public static Button buttonGetHelp = new Button("ПОМОЩЬ");
    public static Button currentUser = new Button("Узнать текущего пользователя");
    public static Button editButton = new Button("Редактировать этот элемент");
    public static Button buttonClear = new Button("Очистить коллекцию");
    public static Button buttonSendId = new Button("Отправить");
    public static Button buttonShow = new Button("SHOW");
    public static Button buttonEndShow = new Button("Закрыть таблицу\n"+
            "(для корректоного отображения\n"+
            "при редактировании/добавлении эл-тов)");

    public static Button buttonVisual = new Button("КВАРТИРЫ");
    public Localize(){}
    public void setPortugal(){
        editButton.setText("Editar este item");
        buttonGetHelp.setText("Socorro");
        buttonAddUser.setText("\n" +
                "faça login/\n" + "\n" +
                "registrar");
        buttonGetLanguage.setText("\n" +
                "escolher");
        buttonClear.setText("\n" +
                "Claro");
        buttonVisual.setText("APARTAMENTOS");
        buttonSendId.setText("\n" +
                "enviar");
        buttonShow.setText("\n" +
                "MOSTRAR");
        buttonEndShow.setText("\n" +
                "fechar tabela \n" +
                "(for correct display when\n" +
                " \n" +
                "adicionando itens de alteração)");
        buttonGetInfo.setText("\n" +
                "escolher");
        currentUser.setText("\n" +
                "obter usuário");
        text1.setText("\n" +
                "Mudar idioma:");
        text2.setText("Login:");
        text3.setText("Password:");
        text4.setText("\n" +
                "escolha equipe:");
        text5.setText("para começar você precisa\n" +
                "adicionando itens de alteração");
        s1 = "Guest";
        s2 = "\n" +
                "equipe não selecionada";
        CommandReader.locale = "Portugal";
    }
    public void setRussian(){
        buttonGetHelp.setText("ПОМОЩЬ");
        editButton.setText("Редактировать этот элемент");
        text1.setText("Сменить язык:");
        text2.setText("Логин: ");
        text3.setText("Пароль: ");
        text4.setText("Выберите команду: ");
        text5.setText("Для начала\n" +
                "работы необходимо\n" +
                "зарегистрироваться/\n" +
                "авторизоваться ");
        s1 = "Гость";
        s2 = "Команда не выбрана";
        buttonClear.setText("Очистить коллекцию");
        buttonVisual.setText("КВАРТИРЫ");
        buttonShow.setText("SHOW");
        buttonSendId.setText("Отправить");
        buttonEndShow.setText("Закрыть таблицу\n"+
                "(для корректоного отображения\n"+
                "при редактировании/добавлении эл-тов)");
        buttonGetInfo.setText("Выбрать");
        buttonGetLanguage.setText("Выбрать");
        buttonAddUser.setText("Войти/\n"
                +"Зарегистроваться");
        buttonGetHelp.setText("ПОМОЩЬ");
        currentUser.setText("Узнать текущего пользователя");
        CommandReader.locale = "Русский";
    }
    public void setRomanian(){
        editButton.setText("editați acest articol");
        buttonGetHelp.setText("AJUTOR");
        buttonAddUser.setText("A intra/\n" + "A înregistra");
        buttonGetLanguage.setText("Selectați");
        buttonGetInfo.setText("Selectați");
        buttonClear.setText("Colecție clară");
        currentUser.setText("Obțineți un utilizator curent:");
        buttonSendId.setText("Trimite");
        buttonShow.setText("spectacol");
        buttonEndShow.setText("Închideți tabelul (pentru\n" +
                " afișarea corectă la editarea /\n" +
                " adăugarea articolelor electronice)");
        buttonVisual.setText("QUARTIERES");
        text1.setText("Schimbați limba:");
        text2.setText("Autentificare:");
        text3.setText("Parola:");
        text4.setText("Alegeți comanda:");
        text5.setText("Pentru a începe munca, trebuie să\n" +
                "vă înregistrați / conectați");
        s1 = "Oaspetele";
        s2 = "Comanda nu este selectată";
        CommandReader.locale = "Română";
    }
    public void setSwedish(){
        buttonGetHelp.setText("HJÄLP");
        editButton.setText("redigera den här artikeln");
        buttonAddUser.setText("Logga in/\n" + "Registrera");
        buttonGetLanguage.setText("Välja");
        buttonGetInfo.setText("Välja");
        buttonEndShow.setText("Stäng tabellen (för korrekt\n" +
                " visning när du redigerar\n" +
                " / lägger till artiklar)");
        buttonShow.setText("visa");
        buttonSendId.setText("skicka");
        buttonClear.setText("klar");
        buttonVisual.setText("FARTYG");
        currentUser.setText("Skaffa aktuell användare");
        text1.setText("Ändra språk:");
        text2.setText("Logga in:");
        text3.setText("Lösenord:");
        text4.setText("Välj kommando:");
        text5.setText("För att starta arbetet måste\n" +
                "du registrera / logga in");
        s1 = "Gästen";
        s2 = "Kommando har inte valts";
        CommandReader.locale = "Svenska";
    }
}