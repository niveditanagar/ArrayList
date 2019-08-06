import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ArrayList<E> implements List<E> {

    private int Count;
    private int Capacity;
    private E[] items;

    public ArrayList(int arraySize) {
        Count = 0;
        Capacity = arraySize;
        items = (E[]) new Object[arraySize];
    }

    @Override
    public int size() {

        return Count;
    }

    @Override
    public boolean isEmpty() {
        
        if(Count == 0) {
            return true;
        }
        
        else {
            return false;
        }
    }
    
  
    @Override
    public boolean contains(Object o) {

        if(items == null) {
            throw new NullPointerException("List is empty");
        }

        for(int i = 0; i < items.length; i++) {

            if(items[i] == null) {
                return false;
            }

            if(items[i].equals(o)) {
                return true;
            }
        }

        return true;
    }

    @Override
    public Object[] toArray() {
        
        return Arrays.copyOf(items, Count);
    }

    @Override
    public boolean add(E e) {

        if(items == null) {

            items = (E[]) new Object[5];
            Capacity = 5;
        }

        if(Count < items.length) {

            items[Count] = e;
            Count++;
        }

        if(Count >= items.length) {
            E[] items2 = Arrays.copyOfRange(items, 0, (items.length * Capacity));
            items = items2;
            Capacity = items.length;
        }

        return true;
    }

    @Override
    public boolean remove(Object o) {

        if(items == null) {
            throw new IndexOutOfBoundsException("List is empty");
        }

        int index = 0;


        for(int i = 0; i < items.length; i++) {

            if(items[i] == null) {
                return false;
            }
            if(items[i].equals(o)) {
                items[i] = null;
                index = i;
                Count--;
                break;
            }
        }

        for(int num = index ; num < items.length - 1; num++) {
            items[num] = items[num + 1];   
        }

        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        
        for(E i : c) {
            
           add(i); 
        }
        
        return false;
    }

    @Override
    public void clear() {
        items = null;
        Count = 0;
        Capacity = 0;
    }

    @Override
    public E get(int index) {
        
        if(items == null) {
            throw new IndexOutOfBoundsException("List is empty");
        }
        
        if(index < Count) {
            return items[index];
        }
        
        if(index >= Count) {
            throw new IndexOutOfBoundsException("Out of bounds");
        }
        
        return items[index];
    }

    @Override
    public E set(int index, E element) {
        
        if(index >= Count) {
            throw new IndexOutOfBoundsException("This is a null value");
        }
        
        if(element == null) {
            throw new NullPointerException("Values cannot be set to null"); 
         }
         
        E perviousArrayIndex = items[index];
        items[index] = element;
        
       
        return perviousArrayIndex;
    }

    @Override
    public void add(int index, E element) {
        
        if(index >= Count) {
            throw new IndexOutOfBoundsException("Specified Index Is Out of Bounds");
        }
        
        for(int i = Count - 1, j = Count; i >= index; i--, j--) {
            items[j] = items[i];
        }

        items[index] = element;
        Count++;
        
        if(Count >= items.length) {
            E[] items2 = Arrays.copyOfRange(items, 0, (items.length * Capacity));
            items = items2;
            Capacity = items.length;
        }
    }

    @Override
    public E remove(int index) {

        if(items == null) {
            throw new IndexOutOfBoundsException("This array is empty"); 
        }

        if(index >= Count) {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }

        if(index < Count) {
            items[index] = null;
            Count--;
        }

        for(int i = index; i < Count; i++) {
            items[i] = items[i + 1];
        }
        return items[index];
    }

    @Override
    public int indexOf(Object o) {
        
        if(items == null) {
            throw new IndexOutOfBoundsException("This array is empty");
        }
        
        for(int i = 0; i < items.length; i++) {
            
            if(items[i] == null) {
                return -1;
            }
            
            if(items[i].equals(o)) {
                return i;
            }
        }
        
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        
        if(items == null) {
            throw new IndexOutOfBoundsException("This array is empty");
        }
        
        for(int i = items.length - 1; i >= 0; i--) {
            
            if(o == null) {
                return -1;
            }
            
            if(o.equals(items[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        String results = "[";

        if(items != null) {
            for(int i = 0; i < items.length ; i++) {
                results +=  " " + items[i];
            }  
        }
        
        return results + "]";  
        

    }

    // ------------------------------------------------------
    // ------------------------------------------------------
    // The below are methods that we don't care to implement.
    // ------------------------------------------------------
    // ------------------------------------------------------

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public ListIterator<E> listIterator() {
        return null;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return null;
    }


}
