package DesignPatterns.state;

public class Selection implements Tool {
    @Override
    public void mouseDown() {
        System.out.println("selection tool selected");
    }

    @Override
    public void mouseUp() {
        System.out.println("select the item");
    }
}
