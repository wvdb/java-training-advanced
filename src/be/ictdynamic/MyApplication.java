package be.ictdynamic;

import be.ictdynamic.oefeningStreams_20.OefeningStreams;

import java.util.Scanner;

public class MyApplication {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.println("Geef identifier van de oefening: ");
        int oefeningInteger = reader.nextInt();

        switch (oefeningInteger) {
            case 0:
                MyApplication.oefeningInheritance();
                break;
        }

        reader.close();
    }

    private static void oefeningInheritance() {
        OefeningStreams oefeningStreams = new OefeningStreams();
        oefeningStreams.exec();
    }

}
