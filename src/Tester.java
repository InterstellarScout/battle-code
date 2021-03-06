/*
Write a class to test everything:

Create a new BattleManager
Use the BattleManager to setup 2 new Heroes.
Print the stats of each hero
Call the round method using the heroes as input paramters
Print the stats of each hero
Call the round method using the heroes as input paramters
Print the stats of each hero
Compare the health of the two heroes. Print the name of the hero with the most health and declare them the winner.

*/

public class Tester {
    
 //Heroes String name
 //Heroes String name, int stregnth, int agility
        public static void main(String[] args) {
            
          BattleManager BM = new BattleManager();  
          
          //Heroes Battle(int round, Heroes h1, Heroes h2)
          BM.Start(); //Creates the two characters by inputting their names. Then it automatically displays stats.
          
          /*
          BM.Round(BM.h1, BM.h2); //The round asks the player to attack, defend, or rest, then automatically prints the stats at the end. 
          
          BM.Round(BM.h1, BM.h2);
          
          BM.Round(BM.h1, BM.h2); //If any player's health goes below 0, the round is skipped and jumps to Winner();
          */
          BM.Battle(10, BM.h1, BM.h2);
          
          BM.Winner(); //Compares the player's health and declares the winner who has the most health! If they are tied, they tie.
           
            
        }
}
