/**
 * Kelompok 6:
    1. Alif Median Ramadhan (222212480)
    2. Alifia Rahma Nur Anthony Putri (222212484)
    3. Cloudya Qashwah Montolalu (222212550)
    4. Rizky Alif lchwanto (222212857)
 */

public class Kalimat <T> extends ChangerType<T>{
    final private String type = "Kalimat";
    final int jumlahHuruf = 40;
    private String temp;
    
    public Kalimat(String nama, String id, T value){
        super(nama,id,value);
    }
    
    public String getType() {
        return type;
    }
    
    public String getTemp(){
        return temp;
    }
    
    @Override
    public void setTemp(T value){
        this.temp = String.valueOf(value);
    }
    
    public boolean emptyError(T value) throws InputError {
        return super.emptyError(value);
    }
    
    @Override
    public boolean typeError(T value){
        if (value instanceof String){
            return false;
        } else {
            System.out.printf("Tipe Variabel %s Salah",super.getNama());
            return true;
        }
    }
    
    public boolean constraintError(T value){
        try {
            setTemp(value);
            if (getTemp().length()>jumlahHuruf){
                throw new InputError(String.format("Nilai Variabel %s Terlalu Panjang",super.getNama()));
            }
        } catch (InputError e){
            System.out.println(e);
        } finally {
            if (getTemp().length()>jumlahHuruf){
                return true;
            }
            return false;
        }
    }    
    
    public boolean validatenomer(String nomer, String fax){
        if (nomer.matches("\\+\\d+")&& nomer.length()<15&&fax.matches("\\(\\d+\\)\\d+")&&fax.length()<15) {
            return true;
        }
        else{
            System.out.println(Main.ANSI_RED+"Nilai nomer telepon atau faksimili tidak Valid"+Main.ANSI_RED);
            return false;
        }
    }
    
    public boolean checkValue() throws InputError{
        if (emptyError(super.getValue()) || typeError(super.getValue()) || constraintError(super.getValue())){
            return false;
        }
        return true;
    }
    
    @Override
    public String toString(){
        return String.format("%s-Nilai dari variabel %s(%s) yaitu: %s",getType(),super.getNama(),super.getId(),super.getValue());
    }
}

