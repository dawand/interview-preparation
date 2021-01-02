package DesignPatterns.state;

public class Canvas {

    private Tool currentTool;

    public void mouseDown() {
//        if (currentTool == ToolType.SELECTION)
//            System.out.println("selection icon");
//        else if (currentTool == ToolType.BRUSH)
//            System.out.println("brush tool");
//        else if (currentTool == ToolType.ERASER)
//            System.out.println("eraser tool");

        currentTool.mouseDown();
    }
    public void mouseUp(){
        currentTool.mouseUp();
    }

    public Tool getCurrentTool() {
        return currentTool;
    }

    public void setCurrentTool(Tool currentTool) {
        this.currentTool = currentTool;
    }
}
