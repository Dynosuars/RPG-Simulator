import Character.*;
import Enemy.Enemies;
import Player.Players;
import javax.swing.JOptionPane;

public class Main {
    public final static String STORYLINEEN[] = {
        "Through out heaven and earth, I alone am the honored one",
        "OOPPSSSS wrong anime bro my fault - Your dearest developer",
        "Once upon a time....",
        ".....",
        "Bro I had enough, this is NOT undertale",
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
        "Your Dearest dev: #include <iostream>\n int main(){\n std::cout << \"Hello World!\"; \n return 0; \n }",
        "Your Dearest dev: Oopsies I am coding in C++ lmao forgot",
        "....",
        "Here, I got it JUST FOR you my friend"
    };
    public static void main(String[] args) {

        System.setProperty("sun.java2d.uiScale", "1.0");
        int storyLine = 0;
        final String title = "RPG Simulator 0.6.7";


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
                JOptionPane.showMessageDialog(null, String.format("Narrator's turn!"), title, JOptionPane.INFORMATION_MESSAGE);
                JOptionPane.showMessageDialog(null, "Your dearest developer: Nah, js kidding he's a bum, he can't do none LMAOOOOOO", title, JOptionPane.INFORMATION_MESSAGE);
            }
        }
        JOptionPane.showMessageDialog(null, String.format(STORYLINEEN[16], player.getName()), title, JOptionPane.INFORMATION_MESSAGE);
        storyLine++;
        while(storyLine < 22){
            JOptionPane.showMessageDialog(null, STORYLINEEN[storyLine], title, JOptionPane.INFORMATION_MESSAGE);
            storyLine++;
        }
        String[] content = player.loots(narrator);
        JOptionPane.showMessageDialog(null, content[0] + "\n" + content[1], title, JOptionPane.INFORMATION_MESSAGE);
        // More updates never lmao
        System.exit(0);
    }

}
