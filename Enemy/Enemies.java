package Enemy;

import Character.Characters;
import Character.Items;
import Item.HP_pots;
import java.util.Random;

public class Enemies extends Characters{

    public Enemies(String name, int HLT, int ATK, int DEF, int SPD, int MAG){
        super(HLT, ATK, DEF, SPD, MAG);
        this.name = name;
    }

    public Items drop(){
        // ONLY health option for now, I might add more items later
        return new Random().nextInt(0, 100) < 200 ? new HP_pots() : null;
    }

    @Override
    public double attack(Characters other) {
        double damage;
        double multiplier = 1;
        if(this.stat.ATK > other.getStats().DEF){
            multiplier = 1.5;
        }
        damage = this.stat.ATK * 3 * multiplier;
        other.getHit(damage);
        return damage;
    }

    @Override
    public Items UseItem(int item) {
        boolean success = this.inv.Use(item, this);
        return success ? this.inv.getActive()[item] : null;
    }

    public double turn(Characters other){
        if(this.Health < this.stat.HLT * HLTConvRate * 0.3){
            if(this.inv.getActive()[0] != null && this.inv.getActive()[0].id == 0){
                this.UseItem(0);
                return -this.inv.getActive()[0].id;
            }
        }
        return this.attack(other);
    }

}
