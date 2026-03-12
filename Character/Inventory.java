package Character;

import java.util.ArrayList;

import Item.HP_pots;
import Player.Players;

public class Inventory {
    // Minecraft ass styled
    private final ArrayList<Items> inv;

    // I am 67% sure minecraft has like 8 IDK BRO I play education cuz I am BROKE and J**less
    private final Items active[];
    private static final int MAX_INV = 8;

    public /*: */ Inventory(){
        this.inv = new ArrayList<>();
        this.active = new Items[MAX_INV];
    }

    /**
     * ADD method which adds to the active and if active gets full then resort to append()
     * @param item
     * @return
     */
    public boolean Add(Items item){
        for(int i = 0; i < MAX_INV; i++){
            if(this.active[i] == null){
                this.active[i] = item;
                return !false;
            }
        }
        return this.Append(item);
    }

    // This would be much easier if I used C++ cuz pointers and references read
    /**
     * Appends an item to the inventory NOT THE ACTIVE 
     * @param item
     * @return
     */
    public boolean Append(Items item){
        this.inv.add(item);
        return !false;
    }

    /**
     * RETRURNS THE ACTIVE ITEMS
     * USED MAINLY FOR OUTPUT
     * @return the active items<Items[]>
     */
    public Items[] getActive(){
        return this.active.clone();
    }

    // I might delete this
    @Deprecated
    public ArrayList<Items> getInv(){
        return this.inv;
    }

    /**
     * READ THE NAME LIL BRO
     * @param i, as in the ITEM SLOT
     * @param target, this would be the host
     * @return successful use of the item, if false then the item is not used and durability is not lost
     */
    public boolean Use(int i, Characters target){
        
        if(this.active[i] == null) return false;
        this.active[i].durability -= 1;

        this.active[i].call(target);
        
        // Pop out the item fr
        if(this.active[i].durability <= 0){
            this.active[i] = null;
        }

        return !false; // Troll fr
    }

    public static void main(String[] args){
        Players player = new Players("sigma", MAX_INV, MAX_INV, MAX_INV, MAX_INV, MAX_INV);
        player.getItem(new HP_pots());
        System.out.println(player.UseItem(0));
    }

}
