import java.util.ArrayList;

/**
 * Kelompok 6:
    1. Alif Median Ramadhan (222212480)
    2. Alifia Rahma Nur Anthony Putri (222212484)
    3. Cloudya Qashwah Montolalu (222212550)
    4. Rizky Alif lchwanto (222212857)
 */
public class Kuesioner {
    private int id;
    private KodeProv kodeProv;
    private KodeKab kodeKab;
    private int PeriodeData;
    private static int countPerusahaan = 0;
    private ArrayList<Perusahaan> listAllPerusahaan = new ArrayList<>();

    public Kuesioner(int id, KodeProv kodeProv, KodeKab kodeKab, int PeriodeData) {
        this.id = id;
        this.kodeProv = kodeProv;
        this.kodeKab = kodeKab;
        this.PeriodeData = PeriodeData;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setKodeProv(KodeProv kodeProv) {
        this.kodeProv = kodeProv;
    }

    public KodeProv getKodeProv() {
        return kodeProv;
    }

    public void setKodeKab(KodeKab kodeKab) {
        this.kodeKab = kodeKab;
    }

    public KodeKab getKodeKab() {
        return kodeKab;
    }

    public void setPeriodeData(int PeriodeData) {
        this.PeriodeData = PeriodeData;
    }

    public int getPeriodeData() {
        return PeriodeData;
    }

    public void setListAllPerusahaan(ArrayList<Perusahaan> listAllPerusahaan) {
        this.listAllPerusahaan = listAllPerusahaan;
    }

    public String getListAllPerusahaan() {
        String kata = "";
        for (Perusahaan perusahaan : listAllPerusahaan) {
            if (perusahaan.toString().isEmpty()) {
                perusahaan = null;
                kata = null;
            } else {
                kata += perusahaan.toString();
            }
        }
        return kata;
    }

    public static int getCountPerusahaan() {
        return countPerusahaan;
    }

    @Override
    public String toString() {
        return "\n===== Informasi Kuesioner =====" +
                "\nId               = " + id +
                "\nKode Provinsi    = " + kodeProv.getValue() + "(" + kodeProv.getNamaProv() + ")" +
                "\nKode Kabupaten   = " + kodeKab.getValue() + "(" + kodeKab.getNamaKab() + ")" +
                "\nPeriode Data     = " + PeriodeData + "\n";
    }
}