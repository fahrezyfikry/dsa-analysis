package exam;

public class Aksi {
    private final String deskripsiAksi;

    public Aksi(String deskripsiAksi) {
        if (deskripsiAksi == null) throw new IllegalArgumentException("deskripsiAksi tidak boleh null");
        this.deskripsiAksi = deskripsiAksi;
    }

    public String getDeskripsiAksi() {
        return deskripsiAksi;
    }

    @Override
    public String toString() {
        return deskripsiAksi;
    }
}
