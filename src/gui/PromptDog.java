/**
 * @author William Barden
 * Jan 27, 2017
 */
package gui;


public class PromptDog {

    Gui ui;

    PromptDog(String[] args) {
        ui = new Gui(args);
    }

    public static void main(String[] args) {
        new PromptDog(args);
    }
}