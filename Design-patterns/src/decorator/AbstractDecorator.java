package decorator;

abstract class AbstractDecorator {
    protected Component component;

    void setComponent(Component component) {
        this.component = component;
    }

    void makeHouse() {
        if (component != null) {
            component.makeHouse();
        }
    }
}
