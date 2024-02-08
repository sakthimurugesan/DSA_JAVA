
public class LinkedListDemo {

    public static void main(String[] args)
    {
        HashingClass<String,Integer> hash=new HashingClass<>();
        hash.put("sakthi",12);
        hash.put("sakthi1",12);hash.put("sakthi2",12);hash.put("sakthi2",14);
        hash.put("sakthi",13);
        hash.display();

        try {
//            System.out.println(5);
            System.out.println(hash.get("sakthi5"));
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }



    }

}
