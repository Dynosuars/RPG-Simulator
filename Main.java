import javax.swing.JOptionPane;

import Item.HP_pots;
import Player.Players;

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
        "Your Dearest dev: Yo %s ! Help me jump him yo."
    };
    public static void main(String[] args) {

        int storyLine = 0;


        JOptionPane.showMessageDialog(null, "Welcome to RPG simulator!\nA game made by ME, inspiration ALSO BY ME", "RPG Simulator 0.6.7", JOptionPane.INFORMATION_MESSAGE);
        int option = JOptionPane.showOptionDialog(null, "Do you want to hear my rant?", "RPG Simulator 0.67", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
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
            JOptionPane.showMessageDialog(null, STORYLINEEN[storyLine], "RPG Simulator 0.6.7", JOptionPane.INFORMATION_MESSAGE);
            storyLine++;
        }
        String name = JOptionPane.showInputDialog(null, "Enter your name:", "RPG Simulator 0.6.7", JOptionPane.QUESTION_MESSAGE);
        Players player = new Players(name, 5, 5, 10, 5, 0);

        JOptionPane.showMessageDialog(null, String.format(STORYLINEEN[16], name), "RPG Simulator 0.6.7", JOptionPane.INFORMATION_MESSAGE);
        
    }
}
