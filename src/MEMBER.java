import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.List;

public class MEMBER {
    String nama;
    String noTelepon;
    String tanggalDaftar;
    String jenisPaket;


    public MEMBER() {
        setNama("Johny Silver Hand");
        setNoTelepon("+6281265436287");
        setTanggalDaftar("17-08-2026");
        setJenisPaket("VIP");
    }

    
    public MEMBER(String nama, String noTelepon, String tanggalDaftar, String jenisPaket) {
        setNama(nama);
        setNoTelepon(noTelepon);
        setTanggalDaftar(tanggalDaftar);
        setJenisPaket(jenisPaket);
    }

   
    public MEMBER(String nama, String noTelepon, String tanggalDaftar) {
        setNama(nama);
        setNoTelepon(noTelepon);
        setTanggalDaftar(tanggalDaftar);
        setJenisPaket("Basic");
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

    public final void setNama(String nama) {
        if (nama == null || !nama.matches("[a-zA-A\\s]+")) {
            System.out.println("Peringatan: Tipe input salah! Nama hanya boleh berisi huruf dan spasi.");
        } else {
            this.nama = nama;
        }
    }

    public final void setNoTelepon(String noTelepon) {
        if (noTelepon == null || !noTelepon.matches("\\d{10,13}")) {
            throw new IllegalArgumentException("Input tidak valid! Nomor telepon harus berupa 10-13 digit angka.");
        }
        this.noTelepon = noTelepon;
    }

    public final void setTanggalDaftar(String tanggalDaftar) {
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

    public final void setJenisPaket(String jenisPaket) {
        if (jenisPaket == null) {
            throw new IllegalArgumentException("Jenis paket tidak boleh null.");
        }

        
        List<String> paketValid = List.of("Reguler", "Express", "Kilat");

       
        boolean isValid = paketValid.stream()
                .anyMatch(p -> p.equalsIgnoreCase(jenisPaket.trim()));

        if (!isValid) {
            throw new IllegalArgumentException("Jenis paket tidak valid! Pilihan yang tersedia: Reguler, Express, Kilat.");
        }

        this.jenisPaket = jenisPaket.trim();
    }
}
