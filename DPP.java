/**
 * Kelompok 6:
    1. Alif Median Ramadhan (222212480)
    2. Alifia Rahma Nur Anthony Putri (222212484)
    3. Cloudya Qashwah Montolalu (222212550)
    4. Rizky Alif lchwanto (222212857)
 */
public class DPP{
    private Kode kunjungan;
    private Kode aktif;

    public DPP(Kode kunjungan, Kode aktif) {
        this.kunjungan = kunjungan;
        this.aktif = aktif;
    }
    
    public Kode getAktif() {
        return aktif;
    }
    
    public Kode getKunjungan() {
        return kunjungan;
    }
    
    public void setAktif(Kode aktif) {
        this.aktif = aktif;
    }
    
    public void setKunjungan(Kode kunjungan) {
        this.kunjungan = kunjungan;
    }   
}