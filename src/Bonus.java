import java.util.HashSet;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class Bonus {

    public static void main(String[] args) {
//
//        // Onderstaande code is uitgecommentarieerd. Haal de code uit de comment (delete /* en */) om aan de slag te gaan met de bonus
//        // In de code staan op verschillende plekken comments tussen "/*...*/" als hint wat je moet doen
//
//
        HashSet<Integer> secretnumber = randomnumbergenerator();
        String stringnumber = setToStringConverter(secretnumber);
        System.out.println(stringnumber);
        feedback(stringnumber);

    }

    //
    public static HashSet<Integer> randomnumbergenerator() {
        // Instance of random class
        Random rand = new Random();
        HashSet<Integer> generatedNumbers = new HashSet<>();

        while (generatedNumbers.size() < 4) {

            // Setting the upper bound to generate the
            // random numbers in specific range
            int upperbound = 10;
            // Generating random values from 0 to 10
            // using nextInt()
            int int_random = rand.nextInt(upperbound);

            generatedNumbers.add(int_random);
        }

        return generatedNumbers;


//        Stappenplan:
//        - Maak een nieuwe variabele van type Random. (Tip: Zoek op internet hoe je Random kunt gebruiken)
//        - Maak een nieuwe variabele van type HashSet.
//        - Schrijf een while-loop om 4 random nummers aan de hashset toe te voegen
//        - return de hashset

    }

    public static String setToStringConverter(HashSet<Integer> generatedNumbers) {

//        Vul hier de body van de methode in.

        // eerst opgezocht wat een stringbuilder is en doet. Met een lege string kreeg ik het niet voor elkaar.
        // bron: https://www.javatpoint.com/StringBuilder-class
        // met append kan een item worden toegevoegd.

        // String stringnumber = setToStringConverter(secretnumber) verwacht een secretnumber terug, dus deze naam houd ik aan voor de duidelijkheid
        // return secretnumber geeft een error met de vraag of ik ergens een tostring conversie wil maken. Na .toString achter de return secretnumber te zetten is de error weg.

        StringBuilder secretnumber = new StringBuilder();

        for (Integer stringNumber : generatedNumbers) {
            secretnumber.append(stringNumber);
        }
        return secretnumber.toString();

//        Stappenplan:
//        - Maak als eerst een String variabele met als waarde een lege String. (of gebruik een StringBuilder)
//        - Schrijf vervolgens een for-loop om de items in de hashset een voor een aan de String variabele toe te voegen.
//        - Return de (gevulde) String variabele

    }


    public static void feedback(String stringnumber) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder feedback = new StringBuilder();
        System.out.println("+ = juiste nummer op de juiste plek, O = juiste nummer verkeerde plek, X = verkeerde nummer");
        System.out.println("Doe een gok, Let op vul 4 getallen in.");
        String guess = scanner.nextLine();
        if (Objects.equals(guess, stringnumber)) {
            System.out.println("gefeliciteerd je hebt het goed");
        } else {
            for (int i = 0; i < 4; i++) {
                if (guess.substring(i, i + 1).equals(stringnumber.substring(i, i + 1))) {
                    feedback.append("+");
                } else if (stringnumber.contains(guess.substring(i, i + 1))) {
                    feedback.append("0");
                } else {
                    feedback.append("X");
                }
            }
        }
        System.out.println(feedback); // deze .toString was volgens mij onnodig. Alles is toch al omgezet naar een String?
    }
}
