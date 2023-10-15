public class SinglyLinkedList<E> {
    private static class Node<E>{
        private E element; //Reference to this node
        private Node<E> next; //Reference to the next node

        public Node(E e, Node<E> n){
            element = e;
            next = n;
        }

        public E GetElement(){
            return element;
        }
        public Node<E> GetNext(){
            return next;
        }
        public void SetNext(Node<E> n){
            next = n;
        }
    }

    private Node<E> head = null; //The head node of the list
    private Node<E> tail = null; //The last node of the list
    private int size = 0; //The number of nodes in the list


    public SinglyLinkedList(){} //The constructor of the class

    //Access to methods
    public int Size(){
        return size;
    }
    public boolean IsEmpty(){
        return size == 0;
    }
    public E First(){
        if (IsEmpty()){
            return null;
        }
        else{
            return head.GetElement();
        }
    }
    public E Last(){
        if (IsEmpty()){
            return null;
        }
        else {
            return tail.GetElement();
        }
    }

    //Update Methods
    public void AddFirst(E e){
        head = new Node<>(e, head); //Create, Link a new node
        if (size == 0){
            tail = head;
        }
        size++;
    }
    public void AddLast(E e){
        Node<E> newNode = new Node<>(e, null);
        if (IsEmpty()) {
            head = newNode;
        }
        else {
            tail.SetNext(newNode);
            tail = newNode;
        }
        size++;
    }

    public E RemoveFirst(){
        if (IsEmpty()) {
            return null;
        }
        E elementRemoved = head.GetElement();
        head = head.GetNext();
        size--;
        if (size == 0) {
            tail = null;
        }
        return elementRemoved;
    }

    public void Display(){
        Node<E> current = null;
        current = head;
        System.out.println("The contents of the list: ");
        for (int i = 0; i <= size; i++) {
            if (current == null) {
                break;
            }
            System.out.print(current.element + " ");
            current = current.GetNext();
        }
    }

    public static void main(String[] args) {
        SinglyLinkedList<Integer> hassanList = new SinglyLinkedList<Integer>();
        hassanList.AddFirst(5);
        hassanList.AddFirst(6);
        hassanList.AddFirst(7);
        hassanList.AddFirst(8);
        hassanList.AddFirst(9);
        hassanList.AddLast(10);
        hassanList.RemoveFirst();
        hassanList.Display();
    }
}
