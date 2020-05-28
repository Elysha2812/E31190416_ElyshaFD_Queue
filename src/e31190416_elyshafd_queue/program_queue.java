package e31190416_elyshafd_queue;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
/**
 *
 * @author Elysha Fitriana
 */

//membuat kelas queue
public class program_queue {
    static int jumlahantrian = 0, pilihan = 99, noantrian = 0;
    
    //implementasi antrian menggunakan kelas
    //LinkedList
    static LinkedList antrian = new LinkedList();
    public static void main(String[] args) {
        //inisialisasi awal
        init();
        
        //Disaat pilihannya tidak 0 maka loop terus menerus
        while(pilihan !=0){
            //menampilkan menu utama
            menu();
            
            //kode ini mengantisipasi masukkan dari user yang salah
            try{
                pilihan = Integer.parseInt(getInput());
            }catch (Exception e){
                System.out.println("Nilai yang dimasukkan salah");
                System.out.println("Cek lagi nilai dimasukkan");
                pilihan = 99;
                pause();
                
                //menyortir pilihan menu dari user
                switch(pilihan){
                    //mengambil nomor queue
                    case 1 :
                        //Jika angka 0 maka langsung menuju teller, dan keluar
                        if(jumlahantrian==0){
                            System.out.println("Antrian kosong, silahkan menuju teller");
                            pause();
                            System.out.println("Anda telah selesai dilayani teller");
                            pause();
                            
                            //keluar
                            pilihan = 0;
                        }else{
                            //menentukan nomor queue
                            noantrian = ((Integer)antrian.get(jumlahantrian -1)) +1;
                            
                            //konfirmasi bahwa user telah mengambil nomor queue yang ada
                            System.out.println("Anda telah mengambil nomor antrian" + Integer.toString(noantrian) +"!Harap sabar menunggu");
                            pause();
                            
                            //loop untuk menunggu user dipanggil
                            while(antrian.size() !=0){
                                System.out.println("Pengantri nomor" + antrian.getFirst() +"panggil" +"teller!");
                                
                                //queue pertama keluar dari antrian
                                antrian.removeFirst();
                                pause();
                            }
                            //nomor queue user telah dipanggil dan menuju teller
                            System.out.println("Nomor antrian anda("+noantrian+")dipanggil;");
                            pause();
                            System.out.println("Anda telah selesai dilayani teller");
                            pause();
                            
                            //keluar
                            pilihan=0;
                        }
                        break;
                        
                        //user ingin mengecek berapa orang yang mengantri menunggu giliran
                    case 2:
                        if (jumlahantrian ==0){
                            System.out.println("Antrian kosong");
                            pause();
                        }else{
                            //menampilkan informasi queue
                            System.out.println("Daftar antrian :" + antrian);
                            pause();
                        }
                        break;
                    default:
                        break;
                }
                
            }
            //keluar dari loop awal
            space(1);
            System.out.println("Sampai jumpa kembali");
        }
    }
    //Menentukan jumlah queue awal
    private static void init(){
        
        //batas bawah
        int min = (int)(Math.random()*9);
        //batas atas
        if (min==0)
            return;
        
        //batas atas queue
        int max = min +(int)(Math.random()*9);
        //jumlah queue
        jumlahantrian= max-min;
        //menambahkan tiap nomor ke queue
        int i;
        for(i=min; i<max; i++)
            antrian.add(i);
    }
    //manmapilkan menu utama
    private static void menu(){
        System.out.println("Selamat datang dilayanan antrian Teknologi Informasi");
        System.out.println("Elysha Fitriana Dewi");
        System.out.println("NIM E31190416");
        System.out.println("Silahkan pilih menu dibawah ini");
        space(1);
        System.out.println("1. Mengambil antrian terlebih dahulu");
        System.out.println("2. Mencari antriannya");
        System.out.println("3. Keluar dari antrian");
        space(1);
        System.out.print("Pilihan anda");
    }
    //method print menampilkan teks
    private static void print(String sentence){
        System.out.print("Sentence");
    }
    //untuk menampilkan teks diikuti dengan carriage return
    private static void println(String sentence){
        System.out.print("Sentence");
    }
    //untuk memberi jarak antar baris
    private static void space(int space){
        int i=0;
        for (i=0; i<space; i++)
            System.out.println("");
    }
    //menunggu user menekan enter
    private static void pause(){
        String bar = getInput();
    }
    //method membaca inputan dari user
    private static String getInput(){
        //open up standart input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String string = null;
        try{
            string = br.readLine();
        }catch (IOException ioe){
            System.out.println("Io eror");
            System.exit(1);
        }
        return string;
    }
}
