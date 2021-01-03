package decorator;

public class ConcreteComponent extends Component {
    @Override
    void makeHouse() {
        System.out.println("Creating a house! No more modifications accepted :) The O of SOLID");
    }
}
