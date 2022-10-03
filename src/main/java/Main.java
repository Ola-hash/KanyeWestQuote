import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Scanner;

public class Main {
    private static final String NEXT_COMMAND = "next";
    private static final String CLOSE_COMMAND = "close";
    private static final String INTERNET_NOT_CONNECTED_MESSAGE = "Internet nie jest podłączony";
    private static final String GOODBYE_MESSAGE = "Dowidzenia :)";
    private static final String UNSUPPORTED_COMMAND_MESSAGE = "Nieobsługiwana komenda";

    private static Scanner scanner;
    private static KanyeWestQuoteReader kanyeWestQuoteReader = null;

    public static void main(String[] args) {
        initKanyeWestQuoteReader();
        showMenu();
        readCommands();
    }

    private static void initKanyeWestQuoteReader() {
        try {
            kanyeWestQuoteReader = new KanyeWestQuoteReader();
        } catch (MalformedURLException e) {
            System.out.println(INTERNET_NOT_CONNECTED_MESSAGE);
            System.exit(0);
        }
    }

    private static void showMenu() {
        System.out.println("Witaj!");
        System.out.println("1) Aby pobrać nową perełkę mądrości od Kanye Westa :) napisz next i zatwierdź enterem.");
        System.out.println("2) Komenda close wyłącza program.");
    }

    private static void readCommands() {
        scanner = new Scanner(System.in);
        while (true) {
            String command = scanner.nextLine();
            if (NEXT_COMMAND.equals(command)) {
                try {
                    System.out.println(kanyeWestQuoteReader.readQuote());
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            } else if (CLOSE_COMMAND.equals(command)) {
                System.out.println(GOODBYE_MESSAGE);
                System.exit(0);
            } else {
                System.out.println(UNSUPPORTED_COMMAND_MESSAGE);
            }
        }
    }

}
