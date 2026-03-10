package Character;

public abstract class Items{
    @FunctionalInterface
    public static abstract interface Functional {
        void func(Character host);
    }
    
    protected final Functional func;
    protected final String name;
    protected final long id;
    protected int durability;

    public Item(String name, Functional func){
        this.name = name;
        this.func = func;
        this.id = -1;
    }


}