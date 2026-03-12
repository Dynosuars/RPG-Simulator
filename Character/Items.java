package Character;

public abstract class Items{
    @FunctionalInterface
    public static abstract interface Functional {
        void func(Characters host);
    }
    
    // Where is my std::functional?????? Java is stupid
    protected final Functional func;
    protected final String name;
    public final long id;
    protected int durability;

    /**
     * MAKES A ITEM, WHICH IS A BASED ON CLASS NOT OBJECT
     * @param name
     * @param id
     * @param func
     */
    public Items(String name, int id, Functional func){
        this.name = name;
        this.func = func;
        this.id = id;
    }

    // Js read bro
    public String getName(){
        return this.name;
    }
    // Js read
    public int getDurability(){
        return this.durability;
    }

    // Functionality of the item lol
    public abstract boolean call(Characters chars);

    // Ts js for output
    @Override
    public String toString(){
        return this.name;
    }


}