public class DoubleLinkedLists24 {
    Node24 head;
    int size;
    
    public DoubleLinkedLists24(){
        head = null;
        size = 0;    
    }
    public boolean isEmpty(){
        return head == null;
    }
    public void addFirst(String pembeli, String NoHP, int kd, String pesanan, int harga){
        if (isEmpty()){
            head  = new Node24(null, pembeli, NoHP, kd , pesanan, harga, null);
        }else{
            Node24 newNode = new Node24(null, pembeli, NoHP, kd , pesanan, harga, head);
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }
    public void addLast(String pembeli, String NoHP, int kd, String pesanan, int harga){
        if (isEmpty()){
            addFirst(pembeli, NoHP, kd , pesanan, harga);
        }else{
            Node24 current = head;
            while (current.next != null){
                current = current.next;
            }
            Node24 newNode = new Node24(current, pembeli, NoHP, kd , pesanan, harga, null);
            current.next = newNode;
            size++;
        }
    }
    public void add(String pembeli, String NoHP, int kd, String pesanan, int harga, int index) throws Exception {
        if (isEmpty()){
            addFirst(pembeli, NoHP, kd , pesanan, harga);
        }else if (index <0 || index > size){
            throw new Exception("Nilai indeks di luar batas");
        }else{
            Node24 current = head;
            int i = 0;
            while(i<index){
                current = current.next;
                i++;
            }
            if(current.prev == null){
                Node24 newNode = new Node24(null, pembeli, NoHP, kd , pesanan, harga, current);
                current.prev = newNode;
                head = newNode;
            }else{
                Node24 newNode = new Node24(current.prev, pembeli, NoHP, kd , pesanan, harga, current);
                newNode.prev = current.prev;
                newNode.next = current;
                current.prev.next = newNode;
                current.prev = newNode;
            }
        }
        size++;
    }
    public void removeFirst() throws Exception{
        if(isEmpty()){
            throw new Exception("Linked List Masih kosong, tidak dapat dihapus!");
        }else if (size == 1){
            removeLast();
        }else{
            head = head.next;
            head.prev = null;
            size--;
        }
    }
    public void removeLast() throws Exception {
        if(isEmpty()){
            throw new Exception("Linked list masih kosong, tidak dapat dihapus!");
        }else if (head.next == null){
            head = null;
            size--;
            return;
        }
        Node24 current = head;
        while (current.next.next != null){
            current = current.next;
        }
        current.next = null;
        size--;
    }
    public void remove(int index) throws Exception {
        if (isEmpty() || index >= size){
            throw new Exception("Nilai indeks di luar batas");
        }else if (index == 0){
            removeFirst();
        }else{
            Node24 current = head;
            int i=0;
            while (i<index){
                current = current.next;
                i++;
            }
            if(current.next == null){
                current.prev.next = null;
            }else if(current.prev == null){
                current = current.next;
                current.prev = null;
                head = current;
            }else{
                current.prev.next = current.next;
                current.next.prev = current.prev;
            }
            size--;
        }
    }
    public void print(){
        System.out.println("----------------------");
        System.out.println("Daftar Antrian Resto Royal Delish"); 
        if(!isEmpty()){
            Node24 tmp = head;
            while (tmp != null){
                System.out.println("Nama Customer \t\t: "+tmp.pembeli);
                System.out.println("No Hp \t: "+tmp.NoHP);
                System.out.println();
                tmp = tmp.next;
            }
        }else{
            System.out.println("Linked List Kosong");
        }
    }
    public int findSeqSearch(int cari){
        Node24 tmp = head;
        int posisi = -1;
        int index = 0;
        while (tmp != null){
            if(tmp.kd == cari){
                posisi = index;
                break;
            }
            index++;
            tmp = tmp.next;
        }
        return posisi;
    }
    public void tampilPosisi(int x, int pos){
        if(pos != -1){
            System.out.println("Kode\t\t: "+ x +" ditemukan pada indeks "+pos);
        }else {
            System.out.println("Kode\t\t"+ x +" tidak ditemukan");
        }
    }
    public void sort(){
        Node24 current = null, index = null;
        String tempPBL;
        String tempNP;
        int tempKD;
        String tempPSN;
        int tempHG;

        if (head == null) {
            return;
        } else {
            for (current = head; current.next != null; current = current.next) {
                for (index = current.next; index != null; index = index.next) {
                    if (current.harga < index.harga) {
                        tempHG = current.harga;
                        current.harga = index.harga;
                        index.harga = tempHG;
                        tempKD = current.kd;
                        current.kd = index.kd;
                        index.kd = tempKD;
                        tempPBL = current.pembeli;
                        current.pembeli = index.pembeli;
                        index.pembeli = tempPBL;
                    }
                }
            }
            print();
        }
    }
}