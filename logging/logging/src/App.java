public class App {
    public static void main(String[] args) throws Exception {
        prep();
        new GenerateOutputs();
        prep();

        new BrokenClass();
        prep();
    }

    private static void prep() {
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
    }
}