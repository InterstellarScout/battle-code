
import java.util.Scanner;

/*
A battleManager is a management class. It handles all the interactions between hero objects. It also uses the Die class. A battle manager needs the following methods:

setupHero - Takes a string, the name of the hero, as a parameter. The method uses the initialization instructions above to create and initialize a hero object. The method returns the hero object that was created. 

round - takes two hero objects, returns void. Allows user to select moves, performs the moves, and applies damage. print any info you would like upon completion.

You may have any other private methods you like

*/
public class BattleManager {

    public Scanner scnr = new Scanner(System.in);
      
    Heroes h1;
    Heroes h2;
    
    boolean heroDown = false;
    
    int round = 0;
    
    public Heroes setHero(String name) {
   //stamina cost of attacking (6), the stamina cost of defending (4), the default values for health (50), stamina (25), strength (5), and agility (5) if none are specified.
    
   Heroes hero= new Heroes(name);
    
   //int stregnth;
   //int agility;
   //Roll one 12 sided die, one 10 sided die, and one 8 sided die. Assign the highest value to strength. Set agility to the sum of the other two values.
    int die1;
    int die2;
    int die3;
    
   Die d12;
   Die d10;
   Die d8;
   
   d8 = new Die();
   d10 = new Die();
   d12 = new Die();
   
   d8.setSides(8);
   d10.setSides(10);
   d12.setSides(12);
   
   d8.roll();  
   die2 = d8.getValue();
   d10.roll();  
   die3 = d10.getValue();
   d12.roll();   
   die1 = d12.getValue();
   
   int firstMaxDie;
  
   //Calculations of Adding the highest value to health. Add the sum of the other two to stamina.
  firstMaxDie = Math.max(die1, die2);
  hero.strength = Math.max(die3, firstMaxDie);
   
   hero.agility = die1 + die2 + die3;
   hero.agility = hero.agility - hero.strength;
  
   return hero;
    }


   public EquippedHero setHero(String name, Equiptment eq) {
   //stamina cost of attacking (6), the stamina cost of defending (4), the default values for health (50), stamina (25), strength (5), and agility (5) if none are specified.
       
   EquippedHero EQHero = new EquippedHero(name, eq);
       
   //int stregnth;
   //int agility;
   //Roll one 12 sided die, one 10 sided die, and one 8 sided die. Assign the highest value to strength. Set agility to the sum of the other two values.
    int die1;
    int die2;
    int die3;
    
   Die d12;
   Die d10;
   Die d8;
   
   d8 = new Die();
   d10 = new Die();
   d12 = new Die();
   
   d8.setSides(8);
   d10.setSides(10);
   d12.setSides(12);
   
   d8.roll();  
   die2 = d8.getValue();
   d10.roll();  
   die3 = d10.getValue();
   d12.roll();   
   die1 = d12.getValue();
   
   int firstMaxDie;
  
   //Calculations of Adding the highest value to health. Add the sum of the other two to stamina.
  firstMaxDie = Math.max(die1, die2);
  EQHero.strength = Math.max(die3, firstMaxDie);
   
   EQHero.agility = die1 + die2 + die3;
   EQHero.agility = EQHero.agility - EQHero.strength;
   
   return EQHero;
    }
                               
    public void Start()
    {
    String name1;
    System.out.println("Welcome to Battle Code!");
    System.out.println("Lets first start by creating our characters");
    System.out.println("Please enter the name of Hero 1:");
    name1 = scnr.nextLine();
    
    h1 = setHero(name1);

    
    String name2;
    System.out.println("Please enter the name of Hero 2:");
    name2 = scnr.nextLine();  
        
    h2 = setHero(name2);
    
    h1.printStats();
    
    h2.printStats();
    
    System.out.println("WELCOME TO JAVA TOURNAMENTS!");
    System.out.println("When asked, you will choose to either defend, d, or attack, a for each player. In three rounds the player with the most heath wins.");
    System.out.println("Go!");
    System.out.println(" ");
    
    }
    
