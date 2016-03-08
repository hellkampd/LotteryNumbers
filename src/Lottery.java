/*Daniel Hellkamp Jr.*/
import java.io.File;
import java.util.Scanner;


 

public class Lottery {
  //variable to hold number of players, lotto numbers
 static int Rows, Cols;
 //static String[][] Grid;
 static LottoTickets[] tickets;  
public static class LottoTickets{
   //not sure how to assign individual name and numbers because needs to be from a
   //static context???????
 public String lname;
 public String fname;
 public int numbers[];
 public int matches;
 public LottoTickets(){
 numbers = new int[6];}
 } 

 static void LoadData() throws Exception
 {
   String inputfileName;
   Scanner user = new Scanner( System.in );
   inputfileName = user.nextLine().trim();
   File input = new File( inputfileName );  
   Scanner in = new Scanner(input);
  
   //get number of tickets to read in
   Rows = in.nextInt();
   tickets = new LottoTickets[Rows];
   //6 lotto numbers
   Cols = 6;
 
  for( int row=0; row<Rows; row++ )
  {
   tickets[row] = new LottoTickets();
    //get player name before getting numbers
   tickets[row].lname = in.next();
   tickets[row].fname = in.next();
   for( int col=0; col<Cols; col++ )
   {
    tickets[row].numbers[col] = in.nextInt();
   }
  }
  
  in.close();
  
 }
 public static void main(String[] args){
   
// LottoTickets[] lotto = new LottoTickets[Rows];
 int winners[] = new int[6];
  //request user input for file io
 System.out.println("Enter the name of the file with the ticket data.");
 
 //Call method for file io
 //use try catch block
 try
 {
 LoadData();
 }
 catch(Exception ex){}
 
   for( int row=0; row<Rows; row++ )
  {
     System.out.print(tickets[row].fname + " " + tickets[row].lname);
     System.out.println("");
     for(int col=0; col<Cols; col++){
       System.out.print(" "+ tickets[row].numbers[col]);}
     System.out.println();
   }
  
 
 //create new scanner for obtaining winning lotto numbers
 Scanner sc = new Scanner(System.in);
 
 System.out.println("Enter the winning lottery numbers.");
 //scan in the 6 winning numbers from the user
 for(int i=0; i<6; i++)
 {
  winners[i] = sc.nextInt();
 }
 
 //Determining the winners
 //loop through each ticket
 for(int row=0; row<Rows; row++)
 {
  //compare each of the values of the winning numbers with the numbers the player has
   for(int i=0; i<6; i++)
   {
     if(winners[i]==tickets[row].numbers[i]){
       //attribute the matches to the player themselves
     tickets[row].matches++;}
   }
  }
 //output the winnings using enums
   // Output the winnings of each of the players
  for (int j=0; j<Rows; j++) {
 
 switch (tickets[j].matches)
  {
  case 3:
   System.out.println(tickets[j].fname + " " + tickets[j].lname + " has " + tickets[j].matches + " matches and won " + Winnings.THREE.getValue()); break;
  case 4:
   System.out.println(tickets[j].fname + " " + tickets[j].lname + " has " + tickets[j].matches + " matches and won " + Winnings.FOUR.getValue()); break;
  case 5:
   System.out.println(tickets[j].fname + " " + tickets[j].lname + " has " + tickets[j].matches + " matches and won " + Winnings.FIVE.getValue()); break;
  case 6:
   System.out.println(tickets[j].fname + " " + tickets[j].lname + " has " + tickets[j].matches + " matches and won " + Winnings.SIX.getValue()); break;
  default:
   System.out.println(tickets[j].fname + " " + tickets[j].lname + " is not a winnner");
  }
  

 }
}
public enum Winnings
{
 THREE(10),
 FOUR(100),
 FIVE(10000),
 SIX(1000000);
 
 private int value;
 
 public int getValue() { return value; }
 
 private Winnings(int value)
 {
  this.value = value;
 }
 public int getWinnings(int value) {
        return this.value;
    }
}

}


