/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_ov;

import java.util.Random;

/**
 *
 * @author OV
 */
public abstract class Tools
  {
    //##############################################################################
    //#                         A Tool Kit for Every Game                          #
    //##############################################################################

    public Tools()
      {
      }

    //Delay Thread fro certain miliseconds
    protected static void delay(int miliseconds)
      {
        try
        {
            Thread.sleep(miliseconds);
        } catch (InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
      }

    //Printing String with small delay b/w chars
    protected static void delayString(String s)
      {
        for (int i = 0; i < s.length(); i++)
        {
            System.out.print(s.charAt(i));
            delay(300);
        }
      }
    
    //Spacing
    protected static void newPage()
      {
          for (int i = 0; i < 50; i++)
          {
              System.out.println("");
          }
      }
    

    //Suffling Array using
    //FISHER–YATES shuffle ALGORITHM
    protected int[] shuffleArray(int[] array)
      {
        Random rand = new Random();
        for (int i = array.length - 1; i > 0; i--)
        {
            int index = rand.nextInt(i + 1);
            // Simple swap
            int a = array[index];
            array[index] = array[i];
            array[i] = a;
        }
        return array;
      }

    //Learn from StackOverFlow ARRAY-Merge
    //Use a Vararge Parameter Array and System.arraycopy to Combined them
    protected int[] mergeArray(int[]... arrays)
      {
        int length = 0;
        for (int[] array : arrays)
        {
            length += array.length;
        }

        final int[] result = new int[length];

        int offset = 0;
        for (int[] array : arrays)
        {
            System.arraycopy(array, 0, result, offset, array.length);
            offset += array.length;
        }

        return result;
      }

    //Char Array to int Array Converter
    //twoD arrays
    protected int[] charToIntArray(char[] charArray)
      {
        int[] intArray = new int[charArray.length];
        for (int i = 0; i < intArray.length; i++)
        {
            intArray[i] = Character.getNumericValue(charArray[i]);
        }
        return intArray;
      }

    protected int[][] charToIntArray(char[][] charArray)
      {
        int[][] intArray = new int[charArray.length][charArray.length];
        for (int i = 0; i < intArray.length; i++)
        {
            for (int j = 0; j < intArray[i].length; j++)
            {
                intArray[i][j] = Character.getNumericValue(charArray[i][j]);
            }

        }

        return intArray;
      }
  }
