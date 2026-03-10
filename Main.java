import Player.Players;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world");
        Players player = new Players("Player", 10, 10, 5, 5, 5);
        Players enemy = new Players("Enemy", 10, 5, 5, 5, 5);

        System.out.println(player.attack(enemy));
        System.out.println(player.getHealth());
        System.out.println(enemy.getHealth());

    }
}
