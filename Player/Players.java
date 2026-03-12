package Player;
import Character.Characters;
import Character.Items;
import Enemy.Enemies;
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
            else multiplier = 1.5;
        }

        // I am no math lunatics so I js figured out something I GUESS BRO. I NEVER MADE A GAME LIKE THIS
        multiplier += this.stat.ATK > other.getStats().ATK ? Math.log10(this.stat.ATK - other.getStats().ATK) : 0;
        
        damage = this.stat.ATK * 3 * multiplier;
        System.out.println("Multiplier: " + multiplier);
        other.getHit(damage);
        return damage;
    }

    @Override
    public Items UseItem(int item) {
        boolean success = this.inv.Use(item, this);
        return success ? this.inv.getActive()[item] : null;
    }

    public String[] loots(Enemies other){
        int currlevel = this.getLevel();
        this.Experience += other.getExperience() * 0.87 + 50;
        Items drop = other.drop();
        this.inv.Add(drop);

        String exp, drops;
        exp = "You gained: " + (other.getExperience() * 0.87 + 50) + " experience points" + ((currlevel!=this.getLevel())?" and leveled up! new level = " + this.getLevel() : "");
        drops = drop != null ? "You looted: " + drop.getName() : "The enemy dropped nothing :(";

        return new String[]{exp, drops};

    }

    // I MIGHT ADD THIS BACK
    /*@Override
    public void getHit(double damage){
        System.out.println("DAMAGE RED: " + (1 - (damage/this.stat.DEF)/ 100));
        System.out.println("True damage delt: " + damage * (1 - (damage/this.stat.DEF)/ 100));
        this.Health -= damage * (1 - (damage/this.stat.DEF)/ 100);
    }*/


}
