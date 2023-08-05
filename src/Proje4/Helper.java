package Proje4;

import java.util.Scanner;

public class Helper {
    static Scanner scan = new Scanner(System.in);

    private static String loggedInUsername;
    private static UserRole loggedInUserRole;

    public static void anaMenu() throws InterruptedException {

        login(); // Kullanıcı girişi yapılıyor
        //TODO User Role'e göre kullanıcının "showAdminMenu()" ya da "showUserMenu()" ye
        //TODO Yönlendirin...

        String tercih = "";
         {//TODO Kullanıcıdan alacağınız tercihlere göre, gerekli menü metodlarına yönlendirme yapınız

//                    "\n=========== TECHNO STUDY CONFLUENCE =============\n" +
//                            "=================== ANA MENU ====================\n" +
//                            "\n" +
//                            "\t   1- Kutuphane Bilgileri Goruntule\n" +
//                            "\t   2- Uyeler Menu\n" +
//                            "\t   3- Kitaplar Menu\n" +
//                            "\t   Q- CIKIS\n");
//            System.out.print("Lutfen Menuden tercihinizi yapiniz:");

            tercih = scan.nextLine().toLowerCase();

             {
//                    kutuphaneBilgileriniYazdir();
//                    loginAndShowUserMenu(UserRole.ADMIN);
//                    loginAndShowUserMenu(UserRole.ADMIN);
//                    System.out.print("Lutfen gecerli bir tercih giriniz:");
            }

        }

        projeDurdur();
    }

    public static void kutuphaneBilgileriniYazdir() throws InterruptedException
    {//BU METODDA BİR DEĞİŞİKLİK YAPMANIZA GEREK YOK...

        System.out.print("Kutuphane bilgileri yazdiriliyor...");
        for (int i = 0; i < 20; i++) {
            Thread.sleep(100);
            System.out.print(">");
        }

        System.out.println("\n" +
                "\n============= TECHNO STUDY CONFLUENCE =============\n" +
                "\t\t Kutuphane : " + Kutuphane.kutuphaneIsim +
                "\n\t\t Adres : " + Kutuphane.adres +
                "\n\t\t Telefon : " + Kutuphane.telefon);

    }

    private static void loginAndShowUserMenu(UserRole requiredRole) throws InterruptedException {
        System.out.print("Kullanici Adi: ");
        String username = scan.nextLine();
        System.out.print("Sifre: ");
        String password = scan.nextLine();

        //Kullanıcıdan aldığınız username ve password, authenticateUser(String username, String password)
        //metodunda doğrulamaya tabi tutuluyor...
        UserRole role = authenticateUser(username, password);

        //NOT : Doğrulamadan geçerse role ADMIN veya USER olur... Geçmezse "null" olur

        //TODO null ise "Gecersiz kullanici adi veya sifre." mesajı verin
        //TODO ADMIN ise showAdminMenu() metoduyla admin menüyü gösterin
        //TODO USER ise showUserMenu() metoduyla user menüyü gösterin...
        //TODO Aksi durumlarda "Bu sayfaya erisim izniniz yok." mesajını verin...
        //if-else bloklarıyla şartlar gerçeklenebilir...
    }

    private static UserRole authenticateUser(String username, String password) {

        //TODO Girilen Kullanıcı adı ve şifreyi kontrol edin,
        //TODO Geçerli kullanıcıadı ve şifreyse UserRole return edin... > ADMIN ya da USER
        return null;
    }

    private static void showAdminMenu() throws InterruptedException {

        System.out.println(
                "\n=========== TECHNO STUDY CONFLUENCE ==========\n" +
                        "================== ADMIN MENU ================\n" +
                        "\n" +
                        "\t   1- Uyeler Menu\n" +
                        "\t   2- Kitaplar Menu\n" +
                        "\t   A- ANAMENU\n" +
                        "\t   Q- CIKIS");

        //TODO Kullanıcıdan alacağınız tercihlere göre ilgili menüye (metoda) yönlendirme yapınız...
        {
//                UyeManager.uyeMenu();
//                KitapManager.kitapMenu();
//                anaMenu();
//                projeDurdur();
//                System.out.println("Lutfen gecerli bir tercih giriniz");
        }
    }

    private static void showUserMenu() throws InterruptedException {
        String tercih = "";
        //TODO Kullanıcı Çıkış Yapmadığı Sürece User Menüde Kalsın...
        {
            System.out.println(
                          "\n========== TECHNO STUDY CONFLUENCE ===========\n" +
                            "================== USER MENU =================\n" +
                            "\n" +
                            "\t   1- Uyeleri Listele\n" +
                            "\t   2- Soyisimden Uye Bulma\n" +
                            "\t   3- Sehire Gore Uye Bulma\n" +
                            "\t   4- Kitaplari Listele\n" +
                            "\t   5- Yazardan Kitap Bulma\n" +
                            "\t   6- Kitap Turu veya Yayin Tarihi Ile Kitap Bulma\n" +
                            "\t   7- Kitap Odunc Al\n" +
                            "\t   8- Kitap Iade Et\n" +
                            "\t   A- ANAMENU\n" +
                            "\t   Q- CIKIS");

            //TODO Kullanıcıdan alacağınız tercihlere göre ilgili menüye (metoda) yönlendirme yapınız...

            {
//                    UyeManager.uyeListesiYazdir();
//                    UyeManager.soyisimdenUyeBulma();
//                    UyeManager.sehreGoreUyeBulma();
//                    KitapManager.kitapListesiYazdir();
//                    KitapManager.yazardanKitapBulma();
//                    KitapManager.turVeyaYayinTarihiIleKitapBulma();
//                    KitapManager.kitapOduncAl();
//                    KitapManager.kitapIadeEt();
//                    anaMenu();
//                    projeDurdur();
//                    System.out.println("Lutfen gecerli bir tercih giriniz");
            }
        }
    }

    public static void projeDurdur() {
        System.out.println("Kutuphane projesinden ciktiniz");
        System.exit(0);
    }
}

