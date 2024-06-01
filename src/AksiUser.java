public class AksiUser extends Aksi {
    @Override
    public void tampilanAksi() {
        System.out.println("Aksi User:");
        System.out.println("1. Pesan Film");
        System.out.println("2. Lihat Saldo");
        System.out.println("3. Lihat List Film");
        System.out.println("4. Lihat Pesanan");
        System.out.println("5. Logout");
        System.out.println("6. Tutup Aplikasi");
    }

    @Override
    public void keluar() {
        Akun.logout();
        System.out.println("Anda telah logout.");
    }

    @Override
    public void tutupAplikasi() {
        System.out.println("Aplikasi ditutup.");
        System.exit(0);
    }

    @Override
    public void lihatListFilm() {
        // Implementasi melihat list film
        Film.getFilms().forEach((key, value) -> {
            System.out.print("Film: " + key);
            System.out.print(" - Deskripsi: " + value.getDescription());
            System.out.print(" - Harga: " + (int) value.getPrice());
            System.out.println(" - Stok: " + value.getStock());
        });
    }

    public void lihatSaldo() {
        // Implementasi lihat Saldo
        System.out.println("Saldo Anda: " + (int) Akun.getCurrentUser().getSaldo());
    }

    public void pesanFilm() {
        // Implementasi pemesanan film
        System.out.print("Nama Film yang ingin dipesan: ");
        Main.scanner.nextLine();
        String filmName = Main.scanner.nextLine();
        if (!Film.getFilms().containsKey(filmName)) {
            System.out.println("Film yang dicari tidak ditemukan.");
            return;
        }
        System.out.print("Jumlah tiket yang ingin dipesan: ");
        int jumlahTiket = Main.scanner.nextInt();
        int stock = Film.getFilms().get(filmName).getStock();
        if (jumlahTiket > stock) {
            System.out.println("Stok tiket tidak mencukupi.");
            return;
        }
        System.out.println("Harga satuan tiket " + Film.getFilms().get(filmName).getPrice());
        System.out.println("Total harga: " + Film.getFilms().get(filmName).getPrice() * jumlahTiket);
        if (Akun.getCurrentUser().getSaldo() < Film.getFilms().get(filmName).getPrice() * jumlahTiket) {
            System.out.println("Saldo tidak mencukupi, saldo yang dimiliki " + (int) Akun.getCurrentUser().getSaldo());
        } else {
            Film.getFilms().get(filmName).setStock(stock - jumlahTiket);
            Akun.getCurrentUser().setSaldo(Akun.getCurrentUser().getSaldo() - Film.getFilms().get(filmName).getPrice() * jumlahTiket);
            Akun.getCurrentUser().addPesanan(Film.getFilms().get(filmName), jumlahTiket);
            System.out.println("Tiket berhasil dipesan.");
        }
    }

    public void lihatPesanan() {
        // Implementasi melihat pesanan
        Akun.getCurrentUser().getPesanan().forEach((key, value) -> {
            System.out.print("Film: " + key);
            System.out.print(" - Jumlah Tiket: " + value.getKuantitas());
            System.out.println(" - Total Harga: " + (int) value.getFilm().getPrice() * value.getKuantitas());
        });
    }
}
