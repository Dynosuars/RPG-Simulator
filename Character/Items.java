package Character;

public abstract class Items{
    @FunctionalInterface
    public static abstract interface Functional {
        void func(Characters host);
    }
    
    protected final Functional func;
    protected final String name;
    public final long id;
    protected int durability;

    public Items(String name, int id, Functional func){
        this.name = name;
        this.func = func;
        this.id = id;
    }

    public String getName(){
        return this.name;
    }
    
    public int getDurability(){
        return this.durability;
    }

    public abstract boolean call(Characters chars);

    @Override
    public String toString(){
        return this.name;
    }


}