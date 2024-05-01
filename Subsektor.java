/**
 * Kelompok 6:
    1. Alif Median Ramadhan (222212480)
    2. Alifia Rahma Nur Anthony Putri (222212484)
    3. Cloudya Qashwah Montolalu (222212550)
    4. Rizky Alif lchwanto (222212857)
 */
public class Subsektor {
    private Kode tanamanPangan;
    private Kode holtikultura;
    private Kode perkebunan;
    private Kode kehutanan;
    private Kode peternakan;
    private Kode perikanan;
    
    public Subsektor(Kode tanamanPangan, Kode holtikultura, Kode perkebunan, Kode kehutanan, Kode peternakan, Kode perikanan) throws InputError {
        if (validate(tanamanPangan, holtikultura, perkebunan, kehutanan, peternakan, perikanan)) {
            this.tanamanPangan = tanamanPangan;
            this.holtikultura = holtikultura;
            this.perkebunan = perkebunan;
            this.kehutanan = kehutanan;
            this.peternakan = peternakan;
            this.perikanan = perikanan;
        }

    }

    public boolean validate(Kode tanamanPangan, Kode holtikultura, Kode perkebunan, Kode kehutanan, Kode peternakan, Kode perikanan ) throws InputError{
        if(tanamanPangan.checkValue(true)&& holtikultura.checkValue(true) && perkebunan.checkValue(true) && kehutanan.checkValue(true) && perikanan.checkValue(true)){
            System.out.println(Main.ANSI_GREEN+"Validasi Sukses! Object Subsektor Akan Dibuat!"+Main.ANSI_RESET);
            return true;
        }
        else{
            Object[] obj = {tanamanPangan,peternakan,perkebunan,perikanan,kehutanan,holtikultura};
            System.out.println(Main.ANSI_RED+"Validasi Gagal! Harap Ulang Periksa Kembali Data Object Subsektor"+Main.ANSI_RESET);
            deleteSubSektor(obj);
            return false;
        }
     }
     
    public void delete(Object obj){
        obj = null;
    }
    
    public void deleteSubSektor(Object[] objs){
        for (Object obj:objs){
            delete(obj);
        }
        System.out.println("Input Sebelumnya Sudah Berhasil Dihapus");
    } 

    @Override
    public String toString() {
        return String.format("%7s | %12s | %10s | %10s | %10s | %10s", tanamanPangan.getValue(),
                                     holtikultura.getValue(),
                                     perkebunan.getValue(),
                                     kehutanan.getValue(),
                                     peternakan.getValue(),
                                     perikanan.getValue());
    }
}
