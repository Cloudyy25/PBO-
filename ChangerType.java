/**
 * Kelompok 6:
    1. Alif Median Ramadhan (222212480)
    2. Alifia Rahma Nur Anthony Putri (222212484)
    3. Cloudya Qashwah Montolalu (222212550)
    4. Rizky Alif lchwanto (222212857)
 */
public abstract class ChangerType <T> implements Variabel <T> {
    private String nama;
    private String id;
    private T value;
    
    public ChangerType(){}
    
    public ChangerType(String nama, String id, T value){
        this.nama = nama;
        this.id = id;
        this.value = value;
    }
    
    public String getNama(){
        return nama;
    }
    
    public void setNama(String nama){
        this.nama = nama;
    }
    
    public String getId(){
        return id;
    }
    
    public void setId(String id){
        this.id = id;
    }
    
    public T getValue(){
        return value;
    }
    
    public void setValue(T value){
        this.value = value;
    }
    
    public boolean emptyError(T value) throws InputError {
    if (getValue().equals("")) {
        throw new InputError(String.format("Variabel %s Kosong", getNama()));
    }
    return false;
    }
    
    public boolean checkValue() throws InputError {
        if (emptyError(getValue())){
            return false;
        }
        return true;
    }
    
    public void delete(Object obj){
    obj = null;
    }
    
    public abstract void setTemp(T value);
    public abstract boolean typeError(T value);
    public abstract String toString();
}

