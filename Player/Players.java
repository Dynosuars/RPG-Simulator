package Player;
import Character.Characters;
import Character.Items;
import java.util.Random;

public class Players extends Characters{


    public Players(String name, int HLT, int ATK, int DEF, int SPD, int MAG){
        super(HLT, ATK, DEF, SPD, MAG);
        this.name = name;
    }

    /**
     * FAHHHHHHHH STUPID ASS FUNCTION
     * @param other
     * @return
     */
    @Override
    public double attack(Characters other) {
        double damage;
        double multiplier = 1;

        // Crit system because i am  A GAMBLER
        if(this.stat.ATK > other.getStats().DEF){
            if(new Random().nextInt(0, 100) < 20)
                multiplier = 4; // HOI4 ass crit system
        }

        // I am no math lunatics so I js figured out something I GUESS BRO. I NEVER MADE A GAME LIKE THIS
        //multiplier += Math.log10(this.getLevel() - other.getLevel()); 
        
        damage = this.stat.ATK * 3;
        System.out.println("Multiplier: " + multiplier);
        System.out.println(this.getLevel() / other.getLevel());
        other.getHit(damage);
        return damage;
    }

    @Override
    public Items UseItem(int item) {
        boolean success = this.inv.Use(item, this);
        return success ? this.inv.getActive()[item] : null;
    }

    @Override
    public void getHit(double damage){
        this.Health -= damage;
    }


}
