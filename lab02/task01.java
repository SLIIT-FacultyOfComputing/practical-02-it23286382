package lab02;
import java.util.Arrays;
import java.io.*;
import java.util.Scanner;
class task01{
        public static void main(String[] Args){
                        Scanner scanner = new Scanner(System.in);
                        System.out.println("enter the firstname");
                        String firstName = scanner.nextLine();
                        System.out.println("enter middle name");
                        String middleName=scanner.nextLine();
                        System.out.println("enter last name");
                        String lastName = scanner.nextLine();

                        StringBuilder stringbuilder = new StringBuilder();
	                stringbuilder.append(lastName);

			stringbuilder.append(firstName);
                        stringbuilder.append(middleName);
                        
                        String result =  stringbuilder.toString();

                        System.out.println("enter a fullname:");
                        String fullName = scanner.nextLine();

                        if(result==fullName){
                        System.out.println("names are identical");
                        }else{
                        System.out.println("different names");
                        };

			StringBuilder replacedString = new StringBuilder();
			char e = 'e';
			char a = 'a';

			for(char c : result.toCharArray()){
				if(c==e){
					replacedString.append("3");
				}else if(c==a){
					replacedString.append("@");
				}else{
					replacedString.append(c);
				}

			}


			String upperCaseResult = replacedString.toString().toUpperCase();
			System.out.println(upperCaseResult);
			

			String[] parts= result.split(" ");
			System.out.println(Arrays.toString(parts));

			System.out.print("enter a string with leading and trailing spaces :");
			String spacedLine = scanner.nextLine();
			String trimmedString = spacedLine.trim();
			System.out.println(trimmedString);

			String vowels = "aeiouAEIOU";
			int vowelCount = 0;
			for(char c:result.toCharArray()){
				if(vowels.indexOf(c) != -1){
					vowelCount++;	
				}
			}

			System.out.print("number of vowels: "+vowelCount);


                }
	}
