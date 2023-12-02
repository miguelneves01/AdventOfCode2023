import java.util.HashMap;

public class Game {

    private int id;
    private HashMap<String,Integer> bag;

    public Game(int id) {
        this.id = id;
        this.bag = new HashMap<>();
        bag.put("red",0);
        bag.put("green",0);
        bag.put("blue",0);
    }

    public int getId() {
        return id;
    }

    public void put(String key, Integer value) {
        if (value > bag.get(key)) {
            bag.put(key, value);
        }
    }

    public Integer get(String key) {
        return bag.get(key);
    }

    public boolean isPossible(int red, int green, int blue) {
        return bag.get("red") <= red && bag.get("green") <= green && bag.get("blue") <= blue;
    }

    //Challenge 2
    public int getPower() {
        return bag.get("red") * bag.get("green") * bag.get("blue");
    }

    @Override
    public String toString() {
        return "Game{" +
                "id=" + id +
                ", bag=" + bag +
                '}';
    }
}
