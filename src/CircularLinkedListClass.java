public class CircularLinkedListClass<T> {
    static private class Node<T>
    {
        T data;
        Node<T> next=null;

        Node() {}

        Node(T data)
        {
            this.data=data;
        }
    }

   private Node head=null;
    private Node<T> tail=null;

    private int length=0;
    CircularLinkedListClass(){}
    CircularLinkedListClass(T data)
    {
        insert(data);
    }
    void insert(T data)
    {
        Node<T> tNode=new Node<T>(data);
        if(head==null)
        {
            head=tNode;
            head.next=tNode;
            tail=tNode;
        }
        else
        {
            tail.next=tNode;
            tNode.next=head;
            tail=tNode;
        }
        length++;
    }

    void insertFront(T data)
    {
        Node<T> tNode=new Node<>(data);
        if(head==null)
        {
            head=tNode;
            head.next=tNode;
            tail=tNode;
        }
        else
        {
           tail.next=tNode;
           tNode.next=head;
           head=tNode;
        }
        length++;
    }

    private Node insertAtIndex(int index,T data)
    {
        if(index>length+1) {
            return this.head;
        }
        if(index==1) {
            insertFront(data);
            return head;
        }
        else if (index==length+1) {
            insert(data);
            return head;
        }
        else {
            Node<T> temp=head;
            for(int i=1;i<length-2;i++)
            {
                temp=temp.next;
            }
            Node<T> tnode=new Node<>(data);

            tnode.next=temp.next;
            temp.next=tnode;
            length++;
            return head;
        }

    }
    void insertAt(int index,T data)
    {
        this.head=this.insertAtIndex(index,data);
    }

    void delete(){
        if (head==null)return;
        if (head.next==head)
        {
            head=null;
            tail=null;
            return;
        }
        else
        {
            Node<T> temp=head;

            while (temp.next!=tail)
                temp=temp.next;

            tail=temp;
            tail.next=head;
        }
        length--;
    }

    void deleteFront() {
        if(head==null)return;
        if (head.next == head) {
            head = null;
            tail = null;
            length--;
        } else {
            head = head.next;
            tail.next=head;
            length--;
        }
    }


    void deleteAt(int index)
    {
        if (index<=0)return;
       if(index==1 || head.next==head)
       {
           deleteFront();
       } else if (index==length) {
           delete();
       } else {
           Node<T> temp=head;
           for(int i=1;i<index-1;i++)
               temp=temp.next;

           temp.next=temp.next.next;

       }
    }

    void display()
    {
        if (head==null)return;
        Node<T> temp=head;
        do {
            System.out.print(temp.data+" ");
            temp=temp.next;
        }while (temp!=head);
    }

    int length()
    {return this.length;}

}
