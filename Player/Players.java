package Player;
import Character.Characters;
import Character.Items;
import Enemy.Enemies;
import java.util.Random;

public class Players extends Characters{

    private int skillPoints;

    public Players(String name, int HLT, int ATK, int DEF, int SPD, int MAG){
        super(HLT, ATK, DEF, SPD, MAG);
        this.name = name;
        this.skillPoints = 0;
    }

    /**
     * FAHHHHHHHH STUPID ASS FUNCTION
     * @param other<Characters: enemy> character
     * @return damage<double> of the attack
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
        // Debug 
        // System.out.println("Multiplier: " + multiplier);
        other.getHit(damage);
        return damage;
    }

    
    @Override
    /**
     * Uses a item within this.inv
     * @param item<int> index of the item
     * @return the item being used
     */
    public Items UseItem(int item) {
        Items result = this.inv.getActive()[item];
        boolean success = this.inv.Use(item, this);
        return success ? result : null;
    }

    /**
     * A EASY method to gain exp
     * @param experience
     * @return the numbers of level gained 
     */
    public int GainExp(double experience){
        int currentLevel = this.getLevel();
        this.Experience += experience * 1.05 + 50;
        this.skillPoints += this.getLevel() - currentLevel * 3;
        return this.getLevel() - currentLevel;
    }

    /**
     * @param item
     * @return
     */
    public void getItem(Items item){
        this.inv.Add(item);
    }

    /**
     * A method to get the current skill points of the player
     * @return skillPoints<int> the current skill points of the player
     * I MIGHT ADD A SKILL TREE LATER WHO KNOWS
     *      */
    public int getSkillPoints(){
        return this.skillPoints;
    }
    
    /**
     * As a J**less Cs STUDENT I must increase my J** finding stat by 6767
     * @param stat<int>, the index of the stat, 0 = HLT, 1 = ATK, 2 = DEF, 3 = SPD, 4 = MAG
     * @param amount, the amount of skill points to increase the stat by
     * @return nullptr (not a function that returns anything)
     */
    public void increaseStat(int stat, int amount){
        if(this.skillPoints < amount){
            // Debug I gotta find a way to patch this
            // System.out.println("Not enough skill points!");
            return;
        }
        switch(stat){
            case 0:
                this.stat.HLT += amount;
                break;
            case 1:
                this.stat.ATK += amount;
                break;
            case 2:
                this.stat.DEF += amount;
                break;
            case 3:
                this.stat.SPD += amount;
                break;
            case 4:
                this.stat.MAG += amount;
                break;
        }
        // Jajajajaja
        this.skillPoints -= amount;
    }

    /**
     * my favorite method js loot fr
     * @param other<Enemies: enemy> the enemy that was just killed by U
     * @return String[] of the experience gained and the item looted, mainly used for output
     */
    public String[] loots(Enemies other){
        int currlevel = this.getLevel();
        this.GainExp(other.getExperience());
        Items drop = other.drop();
        this.inv.Add(drop);

        String exp, drops;
        exp = "You gained: " + (other.getExperience() * 1.05 + 50) + " experience points" + ((currlevel!=this.getLevel())?" and leveled up! new level = " + this.getLevel() : "");
        drops = drop != null ? "You looted: " + drop.getName() : "The enemy dropped nothing :(";

        return new String[]{exp, drops};

    }

    // I MIGHT ADD THIS BACK basically specializes getting hit
    /*@Override
    public void getHit(double damage){
        System.out.println("DAMAGE RED: " + (1 - (damage/this.stat.DEF)/ 100));
        System.out.println("True damage delt: " + damage * (1 - (damage/this.stat.DEF)/ 100));
        this.Health -= damage * (1 - (damage/this.stat.DEF)/ 100);
    }*/


}
