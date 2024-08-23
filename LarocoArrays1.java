/******************************************************************************
 
NAME: JAN LORENZ L. LAROCO
SECTION: BSIT-2B
DATE: AUGUST 23,2024
DESCRIPTION: Prelim-Lab.Act.#01 - Working with Arrays

*******************************************************************************/
import java.util.InputMismatchException;
import java.util.Scanner;

class LarocoArrays1
{
  static Scanner scanner = new Scanner(System.in);
  static int size;
  static int[] grades;
  static int sum=0;
  static boolean error = false;
  static String choice ="";
    
	public static void main(String[] args) {
    
    displayName();
    do{
	     displaySize();
	     displayGrades();
       displayMin();
       displayMax();
       displayAverage();

        System.out.println();
        System.out.printf("\nDo you want to compute again? Y/N: ");
        choice = scanner.next();
        sum = 0;

    } while (choice.equalsIgnoreCase("Y"));
		System.out.printf("Thank you!");
	}
  /*FUNCTIONS*/

  static void displayName(){
    System.out.printf("------Name: Jan Lorenz L. Laroco-----\n");
    System.out.printf("Prelim-Lab.Act.#01 - Working with Arrays\n");
    System.out.printf("\n");
  }

  //forSIZE
	static void displaySize(){
    do {
      error = false;
      try {
          System.out.printf("Enter the number of grades you want to compute: ");
          size = scanner.nextInt();
          grades = new int[size]; 
  
        if(size<=1 || size>=10){
          System.out.printf("Invalid number. (2-10 grades only)\n");
          displaySize();
        } 
          
      } catch (InputMismatchException e) {
          System.out.printf("Please input numbers. \n");
          error = true;
          scanner.nextLine();
        }
        
    } while(error);
    }

  //forGRADES
	static void displayGrades() {
    sum = 0;
    
    for (int i = 0; i < grades.length; i++) {
        boolean validInput = false; 

        while (!validInput) {
            try {
                System.out.printf("Grade #%d: ", i + 1);
                int grade = scanner.nextInt();

                if (grade < 70 || grade > 100) {
                    System.out.println("Enter a valid grade (between 70 and 100).");
                } else {
                    grades[i] = grade;
                    sum += grade;
                    validInput = true; 
                }
            } catch (InputMismatchException e) {
                System.out.printf("Invalid input. Please input a number between 70 and 100.\n");
                scanner.nextLine(); 
            }
        }
    }  
}  
 
  //forMAX
	static void displayMax(){
	    int max = grades[0];
	    for(int i=1; i<grades.length; i++){ 
	        if(max<grades[i]){
	            max = grades[i];
	        }
	    }
	    System.out.printf("\nMax: "+ max);
  }

  //forMIN
	static void displayMin(){
	    int min = grades[0];
	    for(int i=1; i<grades.length; i++){
	        if(min>grades[i]){
	            min = grades[i];
	        }
	    }
	    System.out.printf("\nMin: "+ min);
  }

  //forAVERAGE
  static void displayAverage(){
    double average = (double) sum/size;
    System.out.printf("\nThe average is: %.2f", average);
  }

}