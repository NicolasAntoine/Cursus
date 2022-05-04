public class Level extends AbstractLevel{

    @Override
    public String toString() {
        return null;
    }

    @Override
    LevelComponent[][] getComponents() {
        return components;
    }

    @Override
    int getSize() {
        return this.size;
    }

    public Level(String input){
        char[] tab = input.toCharArray();
        for (int i = 0; i < tab.length; i++) {
            if (tab[i] ==  '\n') {
                size++;
            }
            ElementFactory.getInstance().getElement(tab[i]);
        }
    }
}
