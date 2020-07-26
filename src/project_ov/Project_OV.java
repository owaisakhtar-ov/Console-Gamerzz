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
public class Project_OV extends Tools
  {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
      {
        System.out.println("\n\n\n");
        Scanner scan = new Scanner(System.in);

        //Control Menu
        char userInput, itrationControlChar;
        boolean iterationControl = true;
        
        
        while (iterationControl)
        {
            System.out.println("      ██╗           ██████╗ ██████╗ ███╗   ██╗▄▄███▄▄╗ ██████╗ ██╗     ███████╗\n"
                    + "     ██╔╝▄ ██╗▄    ██╔════╝██╔═══██╗████╗  ██║██╔════╝██╔═══██╗██║     ██╔════╝\n"
                    + "    ██╔╝  ████╗    ██║     ██║   ██║██╔██╗ ██║███████╗██║   ██║██║     █████╗  \n"
                    + "   ██╔╝  ▀╚██╔▀    ██║     ██║   ██║██║╚██╗██║╚════██║██║   ██║██║     ██╔══╝  \n"
                    + "  ██╔╝     ╚═╝     ╚██████╗╚██████╔╝██║ ╚████║███████║╚██████╔╝███████╗███████╗\n"
                    + "  ╚═╝               ╚═════╝ ╚═════╝ ╚═╝  ╚═══╝╚═▀▀▀══╝ ╚═════╝ ╚══════╝╚══════╝\n"
                    + "                                                                               \n"
                    + "   ██████╗  █████╗ ███╗   ███╗███████╗██████╗ ███████╗███████╗             ██╗ \n"
                    + "  ██╔════╝ ██╔══██╗████╗ ████║██╔════╝██╔══██╗╚══███╔╝╚══███╔╝    ▄ ██╗▄  ██╔╝ \n"
                    + "  ██║  ███╗███████║██╔████╔██║█████╗  ██████╔╝  ███╔╝   ███╔╝      ████╗ ██╔╝  \n"
                    + "  ██║   ██║██╔══██║██║╚██╔╝██║██╔══╝  ██╔══██╗ ███╔╝   ███╔╝      ▀╚██╔▀██╔╝   \n"
                    + "  ╚██████╔╝██║  ██║██║ ╚═╝ ██║███████╗██║  ██║███████╗███████╗      ╚═╝██╔╝    \n"
                    + "   ╚═════╝ ╚═╝  ╚═╝╚═╝     ╚═╝╚══════╝╚═╝  ╚═╝╚══════╝╚══════╝         ╚═╝  \n\n");
            System.out.print("\t\t\t\t   ");
            delayString("WELCOME!!!");
            System.out.println("\n\t\t╔═════════════════════════════════════════════╗");
            System.out.println("\t\t║░░░░░░░░   ╔╦╗╔═╗╦╔╗╔  ╔╦╗╔═╗╔╗╔╦ ╦  ░░░░░░░░║\n"
                    + "\t\t║░░░░░░░░   ║║║╠═╣║║║║  ║║║║╣ ║║║║ ║  ░░░░░░░░║\n"
                    + "\t\t║░░░░░░░░   ╩ ╩╩ ╩╩╝╚╝  ╩ ╩╚═╝╝╚╝╚═╝  ░░░░░░░░║");
            System.out.println("\t\t╠═════════════════════════════════════════════╣");
            System.out.println("\t\t║░░░░░░░░ Press 'H' for \"Hangman\"     ░░░░░░░░║");
            System.out.println("\t\t║░░░░░░░░ press 'S' for \"Sudoku\"      ░░░░░░░░║");
            System.out.println("\t\t║░░░░░░░░ Press 'T' for \"Tic-Tac-Toe\" ░░░░░░░░║");
            System.out.println("\t\t║░░░░░░░░ Press 'W' for \"Word Search\" ░░░░░░░░║");
            System.out.println("\t\t║░░░░░░░░ Press 'A' for \"About\"       ░░░░░░░░║");
            System.out.println("\t\t║░░░░░░░░ Press 'Q' for \"Quit\"        ░░░░░░░░║");
            System.out.println("\t\t╚═════════════════════════════════════════════╝\n");

            userInput = scan.next().toUpperCase().charAt(0);
            char gameRepeat;

            switch (userInput)
            {
                case 'H':
                    //HANGMAN
//                    do
//                    {
                    delayString("Loading ...");
                    newPage();
                    HangMan hangMan = new HangMan();
                    hangMan.start();

//                        System.out.println("Press [Y] to Play Again \"Hangman\"");
//                        gameRepeat = scan.next().toUpperCase().charAt(0);
//                    } while (gameRepeat == 'Y');
                    break;

                case 'S':
                    //SUDOKU
                    do
                    {
                        delayString("Loading ...");
                        newPage();
                        Sudoku sudoku = new Sudoku();
                        sudoku.start();

                        System.out.println("Press [Y] to Play Again \"Sudoku\"");
                        gameRepeat = scan.next().toUpperCase().charAt(0);

                    } while (gameRepeat == 'Y');

                    break;
                case 'T':
                    //TIC TAC TOE
                    do
                    {
                        delayString("Loading ...");
                        newPage();
                        TicTacToe ticTacToe = new TicTacToe();
                        ticTacToe.start();

                        System.out.println("Press [Y] to Play Again \"TIC-TAC-TOE\"");
                        gameRepeat = scan.next().toUpperCase().charAt(0);

                    } while (gameRepeat == 'Y');

                    break;
                case 'W':
                    //WORD SEARCH
                    do
                    {
                        delayString("Loading ...");
                        newPage();
                        WordSearch wordSearch = new WordSearch();
                        wordSearch.start();

                        System.out.println("Press [Y] to Play Again \"Word Search\"");
                        gameRepeat = scan.next().toUpperCase().charAt(0);

                    } while (gameRepeat == 'Y');

                    break;
                case 'A':
                    //ABOUT
                    System.out.println("\n\n\n\n\n");
                    System.out.println("\t  ╔═╗╔═╗╔╗╔╔═╗╔═╗╦  ╔═╗  ╔═╗╔═╗╔╦╗╔═╗╦═╗╔═╗╔═╗  ╦  ╦╦ ╔═╗\n"
                            + "\t  ║  ║ ║║║║╚═╗║ ║║  ║╣   ║ ╦╠═╣║║║║╣ ╠╦╝╔═╝╔═╝  ╚╗╔╝║ ║ ║\n"
                            + "\t  ╚═╝╚═╝╝╚╝╚═╝╚═╝╩═╝╚═╝  ╚═╝╩ ╩╩ ╩╚═╝╩╚═╚═╝╚═╝   ╚╝ ╩o╚═╝\n\n"
                            + "");
                    System.out.print("\t\tProgrammer :   ");
                    delayString("H.M.OWAIS AKHTAR \"OV\" B16101044");
                    System.out.print("\n\t\tSubmitted to : ");
                    delayString("Ma'am Maryam Feroze");
                    System.out.print("\n\t\tSemester :     ");
                    delayString("3rd");
                    System.out.print("\n\t\tCourse :       ");
                    delayString("OOP");
                    System.out.println("\n");

                    break;

                case 'Q':
                    iterationControl = false;
                    continue;

                default:
                    System.out.println("Wrong Input");
                    delay(800);
                    newPage();
                    continue;

            }
            System.out.println("\n\n\nPress M for the MAIN MENU");
            itrationControlChar = scan.next().toUpperCase().charAt(0);
            if (itrationControlChar != 'M')
            {
                iterationControl = false;
            } else
            {
                newPage();
            }

        }
            System.out.print("\n\n\t\t\tThank you for Playing");
            delayString(" .........");

//        scan.next();
      }

  }
