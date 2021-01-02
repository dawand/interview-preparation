package DesignPatterns.state;

public class BrushTool implements Tool {
    @Override
    public void mouseDown() {
        System.out.println("brush icon");
    }

    @Override
    public void mouseUp() {
        System.out.println("draw with brush");
    }
}
