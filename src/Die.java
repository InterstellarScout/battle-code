import java.util.Random;

public class Die
{
   private int value;
   private int sides;
   
   public void roll()
   {
      
Random r = new Random();          //we assign r to Random 
value = r.nextInt(sides) + 1;     //We now tell Random to generate a number up to the number of sides, then add one to shift it from 0-5 to 1-6 numbers.
      
   }

    public void setValue(int value) 
    {
        this.value = value;
    }
   
   public int getValue()
   {
      return value;
   }
   
   
   public int getSides()
   {
      return sides;
   }
   
   public void setSides(int sides)
   {
      this.sides = sides;
   }
   
}