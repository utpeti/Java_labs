public class Main {
    public static void main(String[] args) {
        Java7Strategy java7Strategy = new Java7Strategy();
        java7Strategy.printStatistics(java7Strategy.processFile("data.txt"));

        Java8Strategy java8Strategy = new Java8Strategy();
        java8Strategy.printStatistics(java8Strategy.processFile("data.txt"));
    }
}