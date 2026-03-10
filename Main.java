import Player.Players;

public class Main {
    public static void main(String[] args) {
        Players player = new Players("Player", 10, 5, 5, 5, 5);
        Players enemy = new Players("Enemy", 10, 5, 5, 5, 5);

        System.out.println("\nPlayer attacks enemy: " + player.attack(enemy));
        System.out.println("Player health: " + player.getHealth());
        System.out.println("Enemy health: " + enemy.getHealth());

    }
}
