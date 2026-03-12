import Character.*;
import Enemy.Enemies;
import Player.Players;
import java.util.Random;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Main {

    public final static String title = "RPG Simulator 0.6.7";
    /**
     * Info panel, this is where you can check your stats and inventory, also use skill points. I might add more functions later but for now this is it.
     * @param player
     */
    public static void infopanel(Players player){
        final String statName[] = {"Health", "Attack", "Defense", "Speed", "Magic", "Exit"};
        String info = String.format("Name: %s\nLevel: %d\nExperience: %.2f\nHealth: %.2f\nAttack: %d\nDefense: %d\nSpeed: %d\nMagic: %d", player.getName(), player.getLevel(), player.getExperience(), player.getHealth(), player.getStats().ATK, player.getStats().DEF, player.getStats().SPD, player.getStats().MAG);
        int option = JOptionPane.showOptionDialog(null, "Below are your stats:\n" + info + "\nChoose what you want to do:", title, JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, new String[]{"Exit game", "Use skill points", "View active inventory", "View backpack"}, null);

        if(option == 0)
            JOptionPane.showMessageDialog(null, "Your dearest developer:I SEE HOW IT IS! You tryna leave me", "I AM VERY ANGRY", JOptionPane.WARNING_MESSAGE);
        else if(option == 1){
            JOptionPane.showMessageDialog(null, "Your dearest developer: Oh you wanna use skill points? Too bad I haven't added that function yet :P", title, JOptionPane.INFORMATION_MESSAGE);
            JOptionPane.showMessageDialog(null, "Your dearest developer: nah I lied lmao", title, JOptionPane.INFORMATION_MESSAGE);
            do{
                option = JOptionPane.showOptionDialog(null, "Which stat do you want to increase? You have " + player.getSkillPoints() + " skill points left.", title, JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, statName, null);
                if(option == 5)
                    break;
                
                if(option >= 0 && option < statName.length){
                    if(player.getSkillPoints() > 0){
                        player.increaseStat(option, 1);
                        JOptionPane.showMessageDialog(null, "Your dearest developer: Nice choice! Your " + statName[option] + " has increased!", title, JOptionPane.INFORMATION_MESSAGE);
                    }else{
                        JOptionPane.showMessageDialog(null, "Your dearest developer: You have no skill points left!", title, JOptionPane.INFORMATION_MESSAGE);
                        break;
                    }
                }else{
                    break;
                }
            }while(true);
        } else if(option == 2){
            Items[] items = player.getActive();
            String inventory = "Your ACTIVE inventory:\n";
            for(int i = 0; i < items.length; i++){
                if(items[i] != null){
                    inventory += String.format("%d. %s (Durability: %d)\n", i + 1, items[i].getName(), items[i].getDurability());
                }else{
                    inventory += String.format("%d. nullptr\n", i + 1);
                }
            }
            JOptionPane.showMessageDialog(null, inventory, title, JOptionPane.INFORMATION_MESSAGE);
        } else if(option == 3){
            ArrayList<Items> items = player.getInv();
            String inventory = "Your BACKPACK:\n";
            for(int i = 0; i < items.size(); i++){
                if(items.get(i) != null){
                    inventory += String.format("%d. %s\n", i + 1, items.get(i).getName());
                }else{
                    inventory += String.format("%d. nullptr\n", i + 1);
                }
            }
            JOptionPane.showMessageDialog(null, inventory, title, JOptionPane.INFORMATION_MESSAGE);
        }
    }


    public final static String STORYLINEEN[] = {
        "Narrator: Through out heaven and earth, I alone am the honored one",
        "OOPPSSSS wrong anime bro my fault - Your dearest developer",
        "Narrator: Once upon a time....",
        ".....",
        "Narrator: Bro I had enough, this is NOT undertale",
        "Narrator: ST** go get a J** just stick on ONE topic.",
        "Your Dearest dev: Shut up lil bro, you ain't know how to code",
        "Your Dearest dev: pipe the f**k down, I AM the owner",
        "Narrator: I SEE HOW IT IS",
        "Narrator: SO WHEN THIS J**LESS CS MAJOR CAN'T COME UP WITH A STORY, HE GETS AURA?",
        "Narrator: BUT WHEN IIIIIIIIIIIIIIIIIIIIIIIIII",
        "Narrator: WIN A 50v1",
        "Narrator: I GET NEGATIVE -10000 AURA?????",
        "Narrator: I SEEEEEEEEEE HOW IT IS",
        "Your Dearest dev: Yo player lowkey help me jump this bum",
        "Your Dearest dev: What is ur name???", //15
        "Your Dearest dev: Well uh hello I guess, %s, please jump this bum rn",
        "Your Dearest dev: Thanks bruh, now I am gonna add looting function JUST FOR YOU. You're the HONORED ONE!",
        "Your Dearest dev: \n#include <iostream>\n int main(){\n\tstd::cout << \t\"Hello World!\"; \n\t return 0; \n }",
        "Your Dearest dev: Oopsies I am coding in C++ lmao forgot",
        "....",
        "Here, I got it JUST FOR you my friend"
    };
    public static void main(String[] args) {

        // Change to 2 if you're using Ubuntu 26.04
        System.setProperty("sun.java2d.uiScale", "2.0");
        int storyLine = 0;

        JOptionPane.showMessageDialog(null, "Welcome to RPG simulator!\nA game made by ME, inspiration ALSO BY ME", title, JOptionPane.INFORMATION_MESSAGE);
        int option = JOptionPane.showOptionDialog(null, "Do you want to hear my rant?", title, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
        if(option == JOptionPane.YES_OPTION){
            JOptionPane.showMessageDialog(null, "Lagva is so ahh, I wished I did this in C++", "Dyno's rant", JOptionPane.INFORMATION_MESSAGE);
            JOptionPane.showMessageDialog(null, "Boo, I can't even MAKE a 3d renderer here; no model", "Dyno's rant", JOptionPane.INFORMATION_MESSAGE);
            JOptionPane.showMessageDialog(null, "The original idea of this was Honkai star rail btw", "Dyno's rant", JOptionPane.INFORMATION_MESSAGE);
            option = JOptionPane.showOptionDialog(null, "Do you even care abt this????", "Dyno's rant", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new String[]{"I do trust", "Stop yapping"}, null);
            if(option == JOptionPane.YES_OPTION){
                JOptionPane.showMessageDialog(null, "Aww, thank you! :pray:", "Dyno's rant", JOptionPane.INFORMATION_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(null, "I would've pulled up with your device infomation if this was in C++ btw, YOU'RE NOT SAFE!!!!!", "Dyno's rant", JOptionPane.INFORMATION_MESSAGE);
            }
        }

        while(storyLine < 16){
            JOptionPane.showMessageDialog(null, STORYLINEEN[storyLine], title, JOptionPane.INFORMATION_MESSAGE);
            storyLine++;
        }
        String name = JOptionPane.showInputDialog(null, "Enter your name:", title, JOptionPane.QUESTION_MESSAGE);
        Players player = new Players(name, 5, 5, 10, 5, 0);

        JOptionPane.showMessageDialog(null, String.format(STORYLINEEN[16], player.getName()), title, JOptionPane.INFORMATION_MESSAGE);
        storyLine ++;
        // idk what I AM doing bro
        JOptionPane.showMessageDialog(null, "Your Dearest dev: Now, JUMP HIM NOW!!!!!!", title, JOptionPane.INFORMATION_MESSAGE);

        Enemies narrator = new Enemies("Bum narrator", 10, 0, 1, 2, 0);
        while(!narrator.isDead()){
            final String options[] = {"Attack", "Use item"};
            option = JOptionPane.showOptionDialog(null, String.format("Your health: %.2f Narrator's health: %.2f\nWhat will you do?", player.getHealth(), narrator.getHealth()), title, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, null);

            if(option == JOptionPane.YES_OPTION){
                double damage = player.attack(narrator);
                JOptionPane.showMessageDialog(null, String.format("You dealt %.2f damage!", damage), title, JOptionPane.INFORMATION_MESSAGE);
            }else{
                final Items items[] = player.getActive();
                Items item;
                String itemOptions[] = new String[items.length];
                for(int i = 0; i < items.length; i++){
                    if(items[i] != null){
                        itemOptions[i] = String.format("%s (Durability: %d)", items[i].getName(), items[i].getDurability());
                    }else{
                        // C++ troll fr.
                        itemOptions[i] = "nullptr";
                    }
                }
                option = JOptionPane.showOptionDialog(null, "Which item do you want to use?", title, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, itemOptions, null);
                if(option >= 0 && option < items.length){
                    item = player.UseItem(option);
                }else{
                    item = null;
                }
                if(item != null){
                    JOptionPane.showMessageDialog(null, String.format("You used %s!", item.getName()), title, JOptionPane.INFORMATION_MESSAGE);
                }else{
                    JOptionPane.showMessageDialog(null, "You have no item in that slot!", title, JOptionPane.INFORMATION_MESSAGE);
                }
            }
            if(narrator.isDead()){
                JOptionPane.showMessageDialog(null, "Your dearest developer:You defeated the bum narrator! Congratulations!", title, JOptionPane.INFORMATION_MESSAGE);
                break;
            }else{
                // VERY BAD practice bro but Ion care lmao ts such a small game
                JOptionPane.showMessageDialog(null, new Random().nextInt(0, 100) <= 50?"Narrator: Ouch that hurts lil bro": "Narrator: Boot licker!!! Get off me!!!", title, JOptionPane.INFORMATION_MESSAGE);
                JOptionPane.showMessageDialog(null, new Random().nextInt(0, 100) <= 50?"Your dearest dev: What is you YAPPING about like S***": "Your dearest dev: Nobody even like you, stay in the corner lil bro", title, JOptionPane.INFORMATION_MESSAGE);
            }
        }
        while(storyLine < 22){
            JOptionPane.showMessageDialog(null, STORYLINEEN[storyLine], title, JOptionPane.INFORMATION_MESSAGE);
            storyLine++;
        }

        String[] content = player.loots(narrator);
        JOptionPane.showMessageDialog(null, content[0] + "\n" + content[1], title, JOptionPane.INFORMATION_MESSAGE);

        JOptionPane.showMessageDialog(null, "Your dearest developer: Wow you leveled up!\nYou gain 3 skill points", title, JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(null, "Your dearest developer: Chat now it's your free time, check ur info panel", title, JOptionPane.INFORMATION_MESSAGE);

        // Info panel
        infopanel(player);

        JOptionPane.showMessageDialog(null, "I SEE YOU TRYNA LEAVE ME", title, JOptionPane.WARNING_MESSAGE);
        JOptionPane.showMessageDialog(null, "I AIN'T DONE YET", title, JOptionPane.WARNING_MESSAGE);
        Enemies YourDearestDev = new Enemies("Your dearest DEV (Sigma)", 6, 3, 2, 1, 0);
        JOptionPane.showMessageDialog(null, "Ricky Jiang: Jit trippin, bro thinks he can code but bro is js a j**less cs major", title, JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(null, "Your dearest developer: Oh you wanna fight me? Let's gooooooo", title, JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(null, "Ricky Jiang: Nah i'd win :gojo:", title, JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(null, "Ricky Jiang: btw I implemented SPD stats, every 5 speed u have u get extra turns", title, JOptionPane.INFORMATION_MESSAGE);
        while(!YourDearestDev.isDead()){
            final String options[] = {"Attack", "Use item"};
            for(int i=0; i < (int)player.getStats().SPD / 5 + 1; i++){
                option = JOptionPane.showOptionDialog(null, String.format("Your health: %.2f Your dearest dev's health: %.2f\nWhat will you do?", player.getHealth(), YourDearestDev.getHealth()), title, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, null);

                if(option == JOptionPane.YES_OPTION){
                    double damage = player.attack(YourDearestDev);
                    JOptionPane.showMessageDialog(null, String.format("You dealt %.2f damage!", damage), title, JOptionPane.INFORMATION_MESSAGE);
                    if(damage > 100){
                        JOptionPane.showMessageDialog(null, "Your dearest dev: OUCHEEEEEE THAT HURTS", title, JOptionPane.INFORMATION_MESSAGE);
                    } else{
                        JOptionPane.showMessageDialog(null, "Your dearest dev: Weakling lil bro", title, JOptionPane.INFORMATION_MESSAGE);
                    }
                }else{
                    final Items items[] = player.getActive();
                    Items item;
                    String itemOptions[] = new String[items.length];
                    for(int j = 0; j < items.length; j++){
                        if(items[j] != null){
                            itemOptions[j] = String.format("%s (Durability: %d)", items[j].getName(), items[j].getDurability());
                        }else{
                            // C++ troll fr.
                            itemOptions[j] = "nullptr";
                        }
                    }
                    option = JOptionPane.showOptionDialog(null, "Which item do you want to use?", title, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, itemOptions, null);
                    if(player.getActive()[option] != null){
                        System.out.println(items[option]);
                        System.out.println(player.UseItem(option));
                        item = player.UseItem(option);
                    }else{
                        item = null;
                    }
                    if(item != null){
                        JOptionPane.showMessageDialog(null, String.format("You used %s!", item.getName()), title, JOptionPane.INFORMATION_MESSAGE);
                    }else{
                        JOptionPane.showMessageDialog(null, "You have no item in that slot!", title, JOptionPane.INFORMATION_MESSAGE);
                    }
                }
                if(YourDearestDev.isDead()){
                    JOptionPane.showMessageDialog(null, "Your dearest developer: you're NOT safe lil bro I will call up King von on u", title, JOptionPane.INFORMATION_MESSAGE);
                    break;
                }else{
                    double damage = YourDearestDev.attack(player);
                    JOptionPane.showMessageDialog(null, String.format("Your dearest dev dealt %.2f damage!", damage), title, JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }
            
        
            
        
        // More updates never lmao
        System.exit(0);
    }

}
