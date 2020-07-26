/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_ov;

import java.util.*;

/**
 *
 * @author OV
 */
public class HangMan extends Tools
  {

    private Scanner scan = new Scanner(System.in);
    private Random rand = new Random();

    private List<String> checkWord = new ArrayList<>();
    private final int MAX_TRAILS = 6;
    private int totalWordsFound = 0;
    private String[] dictionary =
    {
        "DRIVING", "PLAYING", "ENTERTAINING", "TALKING", "EXERCISE", "EATING", "FOOTBALL", "WALKING", "POKER", "BASEBALL", "MARCH", "SUNSHINE", "ELECTRONIC", "AMPLIFIER", "ENERGY", "TELEVISION", "BATTERY", "LAPTOP", "BEGINNING", "ARRANGEMENT", "IMPROVEMENT", "ACCORDING", "UNFORTUNATE", "YESTERDAY", "IMPOSSIBLE", "INVESTIGATE", "DISCUSSION", "ATTENTION", "DIFFERENCE", "UNDERSTAND", "DEPARTMENT", "RESPONSIBLE", "SCORPION", "PANTHER", "PYTHON", "CHOCOLATE", "FRIENDSHIP", "MAGIC", "MATHEMATICS", "HUNTER", "MYSTERIOUS", "NEIGHBORHOOD", "RELATIONSHIP", "UNIVERSITY", "SUBMISSION", "HARDCORE", "ACKNOWLEDGE", "ADMINISTRATION", "APPROXIMATELY", "BONDAGE", "ENGINEERING", "EXAMINATION", "EXTRAORDINARY", "FOUNDATION", "IDENTIFICATION", "NEWSPAPER", "PARTNERSHIP", "PHOTOGRAPHER", "PSYCHOLOGICAL", "REPRESENTATION", "TRANSFORMATION", "UNDERSTANDING", "TRADITIONAL", "MANAGEMENT", "SPECIFICATION", "IMPLEMENTATION", "COMBINATION", "MOTHER", "ANIMALS", "CHICKEN", "FRIENDS", "TOOTHBRUSH", "NECKLACE", "CALENDAR", "HAPPINESS", "MESSAGE", "ERASER", "RECTANGLE", "TRIANGLE", "SCRATCH", "BREAKFAST", "HIGHLIGHTER", "MEDICINE"
    };

    private String Final = "\n\n"
            + "\t\t▓▓▓▓▓▓▓▓▓▓▓▓▓░░▓▓\n"
            + "\t\t▓▓▓ // //    ||\n"
            + "\t\t▓▓▓// //     ||\n"
            + "\t\t▓▓▓/ //      ||.-''.\n"
            + "\t\t▓▓▓ //       |/  _  \\\n"
            + "\t\t▓▓▓//        ||  `/,|\n"
            + "\t\t▓▓▓/         (\\\\`_.'\n"
            + "\t\t▓▓▓         .-`--'.\n"
            + "\t\t▓▓▓        /Y . . Y\\\n"
            + "\t\t▓▓▓       // |   | \\\\\n"
            + "\t\t▓▓▓      //  | . |  \\\\\n"
            + "\t\t▓▓▓     ')   |   |   (`\n"
            + "\t\t▓▓▓          ||'||\n"
            + "\t\t▓▓▓          || ||\n"
            + "\t\t▓▓▓          || ||\n"
            + "\t\t▓▓▓          || ||\n"
            + "\t\t▓▓▓         / | | \\\n"
            + "\t\t▓▓▓░░░░░░░░░`-' `-' ░░░░░░░░░░░░░░░░░░░░░░░░░░▓▓▓\n"
            + "\t\t▓▓▓░░░░░░░\\ \\       ░░░░░░░░░░░░░░░░░░░░░░░░░░▓▓▓\n"
            + "\t\t▓▓▓        \\ \\                                ▓▓▓\n"
            + "\t\t▓▓▓	    \\ \\          ╦ ╦╔═╗╔╗╔╔═╗╔═╗╔╦╗   ▓▓▓\n"
            + "\t\t▓▓▓	     \\ \\         ╠═╣╠═╣║║║║ ╦║╣  ║║   ▓▓▓\n"
            + "\t\t▓▓▓           `'         ╩ ╩╩ ╩╝╚╝╚═╝╚═╝═╩╝   ▓▓▓ \n"
            + "\t\t▓▓▓                                           ▓▓▓ \n"
            + "\t\t▓▓▓░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░▓▓▓\n"
            + "\t\t▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓\n\n\n";

    private String[] hangMans =
    {
        "     ╔═══╗ \n"
        + "     |   ║ \n"
        + "     Ö   ║ \n"
        + "         ║ \n"
        + "         ║ \n"
        + "         ║ \n"
        + "  ╔══════╩══╗\n"
        + "  ║▓▓▓▓▓▓▓▓▓║\n\n",
        "     ╔═══╗ \n"
        + "     |   ║ \n"
        + "     Ö   ║ \n"
        + "     |   ║ \n"
        + "         ║ \n"
        + "         ║ \n"
        + "  ╔══════╩══╗\n"
        + "  ║▓▓▓▓▓▓▓▓▓║\n\n",
        "     ╔═══╗ \n"
        + "     |   ║ \n"
        + "     Ö   ║ \n"
        + "    /|   ║ \n"
        + "         ║ \n"
        + "         ║ \n"
        + "  ╔══════╩══╗\n"
        + "  ║▓▓▓▓▓▓▓▓▓║\n\n",
        "     ╔═══╗ \n"
        + "     |   ║ \n"
        + "     Ö   ║ \n"
        + "    /|\\  ║ \n"
        + "         ║ \n"
        + "         ║ \n"
        + "  ╔══════╩══╗\n"
        + "  ║▓▓▓▓▓▓▓▓▓║\n\n",
        "     ╔═══╗ \n"
        + "     |   ║ \n"
        + "     Ö   ║ \n"
        + "    /|\\  ║ \n"
        + "    /    ║ \n"
        + "         ║ \n"
        + "  ╔══════╩══╗\n"
        + "  ║▓▓▓▓▓▓▓▓▓║\n\n",
        Final

    };

    public HangMan()
      {
      }

    public void start()
      {

        System.out.println("  ██╗  ██╗ █████╗ ███╗   ██╗ ██████╗     ███╗   ███╗ █████╗ ███╗   ██╗\n"
                + "  ██║  ██║██╔══██╗████╗  ██║██╔════╝     ████╗ ████║██╔══██╗████╗  ██║\n"
                + "  ███████║███████║██╔██╗ ██║██║  ███╗    ██╔████╔██║███████║██╔██╗ ██║\n"
                + "  ██╔══██║██╔══██║██║╚██╗██║██║   ██║    ██║╚██╔╝██║██╔══██║██║╚██╗██║\n"
                + "  ██║  ██║██║  ██║██║ ╚████║╚██████╔╝    ██║ ╚═╝ ██║██║  ██║██║ ╚████║\n"
                + "  ╚═╝  ╚═╝╚═╝  ╚═╝╚═╝  ╚═══╝ ╚═════╝     ╚═╝     ╚═╝╚═╝  ╚═╝╚═╝  ╚═══╝\n"
                + "                                                                    \n"
                + "");

        //Main Game STARTS here
        for (int i = 0; i < dictionary.length; i++)
        {
            if (i != 0)
            {
                newPage();
            }
            int rightGuess = 0, wrongGuess = 0;
            System.out.println("\n\n╔═════════════════════════╗");
            System.out.println("║░░░░░░░░ WORD :" + (i + 1) + " ░░░░░░░░║");
            System.out.println("╚═════════════════════════╝\n");

            char[] word = newWord();
            char[] hidden = new char[word.length];
            Arrays.fill(hidden, '*');
            List<Character> alreadyInput = new ArrayList<>();

            System.out.print("Here we Go");
            delayString(" .....");
            System.out.println("\nGuess the Word\n");

            //Trails MAX 6
            for (int j = 0; j < MAX_TRAILS; j++)
            {
                boolean found = false;
                System.out.print((new String(hidden)) + " ════> ");
                char userInput = scan.next().toUpperCase().charAt(0);

                if (alreadyInput.contains(userInput))
                {
                    System.out.println("\nYou already guess : " + userInput);
                    System.out.print("Please try a new Letter");
                    delayString(" .....");
                    System.out.println("");
                    j--;
                    continue;
                } else
                {
                    alreadyInput.add(userInput);
                }

                for (int k = 0; k < word.length; k++)
                {
                    if (userInput == word[k])
                    {
                        hidden[k] = word[k];
                        found = true;
                    }

                }//End WORD CHECKING loop
                if (!found)
                {
                    wrongGuess++;
                    System.out.println(" Opss!!!\n Wrong\n");
                    System.out.println(hangMans[j]);
                } else
                {
                    j--;
                    rightGuess++;
                }

                if (!new String(hidden).contains("*"))
                {
                    System.out.println(hidden);
                    System.out.println("");
                    delayString("WINNER!!!");
                    System.out.println("\n");
                    this.totalWordsFound++;
                    break;
                }

            }
            System.out.println("The word is : " + (String.valueOf(word)));
            System.out.println("Correct = " + rightGuess);
            System.out.println("Wrong = " + wrongGuess);
            System.out.println("You Wanna Play Again ??? [Y/N]");
            if (scan.next().toUpperCase().charAt(0) != 'Y')
            {
                break;
            }

        }
        //Game ENDS with Outer-Most LOOP
        System.out.println("Here is the Final Score");
        System.out.println("Total Words Found Correctly : " + this.totalWordsFound);

      }

    private char[] newWord()
      {
        int index;
        String word;

        do
        {
            index = rand.nextInt(dictionary.length);
            word = dictionary[index];
        } while (checkWord.contains(word));

        checkWord.add(word);
        char[] wordArray = word.toCharArray();
        return wordArray;
      }

  }
