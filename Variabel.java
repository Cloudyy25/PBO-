/**
 * Kelompok 6:
    1. Alif Median Ramadhan (222212480)
    2. Alifia Rahma Nur Anthony Putri (222212484)
    3. Cloudya Qashwah Montolalu (222212550)
    4. Rizky Alif lchwanto (222212857)
 */
interface Variabel <T>{
       public String getNama();
        public void setNama(String nama);
        public String getId();
        public void setId(String id);
        public T getValue();
        public void setValue(T value);
        public boolean emptyError(T value) throws InputError;
}
