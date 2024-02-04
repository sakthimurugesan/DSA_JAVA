public class LinkedListDemo {

    static QueueLinkedList<Integer> obj=new QueueLinkedList<>();

    public static void main(String[] args) {

        for (int i = 0; i < 5; i++) {
            obj.enqueue(i+1);
        }
        System.out.println(obj.rear());
        System.out.println(obj.front());
        System.out.println(obj.dequeue());
       obj.display();
    }

}
