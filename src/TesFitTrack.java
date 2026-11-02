
/**
 * Class TesFitTrack menguji seluruh skenario penggunaan pada Sistem Keanggotaan FitTrack.
 *
 * @author Azmi Basri
 * @version 1.0
 * @since 2026
 */
public class TesFitTrack {
    public static void main(String[] args) {
        System.out.println("=== SKENARIO 1 & 2: INISIALISASI ARRAY MEMBER DAN TES VALIDASI AWAL ===");
        
        MEMBER[] daftarMember = new MEMBER[5];

        // 3 Member dengan jenis paket berbeda & 1 Member dari constructor tanpa paket
        daftarMember[0] = new MEMBER("Johnny Silverhand", "081265436287", "18-10-2026", "VIP");
        daftarMember[1] = new MEMBER("Ciri", "081265436277", "19-10-2026", "Basic");
        daftarMember[2] = new MEMBER("Eugeo", "081265436250", "20-10-2026", "Premium");
        daftarMember[3] = new MEMBER("Subianto", "081265436230", "23-10-2026"); // Menggunakan constructor 3 param

        System.out.println("\n--- Pengujian Objek dengan Input Salah saat pembuatan (Skenario 2) ---");
        // Sengaja memasukkan format tanggal salah (memakai '/') dan paket tidak valid
        daftarMember[4] = new MEMBER("Geralt", "081265436999", "23/10/2026", "UltraVIP");

        System.out.println("\n=== SKENARIO 3: PEMANGGILAN SETTER DENGAN NILAI SALAH ===");
        System.out.println("Tanggal daftar awal Member 1 (" + daftarMember[0].getNama() + "): " + daftarMember[0].getTanggalDaftar());
        
        System.out.print("Mencoba mengubah tanggal ke '23/10/2026': ");
        daftarMember[0].setTanggalDaftar("23/10/2026");
        
        System.out.println("Tanggal setelah setter ditolak: " + daftarMember[0].getTanggalDaftar());
        System.out.println("(Terbukti nilai lama tetap bertahan)");

        System.out.println("\n=== SKENARIO 4: MENAMPILKAN SELURUH DATA MEMBER (ARRAY FOR-EACH) ===");
        for (MEMBER m : daftarMember) {
            if (m != null) {
                System.out.println(m);
            }
        }
    }
}