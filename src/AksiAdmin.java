public class AksiAdmin extends Aksi {
    @Override
    public void tampilanAksi() {
        System.out.println("Aksi Admin:");
        System.out.println("1. Tambah Film");
        System.out.println("2. Lihat List Film");
        System.out.println("3. Logout");
        System.out.println("4. Tutup Aplikasi");
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
            System.out.print(" - Harga: " + value.getPrice());
            System.out.println(" - Stok: " + value.getStock());
        });
    }

    public void tambahFilm() {
        // Implementasi menambahkan film
        System.out.print("Nama Film: ");
        Main.scanner.nextLine();
        String filmName = Main.scanner.nextLine();
        System.out.print("Deskripsi Film: ");
        String description = Main.scanner.nextLine();
        System.out.print("Harga Tiket: ");
        double price = Main.scanner.nextDouble();
        System.out.print("Stok Tiket: ");
        int stock = Main.scanner.nextInt();
        Film.addFilm(filmName, description, price, stock);

        /*Film.addFilm("Furiosa: A Mad Max Saga", "The origin story of renegade warrior Furiosa before her encounter and teamup with Mad Max.", 100000, 10);
        Film.addFilm("Kingdom of the Planet of the Apes", "Many years after the reign of Caesar, a young ape goes on a journey that will lead him to question everything he's been taught about the past and make choices that will define a future for apes and humans alike.", 150000, 5);
        Film.addFilm("The Fall Guy", "A down-and-out stuntman must find the missing star of his ex-girlfriend's blockbuster film.", 200000, 7);
        Film.addFilm("IF", "A young girl who goes through a difficult experience begins to see everyone's imaginary friends who have been left behind as their real-life friends have grown up.", 250000, 3);
        Film.addFilm("Challengers", "Tashi, a former tennis prodigy turned coach, turned her husband into a champion. But to overcome a losing streak, he needs to face his ex-best friend and Tashi's ex-boyfriend.", 200000, 7);*/
    }
}
