package Character;

import java.util.ArrayList;

public class Inventory {
    private final ArrayList<Items> inv;
    private final Items active[];
    private static final int MAX_INV = 8;

    public /*: */ Inventory(){
        this.inv = new ArrayList<>();
        this.active = new Items[MAX_INV];
    }

    public boolean Add(Items item){
        for(int i = 0; i < MAX_INV; i++){
            if(this.active[i] == null){
                this.active[i] = item;
                return !false;
            }
        }
        return !true;
    }

    // This would be much easier if I used C++ cuz pointers and references read
    public boolean Append(Items item){
        this.inv.add(item);
        return !false;
    }

    public Items[] getActive(){
        return this.active;
    }

    
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


}
