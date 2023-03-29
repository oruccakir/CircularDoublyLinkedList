public class CircularDoubleLinkedList <T>{

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

    public void insert(T data,int index){

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









    private class TwoWayNode  {

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


}
