package game;

import droids.Droid;

import java.util.List;

public class TeamBattle {
    private List<Droid> team1;
    private List<Droid> team2;

    public TeamBattle(List<Droid> team1, List<Droid> team2) {
        this.team1 = team1;
        this.team2 = team2;
    }

    public boolean startBattle() {
        while (!team1.isEmpty() && !team2.isEmpty()) {
            for (int i = 0; i < Math.max(team1.size(), team2.size()); i++) {
                if (i < team1.size() && i < team2.size()) {
                    Droid attacker = team1.get(i);
                    Droid defender = team2.get(i);
                    if (attacker != null && defender != null) {
                        attacker.attack(defender);
                        if (!defender.isAlive()) {  // Змінено тут
                            System.out.println(defender.getName() + " був знищений!");
                            team2.remove(defender);
                        }
                    }
                }
            }
        }
        return !team1.isEmpty();
    }
}
