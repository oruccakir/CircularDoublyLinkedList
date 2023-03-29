public interface CircularDoubleListInterface <T> extends PubliclyCloneable{


    public void add(T data);

    public void remove();

    public void add(T data, int index);

    public void remove(int index);

    public void remove(T data);

    public boolean equals(Object obj);

    public void print();

    public void reversePrint();

    public boolean contains(T data);

    public  Object[] toArray();

    public T[] toArray(T array[]);

    public int indexOf(T data);

    public int lastIndexOf(T data);

    public T get(int index);

    public void set(int index, T data);

    public void clear();

    public CircularDoubleLinkedList<T>.TwoWayNode getNode(int dataIndex);

    public void removeAll(T data);

}

interface PubliclyCloneable extends Cloneable{
}
