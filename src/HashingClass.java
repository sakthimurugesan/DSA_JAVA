import java.util.LinkedList;

class KeyNotFoundException extends Exception
{
    @Override
    public String getMessage()
    {
        return "Key Not Found ";
    }
}

public class HashingClass<K,V> {
    static private class Node<K,V>
    {
        private K key;
        private V value;


        Node(K key,V value)
        {
            this.key=key;
            this.value=value;
        }

    }

    private LinkedList<Node> bucketArray[];
    private int bSize=0;
    private int ele=0;

    HashingClass()
    {
        this.bSize=4;
        bucketArray=new LinkedList[bSize];
        for (int i = 0; i <4; i++) {
            bucketArray[i]= new LinkedList<>();
;        }

    }

    private int bucketIndex(K key)
    {
        return Math.abs(key.hashCode())%bSize;
    }

    private int searchInList(int bIndex,K key)
    {
        for (int i = 0; i < bucketArray[bIndex].size(); i++) {
            if(bucketArray[bIndex].get(i).key==key) {
                Node temp=bucketArray[bIndex].get(i);
                return i;
            }
        }
        return -1;
    }

    void put(K key,V value)
    {
        int bIndex=bucketIndex(key);
        int searchResult=searchInList(bIndex,key);
        if(searchResult==-1)
        {
            bucketArray[bIndex].add(new Node<>(key, value));
        }
        else
        {
            bucketArray[bIndex].get(searchResult).value=value;
        }

    }

    V get(K key) throws KeyNotFoundException
    {
        int bIndex=bucketIndex(key);
        for (int i = 0; i < bucketArray[bIndex].size(); i++) {
            if(bucketArray[bIndex].get(i).key==key) {
                return (V) bucketArray[bIndex].get(i).value;
            }
        }
        throw new KeyNotFoundException();
    }
    void display()
    {
        for (int i = 0; i < bSize; i++) {
            for (int j = 0; j < bucketArray[i].size(); j++) {
                System.out.println(bucketArray[i].get(j).key+" "+bucketArray[i].get(j).value);
            }
        }
    }
}
