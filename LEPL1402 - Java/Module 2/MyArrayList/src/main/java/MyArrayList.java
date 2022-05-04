import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyArrayList<Item> implements Iterable<Item> {

    private Object [] list;
    private int size;


    public MyArrayList(int initSize){
        if (initSize<0) throw new IndexOutOfBoundsException();
        this.size = 0;
        this.list = new Object[initSize];
    }


    /*
    * Checks if 'list' needs to be resized then add the element at the end 
    * of the list.
    */
    public void enqueue(Item item){
        if (list.length-1 == size){
            Object[] resized = new Object[size*2];
            for (int i = 0; i < list.length; i++) {
                resized[i] = list[i];
            }
        } list[size] = item;
        size++;
    }

    /*
    * Removes the element at the specified position in this list.
    * Returns the element that was removed from the list. You dont need to 
    * resize when removing an element.
    */
    public Item remove(int index){
        if (index <0 || index >= size {
            throw new IndexOutOfBoundsException();
        }
        Object object = list[index];
        for (int i = index; i < list.length; i++) {
            if (i == list.length - 1) {
                list[i] = null;
            }
            list[i] = list[i + 1];
        }
        size--;
        return (Item) object;
    }


    public int size(){
        return this.size;
    }
    
    
    public Object [] getList(){
        return this.list;
    }


    @Override
    public Iterator<Item> iterator() {
        return new MyArrayListIterator();
    }


    private class MyArrayListIterator implements Iterator<Item> {
        int initialSize = MyArrayList.this.size;
        int repaire = 0;

        @Override
        public boolean hasNext() {
            if (size != initialSize) throw new ConcurrentModificationException();
            return (repaire < size);
        }

        @Override
        public Item next() {
            if (hasNext()) {
                return (Item) list[repaire++];
            } else {
                throw new NoSuchElementException();
            }
        }
    }
}