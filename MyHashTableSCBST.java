class MyHashTableSCBST<K extends Comparable<K>,T> implements MyHashTable_<K, T> {
    public int size;
    public NodeSC<K, T>[] hashtable;
    public static long djb2(String str, int hashtableSize) {
        long hash = 5381;
        for (int i = 0; i < str.length(); i++) {
            hash = ((hash << 5) + hash) + str.charAt(i);
        }
        return Math.abs(hash) % hashtableSize;
    }
    public MyHashTableSCBST(int size) {
        this.size=size;
        hashtable=new NodeSC[size];
    }

    public int insert(K key, T obj) {
        int i=1;
        String k=key.toString();
        int index= (int) djb2(k,size);
      //  System.out.println("INDEX of "+k+Integer.toString(index));
        NodeSC<K, T> node=hashtable[index];
        if (node!=null)
        while(true){
            if (node!=null){
                if (key.compareTo(node.key)==0){
                    break;
                }else if (key.compareTo(node.key)>0/*A is Greater than B*/){
                    if (node.right!=null){
                        node=node.right;
                        i++;
                    }else{
                        node.right=new NodeSC<K, T>();
                        i++;
                        node.right.key=key;
                        node.right.value=obj;
                        break;
                    }

                }else if (key.compareTo(node.key)<0/*A is less than B*/){
                    if (node.left!=null){
                        node=node.left;
                        i++;
                    }else {
                        node.left=new NodeSC<K, T>();
                        i++;
                        node.left.key=key;
                        node.left.value=obj;
                        break;
                    }
                }
            }
        }
        else {
            hashtable[index]=new NodeSC<K, T>();
            hashtable[index].key=key;
            hashtable[index].value=obj;
        }


        return i;
    }

    // Update object for given key
    public int update(K key, T obj) {
        int i=1;
        String k=key.toString();
        int index= (int) djb2(k,size);
        NodeSC<K, T> node=hashtable[index];
        boolean b=false;
        while(true){
            if (node!=null){

                if (key.compareTo(node.key)==0){
                    node.value=obj;
                    b=true;
                    break;
                }else if (key.compareTo(node.key)>0/*A is Greater than B*/){
                    node=node.right;
                    i++;
                }else if (key.compareTo(node.key)<0/*A is less than B*/){
                    node=node.left;
                    i++;
                }
            }else {
                break;
            }
        }
        if (b)
        return i;
        else return -1;
    }

    // Delete object for given key
    public int delete(K key) {
        int i=1;
        String k=key.toString();
        int index= (int) djb2(k,size);
        NodeSC<K, T> node=hashtable[index];
        NodeSC<K, T> nodep=null;
        boolean b=false;
        while(true){
            if (node!=null) {
                if (key.compareTo(node.key)==0) {
                    if (node.right != null/*&&node.left != null*/) {
                        if (node.right.left==null){
                            i++;
                            node.key=node.right.key;
                            node.value=node.right.value;
                            b=true;
                            if (node.right.right!=null){
                               // i++;
                                node.right=node.right.right;
                            }
                            else node.right=null;
                            break;
                        }else {
                            NodeSC<K, T> node2 = node.right;
                            NodeSC<K, T> node3 = null;
                            while (node2.left != null) {
                                node3 = node2;
                                node2 = node2.left;
                                i++;
                            }
                            node.key = node2.key;
                            node.value = node2.value;
                            b=true;
                             if (node2.right != null) {
                                node3.left=node3.left.right;
                              //  i++;
                            } else node3.left = null;
                            break;
                        }

                    } else if (node.left != null) {
                        node.key = node.left.key;
                        node.value=node.left.value;
                        b=true;
                        i++;
                        if (node.left.left==null&&node.left.right==null){
                            node.left=null;
                            break;
                        }
                        if (node.left.left!=null){
                           // i++;
                            node.left=node.left.left;
                        }
                        if (node.left.right!=null){
                          //  i++;
                            node.right=node.left.right;
                        }
                        break;
                    } else /*if (node.right != null) {
                        node.key = node.right.key;
                        node.value=node.right.value;
                        b=true;
                        i++;
                        if (node.right.left==null&&node.right.right==null){
                            node.right=null;
                            break;
                        }
                        if (node.right.left!=null){
                            // i++;
                            node.left=node.right.left;
                        }
                        if (node.right.right!=null){
                            //  i++;
                            node.right=node.right.right;
                        }
                        break;
                    } else*/ {
                        b=true;
                        if (nodep==null)
                            hashtable[index]=null;
                        else if (nodep.left==node)
                            nodep.left=null;
                        else if (nodep.right==node)
                            nodep.right=null;
                        break;
                    }
                } else if (key.compareTo(node.key) > 0/*A is Greater than B*/) {
                    nodep=node;
                    node = node.right;
                    i++;
                } else if (key.compareTo(node.key) < 0/*A is less than B*/) {
                    nodep=node;
                    node = node.left;
                    i++;
                }
            }else break;
        }
        if (b)
        return i;
        else return -1;
    }

    // Does an object with this key exist?
    public boolean contains(K key) {
        String k=key.toString();
        int index= (int) djb2(k,size);
        NodeSC<K, T> node=hashtable[index];
        int i=0;
        while(true){

            if (node!=null) {
                if (key.compareTo(node.key)==0) {
                    return true;
                } else if (key.compareTo(node.key) > 0/*A is Greater than B*/) {
                    node = node.right;
                } else if (key.compareTo(node.key) < 0/*A is less than B*/) {
                    node = node.left;
                }
            }else break;
        }
        return false;
    }

    // Return the object with given key
    public T get(K key) throws NotFoundException {
        String k=key.toString();
        int index= (int) djb2(k,size);
        NodeSC<K, T> node=hashtable[index];
        while(true){

            if (node!=null) {
                if (key.compareTo(node.key)==0) {
                    return node.value;
                } else if (key.compareTo(node.key) > 0/*A is Greater than B*/) {
                    node = node.right;
                } else if (key.compareTo(node.key) < 0/*A is less than B*/) {
                    node = node.left;
                }
            }else throw new NotFoundException();
        }
    }


    public String address(K key) throws NotFoundException {
        String ans;
        String k=key.toString();
        int index= (int) djb2(k,size);
        ans=Integer.toString(index)+'-';
        String add="";
        NodeSC<K, T> node=hashtable[index];
        while(true){
            if (node!=null) {
                String B=(String)((Key)node.key).f;
                if (key.compareTo(node.key)==0) {
                    return ans + add;
                } else if (key.compareTo(node.key) > 0/*A is Greater than B*/) {
                    node = node.right;
                    add = add + 'R';
                } else if (key.compareTo(node.key) < 0/*A is less than B*/) {
                    node = node.left;
                    add = add + 'L';
                }
            }else throw new NotFoundException();
        }
    }
}
