package lab02;
import java.util.Scanner;
class task01{
        public static void main(String[] Args){
                        Scanner scanner = new scanner(System.in);
                        System.out.println("enter the firstname");
                        String firstName = scanner.nextLine();
                        System.out.println("enter middle name");
                        String middleName=scanner.nextLine();
                        System.out.println("enter last name");
                        String lastName = scanner.nextLine();

                        StringBuilder stringbuilder = new StringBuilder();
                        stringbuilder.append(firstname);
                        stringbuilder.append(middleName);
                        stringbuilder.append(lastName);
                        String result =  stringbuilder.toString();

                        System.out.println("enter a fullname:");
                        String fullName = scanner.nextLine();

                        if(result==fullName){
                        System.out.println("names are identical")
                        }else{
                        System.out.println("different names")
                        };








                }
	}
