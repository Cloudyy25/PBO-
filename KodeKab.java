import java.util.ArrayList;
/**
 * Kelompok 6:
    1. Alif Median Ramadhan (222212480)
    2. Alifia Rahma Nur Anthony Putri (222212484)
    3. Cloudya Qashwah Montolalu (222212550)
    4. Rizky Alif lchwanto (222212857)
 */
public class KodeKab <T> extends Kode <T> {
    private ArrayList<String> daftarNama = new ArrayList<>();
    private String namaKab;
    
    public KodeKab(T value ,String namaKab) throws InputError {
        super("KodeKab","DPP.02",value,2);
        this.namaKab=namaKab;
    }
    
    public void addKecamatan(KodeKec kodeKec){
        this.daftarNama.add(kodeKec.getNama());
    }
    
    public ArrayList getKecamatanList(){
        return daftarNama;
    }
    
    public boolean validate() throws InputError, NumberFormatException {
    if(checkValue(true)){
        try {
            int value = Integer.parseInt((String)this.getValue());
            if(value<100 && value>0){
                if (namaKab.isEmpty()) {
                    throw new InputError("Nama Kabupaten tidak boleh kosong!");
                } else if (!namaKab.matches("(?i)^[a-z]+(?:\\s[a-z]+)*$")) {
                    throw new InputError("Nama Kabupaten tidak valid! Silakan input ulang.");
                }
                System.out.println(Main.ANSI_GREEN+"Validasi Sukses! Object Kabupaten Akan Dibuat!"+Main.ANSI_RESET);
                return true;
            } else {
                throw new InputError(String.format("Nilai Variabel %s Salah", getNama()));
            }
        } catch (NumberFormatException e) {
            throw new InputError(String.format("Nilai Variabel %s Harus Berupa Angka", getNama()));
        }
    } else{
        return false;
    }
}
    
    public String getNamaKab() {
        return namaKab;
    }
    @Override
    
    public String toString(){
        return "\nKode Kabupaten = "+getValue()+
               "\nNama Kabupaten = "+namaKab;
    }  
}