import java.util.HashMap;
/**
 * Kelompok 6:
    1. Alif Median Ramadhan (222212480)
    2. Alifia Rahma Nur Anthony Putri (222212484)
    3. Cloudya Qashwah Montolalu (222212550)
    4. Rizky Alif lchwanto (222212857)
 */
public class Kode <T> extends ChangerType<T>{
    final private String type = "Kode";
    private String temp;
    private HashMap<String,String> daftarKode;
    private int length;
    
    public Kode(String nama, String id, T value, int length){
        super(nama,id,value);
        this.length = length;
    }
    
    public Kode(String nama, String id, T value, HashMap<String,String> daftarKode, int length){
        super(nama,id,value);
        this.daftarKode = daftarKode;
        this.length = length;
    }
    
    public String getType() {
        return type;
    }
    
    public String getTemp(){
        return temp;
    }
    
    public T getValue() {
        return super.getValue(); 
    }
    
    @Override
    public void setTemp(T value){
        this.temp = (String) getValue();
    }
    
    public HashMap<String,String> getKamusKode(){
        return daftarKode;
    }
    
    public int getLength(){
        return length;
    }
    
    public boolean emptyError(T value) throws InputError  {
        return super.emptyError(value); 
    }   
    
    @Override
    public boolean typeError(T value){
        if (value instanceof String){
            return false;
        } else {
            System.out.println(Main.ANSI_RED+String.format("Tipe Variabel %s Salah",super.getNama())+Main.ANSI_RESET);
            return true;
        }
    }
    
    public boolean constraintError(T value,int length) throws InputError{
            setTemp(value);
            if (getTemp().length()>length){
                throw new InputError(String.format("Nilai Variabel %s Terlalu Panjang",super.getNama()));
            }
            if (getTemp().length()<=length){
                return false;
            }
        return true;
        }
    
    public boolean constraintError(T value,HashMap<String,String> daftarKode,int length){
        try {
            setTemp(value);
            if (!daftarKode.containsKey(getTemp())||getTemp().length()>length){
                throw new InputError(String.format("Nilai Variabel %s Terlalu Panjang",super.getNama()));
            }
            
        } catch (InputError e){
            throw e;
        } finally {
            if (daftarKode.containsKey(getTemp()) && getTemp().length()<=length){
                return false;
            } else {
                return true;
            }
        }
    }
    
    public boolean checkValue(boolean identifier) throws InputError{
        if (emptyError(super.getValue())||typeError(super.getValue()) || constraintError(super.getValue(),getLength())){
            return false;
        }
        return true;
    }
    
    public boolean checkValue() throws InputError{
        if (emptyError(super.getValue()) || typeError(super.getValue()) || constraintError(super.getValue(),getKamusKode(),getLength())){
            return false;
        }
        return true;
    }
    
    public String getValueKode(){
        return daftarKode.get(super.getValue());
    }
    
    public String toString(boolean identifier){
        return String.format("%s-Nilai dari variabel %s(%s) yaitu: '%s'",getType(),super.getNama(),super.getId(),super.getValue());
    }
    
    @Override
    public String toString(){
        return String.format("%s-Nilai dari variabel %s (%s) yaitu: [Kode: '%s', Label: '%s']",getType(),super.getNama(),super.getId(),super.getValue(),getValueKode());
    }    
}
