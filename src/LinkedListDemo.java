public class LinkedListDemo {

    static StackLinkedList<Integer> obj=new StackLinkedList<>();

    public static void main(String[] args) {

        for (int i = 0; i < 2; i++) {
            obj.push(i+1);
        }

       obj.display();
        System.out.println(obj.top());
        System.out.println(obj.isEmpty());
        obj.display();
    }

}
