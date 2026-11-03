/**
 * Merepresentasikan satu member yang terdaftar di sistem keanggotaan FitTrack.
 * Class ini menyimpan data pribadi member dan memastikan setiap
 * perubahan data lolos validasi sebelum disimpan.
 *
 * @author Azmi Basri
 * @version 1.0
 * @since 2026
 */
public class MEMBER{

    /** Panjang minimal nomor telepon yang valid. */
    public static final int MIN_PANJANG_TELEPON = 10;

    /** Awalan wajib untuk nomor telepon yang valid. */
    public static final String AWALAN_TELEPON_VALID = "0";

    /** Pilihan paket keanggotaan Basic. */
    public static final String PAKET_BASIC = "Basic";

    /** Pilihan paket keanggotaan Premium. */
    public static final String PAKET_PREMIUM = "Premium";

    /** Pilihan paket keanggotaan VIP. */
    public static final String PAKET_VIP = "VIP";

    /** Nilai default nama ketika input awal pada constructor tidak valid. */
    public static final String DEFAULT_NAMA = "MEMBER Tanpa Nama";

    /** Nilai default nomor telepon ketika input awal pada constructor tidak valid. */
    public static final String DEFAULT_NO_TELEPON = "0000000000";

    /** Nilai default tanggal daftar ketika input awal pada constructor tidak valid. */
    public static final String DEFAULT_TANGGAL_DAFTAR = "01-01-2026";

    /** Panjang string format tanggal dd-MM-yyyy. */
    private static final int PANJANG_FORMAT_TANGGAL = 10;

    private String nama = DEFAULT_NAMA;
    private String noTelepon = DEFAULT_NO_TELEPON;
    private String tanggalDaftar = DEFAULT_TANGGAL_DAFTAR;
    private String jenisPaket = PAKET_BASIC;

    /**
     * Membuat objek MEMBER baru dengan seluruh informasi lengkap.
     * Seluruh parameter akan divalidasi melalui method setter masing-masing.
     * Jika ada nilai yang tidak valid, atribut akan menggunakan nilai default yang aman.
     *
     * @param nama          nama lengkap member, tidak boleh kosong atau hanya berisi spasi
     * @param noTelepon     nomor telepon aktif, wajib diawali angka 0 dan minimal 10 digit
     * @param tanggalDaftar tanggal pertama kali mendaftar dengan format dd-MM-yyyy
     * @param jenisPaket    jenis paket keanggotaan (Basic, Premium, atau VIP)
     */
    public MEMBER(String nama, String noTelepon, String tanggalDaftar, String jenisPaket) {
        setNama(nama);
        setNoTelepon(noTelepon);
        setTanggalDaftar(tanggalDaftar);
        setJenisPaket(jenisPaket);
    }

    /**
     * Membuat objek MEMBER baru tanpa menentukan jenis paket secara eksplisit.
     * Jenis paket secara otomatis diatur menjadi Basic melalui pemanggilan constructor lengkap.
     *
     * @param nama          nama lengkap member, tidak boleh kosong atau hanya berisi spasi
     * @param noTelepon     nomor telepon aktif, wajib diawali angka 0 dan minimal 10 digit
     * @param tanggalDaftar tanggal pertama kali mendaftar dengan format dd-MM-yyyy
     */
    public MEMBER(String nama, String noTelepon, String tanggalDaftar) {
        this(nama, noTelepon, tanggalDaftar, PAKET_BASIC);
    }

    /**
     * Mengambil nama lengkap member.
     *
     * @return nama lengkap member saat ini
     */
    public String getNama() {
        return nama;
    }

    /**
     * Mengubah nama lengkap member setelah melalui validasi.
     * Jika nama bernilai null, kosong, atau hanya berisi spasi, maka perubahan ditolak,
     * nilai lama dipertahankan, dan pesan alasan penolakan dicetak ke layar.
     *
     * @param nama nama lengkap baru untuk member
     */
    public void setNama(String nama) {
        if (nama == null || nama.trim().isEmpty()) {
            System.out.println("Penolakan Validasi: Nama member tidak boleh kosong atau hanya berisi spasi.");
            return;
        }
        this.nama = nama.trim();
    }

    /**
     * Mengambil nomor telepon aktif member.
     *
     * @return nomor telepon member saat ini
     */
    public String getNoTelepon() {
        return noTelepon;
    }

