import java.util.ArrayList;
/**
 * Kelompok 6:
    1. Alif Median Ramadhan (222212480)
    2. Alifia Rahma Nur Anthony Putri (222212484)
    3. Cloudya Qashwah Montolalu (222212550)
    4. Rizky Alif lchwanto (222212857)
 */
public class KodeProv <T> extends Kode <T>{
    private ArrayList<String> daftarNama = new ArrayList<>();
    private String namaProv;
    
    public KodeProv(T value, String namaProv) {
        super("KodeProv","DPP.02",value,2);
        this.namaProv =namaProv;
    }
    
    public void addKabupaten(KodeKab kodeKab){
        this.daftarNama.add(kodeKab.getNama());
    }
    
    public ArrayList getKabupatenList(){
        return daftarNama;
    }
    
    public String getNamaProv() {
        return namaProv;
    }
    
    public boolean validate() throws InputError, NumberFormatException {
    if(checkValue(true)){
        try {
            int value = Integer.parseInt((String)this.getValue());
            if(value<39 && value>0){
                if (namaProv.isEmpty()) {
                    throw new InputError("Nama Provinsi tidak boleh kosong!");
                } else if (!namaProv.matches("(?i)^[a-z]+(?:\\s[a-z]+)*$")) {
                    throw new InputError("Nama Provinsi tidak valid! Silakan input ulang.");
                }
                System.out.println(Main.ANSI_GREEN+"Validasi Sukses! Object Provinsi Akan Dibuat!"+Main.ANSI_RESET);
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
    @Override   
    public String toString(){
        return "\nKode Provinsi = "+getValue()+
               "\nNama Provinsi = "+namaProv;
    }
}