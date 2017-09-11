package be.ictdynamic;

import be.ictdynamic.oefeningStreams_1.OefeningStreams;

import java.util.Scanner;

public class MyApplication {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.println("Geef identifier van de oefening: ");
        int oefeningInteger = reader.nextInt();

        switch (oefeningInteger) {
            case 1:
                MyApplication.oefeningStreams();
                break;
            default :
                System.out.println("geen oefening voorzien");
        }

        reader.close();
    }

    private static void oefeningStreams() {
        OefeningStreams oefeningStreams = new OefeningStreams();
        oefeningStreams.exec();
    }

}
