package nl.emilvdijk;

import java.io.IOException;
import java.util.HashMap;
import java.util.Objects;
import java.util.Scanner;

public class App {

  public static void main(String[] args) throws IOException {
    char ch, ignore;
    HashMap<String, Integer> students = new HashMap<>();
    Scanner myscanner = new Scanner(System.in);

    students.put("Jantje", 2);
    students.put("Eric", 13);
    students.put("Evelien", 2346);

    do {
      do {
        System.out.println("Welkom in het studentendatabasesysteem.");
        System.out.println("1 om een persoon toe te voegen\n"
            + "2 om een persoon te verwijderen \n"
            + "3 om alle personen te tonen\n" +
            "'q' to quit");
        ch = (char) System.in.read();
        do {
          ignore = (char) System.in.read();
        } while (ignore != '\n');
      } while (ch < '1' | ch > '3' & ch != 'q');




      switch (ch) {
        case '1':
          System.out.println("Vul de naam van de nieuwe student in of q om te annuleren: \n");
          String studentName = myscanner.nextLine();
          if (Objects.equals(studentName, "q")) {
            break;
          }
          System.out.println("Vul de leeftijd van de nieuwe student in: \n");
          Integer studentAge = myscanner.nextInt();
          students.put(studentName, studentAge);
          break;
        case '2':
          System.out.println(
              "Vul de naam van de te vervijderen student in of q om te annuleren: \n");
          String studentDelete = myscanner.nextLine();
          if (Objects.equals(studentDelete, "q")) {
            break;
          }
          students.remove(studentDelete);
          break;
        case '3':
          for (String i : students.keySet()) {
            System.out.print("naam: " + i + "\t\tleeftijd:\t");
            System.out.println(students.get(i));
          }
          break;
      }

      System.out.println();

    } while (ch != 'q');
  }
}
