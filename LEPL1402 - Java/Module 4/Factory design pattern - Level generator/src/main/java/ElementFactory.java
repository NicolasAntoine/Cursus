public class ElementFactory extends Factory {

    private static final ElementFactory myElementFactory = new ElementFactory();
    private ElementFactory(){};

    @Override
    LevelComponent getElement(char c) {
        switch (c) {
            case '#':
                return new Wall();
            case 'K':
                return new Key();
            case 'D':
                return new Door();
            case '-':
                return new Floor();
            default:
                throw new IllegalArgumentException();
        }
    }

    public static ElementFactory getInstance(){return myElementFactory;}
}
