import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.List;

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
        if (nama == null || !nama.matches("[a-zA-A\\s]+")) {
            System.out.println("Peringatan: Tipe input salah! Nama hanya boleh berisi huruf dan spasi.");
        } else {
            this.nama = nama;
        }
    }

    public void setNoTelepon(String noTelepon) {
        if (noTelepon == null || !noTelepon.matches("\\d{10,13}")) {
            throw new IllegalArgumentException("Input tidak valid! Nomor telepon harus berupa 10-13 digit angka.");
        }
        this.noTelepon = noTelepon;
    }

    public void setTanggalDaftar(String tanggalDaftar) {
        if (tanggalDaftar == null) {
            throw new IllegalArgumentException("Tanggal daftar tidak boleh null.");
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-uuuu")
                .withResolverStyle(ResolverStyle.STRICT);

        try {
            LocalDate.parse(tanggalDaftar, formatter);
            this.tanggalDaftar = tanggalDaftar;
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Format tanggal salah! Gunakan format dd-MM-yyyy (contoh: 17-08-2026).");
        }
    }

    public void setJenisPaket(String jenisPaket) {
        if (jenisPaket == null) {
            throw new IllegalArgumentException("Jenis paket tidak boleh null.");
        }

        // Daftar paket yang valid
        List<String> paketValid = List.of("Reguler", "Express", "Kilat");

        // Perbaikan: tambahkan spasi antara 'boolean' dan 'isValid'
        boolean isValid = paketValid.stream()
                .anyMatch(p -> p.equalsIgnoreCase(jenisPaket.trim()));

        if (!isValid) {
            throw new IllegalArgumentException("Jenis paket tidak valid! Pilihan yang tersedia: Reguler, Express, Kilat.");
        }

        this.jenisPaket = jenisPaket.trim();
    }
}
