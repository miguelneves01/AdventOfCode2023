public class Main {
    public static void main(String[] args) {
        CardManager manager = new CardManager("input.txt");
        System.out.println(manager.getPointSum());
        System.out.println(manager.getExtraScratchCards());
    }
}