public class Node24 {
    Pembeli24 data;
    Pesanan24 data1;
    Node24 prev, next;

    public Node24(Node24 prev, Pembeli24 data, Pesanan24 data1, Node24 next) {
       this.prev = prev;
       this.data = data;
       this.data1 = data1;
       this.next = next;
    }
}