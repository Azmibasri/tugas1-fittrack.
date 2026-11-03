/**
 * Class TesFitTrack menguji seluruh skenario penggunaan dan validasi data
 * pada Sistem Keanggotaan Gym FitTrack.
 *
 * @author Azmi Basri
 * @version 1.0
 * @since 2026
 */
public class TesFitTrack {

    /** Jumlah total kapasitas sampel member pada pengujian. */
    private static final int JUMLAH_MEMBER_UJI = 5;

    /**
     * Titik masuk utama (entry point) untuk menjalankan seluruh skenario uji FitTrack.
     * Mencakup pembuatan objek valid, pembuatan objek dengan data tidak valid,
     * pengujian penolakan pada setter, serta pencetakan seluruh isi array.
     *
     * @param args argumen baris perintah (tidak digunakan dalam program ini)
     */
    public static void main(String[] args) {
        System.out.println("=== SKENARIO 1: INISIALISASI OBJEK MEMBER VALID ===");
        MEMBER[] daftarMEMBER = new MEMBER[JUMLAH_MEMBER_UJI];

        // Tiga member dengan jenisPaket berbeda (VIP, Basic, Premium)
        daftarMEMBER[0] = new MEMBER("Johnny Silverhand", "081265436287", "18-10-2026", "VIP");
        daftarMEMBER[1] = new MEMBER("Ciri Fiona", "081265436277", "19-10-2026", "Basic");
        daftarMEMBER[2] = new MEMBER("Eugeo Synthesis", "081265436250", "20-10-2026", "Premium");

        // Satu member menggunakan constructor tanpa paket (otomatis menjadi Basic)
        daftarMEMBER[3] = new MEMBER("Subianto", "081265436230", "23-10-2026");
        System.out.println("4 objek MEMBER valid berhasil dibuat.\n");

        System.out.println("=== SKENARIO 2: PEMBUATAN OBJEK DENGAN DATA MELANGGAR VALIDASI ===");
        System.out.println("Mencoba membuat MEMBER 'Geralt' dengan noTelepon '628123' (salah awalan & kurang digit) dan paket 'UltraVIP':");
        daftarMEMBER[4] = new MEMBER("Geralt", "628123", "25-10-2026", "UltraVIP");
        System.out.println("Hasil objek yang terbentuk (menggunakan nilai default aman):");
        System.out.println(daftarMEMBER[4] + "\n");

        System.out.println("=== SKENARIO 3: PEMANGGILAN SETTER DENGAN NILAI TIDAK VALID ===");
        MEMBER memberUji = daftarMEMBER[0];
        System.out.println("Data awal MEMBER ke-1: " + memberUji);

        System.out.println("\n1) Mencoba mengubah nomor telepon menjadi '12345' (tidak diawali 0 & kurang dari 10 digit):");
        memberUji.setNoTelepon("12345");
        System.out.println("Nomor telepon saat ini: " + memberUji.getNoTelepon() + " (Nilai lama tetap bertahan)");

        System.out.println("\n2) Mencoba mengubah nama menjadi hanya spasi '   ':");
        memberUji.setNama("   ");
        System.out.println("Nama saat ini: " + memberUji.getNama() + " (Nilai lama tetap bertahan)");

        System.out.println("\n3) Mencoba mengubah tanggal daftar ke format yang salah '23/10/2026':");
        memberUji.setTanggalDaftar("23/10/2026");
        System.out.println("Tanggal daftar saat ini: " + memberUji.getTanggalDaftar() + " (Nilai lama tetap bertahan)\n");

        System.out.println("=== SKENARIO 4: MENCETAK SELURUH DATA MEMBER DARI ARRAY ===");
        for (int i = 0; i < daftarMEMBER.length; i++) {
            System.out.println((i + 1) + ". " + daftarMEMBER[i].toString());
        }
    }
}