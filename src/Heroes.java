/*
Attached to this assignment is an Equipment class. Equipment can modify the Hero defense and attack.

Modify your hero to make the fields protected - this way the sub class can access our fields.
Extend a Hero class and create an EquippedHero class.


Modify your battle manager and overload the setup method so that it takes a name and an equipment object as a parameter and returns a new equippedHero object.
Modify your main method so that it creates an array EquippedHeroes  and runs a tournament


Use at least one toString method. Add toString methods to anything you like - probably everything.

Unless otherwise specified define any additional constructors or private methods you need
Below is a sample class with a main method that generates an array of equipped heroes. 
Submission


*/

public class Heroes {

    public String name;
    public int health;
    public int stamina;
    public int strength;
    public int agility;
    
    public int attack;
    public int defence;
    public boolean heroDown;
    
    //public int healthGain;
    public int healthLoss;
    public int staminaCost;
    
    public final int attacking = 6;
    public final int defending = 4;
    public final int dHealth = 50;
    public final int dStamina = 25;
    public final int dStrength = 5;
    public final int dAgility = 5;

        //Constructors
    public Heroes(String name) {
        //stamina cost of attacking (6), the stamina cost of defending (4), the default values for health (50), stamina (25), strength (5), and agility (5) if none are specified.
        this.name = name;
        //this.strength = dStrength;
        //this.agility = dAgility;
        this.health = dHealth;
        this.stamina = dStamina;
    }

    
    
    public Heroes(String name, int stregnth, int agility) {
        this.name = name;
       // this.strength = stregnth;
       // this.agility = agility;
        this.health = dHealth;
        this.stamina = dStamina;
    }
    
    //Name Methods
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    
    //Health Methods
    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }
    
    //gain Health
    public int addHealth(int healthGain) {
        health = health + healthGain;
        
        return health;
    }
    
    //Losing Health    
    public int loseHealth(int healthLoss) {
        health = health - healthLoss;
        
        return health;
    }


   
//Stamina Methods
    public int getStamina() {
        return stamina;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }
    
    //Gain Stamina
    public int addStamina(int StaminaGain) {
        stamina = stamina + StaminaGain;
        
        return stamina;
    }
    
    //Lose Stamina
    public int loseStamina(int StaminaLoss) {
        stamina = stamina - StaminaLoss;
        
        return stamina;
    }
    
        
    //Stregnth Methods
    public int getStregnth() {
        return strength;
    }

    public void setStregnth(int stregnth) {
        this.strength = stregnth;
    }

    
    //Agility Methods
    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }
    
    /*
    Actions:

defend - returns the int value calculated by the table below - if stamina is less than move cost, opponent must rest and zero is returned
attack - returns the int value calculated by the table below - if stamina is less than move cost, opponent must rest and zero is returned
rest   - returns void, adds to health and stamina based on table below, should be private and triggered by attack/defend

Move	Action	Calculation                                                                                                                                                                                         Stamina Cost
Attack	User selected, attacks opponent	Roll a 20 sided die. The attack value is the strength plus the roll. If the Hero cannot meet the stamina cost, it must rest and the attack value is zero                             6
Defend	User selected, defends from opponent attack	Roll a 20 sided die. The defend value is the agility plus the die roll. If the Hero cannot meet the stamina cost, it must rest and the attack value is zero           4
Rest	triggered when stamina is depleted	When a player tries to attack/defend but is out of stamina, roll a 6 sided, an 8 sided die, and a 10 sided die. Add the highest value to health. Add the sum of the other two to stamina.   0
*/
    
public int Attack()
{
   int d20total;
   
if (stamina >= 6)
{
  loseStamina(6);
   
   Die d20;
   d20 = new Die();
   d20.setSides(20);
   d20.roll();
   
   d20total = d20.getValue();
   
   attack = d20total + agility;
   
   return attack;
}
    
else
    {
        System.out.println(name + " doesn't have enough stamina! " + name + " rests!");
        attack = 0;
        Rest();
        return attack;
        
    } 
}

public int getAttack()
{
    return attack;
}
    
public int Defend()
{
   
   int d20total;
   
if (stamina >= 4)
{
   loseStamina(4);
       
   Die d20;
   d20 = new Die();
   d20.setSides(20);
   d20.roll();
   
   d20total = d20.getValue();
   
   defence = d20total + agility;
   
   return defence;
}
 
else
    {
        System.out.println(name + " doesn't have enough stamina! " + name + " rests!");
        defence = 0; 
        Rest();
        return defence;
    }
}
    
public int getDefend()
{
    return defence;
}
   

private void Rest()
//When a player tries to attack/defend but is out of stamina, roll a 6 sided, an 8 sided die, and a 10 sided die. Add the highest value to health. Add the sum of the other two to stamina.   0
{
    int healthGain;
    int staminaGain;
   
    int die1;
    int die2;
    int die3;
    
   Die d6;
   Die d8;
   Die d10;
   
   d6 = new Die();
   d8 = new Die();
   d10 = new Die();
   
   d6.setSides(6);
   d8.setSides(8);
   d10.setSides(10);
   
   d6.roll();   
   die1 = d6.getValue();
   d8.roll();  
   die2 = d8.getValue();
   d10.roll();  
   die3 = d10.getValue();
   
   int firstMaxDie;
  
   //Calculations of Adding the highest value to health. Add the sum of the other two to stamina.
   firstMaxDie = Math.max(die1, die2);
   healthGain = Math.max(die3, firstMaxDie);
   
   staminaGain = die1 + die2 + die3;
   staminaGain = staminaGain - healthGain;
  
   addHealth(healthGain);
   addStamina(staminaGain);
   //all adjustments are made in the functions above
   
}

public boolean checkHealth()
{

    if (health <= 0)
    {
        System.out.println(name + " Is down!");
        heroDown = true;
    }
    else 
    {
        heroDown = false;
    }
    
    return heroDown;
}

public boolean getDown()
{
    return heroDown;
}
    
       public void printStats()
    {
        System.out.println("Hero Name is " + name);
        System.out.println("Hero " + name + " Health: " + health);
        System.out.println("Hero " + name + " Stamina: " + stamina);
        System.out.println("Hero " + name + " Stregnth: " + strength);
        System.out.println("Hero " + name + " Agility: " + agility);
        System.out.println(" ");
        
    }
       
    @Override
    public String toString()
    {
        return  name + " is the Hero. They have + " + health + " health, " + strength + " strength, and " + agility + " agility.";
    }

    
    
    
    
    
    
    
    
    
}
