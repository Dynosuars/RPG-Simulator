package Character;
import java.util.ArrayList;
public abstract class Characters {

    // Useless features
    protected String name;
    protected int money;

    // Stupid stats
    protected Stats stat;
    protected Inventory inv;
    protected double Health;
    protected long Experience;

    // Stupid constants
    protected final static double HLTConvRate = 20;
    protected final static int DerivativeEXP = 10;
    
    public abstract double attack(Characters other);
    public abstract Items UseItem(int item);


    public void placeitem(Items item){
        this.inv.Add(item);
    }

    public Items[] getActive(){
        return this.inv.getActive().clone();
    }

    public ArrayList<Items> getInv(){
        return this.inv.getInv();
    }

    public void getHit(double damage){
        this.Health -= damage;
    }

    public void Heal(double heal){
        if(this.Health + heal > this.stat.HLT * HLTConvRate){
            this.Health = this.stat.HLT * HLTConvRate;
            return;
        }
        this.Health += heal;
    }


    // GETTERS
    public Stats getStats(){
        return this.stat;
    }

    public double getHealth(){
        return this.Health;
    }

    public double getExperience(){
        return this.Experience;
    }

    // Levels formula is derivative of EXP (10) * sqrt(EXP) * L, so L = sqrt (EXP / 10)
    public int getLevel(){
        return (int) Math.sqrt(this.Experience / DerivativeEXP);
    }

    public boolean isDead(){
        return this.Health <= 0;
    }

    public String getName(){
        return this.name;
    }

    public Characters(int HLT, int ATK, int DEF, int SPD, int MAG){
        this.stat = new Stats(HLT, ATK, DEF, SPD, MAG);
        this.inv = new Inventory();
        this.Health = this.stat.HLT * HLTConvRate;
        this.Experience = 1;
        this.money = 0;
    }

    

    

}
