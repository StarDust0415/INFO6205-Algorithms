package CouponCollector;

import birthday.BirthDay;

public class CouponColletor<Key,Value> {
    private int M;
    private Node[] nodes;
    private int count;
    public CouponColletor(int M) {
        this.M = M;
        this.nodes = new Node[this.M];
        count=0;
    }

    private static class Node {
        private Object key;
        private Object value;
        private Node next;

        private Node(Object key, Object value, Node last) {
            this.key = key;
            this.value = value;
            this.next = last;
        }
    }


    public boolean ifEncountered(Key key) {
        return nodes[hash(key)] != null;
    }
    public boolean ifOccupy(){
        return count==M;
    }
    public int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    public void put(Key key, Value value) {
        int i = hash(key);
        if (nodes[i]==null) count++;
        for (Node x = nodes[i]; x != null; x = x.next)
            if (key.equals(x.key)) {
                x.value = value;
                return;
            }
        nodes[i] = new Node(key, value, nodes[i]);
    }
}
