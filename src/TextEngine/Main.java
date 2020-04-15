package TextEngine;

public class Main {
    public static void main(String[] args){
        // Calling the method that will get the only instance of TextEngine "Singleton" and calling the method that starting console interface.
        TextEngine.getInstance().start();
    }
}
