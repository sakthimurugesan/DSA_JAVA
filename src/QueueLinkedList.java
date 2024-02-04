public class QueueLinkedList<T> {
    static private class Node<T>
    {
        T data;
        Node<T> next=null;

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

    QueueLinkedList()
    {

    }
    QueueLinkedList(T data)
    {
        Node<T> newNode=new Node<>(data);
        head=newNode;
        tail=newNode;
    }

    T rear()
    {
        if(tail!=null)
            return tail.data;
        return null;
    }
    T front()
    {
        if(head!=null)
            return head.data;
        return null;
    }

    void enqueue(T data)
    {
        if(head==null)
        {
            Node<T> newNode=new Node<>(data);
            head=newNode;
            tail=newNode;
        }
        else
        {
            Node<T> newNode=new Node<>(data);
            tail.next=newNode;
            tail=newNode;
        }
    }

    T dequeue()
    {
        if (head!=null)
        {
            T data;
            if(head.next==null)
            {
                data=head.data;
                head=null;
                tail=null;

            }
            else
            {
                data=head.data;
                head=head.next;
            }
            return data;
        }
        return null;
    }

    void display()
    {
        if(head!=null)
        {
            Node<T> tNode=  head;
            while (tNode!=null)
            {
                System.out.print(tNode.data+" ");
                tNode=tNode.next;
            }
            System.out.println();

        }
    }
}
