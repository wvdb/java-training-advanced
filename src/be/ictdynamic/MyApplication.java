package be.ictdynamic;

import be.ictdynamic.domain.Department;
import be.ictdynamic.oefeningGenerics_0.OefeningGenerics;
import be.ictdynamic.oefeningStreams_1.OefeningStreams;

import java.util.Scanner;

public class MyApplication {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.println("Geef identifier van de oefening: ");
        int oefeningInteger = reader.nextInt();

        switch (oefeningInteger) {
            case 0:
                MyApplication.oefeningGenerics();
                break;
            case 1:
                MyApplication.oefeningStreams();
                break;
            default :
                System.out.println("!!!Geen oefening voorzien.");
        }

        reader.close();
    }

    private static void oefeningGenerics() {
        OefeningGenerics.demoBasic();
        OefeningGenerics.demo0();
        OefeningGenerics.demo1();
    }

    private static void oefeningStreams() {
        OefeningStreams oefeningStreams = new OefeningStreams();
        oefeningStreams.exec();
    }

}
