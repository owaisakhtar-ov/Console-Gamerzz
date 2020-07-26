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
public class Sudoku extends Tools
  {

    private Scanner scan = new Scanner(System.in);
    private Random rand = new Random();

    private boolean[][] check9x9 = new boolean[9][9];
    private boolean quiter = false;
    private char difficulty;
    private static long easyHighScore = 0;
    private static long interHighScore = 0;
    private static long hardHighScore = 0;
    private char[][] puzzle;
    private char[][] userAnswer;
    private char[][] solved;

    //##############################################################################
    //#           MAIN ALGORITHM FOR GENERATING NEW SUDOKU EVERYTIME               #
    //# "C:...Documents\NetBeansProjects\Project_OV\nbproject\ALGORITHM.jpeg"      #
    //#  Use Random Indexing-Array for ABC,DEF,GHI only so SUDOKU still solved :-D #
    //##############################################################################
    private int[] subShuffleIndex1 = shuffleArray(new int[]
    {
        0, 1, 2
    });
    private int[] subShuffleIndex2 = shuffleArray(new int[]
    {
        3, 4, 5
    });
    private int[] subShuffleIndex3 = shuffleArray(new int[]
    {
        6, 7, 8
    });
    private int[] shuffleIndexNINE = mergeArray(subShuffleIndex1, subShuffleIndex2, subShuffleIndex3);

    private int[] subShuffleIndex4 = shuffleArray(new int[]
    {
        0, 1
    });
    private int[] subShuffleIndex5 = shuffleArray(new int[]
    {
        2, 3
    });
    private int[] subShuffleIndex6 = shuffleArray(new int[]
    {
        4, 5
    });
    private int[] shuffleIndexSIX = mergeArray(subShuffleIndex4, subShuffleIndex5, subShuffleIndex6);
    //#############################################################################################

    //Using for Indexing 
    private char[] index
            =
            {
                'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I'
            };
    private char[][] defaultBoard9x9
            =
            {
                //Taken from WIKIPEDIA
                //Solved 9x9 SUDOKU
                {
                    '5', '3', '4', '6', '7', '8', '9', '1', '2'
                },
                {
                    '6', '7', '2', '1', '9', '5', '3', '4', '8'
                },
                {
                    '1', '9', '8', '3', '4', '2', '5', '6', '7'
                },
                {
                    '8', '5', '9', '7', '6', '1', '4', '2', '3'
                },
                {
                    '4', '2', '6', '8', '5', '3', '7', '9', '1'
                },
                {
                    '7', '1', '3', '9', '2', '4', '8', '5', '6'
                },
                {
                    '9', '6', '1', '5', '3', '7', '2', '8', '4'
                },
                {
                    '2', '8', '7', '4', '1', '9', '6', '3', '5'
                },
                {
                    '3', '4', '5', '2', '8', '6', '1', '7', '9'
                }
            };
    private char[][] defaultBoard6x6
            =
            {
                //Taken from https://www.funwithpuzzles.com
                //Solved 6x6 SUDOKU
                {
                    '5', '2', '4', '6', '1', '3'
                },
                {
                    '1', '3', '6', '4', '5', '2'
                },
                {
                    '2', '6', '1', '5', '3', '4'
                },
                {
                    '3', '4', '5', '2', '6', '1'
                },
                {
                    '6', '1', '2', '3', '4', '5'
                },
                {
                    '4', '5', '3', '1', '2', '6'
                }
            };

    public Sudoku()
      {
        //Fill the boolean grid with false values to Check after
        for (boolean[] check9x91 : check9x9)
        {
            Arrays.fill(check9x91, false);
        }

      }

    public void start()
      {
        long timerStart, timerStop, timerElapsed;

        System.out.println("  ███████╗██╗   ██╗██████╗  ██████╗ ██╗  ██╗██╗   ██╗\n"
                + "  ██╔════╝██║   ██║██╔══██╗██╔═══██╗██║ ██╔╝██║   ██║\n"
                + "  ███████╗██║   ██║██║  ██║██║   ██║█████╔╝ ██║   ██║\n"
                + "  ╚════██║██║   ██║██║  ██║██║   ██║██╔═██╗ ██║   ██║\n"
                + "  ███████║╚██████╔╝██████╔╝╚██████╔╝██║  ██╗╚██████╔╝\n"
                + "  ╚══════╝ ╚═════╝ ╚═════╝  ╚═════╝ ╚═╝  ╚═╝ ╚═════╝ \n"
                + "                                                   \n"
                + "\n\n");

        System.out.println("Welcome to SUDOKU ");
        System.out.println("Enter Difficulty Level");
        System.out.println("E:Easy\tI:Intermediate\tH:Hard\n\n");

        //Read Difficulty
        difficulty = scan.nextLine().toUpperCase().charAt(0);
        while (difficulty != 'I' && difficulty != 'E' && difficulty != 'H')
        {
            System.out.println("Wrong Input!!!");
            System.out.println("Enter Difficulty Level");
            System.out.println("E:Easy\tI:Intermediate\tH:Hard\n");
            difficulty = scan.nextLine().toUpperCase().charAt(0);

        }
        System.out.flush();
        System.out.print("Loading ");
        delayString(" ......");

        //Timer Starts
        timerStart = System.nanoTime();
        if (difficulty == 'E')
        {
            //Easy Gmae
            sudoku6x6();
        } else if (difficulty == 'I' || difficulty == 'H')
        {
            //Intermediate and Hard Game
            sudoku9x9();
        }
        timerStop = System.nanoTime();
        timerElapsed = (long) ((timerStop - timerStart) * 1e-9);
        System.out.println("Time : " + timerElapsed + " seconds");
        //Timer ends

        //Check for HighScorer
        if (!quiter)
        {
            if (difficulty == 'E' && timerElapsed > easyHighScore)
            {
                System.out.println("High Score : " + easyHighScore);
                System.out.println("WOW!!! You beat the High Score");
                easyHighScore = timerElapsed;
            } else if (difficulty == 'I' && timerElapsed > interHighScore)
            {
                System.out.println("High Score : " + interHighScore);
                System.out.println("WOW!!! You beat the High Score");
                interHighScore = timerElapsed;
            } else if (difficulty == 'H' && timerElapsed > hardHighScore)
            {
                System.out.println("High Score : " + hardHighScore);
                System.out.println("WOW!!! You beat the High Score");
                hardHighScore = timerElapsed;
            }
        }

      }

    //##################################################
    //#               The GAME STARTS                  #
    //##################################################
    private void sudoku6x6()
      {
        userAnswer = new char[6][6];
        solved = new char[6][6];
        puzzle = new char[6][6];
        char[][] temp = new char[6][6];

        //Interchanging Rows b/w AB,CD,EF
        for (int i = 0; i < defaultBoard6x6.length; i++)
        {
            temp[i] = defaultBoard6x6[shuffleIndexSIX[i]];

        }

        //Interchaging Columns b/w ABC,DEF
        for (int i = 0; i < defaultBoard6x6.length; i++)
        {
            for (int j = 0; j < defaultBoard6x6.length; j++)
            {

                solved[j][i] = temp[j][shuffleIndexNINE[i]];
            }
        }
        //Solved Board Done in SOLVED-ARRAY
//        this.board6x6(solved);

        //Making a Puzzle(Holed) Board FOR EASY Blanks = 18
        //Clone of solved in Puzzle
        for (int i = 0; i < puzzle.length; i++)
        {
            puzzle[i] = solved[i].clone();
        }

        int holes = 18;
        for (int i = 0; i < holes; i++)
        {
            int row = rand.nextInt(6);
            int column = rand.nextInt(6);
            if (puzzle[row][column] != ' ')
            {
                puzzle[row][column] = ' ';
                check9x9[row][column] = true;
            } else
            {
                i--;
            }
        }
        //Clone of puzzle in userAnswer
        for (int i = 0; i < userAnswer.length; i++)
        {
            userAnswer[i] = puzzle[i].clone();
        }

        this.board6x6(puzzle);
        //Puzzle Ready 
        userInput();

      }

    private void sudoku9x9()
      {
        userAnswer = new char[9][9];
        solved = new char[9][9];
        puzzle = new char[9][9];
        char[][] temp = new char[9][9];

        //Interchanging Rows b/w ABC,DEF,GHI
        for (int i = 0; i < defaultBoard9x9.length; i++)
        {
            temp[i] = defaultBoard9x9[shuffleIndexNINE[i]];

        }

        //Interchaging Columns b/w ABC,DEF,GHI
        for (int i = 0; i < defaultBoard9x9.length; i++)
        {
            for (int j = 0; j < defaultBoard9x9.length; j++)
            {

                solved[j][i] = temp[j][shuffleIndexNINE[i]];
            }
        }
        //Solved Board Done in SOLVED-ARRAY
//        this.board9x9(solved);

        //Making a Puzzle(Holed) Board FOR INtermediate Blanks = 18 & Hard Blanks = 
        //Clone of solved in Puzzle
        for (int i = 0; i < puzzle.length; i++)
        {
            puzzle[i] = solved[i].clone();
        }

        //Checking for Difficulty
        int holes;
        if (difficulty == 'I')
        {
            holes = 45;
        } else
        {
            holes = 60;
        }
        for (int i = 0; i < holes; i++)
        {
            int row = rand.nextInt(9);
            int column = rand.nextInt(9);
            if (puzzle[row][column] != ' ')
            {
                puzzle[row][column] = ' ';
                check9x9[row][column] = true;
            } else
            {
                i--;
            }
        }
        //Clone of puzzle in userAnswer
        for (int i = 0; i < userAnswer.length; i++)
        {
            userAnswer[i] = puzzle[i].clone();
        }

        this.board9x9(puzzle);
        //Puzzle Ready 
        userInput();

      }

    private void userInput()
      {
        String input;
//        boolean flag = false;
        System.out.println("Please Enter the cell Address with the digit");
        System.out.println("[EXAMPLE : \"AA 5\"] for Row:A Column:A <SPACE> Value:5");
        System.out.println("Enter \"Quit\" to Give up and see the Solution");
        System.out.println("Enter \"Check\" to check your Solution\n\n");

        //LOL
        do//while (!input.equals("QUIT"))
        {
            input = scan.nextLine().toUpperCase();
            if (input.equals("QUIT"))
            {
                continue;
            }
            if (input.length() < 4)
            {
                System.out.println("Wrong Input");
//                input = scan.nextLine().toUpperCase();
                continue;
            }
            char fisrt = input.charAt(0);
            char second = input.charAt(1);
            char third = input.charAt(2);
            char forth = input.charAt(3);
            int row = Arrays.binarySearch(index, fisrt);
            int column = Arrays.binarySearch(index, second);

            //Hit for Solution check
            if (input.equals("CHECK"))
            {
                if (checkSudoku(userAnswer))
                {
                    System.out.println("Winnner !!!");
                    System.out.println("Your Solution is Valid");
                    return;
//                    break;
                } else
                {
                    System.out.println("Not a Valid Solution");
//                    input = scan.nextLine().toUpperCase();
                    continue;
                }
            }

            //Input pattern Varifier
            if ((puzzle.length == 6) && valid6x6Input(fisrt, second, third, forth, row, column))
            {
                userAnswer[row][column] = forth;
            } else if ((puzzle.length == 9) && valid9x9Input(fisrt, second, third, forth, row, column))
            {
                userAnswer[row][column] = forth;
            } else
            {
                System.out.print("Wrong Input, Please select a Valid Cell");
                delayString(" ......");
//                input = scan.nextLine().toUpperCase();
            }

            if (puzzle.length == 6)
            {
                board6x6(userAnswer);
            } else
            {
                board9x9(userAnswer);
            }
        } while (!input.equals("QUIT"));

        //QUIT CONDITION
        quiter = true;
        System.out.println("\t  ╔═╗╔═╗╦  ╦ ╦╔╦╗╦╔═╗╔╗╔\n"
                + "\t  ╚═╗║ ║║  ║ ║ ║ ║║ ║║║║\n"
                + "\t  ╚═╝╚═╝╩═╝╚═╝ ╩ ╩╚═╝╝╚╝"
                + "");
        if (puzzle.length == 6)//(difficulty=='E')
        {
            board6x6(solved);
        } else if (puzzle.length == 9)
        {
            board9x9(solved);
        }
        System.out.println("\nLosser :-P");
      }

    private boolean valid6x6Input(char first, char second, char third, char forth, int row, int column)
      {
        return (first >= 'A' && first <= 'F') && (second >= 'A' && second <= 'F') && (third == ' ') && (forth >= '1' && forth <= '6') && check9x9[row][column] == true;
      }

    private boolean valid9x9Input(char first, char second, char third, char forth, int row, int column)
      {
        return (first >= 'A' && first <= 'I') && (second >= 'A' && second <= 'I') && (third == ' ') && (forth >= '1' && forth <= '9') && check9x9[row][column] == true;
      }

    //#########################SUDOKU CHECKER STARTS####################################
    private boolean checkSudoku(char[][] charArray)
      {
        int[][] intArray = charToIntArray(charArray);//new int from char ARRAY
        for (int i = 0; i < puzzle.length; i++)
        {
            int[] row = new int[puzzle.length];
            int[] grid = new int[puzzle.length];
            int[] column = intArray[i].clone();

            for (int j = 0; j < puzzle.length; j++)
            {
                row[j] = intArray[j][i];
                grid[j] = intArray[(i / 3) * 3 + j / 3][i * 3 % puzzle.length + j % 3];

            }

            if (!(isValid(column) && isValid(row) && isValid(grid)))
            {
                return false;
            }
        }
        return true;
      }

    //Sort the arrays and check for +1 increament
    //i.e 1 2 3 4 5 6 7 8 9
    private boolean isValid(int[] check)
      {
        int i = 0;
        Arrays.sort(check);
        for (int value : check)
        {
            if (value != ++i)
            {
                return false;
            }
        }
        return true;
      }

    //###########################SUDOKU CHECKER ENDS#################################
    private void board9x9(char[][] array)
      {
        System.out.format("\n\n     A   B   C   D   E   F   G   H   I\n");
        System.out.format("   ╔═══╤═══╤═══╦═══╤═══╤═══╦═══╤═══╤═══╗\n");
        System.out.format(" A ║ %c │ %c │ %c ║ %c │ %c │ %c ║ %c │ %c │ %c ║\n", array[0][0], array[0][1], array[0][2], array[0][3], array[0][4], array[0][5], array[0][6], array[0][7], array[0][8]);
        System.out.format("   ╟───┼───┼───╫───┼───┼───╫───┼───┼───╢\n");
        System.out.format(" B ║ %c │ %c │ %c ║ %c │ %c │ %c ║ %c │ %c │ %c ║\n", array[1][0], array[1][1], array[1][2], array[1][3], array[1][4], array[1][5], array[1][6], array[1][7], array[1][8]);
        System.out.format("   ╟───┼───┼───╫───┼───┼───╫───┼───┼───╢\n");
        System.out.format(" C ║ %c │ %c │ %c ║ %c │ %c │ %c ║ %c │ %c │ %c ║\n", array[2][0], array[2][1], array[2][2], array[2][3], array[2][4], array[2][5], array[2][6], array[2][7], array[2][8]);
        System.out.format("   ╠═══╪═══╪═══╬═══╪═══╪═══╬═══╪═══╪═══╣\n");
        System.out.format(" D ║ %c │ %c │ %c ║ %c │ %c │ %c ║ %c │ %c │ %c ║\n", array[3][0], array[3][1], array[3][2], array[3][3], array[3][4], array[3][5], array[3][6], array[3][7], array[3][8]);
        System.out.format("   ╟───┼───┼───╫───┼───┼───╫───┼───┼───╢\n");
        System.out.format(" E ║ %c │ %c │ %c ║ %c │ %c │ %c ║ %c │ %c │ %c ║\n", array[4][0], array[4][1], array[4][2], array[4][3], array[4][4], array[4][5], array[4][6], array[4][7], array[4][8]);
        System.out.format("   ╟───┼───┼───╫───┼───┼───╫───┼───┼───╢\n");
        System.out.format(" F ║ %c │ %c │ %c ║ %c │ %c │ %c ║ %c │ %c │ %c ║\n", array[5][0], array[5][1], array[5][2], array[5][3], array[5][4], array[5][5], array[5][6], array[5][7], array[5][8]);
        System.out.format("   ╠═══╪═══╪═══╬═══╪═══╪═══╬═══╪═══╪═══╣\n");
        System.out.format(" G ║ %c │ %c │ %c ║ %c │ %c │ %c ║ %c │ %c │ %c ║\n", array[6][0], array[6][1], array[6][2], array[6][3], array[6][4], array[6][5], array[6][6], array[6][7], array[6][8]);
        System.out.format("   ╟───┼───┼───╫───┼───┼───╫───┼───┼───╢\n");
        System.out.format(" H ║ %c │ %c │ %c ║ %c │ %c │ %c ║ %c │ %c │ %c ║\n", array[7][0], array[7][1], array[7][2], array[7][3], array[7][4], array[7][5], array[7][6], array[7][7], array[7][8]);
        System.out.format("   ╟───┼───┼───╫───┼───┼───╫───┼───┼───╢\n");
        System.out.format(" I ║ %c │ %c │ %c ║ %c │ %c │ %c ║ %c │ %c │ %c ║\n", array[8][0], array[8][1], array[8][2], array[8][3], array[8][4], array[8][5], array[8][6], array[8][7], array[8][8]);
        System.out.format("   ╚═══╧═══╧═══╩═══╧═══╧═══╩═══╧═══╧═══╝\n\n\n");
      }

    private void board6x6(char[][] array)
      {
        System.out.format("\n\n     A   B   C   D   E   F\n");
        System.out.format("   ╔═══╤═══╤═══╦═══╤═══╤═══╗\n");
        System.out.format(" A ║ %c │ %c │ %c ║ %c │ %c │ %c ║\n", array[0][0], array[0][1], array[0][2], array[0][3], array[0][4], array[0][5]);
        System.out.format("   ╟───┼───┼───╫───┼───┼───╢\n");
        System.out.format(" B ║ %c │ %c │ %c ║ %c │ %c │ %c ║\n", array[1][0], array[1][1], array[1][2], array[1][3], array[1][4], array[1][5]);
        System.out.format("   ╠═══╪═══╪═══╬═══╪═══╪═══╣\n");
        System.out.format(" C ║ %c │ %c │ %c ║ %c │ %c │ %c ║\n", array[2][0], array[2][1], array[2][2], array[2][3], array[2][4], array[2][5]);
        System.out.format("   ╟───┼───┼───╫───┼───┼───╢\n");
        System.out.format(" D ║ %c │ %c │ %c ║ %c │ %c │ %c ║\n", array[3][0], array[3][1], array[3][2], array[3][3], array[3][4], array[3][5]);
        System.out.format("   ╠═══╪═══╪═══╬═══╪═══╪═══╣\n");
        System.out.format(" E ║ %c │ %c │ %c ║ %c │ %c │ %c ║\n", array[4][0], array[4][1], array[4][2], array[4][3], array[4][4], array[4][5]);
        System.out.format("   ╟───┼───┼───╫───┼───┼───╢\n");
        System.out.format(" F ║ %c │ %c │ %c ║ %c │ %c │ %c ║\n", array[5][0], array[5][1], array[5][2], array[5][3], array[5][4], array[5][5]);
        System.out.format("   ╚═══╧═══╧═══╩═══╧═══╧═══╝\n\n\n");
      }

  }
