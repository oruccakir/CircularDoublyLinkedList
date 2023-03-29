import java.util.Arrays;

public class CircularDoubleLinkedList <T> implements CircularDoubleListInterface <T>{

    public TwoWayNode head;

    public TwoWayNode tail;

    public int length;


    public void print(){

        TwoWayNode temp = this.head;

        System.out.print("[ ");

        if(temp != null){

            do{
                System.out.print(temp.data+", ");
                temp = temp.nextNode;
            }while (temp != this.head);

        }

        System.out.print("]");

    }

    public void reversePrint() {
        
        TwoWayNode temp = this.tail;

        System.out.print("[ ");

        if(temp != null){

            do{
                System.out.print(temp.data+", ");
                temp = temp.prevNode;
            }while (temp != this.tail);

        }

        System.out.print("]");

    }

    @Override
    public void add(T data) {

        TwoWayNode newNode = new TwoWayNode(data);

        if(this.head == null){

            newNode.nextNode = this.tail;
            newNode.prevNode = this.tail;
            this.head = newNode;
            this.tail = newNode;
            this.tail.prevNode = this.head;
            this.tail.nextNode = this.head;

        }
        else{

            newNode.prevNode = this.tail;
            this.tail.nextNode = newNode;
            newNode.nextNode = this.head;
            this.head.prevNode = newNode;
            this.tail = newNode;

        }

        length++;
        
    }

    @Override
    public void remove() {
        
        if(this.length == 0) return;

        if(this.length == 1){
            this.head = null;
            this.tail = null;
            return;
        }

        this.tail.nextNode = null;
        this.tail.prevNode.nextNode = this.head;
        this.head.prevNode = this.tail.prevNode;
        this.tail = this.tail.prevNode;

        length--;

    }

    @Override
    public void add(T data, int index) {

        if(index > this.length  || index <0) return;

        TwoWayNode newNode = new TwoWayNode(data);

        if(this.length == 0 && index == 0){

            newNode.nextNode = this.tail;
            newNode.prevNode = this.tail;
            this.head = newNode;
            this.tail = newNode;
            this.tail.prevNode = this.head;
            this.tail.nextNode = this.head;

        }
        else if (index == 0){

            newNode.nextNode = this.head;
            this.head.prevNode = newNode;
            newNode.prevNode = this.tail;
            this.tail.nextNode = newNode;
            this.head = newNode;


        }
        else if(index == this.length){

            newNode.prevNode = this.tail;
            this.tail.nextNode = newNode;
            newNode.nextNode = this.head;
            this.head.prevNode = newNode;
            this.tail = newNode;

        }
        else{

            TwoWayNode temp = this.head;

            int currentIndex = 0;

            do{
                temp = temp.nextNode;
                currentIndex++;
            }while ( currentIndex != index && temp != this.head);

            newNode.nextNode = temp;
            newNode.prevNode = temp.prevNode;
            temp.prevNode.nextNode = newNode;
            temp.prevNode = newNode;

        }

        length++;
 
    }

    @Override
    public void remove(int index) {
        
        if(this.length == 0) return;

        if(index >= this.length || index < 0) return;

        if(this.length == 1 && index == 0){
            this.head = null;
            this.tail = null;
            length--;
            return;
        }

        if(index == 0){

            this.head.prevNode = null;
            this.head.nextNode.prevNode = this.tail;
            this.tail.nextNode = this.head.nextNode;
            this.head = this.head.nextNode;

        }
        else if(index == this.length-1){
            this.remove();
            length++;
        }
        else{

            TwoWayNode temp = this.head;

            int currentIndex =0;

            while(currentIndex != index){
                temp = temp.nextNode;
                currentIndex++;
            }

            temp.nextNode.prevNode = temp.prevNode;
            temp.prevNode.nextNode = temp.nextNode;

        }

        this.length--;

    }

    public TwoWayNode getNode(int dataIndex){

        int currentIndex = 0;

        if(dataIndex == 0) return this.head;

        TwoWayNode temp = this.head;

        do{
            temp = temp.nextNode;
            currentIndex++;
        }while(currentIndex != dataIndex);

        return temp;
    }

    @Override
    public void remove(T data) {
        
        int dataIndex = this.indexOf(data);

        if(dataIndex == -1) return;

        remove(dataIndex);

    }

    public void removeAll(T data){

        if(!this.contains(data)) return;

        remove(data);

        removeAll(data);

    }

    @Override
    public boolean contains(T data) {

        int dataIndex = indexOf(data);

        return (dataIndex != -1) ? true : false;
    }

    @Override
    public Object[] toArray() {
        
        Object objectArray[] = new Object[this.length];

        TwoWayNode temp = this.head;

        int arrayIndex = 0;

        if(temp != null){

            do{

                objectArray[arrayIndex] = temp.data;
                arrayIndex++;
                temp = temp.nextNode;

            }while(temp != this.head);

        }

        return objectArray;

    }

    @Override
    public T[] toArray(T[] array) {

        TwoWayNode temp = this.head;

        int arrayIndex = 0;

        if(temp != null){

            do{

                array[arrayIndex] =temp.data;
                arrayIndex++;
                temp = temp.nextNode;

            }while(temp != this.head);

        }

        return array;
        
    }

    @Override
    public int indexOf(T data) {

        TwoWayNode temp = this.head;

        int currentIndex=0;

        if(temp != null){

            do{
                if(temp.data.equals(data)) return currentIndex;

                currentIndex++;

                temp = temp.nextNode;

            }while(temp != this.head);

        }

        return -1;

    }

    @Override
    public int lastIndexOf(T data) {
        
        TwoWayNode temp = this.tail;

        int currentIndex = this.length-1;

        if(temp !=null){

            do{

                if(temp.data.equals(data)) return currentIndex;

                currentIndex--;

                temp = temp.prevNode;


            }while(temp != this.tail);

        }

        return -1;

    }

    @Override
    public T get(int index) {
        
        if(index >= this.length || index < 0) return null;

        return this.getNode(index).data;

    }

    @Override
    public void set(int index, T data) {

        if(index >= this.length || index < 0) return;

        this.getNode(index).data = data;

    }

    @Override
    public void clear() {
        this.head = null;
        this.tail = null;
        length =0;
    }


    public class TwoWayNode  {

        public T data;

        public TwoWayNode prevNode;

        public TwoWayNode nextNode;

        public TwoWayNode(T data){
            this.data = data;
        }

        public String toString(){
            return ""+data;
        }

    }

   

    public static void main(String[] args) {

        CircularDoubleLinkedList<String> list = new CircularDoubleLinkedList<>();
        list.add("oruç");
        list.add("oruç");
        list.add("oruç");
        list.add("oruç");
        list.add("oruç");
        list.add("oruç");
        list.add("oru");
        list.add("oruç");

        String arr [] = new String[15];

        arr =list.toArray(arr);

        System.out.println(Arrays.toString(arr));
        
        
        list.print();
        System.out.println();
        list.reversePrint();
    }






 
   


}
