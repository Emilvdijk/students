package nl.emilvdijk;


import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Scanner;


public class App {

  public static void main(String[] args){
    String ch;

    HashMap<String, Integer> students = new HashMap<>();
    Scanner myscanner = new Scanner(System.in);

    students.put("Jantje", 2);
    students.put("Eric", 13);
    students.put("Evelien", 2346);

    do {
      do {
        System.out.println("""
            Welkom in het studentendatabasesysteem.
            1 om een persoon toe te voegen
            2 om een persoon te verwijderen
            3 om alle personen te tonen
            'q' to quit""");
        ch = myscanner.nextLine();
      } while ((ch == "1") | (ch=="2") | (ch=="3") & (ch!="q"));

      switch (ch) {
        case "1":
          System.out.println("Vul de naam van de nieuwe student in of \"q\" om te annuleren: \n");
          String studentName = myscanner.nextLine();
          if (Objects.equals(studentName, "q")) {
            break;
          }
          System.out.println("Vul de leeftijd van de nieuwe student in: \n");
          String studentAge = myscanner.nextLine();
          students.put(studentName, Integer.valueOf(studentAge));

          break;
        case "2":
          System.out.println(
              "Vul de naam van de te vervijderen student in of q om te annuleren: \n");
          String studentDelete = myscanner.nextLine();
          if (Objects.equals(studentDelete, "q")) {
            break;
          }
          students.remove(studentDelete);
          break;
        case "3":
          for (Entry<String, Integer> student : students.entrySet()) {
            System.out.printf("naam: %-20s leeftijd: %d%n", student.getKey(), student.getValue());
          }
//          for (String i : students.keySet()) {
//            System.out.print("naam: " + i + "\t\tleeftijd:\t");
//            System.out.println(students.get(i));
//      }

            /*
printf in plaats van print geeft aan dat we een format willen gebruiken voor de variabelen in de string. Laten we %-20s ontleden: % houd in dat we op die plaats een variabel willen tonen, in dit geval de string i, de - geeft aan dat we de variabel links willen uitlijnen en de 20 geeft aan dat de variabel de ruimte van 20 characters moet in nemen, de s houdt in dat de variabel willen tonen als een string. %d houd in dat we de variabel, in dit geval students.get(i) willen tonen als een getal. %n voegt een nieuwe regel toe.

Meer over de formatter kun je hier lezen: https://docs.oracle.com/javase/7/docs/api/java/util/Formatter.html#syntax
             */

          break;
      }

      System.out.println();

    } while (!ch.equals("q"));
  }
}
