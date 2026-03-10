package Item;

import Character.Characters;
import Character.Items;

public class HP_pots extends Items{

    public HP_pots(){
        super("HEALTH POTION", 1,(Characters host) -> {
            host.Heal(50);
        });

        this.durability = 1;
    }

    @Override
    public boolean call(Characters chars) {
        this.func.func(chars);
        return true;
    }

    
}
