/**
 * Kelompok 6:
    1. Alif Median Ramadhan (222212480)
    2. Alifia Rahma Nur Anthony Putri (222212484)
    3. Cloudya Qashwah Montolalu (222212550)
    4. Rizky Alif lchwanto (222212857)
 */
import java.util.ArrayList;
public class KodeKec <T> extends Kode <T> {
    private ArrayList<String> daftarNama = new ArrayList<>();
    
    public KodeKec(T value) {
        super("Kode Kecamatan","DP.03",value,3);
    }
    
    public boolean validate() throws InputError, NumberFormatException {
    if (checkValue(true)) {
        try {
            int value = Integer.parseInt((String)this.getValue());
            if (value<1000 && value>0) {
                System.out.println(Main.ANSI_GREEN + "Validasi Sukses! Object Kecamatan Akan Dibuat!" + Main.ANSI_RESET);
                return true;
            } else {
                Object obj = this;
                delete(obj);
                throw new InputError(String.format("Nilai Variabel %s Salah", getNama()));
            }
        } catch (NumberFormatException e) {
            throw new InputError(String.format("Nilai Variabel %s Harus Berupa Angka", getNama()));
        }
    }
    return true;
}
    @Override
    public String toString(){
        return "\nKode Kecamatan = "+getValue();
    }  
}
