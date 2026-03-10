package Character;

import java.util.ArrayList;

public class Inventory {
    private ArrayList<Items> inv;
    private Items active[];
    private static final int MAX_INV = 8;

    public /*: */ Inventory(){
        this.inv = new ArrayList<>();
        this.active = new Items[MAX_INV];
    }
    
}
