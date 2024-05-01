/**
 * Kelompok 6:
    1. Alif Median Ramadhan (222212480)
    2. Alifia Rahma Nur Anthony Putri (222212484)
    3. Cloudya Qashwah Montolalu (222212550)
    4. Rizky Alif lchwanto (222212857)
 */
public class Perusahaan {
    private int counter;
    private int noUrut;
    private KIP kodeIdentitas;
    private Kalimat namaPerusahaan;
    private Kalimat alamat;
    private Kalimat telp;
    private Kalimat fax;
    private Kode BBH;
    private Subsektor subsektor;
    private Kode kunjungan;
    private Kode aktif;
    private String JUU;
    
    public Perusahaan(int counter, KIP kodeIdentitas, int noUrut, String namaPerusahaan, String alamat, String telp, String fax, Kode BBH, Kode kunjungan, Kode aktif, Subsektor subsektor, String JUU) {
            this.counter = counter;
            this.kodeIdentitas = kodeIdentitas;
            this.noUrut = noUrut;
            this.namaPerusahaan = new Kalimat<>("NamaPerusahaan", "DPP.07", namaPerusahaan);
            this.alamat = new Kalimat<>("AlamatPerusahaan", "DPP.08", alamat);
            this.telp = new Kalimat<>("Telephone", "DPP.09", telp);
            this.fax = new Kalimat<>("Fax", "DPP.10", fax);
            this.BBH = BBH;
            this.kunjungan = kunjungan;
            this.aktif = aktif;
            this.subsektor = subsektor;
            this.JUU = JUU;
    }
    
    public int getCounter(){
        return counter;
    }
    
    public KIP getKodeIdentitas() {
        return kodeIdentitas;
    }
    
    public int getNoUrut() {
        return noUrut;
    }

    public Kalimat getNamaPerusahaan() {
        return namaPerusahaan;
    }

    public Kalimat getAlamat() {
        return alamat;
    }

    public Kalimat getTelp() {
        return telp;
    }

    public Kalimat getFax() {
        return fax;
    }

    public Kode getBBH() {
        return BBH;
    }

    public Subsektor getSubsektor() {
        return subsektor;
    }

    public Kode getKunjungan() {
        return kunjungan;
    }

    public Kode getAktif() {
        return aktif;
    }

    public String getJUU() {
        return JUU;
    }
    
    
    public boolean validate() throws InputError{
        if(namaPerusahaan.checkValue()&& alamat.checkValue() && telp.checkValue()&&telp.validatenomer((String)telp.getValue(), (String)fax.getValue()) && fax.checkValue() && BBH.checkValue()){
            System.out.println(Main.ANSI_GREEN+"Validasi Sukses! Object Perusahaan Akan Dibuat!"+Main.ANSI_RESET);
            return true;
        }
        else{
            Object[] obj = {namaPerusahaan,alamat,telp,fax,BBH};
            System.out.println(Main.ANSI_RED+"Validasi Gagal! Harap Ulang Input Data Object Perusahaan!"+Main.ANSI_RESET);
            deletePerusahaan(obj);
            return false;
        }
    }
    
    public void delete(Object obj){
         obj = new Object();
         obj = null;
         noUrut--;
         counter--;
    }
    
    public void deletePerusahaan(Object[] objs){
        for (Object obj:objs){
            delete(obj);
        }
        System.out.println("Input Sebelumnya Sudah Berhasil Dihapus");
    }
    
    @Override
    public String toString(){
        String format = "| %2s | %4s | %4s | %4s | %4s | %10s | %10s | %14s | %14s | %6s | %10s | %6s | %5s | %5s |%n";
        String output3 = String.format(format, counter , kodeIdentitas.getKodeProv().getValue(),kodeIdentitas.getKodeKab().getValue(),kodeIdentitas.getKodeKec().getValue(),noUrut,namaPerusahaan.getValue(),alamat.getValue(),telp.getValue(),fax.getValue(),BBH.getValue(),kunjungan.getValue(),aktif.getValue(),subsektor.toString(),kodeIdentitas.getKju().getValue(),"");
        return output3;
    }
}