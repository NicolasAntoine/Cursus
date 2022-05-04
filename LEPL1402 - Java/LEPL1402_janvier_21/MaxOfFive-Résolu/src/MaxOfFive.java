// You are allowed to add imports here

import java.util.ArrayList;

/**
 * This class takes a data source that represents sequence of numbers.
 * Everytime getNextNumber() of the data source is called, it returns
 * the next number of the sequence. For example, you could the sequence:
 *     8,4,5,1,7,3,10,2,...
 *
 * Your job is to implement the method getNextMaximum(). When the method
 * is called for the first time, it should return the maximum of the first
 * five values of the sequence from the source:
 *      8    (because 8 is the maximum of 8,4,5,1,7)
 * When the method getNextMaximum() is called again, it gets the next value
 * from the sequence, and calculates again the maximum of the five values:
 *      7    (because 7 is the maximum of 4,5,1,7,3)
 *  And again:
 *      10   (because 10 is the maximum of 5,1,7,3,10)
 *  And again:
 *      10   (because 10 is the maximum of 1,7,3,10,2)
 *  etc.
 */

public class MaxOfFive {
    // You are allowed to add methods or class members here

    private final NumberSource source;

    // A source of an infinite sequence of numbers
    public interface NumberSource {
        // gets the next number from the source
        int getNextNumber();
    }

    public MaxOfFive(NumberSource source) {
        this.source = source;
    }

    private boolean empty = true; //Variable boolean qui m'est nécessaire pour ce programme, vérifier si on n'a pas encore créé le tableau à tester
    private ArrayList<Integer> arraysource = new ArrayList<Integer>();

    /**
     * @return the next maximum of five values from the data source
     */
    public int getNextMaximum() {
        int maximum = 0;
        int current = 0;
        if (empty) { //J'ai défini un boolean empty pour créer ma première ArrayList de 5 éléments dont il faut chercher le maximum
            for (int j = 0; j<5; j++) {
                int toadd = this.source.getNextNumber();
                arraysource.add(j,toadd);
            }
            empty = false;
            //Comme j'ai créé mon premier array et qu'il n'est plus vide, je dois passer mon booléen à false pour ne plus entrer dans cette boucle !
        }

        else { //Quand on a déjà une arraylist de 5 éléments, il faut supprimer le premier élément et ajouter un nouveau à la fin !
            arraysource.remove(0);
            arraysource.add(4,this.source.getNextNumber());
        }

        for (int i = 0; i < arraysource.size(); i++) {
            current = arraysource.get(i);
            if (current>maximum) {
                maximum = current;
            }
        }
        return maximum;
    }


}
