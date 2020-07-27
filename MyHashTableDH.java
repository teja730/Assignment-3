import java.lang.Math;
class MyHashTableDH<K, T> implements MyHashTable_ <K, T>{
    public int size;
    public Node<K, T>[] hashtable;
    public int gcd(int num1,int num2) {
        while (num1 != num2) {
            if(num1 > num2)
                num1 = num1 - num2;
            else
                num2 = num2 - num1;
        }
        return num2;
    }

    public MyHashTableDH(int size) {
        this.size=size;
        hashtable=new Node[size];
    }


    public static long djb2(String str, int hashtableSize) {
        long hash = 5381;
        for (int i = 0; i < str.length(); i++) {
            hash = ((hash << 5) + hash) + str.charAt(i);
        }
        return Math.abs(hash) % hashtableSize;
    }
    public static long sdbm(String str, int hashtableSize) {
        long hash = 0;
        for (int i = 0; i < str.length(); i++) {
            hash = str.charAt(i) + (hash << 6) + (hash << 16) - hash;
        }
        return Math.abs(hash) % (hashtableSize - 1) + 1;
    }

    public int insert(K key, T obj) {
        String k=key.toString();
        Node<K,T> elem=new Node(key,obj);
        int index1= (int) djb2(k,size);
        int index2= (int) sdbm(k,size);
        int i=0;
        //System.out.println("Index is:"+ Integer.toString(index1)+" " +Integer.toString(index2));
        int i1=size/gcd(size,index2%size);
        while (i<=i1) {
            int index=(index1+i*index2)%size;
            //System.out.println(index);
          //  System.out.println("Index is:"+ Integer.toString(index));
            if (hashtable[index]==null){
                hashtable[index]=elem;
                break;
            }else
                i++;
        }
        return i+1;
    }

    @Override
    public int update(K key, T obj) {
        {
            String k = key.toString();
            int index1 = (int) djb2(k, size);
            int index2 = (int) sdbm(k, size);
            int i = 0;
            int i1=size/gcd(size,index2%size);
            boolean b=false;
            while (i<=i1) {
                int index = (index1 + i * index2)  % size;
            //   System.out.println("Index while updating is:"+ Integer.toString(index1));
                if (hashtable[index]!=null)
                if (hashtable[index].key.toString().equals(key.toString())) {
                    hashtable[index].value = obj;
                    b=true;
                    break;
                } else
                    i++;
                else i++;
                //should add the case if it does not exist, what to do
            }
            if (b)
            return i+1;
            else return -1;
        }

    }
    @Override
    public int delete(K key) {
        /*for (int i=0;i<size;i++){
            if (hashtable[i].key.equals(key)) {
                hashtable[i] = null;
                break;
            }
        }*/
            String k = key.toString();
            int index1 = (int) djb2(k, size);
            int index2 = (int) sdbm(k, size);
            int i = 0;
            int i1=size/gcd(size,index2%size);
            boolean b=false;
          //  System.out.println("i1="+i1);
            while (i<=i1) {
                int index = (index1 + i * index2) % size;
                if (hashtable[index]!=null) {
                    if (hashtable[index].key.toString().equals(key.toString())) {
                        b=true;
                        hashtable[index] = null;
                       // System.out.println("deleted "+k);
                        break;
                    } else
                        i++;
                }else i++;
                //should add the case if it does not exist, what to do
            }
            if (b)
            return i+1;
            else return -1;
    }

    @Override
    public boolean contains(K key) {
        for (int i=0;i<size;i++){
            if (hashtable[i]!=null)
            if (hashtable[i].key.toString().equals(key.toString()))
                return true;
        }
        return false;
    }

    @Override
    public T get(K key) throws NotFoundException {
        for (int i=0;i<size;i++){
            if (hashtable[i]!=null)
            if (hashtable[i].key.toString().equals(key.toString()))
                return hashtable[i].value;
        }
        throw new NotFoundException();
    }

    @Override
    public String address(K key) throws NotFoundException {
        for (int i=0;i<size;i++){
            if (hashtable[i]!=null)
            if (hashtable[i].key.toString().equals(key.toString()))
                return Integer.toString(i);
        }
        throw new NotFoundException();
    }
}
