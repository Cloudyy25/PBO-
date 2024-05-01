/**
 * Kelompok 6:
    1. Alif Median Ramadhan (222212480)
    2. Alifia Rahma Nur Anthony Putri (222212484)
    3. Cloudya Qashwah Montolalu (222212550)
    4. Rizky Alif lchwanto (222212857)
 */

public class KIP {
    private KodeProv kodeProv;
    private KodeKab kodeKab;
    private KodeKec kodeKec;
    private Kode kju;
    private int noUrut;
    
    public KIP(KodeProv kodeProv, KodeKab kodeKab, KodeKec kodeKec, Kode kju, int noUrut) throws InputError {
       if(validate(kodeProv, kodeKab, kodeKec, kju)){
        this.kodeProv = kodeProv;
        this.kodeKab = kodeKab;
        this.kodeKec = kodeKec;
        this.kju = kju;
        this.noUrut = noUrut;
       }
    }
    
    public int getNoUrut() {
        return noUrut;
    }

    public Kode getKju() {
        return kju;
    }

    public KodeKab getKodeKab() {
        return kodeKab;
    }

    public KodeKec getKodeKec() {
        return kodeKec;
    }

    public KodeProv getKodeProv() {
        return kodeProv;
    }
    
    public boolean validate(KodeProv kodeProv, KodeKab kodeKab, KodeKec kodeKec, Kode kju ) throws InputError{
        if(kodeProv.checkValue(true)&& kodeKab.checkValue(true) && kodeKec.checkValue(true) && kju.checkValue()){
            System.out.println(Main.ANSI_GREEN+"Validasi Sukses! Object KIP Akan Dibuat!"+Main.ANSI_RESET);
            return true;
        }
        else{
            Object[] obj = {kodeProv,kodeKab,kodeKec,kju};
            System.out.println("Validasi Gagal! Harap Ulang Input Data Object KIP!");
            deleteKIP(obj);
            return false;
        }
     }
     
    public void delete(Object obj){
        obj = null;
    }
    
     public void deleteKIP(Object[] objs){
        for (Object obj:objs){
            delete(obj);
        }
        System.out.println("Input Sebelumnya Sudah Berhasil Dihapus");
    }

    @Override
    public String toString() {
        return "\n===== Kode Identitas Perusahaan (KIP) ====="+
                  kodeProv + 
                  kodeKab + 
                  kodeKec + 
                "\nKode Jenis Usaha Utama = " + kju.getValue()+
                "\nJenis Usaha Utama      = " + kju.getValueKode()+
                "\nNomor Urut             =" + noUrut;
    }
}