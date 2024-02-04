/*
    @author sakthi
    version 1.11
     */
public class LinkedListClass<T> {

    static private class Node<T>
    {
        T data;
        Node <T> next=null;

        Node ()
        {

        }
        Node(T data)
        {
            this.data=data;

        }
    }
    private Node <T> head=null;
    private Node <T> tail=null;

     long length=0L;

    LinkedListClass()
    {

    }

    LinkedListClass(T data)
    {
        Node<T> newNode=new Node<>(data);
        head=newNode;
        tail=newNode;
        length++;
    }

    void insert(T data)
    {
        Node <T> newNode=new Node <T>(data);
        if (head == null) {
            this.head=newNode;
            tail=newNode;
            length++;
        }
        else
        {
            tail.next=newNode;
            this.tail=newNode;
            length++;
        }
    }
    void insertFront(T data)
    {
        Node <T> newNode=new Node <T>(data);
        if (head == null) {
            this.head=newNode;
            tail=newNode;
            length++;
        }
        else
        {
            newNode.next=head;
            head=newNode;
            length++;

        }
    }

    void insertAt(int index,T data)
    {
        if(index>length)
            this.insert(data);
        else if (index<=0) {
            System.out.println("Index must be greater than zero");
        }
        else
        {
            if(index==1)
                this.insertFront(data);
            else
            {
                Node <T> newNode=new Node <T>(data);
                Node <T> temp=head;
                for (int i = 1; i < index-1; i++) {

                    temp=temp.next;
                }
                newNode.next=temp.next;
                temp.next=newNode;
                length++;
            }
        }
    }
    void deleteFront()
    {
        if(head!=null)
        {
            if(head.next==null) {
                head = null;
                tail=null;
                length--;
            }

            else
            {

                head=head.next;
                length--;

            }
        }
    }

    void deleteLast()
    {
        if(head!=null)
        {
            if(head.next==null)
            {
                head = null;
                tail = null;
                length--;
            }

            else
            {
                Node <T> temp=head;
                while (temp.next!=tail)
                {
                    temp=temp.next;
                }
                temp.next=null;
                tail=temp;
                length--;

            }
        }
    }

    void deleteAt(int index)
    {
        if(head==null || head.next==null)
        {
            head=null;
        }
        else if (index<=0)
        {
            System.out.println("Index must be greater than zero");
        } else if (index>=length) {
            this.deleteLast();
        } else if (index==1) {
            this.deleteFront();
        } else
        {
            Node <T> temp=head;
            for (int i = 1; i < index-1; i++) {
                temp=temp.next;
            }
/*
1   2   3

 */
            temp.next=temp.next.next;
        }
    }


    T  at(int index)
    {

        if(index>length)System.out.println("Index must be less than length of LinkedList");
        else if(index<=0)System.out.println("Index must be greater than zero");
        else if (index==1) {
            return head.data;
        } else if (index == length) {
            return tail.data;
        } else
        {
            Node<T> temp= head;

            for (int i = 1; i < length; i++) {

                if(i==index)
                    return temp.data;
                temp=temp.next;
            }
        }
        return null;
    }

    int indexOf(T data)
    {
        if (head==null)
            System.out.println("List is empty");
        else
        {
            Node<T> temp=head;

            for (int i = 1; i <=length ; i++) {
                if (temp.data==data)
                    return i;
                temp=temp.next;
            }
        }
        return -1;
    }

    void update(int index,T data)
    {
        if (head!=null)
        {
            if(index>length)
            {
                System.out.println("Index must be less than length of LinkedList");
            }
            else if (index<=0)
            {
                System.out.println("Index must be greater than zero");
            }
            else if (index==1) {
                head.data=data;
            }
            else if (index==length) {
                this.tail.data=data;
            }
            else {
                Node<T> temp=head;
                for (int i = 1; i <length ; i++) {
                    if (i==index)
                    {
                        temp.data=data;
                        return;
                    }
                    temp=temp.next;

                }
            }
        }
    }

    void display()
    {
        Node <T> temp=head;
        while (temp!=null)
        {
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
        System.out.println();
    }



}