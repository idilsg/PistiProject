package project;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Project {
  public static void main(String args[]) {
    int[] exampleArray = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 };

    shuffleArray (exampleArray);
    for (int i = 0; i < exampleArray.length; i++) {
      System.out.print(exampleArray[i] + " ");
    }
    System.out.println();
  }

  
  public static void shuffleArray (int[] arr) {
      
    Random r = ThreadLocalRandom.current();
    for (int i = arr.length - 1; i > 0; i--) {
      int index = r.nextInt(i + 1);
      int a = arr[index];
      arr[index] = arr[i];
      arr[i] = a;
    } 
  } 
}
