public class DoublyLinkedListClass<T> {
    static private class Node<T>
    {
        Node<T> prev=null;
        Node<T> next=null;
        T data;

        Node()
        {

        }
        Node(T data)
        {
            this.data=data;
        }
    }
    Node<T> head=null;
    Node<T> tail=null;

    long length=0L;


    DoublyLinkedListClass()
    {

    }
    DoublyLinkedListClass(T data)
    {
        Node <T> newNode=new Node<>(data);
        head=newNode;
        tail=newNode;
        length++;
    }

        /*
            insertAt
            insertFront
            insert

            deleteAt
            deleteFront
            deleteLast

            display
            rdisplay

            update
            index
            at

     */

    void insert(T data)
    {
        Node <T> newNode=new Node<>(data);
        if(head==null)
        {
            head=newNode;
            tail=newNode;
            length++;
        }
        else
        {
            tail.next=newNode;
            newNode.prev=tail;
            tail=newNode;
            length++;
        }
    }

    void insertFront(T data)
    {
        if (head==null)
        {
            insert(data);
        }
        else
        {
            Node<T> newNode=new Node<>(data);
            newNode.next=head;
            head.prev=newNode;
            head=newNode;
            length++;
        }
    }

    void insertAt(int index,T data)
    {
        if (index<=0)
        {
            System.out.println("Index must be greater than zero");
        }
        else if (index==length+1)
        {
            insert(data);
        } else if (index==1) {
            insertFront(data);
        } else if (index>length) {
            System.out.println("Enter a valid index number");
        }
        else
        {
            Node<T> newNode=new Node<>(data);
            Node<T> temp=head;
            for (int i = 1; i < index-1; i++) {
                temp=temp.next;
            }
            newNode.next=temp.next;
            temp.next.prev=newNode;
            newNode.prev=temp;
            temp.next=newNode;
            length++;
        }

    }

    void deleteFront()
    {
        if(head!=null)
        {
            if(head.next==null) {
                head = null;
                tail=null;
            }
            else
            {
                head=head.next;
                head.prev=null;
            }
            length--;
        }
    }

    void deleteLast()
    {
        if(head!=null)
        {
            if(head.next==null)
            {
                head=null;
                tail=null;
            }
            else
            {
                tail=tail.prev;
                tail.next=null;
            }
            length--;
        }
    }

    void deleteAt(int index)
    {
        if(head!=null)
        {
            if(index<=0)
                System.out.println("Index must be greater than zero");
            else if (index>length) {
                System.out.println("Index greater than length of linkedlist");
            }
            else
            {
                if(index==1)
                    deleteFront();
                else if (index==length) {
                    deleteLast();
                }
                else
                {
                    Node<T> tNode=head;
                    for(int i=1;i<index-1;i++)
                    {
                        tNode=tNode.next;
                    }
                    tNode.next.next.prev=tNode;
                    tNode.next=tNode.next.next;
                    length--;
                    
                }
            }
        }
    }

    T at(int index)
    {
        if(head!=null)
        {
            if (index==1)
                return head.data;
            else if (index==length) {
                return tail.data;
            }
            else
            {
                Node<T> t=head;
                for (int i=1;i<=length;i++)
                {
                    if(i==index)
                        return t.data;
                    t=t.next;
                }
            }
        }
        return null;
    }

    long indexOf(T data)
    {
        if(head!=null)
        {
            if(head.data==data)return 1;
            else if (tail.data == data) {
                return length;
            }
            Node<T> tNode=head;
            for (long i=1;i<=length;i++)
            {
                if(tNode.data==data)
                    return i;
                tNode=tNode.next;
            }
        }
        return -1L;
    }

    void update(int index,T newData)
    {
        if(head!=null)
        {
            if(index==1)
                head.data=newData;
            else if (index==length)
                tail.data=newData;
            else {
                    Node<T> temp=head;
                    for(int i=1;i<=length;i++)
                    {
                        if(i==index) {
                            temp.data = newData;
                            return;
                        }
                        temp=temp.next;
                    }
            }
        }
    }
    void display()
    {
        Node<T> temp=head;
        while (temp!=null)
        {
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
        System.out.println();
    }

    void rdisplay()
    {
        Node<T> tNode=tail;
        while (tNode!=null)
        {
            System.out.print(tNode.data+" ");
            tNode=tNode.prev;
        }
        System.out.println();

    }

}