    /**
     * Mengubah nomor telepon member setelah melalui validasi format.
     * Jika format tidak valid, nomor lama dipertahankan dan pesan penolakan dicetak.
     *
     * @param noTelepon nomor telepon baru, wajib diawali angka 0, hanya berisi angka,
     *                  dan memiliki panjang minimal 10 digit
     */
    public void setNoTelepon(String noTelepon) {
        if (!apakahNoTeleponValid(noTelepon)) {
            System.out.println("Penolakan Validasi: Nomor telepon harus berupa angka, diawali angka "
                    + AWALAN_TELEPON_VALID + ", dan minimal " + MIN_PANJANG_TELEPON + " digit.");
            return;
        }
        this.noTelepon = noTelepon;
    }

    /**
     * Mengambil tanggal pendaftaran member.
     *
     * @return tanggal daftar member saat ini
     */
    public String getTanggalDaftar() {
        return tanggalDaftar;
    }

    /**
     * Mengubah tanggal pendaftaran member setelah melalui validasi format.
     * Jika format tanggal tidak sesuai pola dd-MM-yyyy, tanggal lama dipertahankan
     * dan pesan penolakan dicetak.
     *
     * @param tanggalDaftar tanggal pendaftaran baru dengan format konsisten dd-MM-yyyy
     */
    public void setTanggalDaftar(String tanggalDaftar) {
        if (!apakahTanggalValid(tanggalDaftar)) {
            System.out.println("Penolakan Validasi: Tanggal daftar tidak boleh kosong dan wajib menggunakan format dd-MM-yyyy (contoh: 17-08-2026).");
            return;
        }
        this.tanggalDaftar = tanggalDaftar;
    }

    /**
     * Mengambil jenis paket keanggotaan member.
     *
     * @return jenis paket keanggotaan saat ini (Basic, Premium, atau VIP)
     */
    public String getJenisPaket() {
        return jenisPaket;
    }

    /**
     * Mengubah jenis paket keanggotaan member setelah memeriksa kesesuaian pilihan.
     * Pilihan hanya menerima Basic, Premium, atau VIP dengan penulisan persis.
     * Jika tidak sesuai, jenis paket lama dipertahankan dan pesan penolakan dicetak.
     *
     * @param jenisPaket jenis paket keanggotaan baru (Basic, Premium, atau VIP)
     */
    public void setJenisPaket(String jenisPaket) {
        if (!apakahPaketValid(jenisPaket)) {
            System.out.println("Penolakan Validasi: Jenis paket '" + jenisPaket
                    + "' tidak dikenali. Pilihan hanya: " + PAKET_BASIC + ", "
                    + PAKET_PREMIUM + ", atau " + PAKET_VIP + ".");
            return;
        }
        this.jenisPaket = jenisPaket;
    }

    /**
     * Memeriksa apakah string nomor telepon memenuhi syarat awalan, panjang minimal, dan digit.
     *
     * @param noTelepon string nomor telepon yang akan diperiksa
     * @return true jika valid, false jika melanggar aturan
     */
    private boolean apakahNoTeleponValid(String noTelepon) {
        if (noTelepon == null) {
            return false;
        }
        if (!noTelepon.startsWith(AWALAN_TELEPON_VALID) || noTelepon.length() < MIN_PANJANG_TELEPON) {
            return false;
        }
        for (int i = 0; i < noTelepon.length(); i++) {
            char karakter = noTelepon.charAt(i);
            if (karakter < '0' || karakter > '9') {
                return false;
            }
        }
        return true;
    }

    /**
     * Memeriksa apakah string tanggal mengikuti format dd-MM-yyyy secara konsisten.
     *
     * @param tanggal string tanggal yang akan diperiksa
     * @return true jika format sesuai dd-MM-yyyy, false jika tidak sesuai
     */
    private boolean apakahTanggalValid(String tanggal) {
        if (tanggal == null || tanggal.length() != PANJANG_FORMAT_TANGGAL) {
            return false;
        }
        return tanggal.matches("\\d{2}-\\d{2}-\\d{4}");
    }

    /**
     * Memeriksa apakah jenis paket sesuai dengan salah satu dari tiga konstanta resmi.
     *
     * @param paket string jenis paket yang akan diperiksa
     * @return true jika bernilai Basic, Premium, atau VIP secara persis
     */
    private boolean apakahPaketValid(String paket) {
        if (paket == null) {
            return false;
        }
        return paket.equals(PAKET_BASIC)
                || paket.equals(PAKET_PREMIUM)
                || paket.equals(PAKET_VIP);
    }

    /**
     * Mengembalikan representasi teks berlabel yang rapi dari data objek MEMBER.
     *
     * @return string terformat berisi nama, nomor telepon, tanggal daftar, dan jenis paket
     */
    @Override
    public String toString() {
        return String.format(
                "MEMBER FitTrack [Nama: %s | No. Telepon: %s | Tanggal Daftar: %s | Jenis Paket: %s]",
                nama, noTelepon, tanggalDaftar, jenisPaket
        );
    }
}