package Character;

public abstract class Items{
    @FunctionalInterface
    public static abstract interface Functional {
        void func(Characters host);
    }
    
    protected final Functional func;
    protected final String name;
    protected final long id;
    protected int durability;

    public Items(String name, int id, Functional func){
        this.name = name;
        this.func = func;
        this.id = id;
    }

    public abstract boolean call(Characters chars);


}