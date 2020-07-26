package project_ov;

import java.util.*;

/**
 *
 * @author OV
 */
public class TicTacToe extends Tools
  {

    private Scanner scan = new Scanner(System.in);
    private Random ran = new Random();
    private char[] ans =
    {
        '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'
    }; //Hadcoded Array from 0 to 9
    private char player = 'X';  //Player

    public TicTacToe()  //Default Constructor
      {

      }

    public void start()
      {
        System.out.println("  ████████╗██╗ ██████╗    ████████╗ █████╗  ██████╗    ████████╗ ██████╗ ███████╗\n"
                + "  ╚══██╔══╝██║██╔════╝    ╚══██╔══╝██╔══██╗██╔════╝    ╚══██╔══╝██╔═══██╗██╔════╝\n"
                + "     ██║   ██║██║            ██║   ███████║██║            ██║   ██║   ██║█████╗  \n"
                + "     ██║   ██║██║            ██║   ██╔══██║██║            ██║   ██║   ██║██╔══╝  \n"
                + "     ██║   ██║╚██████╗       ██║   ██║  ██║╚██████╗       ██║   ╚██████╔╝███████╗\n"
                + "     ╚═╝   ╚═╝ ╚═════╝       ╚═╝   ╚═╝  ╚═╝ ╚═════╝       ╚═╝    ╚═════╝ ╚══════╝\n"
                + "                                                                               \n"
                + "\n\n");
        System.out.println("\t\tEnter 1 for Single Player");
        System.out.println("\t\tEnter 2 for Dual Player");
        char a = scan.next().charAt(0);

        while (a != '1' && a != '2')
        {
            System.out.println("Wrong Input");
            System.out.println("\t\tEnter 1 for Single Player");
            System.out.println("\t\tEnter 2 for Dual Player");

            a = scan.next().charAt(0);
        }
        if (a == '1')
        {
            startSinglePlayer();
        } else
        {
            startDualPlayer();
        }
      }

    private void startSinglePlayer()
      {
        //SINGLE PLAYER START
        int checker = 0;
        int turncheck = ran.nextInt(2);
        System.out.println("\t\tWELCOME TO TIC-TAC-TOE SINGLE PLAYER");
        System.out.println("\t\tLet's Toss Who'll Play First");

        //Tossing for First turn
        delayString("Tossing!!!\n");
        if (turncheck == 0)
        {
            System.out.println("You WON the Toss :-D");
            player = 'X';
        } else
        {
            System.out.println("Computer WON the Toss");
            player = 'O';
        }

        //Game Starts
        do
        {
            board();
            //Check Player's Turn
            if (player == 'X')
            {
                System.out.println("Your Turn : 'X'");
                System.out.println("Please Choose a Spot");
                int spot = Integer.parseInt(scan.next());
                setMark(spot);
                checker = checkWinner();
                nextPlayer();
            } else
            {
                System.out.println("Computer's Turn : 'O'");
                delay(1000);
                guessSpotAI();
                checker = checkWinner();
                nextPlayer();
            }

        } while (checker == 0);
        board();    //Wiining Board
        if (checker == 1)
        {
            nextPlayer();
            System.out.format("We Got a WINNER !!!!\n");
            if (player == 'O')
            {
                delayString("Computer Wins!!!!\n");
            }
            if (player == 'X')
            {
                delayString("You Wins !!!!!!\n");
            }
        } else
        {
            System.out.println("Awwwww Not a Winner :-(\n");
            delayString("Draw :-O\n");

        }

      }

    private void startDualPlayer()
      {
        //DUAL PLAYER START
        int checker = 0;
        System.out.println("\t\tWELCOME TO TIC-TAC-TOE DUAL PLAYER");

        //Play as X O start here
        System.out.println("\t\tPress O to play as 'O' and X to play as 'X'");
        char checkplayer;
        checkplayer = scan.next().toUpperCase().charAt(0);
        while (checkplayer != 'X' && checkplayer != 'O')
        {
            System.out.println("Wrong Input");
            System.out.println("\t\tPress O to play as 'O' and X to play as 'X'");
            checkplayer = scan.next().toUpperCase().charAt(0);
        }
        if (checkplayer == 'X')
        {
            player = 'X';
        } else
        {
            player = 'O';
        }
        //Play as X O ends here
        //Playing  
        do
        {
            board();
            System.out.format("Player %c Turns\n", player);
            System.out.println("Please Choose a Spot");
            int spot = Integer.parseInt(scan.next());
            setMark(spot);
            checker = checkWinner();
            nextPlayer();

        } while (checker == 0);

        //Declearing Winner
        board();    //Wiining Board
        if (checker == 1)
        {
            nextPlayer();
            System.out.format("We Got a WINNER !!!!\n");
            delayString(String.format("Winner is %c !!!!!!!\n", player));
        } else
        {
            System.out.println("Awwwww Not a Winner :-(");
            delayString("Draw :-O");

        }

      }

    public void board()
      {
        System.out.println("\n\t╔═══╦═══╦═══╗");
        System.out.format("\t║ %c ║ %c ║ %c ║\n", ans[1], ans[2], ans[3]);
        System.out.println("\t╠═══╬═══╬═══╣");
        System.out.format("\t║ %c ║ %c ║ %c ║\n", ans[4], ans[5], ans[6]);
        System.out.println("\t╠═══╬═══╬═══╣");
        System.out.format("\t║ %c ║ %c ║ %c ║\n", ans[7], ans[8], ans[9]);
        System.out.println("\t╚═══╩═══╩═══╝");
        System.out.println("\n\n");
      }

    private void nextPlayer()
      {
        if (this.player == 'X')
        {
            player = 'O';
        } else
        {
            player = 'X';
        }
      }

    private int checkWinner()
      {
        //Rows
        if (ans[1] == ans[2] && ans[2] == ans[3])
        {
            return 1;
        } else if (ans[4] == ans[5] && ans[5] == ans[6])
        {
            return 1;
        } else if (ans[7] == ans[8] && ans[8] == ans[9])
        {
            return 1;
        } //Columns    
        else if (ans[1] == ans[4] && ans[4] == ans[7])
        {
            return 1;
        } else if (ans[2] == ans[5] && ans[5] == ans[8])
        {
            return 1;
        } else if (ans[3] == ans[6] && ans[6] == ans[9])
        {
            return 1;
        } //Diagonal
        else if (ans[1] == ans[5] && ans[5] == ans[9])
        {
            return 1;
        } else if (ans[3] == ans[5] && ans[5] == ans[7])
        {
            return 1;
        } //WINNER CHECKING ENDS
        //DRAW CONDITION
        else if ((ans[1] != '1') && (ans[2] != '2') && (ans[3] != '3') && (ans[4] != '4') && (ans[5] != '5') && (ans[6] != '6') && (ans[7] != '7') && (ans[8] != '8') && (ans[9] != '9'))
        {
            return -1;
        } //NO RESULTS
        else
        {
            return 0;
        }
      }

    //Setup Choose Spot
    private void setMark(int position)
      {
        while (position < 1 || position > 9)
        {
            System.out.println("Wrong Input Please Choose from 1 to 9");
            System.out.println("Please Choose a Spot");
            position = Integer.parseInt(scan.next());

        }
        while (ans[position] == 'X' || ans[position] == 'O')
        {
            System.out.format("Spot Already Taken by %c \nPlease try Another Blank Spot\n", ans[position]);
            position = Integer.parseInt(scan.next());

        }
        ans[position] = player;

      }

    private void setMarkAI()
      {
//        while (position < 1 || position > 9)
//        {
//            position = ran.nextInt(9) + 1;
//        }
        int position = ran.nextInt(9) + 1;
        while (ans[position] == 'X' || ans[position] == 'O')
        {
//            System.out.println("Wrong AI");
            position = ran.nextInt(9) + 1;
        }
        System.out.println(position);
        ans[position] = player;

      }

    private void guessSpotAI()
      {

        //If any two Same available then Third Spot taken by AI
        //Start
        if (ans[5] == '5')
        {
            ans[5] = player;
        } else if ((ans[1] == ans[2] || ans[6] == ans[9] || ans[7] == ans[5]) && (ans[3] != 'X' && ans[3] != 'O'))
        {
            ans[3] = player;

        } else if ((ans[2] == ans[3] || ans[4] == ans[7] || ans[5] == ans[9]) && (ans[1] != 'X' && ans[1] != 'O'))
        {

            ans[1] = player;

        } else if ((ans[4] == ans[5] || ans[3] == ans[9]) && (ans[6] != 'X' && ans[6] != 'O'))
        {

            ans[6] = player;

        } else if ((ans[5] == ans[6] || ans[1] == ans[7]) && (ans[4] != 'X' && ans[4] != 'O'))
        {

            ans[4] = player;

        } else if ((ans[7] == ans[8] || ans[3] == ans[6] || ans[1] == ans[5]) && (ans[9] != 'X' && ans[9] != 'O'))
        {
            ans[9] = player;

        } else if ((ans[8] == ans[9] || ans[1] == ans[4] || ans[3] == ans[5]) && (ans[7] != 'X' && ans[7] != 'O'))
        {
            ans[7] = player;

        } else if ((ans[1] == ans[3] || ans[5] == ans[8]) && (ans[2] != 'X' && ans[2] != 'O'))
        {
            ans[2] = player;

        } else if ((ans[4] == ans[6] || ans[2] == ans[8] || ans[1] == ans[9] || ans[3] == ans[7]) && (ans[5] != 'X' && ans[5] != 'O'))
        {
            ans[5] = player;

        } else if ((ans[7] == ans[9] || ans[2] == ans[5]) && (ans[8] != 'X' && ans[8] != 'O'))
        {
            ans[8] = player;

        } //End
        //Setting a Spot 
        else
        {
            setMarkAI();

        }

      }

  }
