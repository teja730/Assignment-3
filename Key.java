public class Key<A extends Comparable<A>, B extends Comparable<B>> implements Comparable<Key<A,B>> {
    A f;
    B l;
    public String toString(){
        return f.toString()+l.toString();
    }



    public int compareTo(Key<A,B> g){
       /* return f.compareTo(g.f);*/
        if (f.compareTo(g.f)==0){
            return l.compareTo(g.l);
            // return 0;
            //else return -1;
        }else return f.compareTo(g.f);
    }

   /* @Override
    public int compareTo(Key<A, B> abKey) {
        return 0;
    }*/
}
