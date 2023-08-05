package Kutphane;

import java.util.Scanner;

public class  c {
    public static void main (String[] args) {

            private static void findMembersByLastNameStartsWith(Scanner scanner) {
            Scanner scanner=new Scanner(System.in);
            System.out.print("Üye soyadının ilk üç harfi: ");
            String uyeBul = scanner.nextLine();

            boolean found = false;

            for (Member member : members) {
                if (member.getLastName().toLowerCase().startsWith(searchQuery.toLowerCase())) {
                    System.out.println("Üye bulundu: " + member);
                    found = true;
                }
            }

            if (!found) {
                System.out.println("Üye bulunamadı.");
            }
        }
    }
}
package Kutphane;

class cc {
    private String lastName;
    public String getLastName(){
        return lastName;
    }

}
