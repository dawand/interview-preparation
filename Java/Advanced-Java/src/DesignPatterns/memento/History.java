package DesignPatterns.memento;

import java.util.ArrayList;
import java.util.List;

public class History {
    private List<EditorState> states = new ArrayList<>();

    /**
     * Add a new state to states
     * @param state to be added
     */
    public void push(EditorState state) {
        this.states.add(state);
    }

    /**
     * Remove the last state from states
     * @return the last state
     */
    public EditorState pop() {
        var lastState = states.get(states.size() - 1);
        states.remove(lastState);
        return lastState;
    }
}
