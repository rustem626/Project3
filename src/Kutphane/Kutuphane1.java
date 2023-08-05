package Kutphane;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class   Kutuphane1 {
    public static void main (String[] args) {


        enum Genre {
            ROMANCE,
            SCIENCE_FICTION,
            MYSTERY,
            HISTORY,
            FANTASY,
            HORROR,
            POETRY,
            DRAMA
        }

        class Book {
            private int id;
            private String title;
            private String author;
            private Genre genre;

            public Book (int id, String title, String author, Genre genre) {
                this.id = id;
                this.title = title;
                this.author = author;
                this.genre = genre;
            }

            public int getId () {
                return id;
            }

            public String getTitle () {
                return title;
            }

            public String getAuthor () {
                return author;
            }

            public Genre getGenre () {
                return genre;
            }

            @Override
            public String toString () {
                return id + ": " + title + " by " + author + " (" + genre + ")";
            }
        }

        class Member {
            private int id;
            private String name;
            private String city;

            public Member (int id, String name, String city) {
                this.id = id;
                this.name = name;
                this.city = city;
            }

            public int getId () {
                return id;
            }

            public String getName () {
                return name;
            }

            public String getCity () {
                return city;
            }

            @Override
            public String toString () {
                return id + ": " + name + " (" + city + ")";
            }
        }

        class LibraryApp {
            private static ArrayList<Book> books = new ArrayList<>();
            private static ArrayList<Member> members = new ArrayList<>();
            private static Map<Integer, Book> borrowedBooks = new HashMap<>();

            private static int bookIdCounter = 1;
            private static int memberIdCounter = 1;

            public static void main (String[] args) {
                Scanner scanner = new Scanner(System.in);

                while (true) {
                    System.out.println("1. Kitap Ekle");
                    System.out.println("2. Kitapları Listele");
                    System.out.println("3. Kitap Ara (Yazar Adına Göre)");
                    System.out.println("4. Kitap Ara (Türe Göre)");
                    System.out.println("5. Üye Ekle");
                    System.out.println("6. Üyeleri Listele");
                    System.out.println("7. Üye Ara (Kimlik Numarası İle)");
                    System.out.println("8. Kitap Ödünç Al");
                    System.out.println("9. Kitap Teslim Et");
                    System.out.println("10. Çıkış");
                    System.out.print("Seçiminizi yapın: ");
                    int choice = scanner.nextInt();
                    scanner.nextLine();

                    switch (choice) {
                        case 1:
                            addBook(scanner);
                            break;
                        case 2:
                            listBooks();
                            break;
                        case 3:
                            searchBookByAuthor(scanner);
                            break;
                        case 4:
                            searchBookByGenre(scanner);
                            break;
                        case 5:
                            addMember(scanner);
                            break;
                        case 6:
                            listMembers();
                            break;
                        case 7:
                            searchMemberById(scanner);
                            break;
                        case 8:
                            borrowBook(scanner);
                            break;
                        case 9:
                            returnBook(scanner);
                            break;
                        case 10:
                            System.out.println("Uygulamadan çıkılıyor...");
                            scanner.close();
                            System.exit(0);
                        default:
                            System.out.println("Geçersiz seçim!");
                    }
                }
            }

            private static void addBook (Scanner scanner) {
                System.out.print("Kitap Adı: ");
                String title = scanner.nextLine();
                System.out.print("Yazar Adı: ");
                String author = scanner.nextLine();

                System.out.println("Türler:");
                for (Genre genre : Genre.values()) {
                    System.out.println(genre.ordinal() + ". " + genre);
                }
                System.out.print("Tür Seçin (Numara): ");
                int genreNum = scanner.nextInt();
                scanner.nextLine();
                Genre genre;
                try {
                    genre = Genre.values()[genreNum];
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("Geçersiz tür numarası!");
                    return;
                }

                Book book = new Book(bookIdCounter++, title, author, genre);
                books.add(book);
                System.out.println("Kitap başarıyla eklendi.");
            }

            private static void listBooks () {
                if (books.isEmpty()) {
                    System.out.println("Kütüphane boş.");
                } else {
                    System.out.println("Kütüphane Kitapları:");
                    for (Book book : books) {
                        System.out.println(book);
                    }
                }
            }

            private static void searchBookByAuthor (Scanner scanner) {
                System.out.print("Aranacak Yazar Adı: ");
                String author = scanner.nextLine();
                boolean found = false;

                for (Book book : books) {
                    if (book.getAuthor().equalsIgnoreCase(author)) {
                        System.out.println("Kitap bulundu: " + book);
                        found = true;
                    }
                }

                if (!found) {
                    System.out.println("Kitap bulunamadı.");
                }
            }

            private static void searchBookByGenre (Scanner scanner) {
                System.out.print("Aranacak Tür (Numara): ");
                int genreNum = scanner.nextInt();
                scanner.nextLine();
                Genre genre;
                try {
                    genre = Genre.values()[genreNum];
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("Geçersiz tür numarası!");
                    return;
                }

                boolean found = false;

                for (Book book : books) {
                    if (book.getGenre() == genre) {
                        System.out.println("Kitap bulundu: " + book);
                        found = true;
                    }
                }

                if (!found) {
                    System.out.println("Kitap bulunamadı.");
                }
            }

            private static void addMember (Scanner scanner) {
                System.out.print("Üye Adı: ");
                String name = scanner.nextLine();
                System.out.print("Şehir: ");
                String city = scanner.nextLine();

                Member member = new Member(memberIdCounter++, name, city);
                members.add(member);
                System.out.println("Üye başarıyla eklendi.");
            }

            private static void listMembers () {
                if (members.isEmpty()) {
                    System.out.println("Üye bulunmamaktadır.");
                } else {
                    System.out.println("Üyeler:");
                    for (Member member : members) {
                        System.out.println(member);
                    }
                }
            }

            private static void searchMemberById (Scanner scanner) {
                System.out.print("Aranacak Üye Kimlik Numarası: ");
                int memberId = scanner.nextInt();
                scanner.nextLine();
                boolean found = false;

                for (Member member : members) {
                    if (member.getId() == memberId) {
                        System.out.println("Üye bulundu: " + member);
                        found = true;
                    }
                }

                if (!found) {
                    System.out.println("Üye bulunamadı.");
                }
            }

            private static void borrowBook (Scanner scanner) {
                System.out.print("Kitap ID'si: ");
                int bookId = scanner.nextInt();
                System.out.print("Üye ID'si: ");
                int memberId = scanner.nextInt();
                scanner.nextLine();

                Book book = findBookById(bookId);
                Member member = findMemberById(memberId);

                if (book == null) {
                    System.out.println("Kitap bulunamadı.");
                } else if (member == null) {
                    System.out.println("Üye bulunamadı.");
                } else {
                    borrowedBooks.put(bookId, book);
                    System.out.println(book.getTitle() + " kitabı " + member.getName() + " üyesine ödünç verildi.");
                }
            }

            private static void returnBook (Scanner scanner) {
                System.out.print("Kitap ID'si: ");
                int bookId = scanner.nextInt();
                scanner.nextLine();

                Book book = borrowedBooks.remove(bookId);

                if (book == null) {
                    System.out.println("Ödünç alınmış kitap bulunamadı.");
                } else {
                    System.out.println(book.getTitle() + " kitabı iade edildi.");
                }
            }

            private static Book findBookById (int bookId) {
                for (Book book : books) {
                    if (book.getId() == bookId) {
                        return book;
                    }
                }
                return null;
            }

            private static Member findMemberById (int memberId) {
                for (Member member : members) {
                    if (member.getId() == memberId) {
                        return member;
                    }
                }
                return null;
            }
        }

    }
}