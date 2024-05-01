/**
 * Kelompok 6:
    1. Alif Median Ramadhan (222212480)
    2. Alifia Rahma Nur Anthony Putri (222212484)
    3. Cloudya Qashwah Montolalu (222212550)
    4. Rizky Alif lchwanto (222212857)
 */

import java.util.ArrayList;
import java.util.Scanner;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_RED = "\u001B[31m";    
    public static final String ANSI_GREEN = "\u001B[32m";    
    public static void main(String[] args) throws Exception {
        Scanner userInput = new Scanner(System.in);
        String kodeKab = "", kodeProv="",kodeKju="" ,kodeKec="",alamat="",namaPerusahaan="",telp="",fax="",input = "",namaprov="", namakab="" ,kodeBBH="",kodeKunj="",kodeActive="",kodeTanPang="", kodeHortikultura="", kodePerkebunan="", kodeKehutanan="", kodePerikanan="", kodePeternakan="",descJUU="";
        KIP kip = null;
        DPP dpp = null;
        Subsektor subsektor = null;
        KodeProv<String> provinsi=null;
        KodeKab<String> kabupaten=null;
        KodeKec<String> kecamatan=null;
        Kode<String> bbh=null ,kju=null, tanPang=null, hortikultura=null ,perkebunan=null, kehutanan=null, perikanan=null , peternakan=null, kunjungan = null, aktif=null;
        //Kalimat<String> namaPerusahaanFix = null,telpFix= null, faxFix = null, alamatFix=null;
        Kuesioner kuesioner = null;
        Perusahaan perusahaan = null;
        ArrayList<Perusahaan> listAllPerusahaan = new ArrayList<>();
        int periodeData = 0, idKues = 0 ,i=0, noUrut=0, counter=0;
        boolean loop = true, inputValid = false;
//        Kode BBH
        LinkedHashMap<String,String> BBHList = new LinkedHashMap<String,String>(){{
            put("1", "Perusahaan Negara (PN)");
            put("2", "Perusahaan Daerah (PD)");
            put("3", "Persero");
            put("4", "Perum");
            put("5", "Perseroan Terbatas (PT)");
            put("6", "Naamloze Vennootschap (NV)");
            put("7", "Commanditaire Venootschap (CV)");
            put("8", "Firma");
            put("9", "Koperasi/KUD");
            put("10", "Yayasan");
        }};
        
//        Kode Jenis Usaha Utama
        LinkedHashMap<String,String> kodeJUU = new LinkedHashMap<String,String>(){{
            put("1", "Padi/Palawija");
            put("2","Hortikultura");
            put("3a","Perkebunan Kakao/cokelat");
            put("3b","Perkebunan Kare");
            put("3c","Perkebunan Kelapa sawit");
            put("3d","Perkebunan Kopi");
            put("3e","Perkebunan Teh");
            put("3f","Perkebunan Tebu");
            put("3g","Perkebunan Tembakau");
            put("3h","Perkebunan Cengkeh");
            put("3i","Perkebunan Kelapa");
            put("3j","Perkebunan Lada");
            put("3k","Tanaman Perkebunan Lainnya");
            put("4","HPH/IUPHHK-HA");
            put("5","HPHT/IUPHHK-HT/Perhutani/Kehutanan lainnya");
            put("6","Penangkaran STL");
            put("7a","Budidaya Udang");
            put("7b","Budidaya Bandeng");
            put("7c","Budidaya Ikan lainnya di tambak");
            put("7d","Budidaya Ikan di laut");
            put("7e","Budidaya Ikan di air tawar");
            put("7f","Budidaya Pembenihan");
            put("8","Penangkapan Ikan");
            put("9","Ternak Besar/Kecil");
            put("10","Unggas");
            put("11","Ternak Sapi Perah");
        }};
        
//       Kode Ada tidak ada
        LinkedHashMap<String,String> umum = new LinkedHashMap<String,String>(){{
            put("0", "tidak ada");
            put("1", "ada");
        }};
        
//       Kode Aktiv
        LinkedHashMap<String,String> active = new LinkedHashMap<String,String>(){{
            put("1", "Aktif");
            put("2", "Tutup Sementara/ Tidak Ada Kegiatan");
            put("3", "Belum Berproduksi");
            put("4", "Tidak Bersedia Diwawancarai");
            put("5", "Alih Usaha ke Non Pertanian");
            put("6", "Tutup");
            put("7", "Tidak Ditemukan");
            put("8", "Baru");
            put("9", "Ganda");
        }};
        
        do {            
            System.out.println("===========================================================================");
            System.out.println("= PROGRAM VALIDASI UPDATING DIREKTORI PERUSAHAAN PERTANIAN BERBADAN HUKUM =");
            System.out.println("===========================================================================");
        
            //input detail kuesioner
            do {                    
                try {
            System.out.println("\n===== Input Kuesioner Details =====");
            System.out.println("Input Kode Provinsi "+ANSI_YELLOW+"(1/2/3/4/5,..)"+ANSI_RESET+": ");
            kodeProv = userInput.nextLine();
            System.out.println("Input Nama Provinsi "+ANSI_YELLOW+"(Jawa Tengah/DKI Jakarta/...)"+ ANSI_RESET+": ");
            namaprov = userInput.nextLine();
            provinsi = new KodeProv<>(kodeProv,namaprov);
            inputValid=provinsi.validate();
            
            } catch (Exception e) {
                System.out.println(Main.ANSI_RED+e+"\nValidasi GAGAL!"+Main.ANSI_RESET);
            }
            } while (!inputValid);
            
            do {      
                try {
                    System.out.println("Input Kode Kabupaten "+ANSI_YELLOW+"(1/2/3/4/5,..)"+ANSI_RESET+": ");
                    kodeKab = userInput.nextLine();
                    System.out.println("Input Nama Kabupaten "+ANSI_YELLOW+"(Jombang/Madiun/...)"+ANSI_RESET+": ");
                    namakab= userInput.nextLine();
                    kabupaten = new KodeKab<>(kodeKab, namakab);
                    inputValid=kabupaten.validate();
                } catch (Exception e) {
                System.out.println(Main.ANSI_RED+e+"\nValidasi GAGAL!"+Main.ANSI_RESET);
                    inputValid=false;
                }
            } while (!inputValid);
            
            do {
                try {
                    System.out.println("Periode data "+ANSI_YELLOW+"(Tahun misal: 2019)"+ANSI_RESET+": ");
                    periodeData = userInput.nextInt();
                    inputValid=true;
                } catch (Exception e) {
                    System.out.println(ANSI_RED+"Pastikan Periode Data Berupa Tahun Dalam Angka\nValidasi GAGAL!"+ANSI_RESET);
                    inputValid=false;
                    userInput.nextLine();
                }
            } while (!inputValid);

            
            // setelah input yang valid diberikan, buat kuesioner
            System.out.println("Membuat Kuesioner");        
            System.out.println("Memuat Variabel...");
            idKues++;
            kuesioner = new Kuesioner(idKues, provinsi, kabupaten, periodeData);
            System.out.println(kuesioner);

            
            do {                
            System.out.println("\n===== Pilihan Menu Program =====");
            System.out.println("1. Input Perusahaan");
            System.out.println("2. Lihat List Perusahaan");
            System.out.println("3. Exit");
            System.out.println("\nSilahkan Input Nilai : ");
//          Mengatasi input loop pertama keskip
            if (i==0){
               input = userInput.nextLine();
               input = userInput.nextLine();
            }else{
                input = userInput.nextLine();
            }
            i++;
            switch (input) {
                case "1":
//                  Input KIP
                    do {                        
                        try {
                        System.out.println("\n===== Input KIP =====");
                        System.out.println("Kode Provinsi "+ANSI_YELLOW+"(harus sama dengan Kode Provinsi Kuesioner)"+ANSI_RESET+" :");
                        kodeProv = userInput.nextLine();
                        if (!kodeProv.equalsIgnoreCase(provinsi.getValue())) {
                            throw new InputError("Kode Provinsi kuesioner dan perusahaan harus sama\nValidasi GAGAL!");
                        }
                        System.out.println("Kode Kabupaten "+ANSI_YELLOW+"(harus sama dengan Kode Kabupaten Kuesioner)"+ANSI_RESET+" :");
                        kodeKab = userInput.nextLine();
                        if (!kodeKab.equalsIgnoreCase(kabupaten.getValue())) {
                            throw new InputError("Kode Kabupaten kuesioner dan perusahaan harus sama\nValidasi GAGAL!");
                        }
                        System.out.println("Kode Kecamatan"+ANSI_YELLOW+"(1/2/3/4/5,..)"+ANSI_RESET+" :");
                        kodeKec = userInput.nextLine();
                        kecamatan = new KodeKec<>(kodeKec);
                        inputValid=kecamatan.validate();
                        System.out.println("\nDaftar KJU");
                        for (Map.Entry<String, String> entry : kodeJUU.entrySet()) {
                            Object key = entry.getKey();
                            Object val = entry.getValue();
                            System.out.println(key+" "+val);
                        }
                        System.out.println("Kode KJU "+ ANSI_YELLOW+"(kodenya saja) :"+ANSI_RESET);
                        kodeKju= userInput.nextLine();
                        if (kodeJUU.containsKey(kodeKju)==false) {
                            throw new InputError("Kode KJU tidak ada dalam Kriteria BPS\nValidasi GAGAL!");
                        }
                        } catch (InputError e) {
                        System.out.println(ANSI_RED+e+ANSI_RESET);
                        inputValid=false;
                        }
                    } while (!inputValid);
                    
                    
                        //                    Membuat variabel KIP
                        System.out.println("Membuat KIP");
                        System.out.println("Memuat variabel ...");
                        kecamatan = new KodeKec<>(kodeKec);
                        kju = new Kode<>("KodeKju","DP.04",kodeKju,kodeJUU,2);
                        noUrut++;
                        counter++;
                        kip = new KIP(provinsi, kabupaten, kecamatan, kju, noUrut);
                        System.out.println(kip);
                        
                    do {   
                        try {
                            //                        Input Informasi Umum
                            System.out.println("\nInput Informasi Umum Perusahaan\n");
                            System.out.println("Nama Perusahaan : ");
                            namaPerusahaan = userInput.nextLine();
                            System.out.println("Alamat: ");
                            alamat = userInput.nextLine();
                            System.out.println("Nomor Telephone "+ANSI_YELLOW+"(awali dengan +62 atau +kode negara lain diikuti nomer)"+ANSI_RESET+" :");
                            telp = userInput.nextLine();
                            System.out.println("Nomor Faksimili "+ANSI_YELLOW+"(awali dengan kode wilayah misal (021) atau (kode) lalu diikuti nomer )"+ANSI_RESET+" :");
                            fax = userInput.nextLine();
                            System.out.println("\nDaftar BBH");
                            for (Map.Entry<String, String> entry : BBHList.entrySet()) {
                                Object key = entry.getKey();
                                Object val = entry.getValue();
                                System.out.println(key+" "+val);
                            }
                            System.out.println("Bentuk Badan Hukum "+ANSI_YELLOW+"(angkanya saja) : "+ANSI_RESET);
                            kodeBBH = userInput.nextLine();
                             if (BBHList.containsKey(kodeBBH)==false) {
                                System.out.println(ANSI_RED+"Kesalahan input BBH");
                                throw new InputError("Kode BBH tidak ada dalam Kriteria BPS"+ANSI_RESET);
                             }

                            //                      Input DPP
                            System.out.println("\n===== Input Pencacahan dengan Kuesioner Rutin/DPP =====\n");
                            System.out.println("Daftar Kunjungan");
                            for (Map.Entry<String, String> entry : umum.entrySet()) {
                                Object key = entry.getKey();
                                Object val = entry.getValue();
                                System.out.println(key+" "+val);
                            }
                            System.out.println("Status Kunjungan"+ANSI_YELLOW+" (angkanya saja) : "+ANSI_RESET);
                            kodeKunj = userInput.nextLine();
                            if (umum.containsKey(kodeKunj)==false) {
                                System.out.println(ANSI_RED+"Kesalahan input kode status");
                                throw new InputError("Kode kunjungan tidak ada dalam Kriteria BPS"+ANSI_RESET);
                             }
                            System.out.println("\nDaftar Kategori Aktif");
                            for (Map.Entry<String, String> entry : active.entrySet()) {
                                Object key = entry.getKey();
                                Object val = entry.getValue();
                                System.out.println(key+" "+val);
                            }
                            System.out.println("Status Keaktifan"+ANSI_YELLOW+" (angkanya saja) : "+ANSI_RESET);
                            kodeActive = userInput.nextLine();
                            if (active.containsKey(kodeActive)==false) {
                                System.out.println(ANSI_RED+"Kesalahan input kode status");
                                throw new InputError("Kode Aktif tidak ada dalam Kriteria BPS"+ANSI_RESET);
                             }

                            //                    Generate Subsektor dan JUU

                            System.out.println("Generate Subsektor dan JUU");
                            System.out.println("Memuat...");
                            if(kodeKju.equals("1")){
                                kodeTanPang = "1";
                            }else{
                                kodeTanPang = "0";
                            }

                            if (kodeKju.equals("2")) {
                                kodeHortikultura = "1";
                            } else {
                                kodeHortikultura = "0";
                            }

                            if (kodeKju.equals("9")||kodeKju.equals("10")||kodeKju.equals("11")) {
                                kodePeternakan = "1";
                            } else {
                                kodePeternakan = "0";
                            }

                            if (kodeKju.equals("4")||kodeKju.equals("5")||kodeKju.equals("6")) {
                                kodeKehutanan = "1";
                            } else {
                                kodeKehutanan = "0";
                            }
 
                            if (kodeKju.matches("^7[a-f]$") || kodeKju.equals("8")) {
                                kodePerikanan = "1";
                            } else {
                                kodePerikanan = "0";
                            }

                            if (kodeKju.matches("^3[a-k]$")){
                                kodePerkebunan = kodeKju;
                            } else{
                                kodePerkebunan = "0";
                            }

                            tanPang = new Kode<>("KodeTanpang","DPP.14",kodeTanPang,2);
                            hortikultura = new Kode<>("KodeHortikultura","DP.15",kodeHortikultura,2);
                            perkebunan = new Kode<>("KodePerkebunan","DPP.16",kodePerkebunan,2);
                            peternakan = new Kode<>("KodePeternakan","DPP.17",kodePeternakan,2);
                            kehutanan = new Kode<>("KodeKehutanan","DPP.18",kodeKehutanan,2);
                            perikanan = new Kode<>("KodePerikanan","DPP.19",kodePerikanan,2);

                            subsektor = new Subsektor(tanPang, hortikultura, perkebunan, kehutanan, peternakan, perikanan);
                            descJUU = kodeJUU.get(kodeKju);

                            //                    Membuat Variabel Perusahaan
                            System.out.println("Membuat variabel perusahaan");
                            System.out.println("Memuat variabel...");
                            bbh = new Kode<>("BBH", "DPP.11", kodeBBH,BBHList,2);
                            kunjungan = new Kode<>("kunjungan", "DPP.12", kodeKunj,umum, 2);
                            aktif = new Kode<>("aktif", "DPP.13", kodeActive,active, 2);
                            dpp = new DPP(kunjungan, aktif);
                            perusahaan = new Perusahaan(counter, kip, noUrut, namaPerusahaan, alamat, telp, fax, bbh, kunjungan, aktif, subsektor, descJUU);
                            if (!perusahaan.validate()) {
                                 noUrut--;
                                 counter--;
                            }else{
                                listAllPerusahaan.add(perusahaan);
                                kuesioner.setListAllPerusahaan(listAllPerusahaan);
                                inputValid=true;
                            }
                        } catch (InputError e) {
                            System.out.println(ANSI_RED+"Membuat Variabel Perusahaan gagal");
                            System.out.println(e+ANSI_RESET);
                            inputValid=false;
                        }
                        }while (!inputValid);
                    break;
                case "2":
                    if (kuesioner.getListAllPerusahaan().isEmpty()){
                        System.out.println(ANSI_RED+"Belum ada perusahaan yang didata\n"+ANSI_RESET);
                    } else{
                        System.out.printf("============================================================================= UPDATING DIREKTORI PERUSAHAAN PERTANIAN BERBADAN HUKUM =============================================================================%n");
                        System.out.println(kuesioner.toString());
                        System.out.printf("==================================================================================================================================================================================================================%n");
                        System.out.printf("| %2s | %25s | %10s | %10s | %14s | %14s | %6s | %19s | %31s %11s %31s| %5s |%n","","Kode Identitas Perusahaan","","","","","","Kuesioner Rutin DPP","","Subsektor","","");
                        System.out.printf("| %2s | %25s | %10s | %10s | %5s %2s %5s | %5s %2s %5s | %6s | %19s | %74s | %5s |%n","","-------------------------","Nama","Alamat","","No","","","No","","Bentuk","-------------------","--------------------------------------------------------------------------","Jenis");
                        System.out.printf("| %2s | %4s | %4s | %4s | %4s | %10s | %10s | %2s %8s %2s | %2s %9s %1s | %6s | %10s | %5s | %7s | %12s | %10s | %10s | %10s | %10s | %5s |%n","No","Kode","Kode","Kode","No","Perusahaan","Perusahaan","","Telepon","","","Faksimili","","Badan","Kunjungan","Status","Tanaman","Hortikultura","Perkebunan","Peternakan","Kehutanan","Perikanan","Usaha");
                        System.out.printf("| %2s | %4s | %4s | %4s | %4s | %10s | %10s | %14s | %14s | %6s | %10s | %6s | %7s | %12s | %10s | %10s | %10s | %10s | %5s |%n","","Prov","Kab","Kec","Urut","Pertanian","Pertanian","","","Hukum","","","Pangan","","","","","","Utama");
                        System.out.printf("==================================================================================================================================================================================================================%n");
                        System.out.printf(kuesioner.getListAllPerusahaan());
                        System.out.printf("==================================================================================================================================================================================================================%n");
                    }
                    break;
                case "3":
                    System.out.println(ANSI_GREEN+"Terima kasih"+ANSI_RESET);
                    System.exit(0);
                    loop = false;
                    break;
                default:
                    System.out.println(ANSI_RED+"Kode yang Anda masukkan salah!"+ANSI_RESET);
            }
            } while (loop);
        } while (loop);
    }
}