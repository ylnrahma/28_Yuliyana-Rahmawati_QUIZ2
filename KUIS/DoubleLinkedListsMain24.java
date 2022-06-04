import java.util.Scanner;
public class DoubleLinkedListsMain24 {

    System.out.print("========QUIZ 2 PRAKTIKUM ASD TI - 1G DAN TI - 1F=========");
    System.out.print("Dibuat oleh : Yuliyana Rahmawati");
    System.out.print("NIM : 2141720241");
    System.out.print("Absen : 24");
    System.out.print("=======================================================");

    public static void menu(){
        System.out.println("=====================================");
        System.out.println("  Sistem Antrian Resto Royal Delish  ");
        System.out.println("=====================================");
        System.out.println(" 1. Tambah Antrian ");
        System.out.println(" 2. Cetak Antrian ");
        System.out.println(" 3. Hapus Antrian");
        System.out.println(" 4. Laporan Pengurutan Pesanan by Yuliyana Rahmawati");
        System.out.println(" 5. Hitung Total Pendapatan");
      System.out.println(" 6. Keluar");
        System.out.println("-----------------------------------");
    }

    public static void main(String[] args) throws Exception {
       Scanner yl = new Scanner(System.in);
       Scanner yln = new Scanner(System.in);
       Scanner ylr = new Scanner(System.in);
       
       DoubleLinkedLists24 dll = new DoubleLinkedLists24();
        
       int pilih;
        do{
            menu();
            pilih = yl.nextInt();
            yl.nextLine();
    
            switch(pilih){
                case 1:
                    System.out.println("Masukan Data Pembeli");
                    System.out.print("Nomor Antrian\t\t: ");
                    String kd = yln.nextLine();
                    System.out.print("Nama Customer\t: ");
                    String pembeli = yl.nextLine();
                    System.out.print("NoHP\t\t: ");
                    String NoHP = yln.nextLine();
                    dll.addFirst(kd, pembeli, NoHP);
                    yl.nextLine();
                break;

                case 2:
                    dll.print();
                
                case 3:
                    System.out.println("hapus antrian");
                    System.out.print("Urutan ke - ");
                    int index = yln.nextInt();
                    dll.remove(index);
                    dll.print();
                    System.out.println("Transaksi Input Pesanan");
                    System.out.print("Nomer Pesana - ");
                    int idx = yln.nextInt();
                    System.out.print("ID Film\t\t: ");
                    int idDD = yln.nextInt();
                    System.out.print("Judul Film\t: ");
                    String judulFilmMM = yl.nextLine();
                    System.out.print("Rating\t\t: ");
                    double ratingGG = ylr.nextDouble();
                    dll.add(idDD, judulFilmMM, ratingGG, idx);
                    yl.nextLine();
                break;
                
                case 4:
                    System.out.println("Laporan Pesanan");
                    dll.sort();
                break;

                case 5:
                    System.out.println("Hitung Total Pesanan");
                    dll.sort();
                break;
                
                case 6:
                    System.exit(0);
                break;
            } 
        }while (pilih == 1 || pilih == 2 || pilih == 3 || pilih == 4 || pilih == 5 || pilih == 6 );
    }
}