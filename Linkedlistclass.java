package Linked_List;
/**
 * Linkedlistclass
 */

class SLL{
    Node head;
    Node tail;
    int size;

    //insert element at tail
    public void addTail(int data){
        size++;
        Node temp=new Node(data);
        if(head==null && tail==null)
            head=tail=temp;
        else{
            tail.next=temp;
            tail=temp;
        }
    }

    //add element at head
    public void addHead(int data){
        size++;
        Node temp= new Node(data);
        if (head== null && tail==null) 
            head=tail=temp;
        else{
            temp.next=head;
            head=temp;
        }

    }

    // add element at specific index  0 => is base index
    public void addAtIdx(int idx, int data){
        // base cases
        if(idx >size || idx<0){
            System.out.println("invalid index :: "+idx);
            return;
        }
        
        if(idx==0){  //add node at head
            addHead(data);
            return;
        }
        if(idx==size){  //add node at tail
            addTail(data);
            return;
        }

        Node temp=new Node(data);
        Node current=head;
        for (int i = 0; i < idx-1; i++) {
            current=current.next;            
        }   
        temp.next=current.next;
        current.next=temp;
        size++;

    }

    // get element from specific position
    public int get(int index){
        // base cases
        if (index ==0) return head.data;
        if (index==size -1) return tail.data;
        if (index>=size || index<0) return -1;

        Node tmp=head;
        for (int i = 0; i <=index; i++) 
            tmp=tmp.next;

        return tmp.data;
    }

    // delete Node using it value
    public void delteNode(int data){
        // check list is empty
        if (head==null) return;
        // Node is head
        if (head.data == data) {
            head=head.next;
            if (head ==null) 
                tail=null;
            return;
        }

        Node current=head;
        Node pre=null;
        while (current !=null) {
            if (current.data == data) {
                pre.next=current.next;
                if (current == tail) 
                    tail=pre;
                return;
            }
            pre=current;
            current=current.next;   
        }
    }

    // delete Node using it index
    public void delete(int idx){
        // base cases
        if (idx==0) {
            head=head.next;
            if (head==null) 
                tail=null;
            size--;
            return;
        }
        if (idx>=size || idx<0) {
            System.out.println("invalid index "+idx);
            return;
        }
        Node current=head;
        Node previous=null;        
        for(int i=0;i<idx;i++){
            previous=current;
            current=current.next;
        }
        if (current == tail) 
            tail=previous;            
        
        previous.next=current.next;
    }

    // my set Node value or update the node value using it's index
    public void set(int idx, int data) throws Error {
        // base cases
        if (head ==null) {
            System.out.println("list is empty"); 
            return;
        }
        if (idx== size-1){
            tail.data=data;
            return;
        }
        if (idx>=size || idx<0){
            System.out.println("Invalid index "+idx); 
            return;
        } 
        Node temp=head;

        for (int i = 0; i <idx; i++) { 
            temp=temp.next;
        }
        temp.data=data;
    }



    // print all the element
    public void print(){
        Node temp=head;
        while (temp != null) {
            System.out.print(temp.data+" ");
            temp=temp.next;            
        }
        System.out.println();
    }
}


public class Linkedlistclass {

    public static void main(String[] args) {
        SLL list=new SLL();

        // Add node at tail
        list.addTail(10);
        list.addTail(20);
        list.addTail(80);
        list.addTail(88);

        // // Add node at head
        // list.addHead(10);
        // list.addHead(20);
        // list.addHead(80);
        // list.addHead(88);

        // size of linkedlist
        // System.out.println("Size of linked list is :: "+list.size);

        // add element at specific index
        list.addAtIdx(0,12);
        list.addAtIdx(3,19);
        list.addAtIdx(1,11);   
        list.addAtIdx(6,93);
        list.addAtIdx(5,75);
        list.addAtIdx(6,77);
        System.out.println("Size of linked list is :: "+list.size);
        // System.out.println("Index 0 :: "+list.get(0));
        // System.out.println("Index 10 :: "+list.get(10));
        // System.out.println("Index 9 :: "+list.get(9));
        // System.out.println("Index 1 :: "+list.get(1));
        // System.out.println("Index 8 :: "+list.get(8));
        // System.out.println("Index 2 :: "+list.get(2));
        
        list.print();
        // // delete node using data
        // list.delteNode(12);
        // list.delteNode(88);
        // list.delteNode(19);
        // list.delteNode(11);
        // list.print();

        // // delete node using it specific index
        // list.delete(0);
        // list.delete(0);
        // list.delete(7);
        // list.print();
        // System.out.println("Head "+list.head.data);
        // System.out.println("tail "+list.tail.data);

        // update the value of Node
        list.set(0, 99);
        list.set(1, 89);
        list.set(9, 49);
        list.set(2, 19);
        list.set(3, 88);
        list.set(10, 55);
        list.set(-1, 77);
        list.set(11, 66);
        System.out.println(list.size);
        list.print();
    }
}