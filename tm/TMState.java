package tm;


/**
 * The TMState class represents a state inside of a Turning Machine
 * 
 * @author brycekratzer
 */
class TMState {

    // Each state is represented by an integer based ID
    private int state;

    /**
     * @constructor 
     * 
     * @param state
     * Takes an integer for the State class that represents it's state
     * id. 
     */
    public TMState(int state){
        this.state = state;
    }

    /*
     * Returns the integer ID
     */
    public int get_State(){
        return state;
    }

    @Override
    public String toString(){
        return "State: " + state + "\n";
    }
}

