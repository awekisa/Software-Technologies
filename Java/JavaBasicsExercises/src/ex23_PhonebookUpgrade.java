import java.util.Collections;
import java.util.Scanner;
import java.util.TreeMap;

public class ex23_PhonebookUpgrade {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeMap<String, String> phoneNumbers = new TreeMap<>();

        while (true) {
            String line = sc.nextLine();
            if (!line.equals("END") && !line.equals("ListAll")) {
                String[] arr = line.split(" ");
                String command = arr[0];
                String name = arr[1];
                String phone = "";
                if (arr.length == 3) {
                    phone = arr[2];
                }
                if (command.equals("A")) {
                    phoneNumbers.put(name, phone);
                } else { // command == "S"
                    if (!phoneNumbers.containsKey(name)) {
                        System.out.printf("Contact %s does not exist.\n", name);
                    }
                    else{
                        System.out.printf("%s -> %s\n", name, phoneNumbers.get(name));
                    }
                }
            }
            else if (line.equals("ListAll")){
                phoneNumbers.forEach((k, v)-> System.out.println(k +" -> " + v));
            }else {
                break;
            }
        }
    }
}

