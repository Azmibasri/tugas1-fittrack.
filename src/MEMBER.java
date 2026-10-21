public class MEMBER {
    String nama = "Johny Silver Hand";
    String noTelepon = "+6281265436287";
    String tanggalDaftar = "17-08-2026";
    String jenisPaket = "VIP";

    public MEMBER(String nama, String noTelepon, String tanggalDaftar, String jenisPaket){
        this.nama = nama;
        this.noTelepon = noTelepon;
        this.tanggalDaftar = tanggalDaftar;
        this.jenisPaket = jenisPaket;

    }

    public MEMBER(String nama, String noTelepon,String tanggalDaftar){
        this.nama = nama;
        this.noTelepon = noTelepon;
        this.tanggalDaftar = tanggalDaftar;
        this.jenisPaket = "Basic";
    }

    public String getNama() {
        return nama;
    }

    public String getNoTelepon() {
        return noTelepon;
    }

    public String getTanggalDaftar() {
        return tanggalDaftar;
    }

    public String getJenisPaket() {
        return jenisPaket;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setNoTelepon(String noTelepon) {
        this.noTelepon = noTelepon;
    }

    public void setTanggalDaftar(String tanggalDaftar) {
        this.tanggalDaftar = tanggalDaftar;
    }

    public void setJenisPaket(String jenisPaket) {
        this.jenisPaket = jenisPaket;
    }
}
