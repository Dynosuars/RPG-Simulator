package Character;

public abstract class Characters {

    // Useless features
    protected String name;
    protected int money;

    // Stupid stats
    protected Stats stat;
    protected Inventory inv;
    protected double Health;
    protected int Experience;

    // Stupid constants
    protected final static double HLTConvRate = 20;
    protected final static int DerivativeEXP = 10;
    
    public abstract void attack(Character other);
    public abstract void UseItem(int item);

    public Characters(int HLT, int ATK, int DEF, int SPD, int MAG){
        this.stat = new Stats(HLT, ATK, DEF, SPD, MAG);
        this.inv = new Inventory();
        this.Health = this.stat.HLT * HLTConvRate;
        this.Experience = DerivativeEXP;
    }

    

}