    /*
    A round consists of each player selecting a move and calculating the resulting damage. Each player must select a move for their hero. Hero objects can attack or defend. Each move requires stamina. If the hero cannot afford the stamina cost, it must rest. 

Once both players select a move damage is calculated.

Attacking and resting provide no defense. If you are attacked in these states, you receive full damage
resting adds health, which mitigates damage, but it is not the same as blocking
Blocking provides defense. If a hero is attacked when blocking, damages could be averted
If the block value is greater than or equal to the attack value, the attack is dodged
Otherwise the difference between the attack and the block is the damage.
    */
    
    public void Round(Heroes h1, Heroes h2)
    //round - takes two hero objects, returns void. Allows user to select moves, performs the moves, and applies damage. print any info you would like upon completion.
    //Allows user to select moves, performs the moves, and applies damage. print any info you would like upon completion.
    {
       boolean h1isDefenceless = false;
       boolean h2isDefenceless = false;

       int hero1Attack = 0;
       int hero2Attack = 0;
       
       int hero1Defend = 0;
       int hero2Defend = 0;
       
       if (h1.heroDown == false && h2.heroDown == false) //If a hero is down, skip to the end. 
       {
        round = round + 1;
        System.out.println("");
        System.out.println("Round " + round);
   
    //Hero 1 actions
    System.out.println(h1.name + " Steps forward, what do they do?");
    String response = scnr.nextLine();
    if ("attack".equals(response) || "a".equals(response))
    {
        System.out.println(h1.name + " Attacks!");
        h1.Attack();
        hero1Attack = h1.getAttack();
        System.out.println(hero1Attack);
        
        h1isDefenceless = true;
    }
    
    if ("defend".equals(response) || "d".equals(response))
    {
        System.out.println(h1.name + " Defends");
        h1.Defend();
        hero1Defend = h1.getDefend();
        System.out.println(hero1Defend);
        

    }

    //Hero 2 Actions
    System.out.println(h2.name + " Steps forward, what do they do?");
    response = scnr.nextLine();
    if ("attack".equals(response) || "a".equals(response))
    {
        System.out.println(h2.name + " Attacks!");
        h2.Attack();
        hero2Attack = h2.getAttack();
        System.out.println(hero2Attack);
                
        h2isDefenceless = true;
    }
    
    if ("defend".equals(response) || "d".equals(response))
    {
        System.out.println(h2.name + " Defends");
        h2.Defend();
        hero2Defend = h2.getDefend();
        System.out.println(hero2Defend);
        

    }

    
    if (h1isDefenceless == true && h2isDefenceless == true)
    {
        //Both Players Attack
        h1.loseHealth(hero2Attack);
        h2.loseHealth(hero1Attack);
        
    }
 
    if (h1isDefenceless == false && h2isDefenceless == false)
    {
        //Both Players Defend
        System.out.println("Both Heroes stare at each other, waiting for each other to make a move. Silence fills the arena. Nothing happens...");
    }
 
    if (h1isDefenceless == true && h2isDefenceless == false)
    {
        //Hero 1 attacks, Hero 2 defends
        hero1Attack = hero1Attack - hero2Defend;
        if (hero1Attack > 0)
        {
        h2.loseHealth(hero1Attack); //So the defence doesnt end up adding health. 
        }
        
        
    }
 
    if (h1isDefenceless == false && h2isDefenceless == true)
    {
        //Hero 1 defends, Hero 2 Attcks
        hero2Attack = hero2Attack - hero1Defend;
        if (hero2Attack > 0) //So the defence doesnt end up adding health. 
        {
        h1.loseHealth(hero2Attack);
        }
       
    }
          
        h1.checkHealth();
        h2.checkHealth();
 
        /*
if (h1.heroDown == true || h2.heroDown == true) //this checks if either hero is down
    {
        Winner();
    }
*/
  
    h1.printStats();
    h2.printStats();
       }
}
    
public void Winner()
{
    //Compare the health of the two heroes. Print the name of the hero with the most health and declare them the winner.
    if  (h1.health > h2.health)
    {
        System.out.println(h1.name +" is the WINNER!");
    }
    
    if  (h1.health < h2.health)
    {
        System.out.println(h2.name +" is the WINNER!");
    }
    
    if  (h1.health == h2.health)
    {
        System.out.println(h1.name + " and " + h2.name + " Tied... Congrats? I guess? They won? Sort of? Time to go home I guess...");
    }
}

/*
Add a method called battle. This method takes, as parameters, 2 heroes and a number of rounds to fight. 
Your battle method should use a loop to run the round methods, 
with the heroes as input to round. Battle should return the hero with the most health after all rounds have completed. You can handle a tie how ever you like AS LONG AS 
A HERO OBJECT YOU CONSIDER THE WINNER IS RETURNED
*/
public Heroes Battle(int round, Heroes h1, Heroes h2)
{
int roundNum;
    
roundNum = 0;

Heroes winner = null; //Null is used as a place holder to 

while (roundNum < round && h1.heroDown == false && h1.heroDown == false)
{
Round(h1, h2);

       h1.checkHealth();
       h2.checkHealth();

roundNum++;

if (h1.heroDown == true)
    {
      winner = h2;  
    }

if (h2.heroDown == true)
    {
      winner =  h1;
    }
}

if (h1.heroDown == true || h1.health < h2.health)
    {
      winner = h2;  
    }

else if (h2.heroDown == true || h1.health > h2.health)
    {
      winner = h1;
    }

while (h1.health == h2.health)
    {
      System.out.println(h1.name + " and " + h2.name + " Tied... Congrats? I guess? They won? Sort of? Time to go home I guess...");
      System.out.println("Do we like ties? No? FIGHT AGAIN!!!!!!!!!!!!!!");
      winner = Battle(round, h1,h2);
    }

return winner;
}

/*
Modify your BattleManager class
Add a method called battle. This method takes, as parameters, 2 heroes and a number of rounds to fight. Your battle method should use a loop to run the round methods, with the heroes as input to round. Battle should return the hero with the most health after all rounds have completed. You can handle a tie how ever you like AS LONG AS A HERO OBJECT YOU CONSIDER THE WINNER IS RETURNED
Add a method called tournament. This method takes, as parameters, an array of heroes. This method runs a single elimination tournament on all the heroes. The method should call the battle method for pairs of heroes in the array. Each battle in the tournament lasts for 3 rounds. After the tournament has completed, return the hero object that is the winner of the entire tournament
Test your changes to the battle manager by creating a main class that
Creates a battle manager
Creates 2 heroes and battles tehm for 5 rounds. using the battle method.
Creates an array of 5 hero objects
call the tournament method with your array
Below is a sample class with a main method that generates an array of heroes 
*/
public Heroes tournament(Heroes[] Heroes)
{   
    Heroes[] currentRound = Heroes; //The round where Heroes fight
    Heroes[] nextRound = new Heroes[((int)Math.ceil(Heroes.length/2))]; //The round where the winning heroes go.
    
    //When fighting is complete, nextRound gets copied into current round, the gets overwritten to be blanked for the new Heroes
    int j = 0;
    int i = 0;
    int battle = 0;
        

   while (currentRound.length > 2) //While there are more then two heroes, do this.
   {
  
        if (currentRound.length % 2 == 1) //if there is only one hero remaining, move them to the next round.
           {
           nextRound[j] = currentRound[i]; //Add the remaining hero to nextRound
           j++;
           i++;
           }
        
     //What is wrong with the battle code? Why is it that when a player goes down, it crashes?
     //How do you reset the information for a hero?
     //Why is there an Array issue?
     
       for (;i < currentRound.length; i++)
       {
           battle = battle + 1;
           System.out.println("");
           System.out.println("");           
           System.out.println("Battle set: " + battle);

           
           nextRound[j] = Battle(3, currentRound[i], currentRound[i+1]);
           System.out.println("The winner is: " + nextRound[j].name);
           nextRound[j].health=40; //Reset the winning hero's stats
           nextRound[j].stamina=25;
           //This is needed to push the losing player out of the turnoment.
           //Add the winning hero to nextRound

           i++;
           j++;
         }

       
       currentRound = nextRound;
       nextRound = new Heroes[((int)Math.ceil(Heroes.length/2))]; //The nextRound where the winning heroes go is recreated for the next round.
    } 
   
   
return Battle(3, currentRound[0], currentRound[1]);

}
}

