
public class Question {
    public static void main ( String args[]){
       boolean goat = true ;
       boolean hero = false; 
       Question.message(goat);}
    public static void message(boolean status){
       if ( status) System.out.println("You’re fired!");
  else System.out.println("You passed!"); }}