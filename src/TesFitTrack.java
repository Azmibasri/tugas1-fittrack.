public class TesFitTrack {
    public static void main(String[] args) {
            MEMBER[] daftarMember = new MEMBER[5];
            daftarMember[0] = new MEMBER("Johnny Silverhand","+6281265436287","18-10-2026","VIP");
            daftarMember[1] = new MEMBER("Ciri","+6281265436277","19-10-2026","Basic");
            daftarMember[2] = new MEMBER("Eugeo","+6281265436250","20-10-2026","Premium");
            daftarMember[3] = new MEMBER("Subianto","+6281265436230","23-10-2026");
            /**
             * Contoh validasi salah
             */
            daftarMember[4] = new MEMBER("Subianto","+6281265436230","23/10/2026");
            /**
             * Sekenrio uji 3 : panggil setter dengan nilai salah;
             */
            
            
            //System.out.println(daftarMember[0].getTanggalDaftar());
            //daftarMember[0].setTanggalDaftar("23/10/2026");
            //System.out.println(daftarMember[0].getTanggalDaftar());
            
            
            for (MEMBER m : daftarMember) {
                if (m != null) {
                    System.out.println(m);
                }
            }
    }

}
