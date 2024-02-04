public class StackLinkedList<T> {
    static private class Node<T>
    {
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

    StackLinkedList()
    {

    }

    StackLinkedList(T data)
    {
        head=new Node<>(data);
    }

    boolean isEmpty()
    {
        return head==null;
    }

    void push(T data)
    {
        Node<T> node=new Node<>(data);
        if(head==null)
        {
            head=node;
        }
        else
        {
            node.next=head;
            head=node;
        }
    }

    T top()
    {
        if (head!=null)
            return head.data;
        return null;
    }

    T pop()
    {
        if(head!=null)
        {
            T data=head.data;
            if(head.next==null)
            {

                head=null;

            }
            else
            {
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
            Node<T> s=head;
            while (s!=null)
            {
                System.out.print(s.data+" ");
                s=s.next;
            }
            System.out.println();
        }
    }

}
