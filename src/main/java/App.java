import java.util.Scanner;

public class App {
    public static void main(String[] args) {
    Scanner myScan = new Scanner(System.in);


        String str;
        String encryptRange;
        int keyLength;

        System.out.println("*********************************************");
        System.out.println("Welcome to this great game of CeaserCipher!!");
        System.out.println(" * * * * ABOUT CEASERCIPHER * * * * ");
        System.out.println(" This is an encryption game which basically takes\n a word and shifts its" +
                "letters down the alphabet by \n a certain number of places eg : " +
                        " shifting 'abc' by 3 spaces will print out 'dfg' ");
        System.out.println("Enjoy the game!!");
        System.out.println("*********************************************");
        System.out.println("Enter your message:");
        str = myScan.nextLine();
        str = str.toLowerCase();
        System.out.println("*******************************************");
        System.out.println("Enter value for encryption between 1 to 26");
        encryptRange = myScan.nextLine();
        keyLength = Integer.parseInt(encryptRange);
        System.out.println("********************");


        //This for is an INFINITE loop, its repeated use of 'Enrypt' and 'Decrypt' options
for(;;) {
    System.out.println("1.Encrypt\n2.Decrypt\n3.Exit...");
    int choice = myScan.nextInt();
    switch (choice) {
        case 1:
            /*send input string keyLength to encrypt() method to encrypt it returns 'Encrypted' string*/
            System.out.println("********************");
            System.out.println("Your encrypted message is " + "'" + encrypt(str, keyLength) + "'");
            System.out.println("********************");
            break;
        case 2:
            //send retrived string from encrypt() method and keyLength to decrypt() method it returns 'Decrypted' string
            System.out.println("********************");
            System.out.println("Your Decrypted message is " + "'" + decrypt(encrypt(str, keyLength), keyLength) + "'");
            System.out.println("********************");
            break;

        case 3:
            //exit from the program
            System.exit(0);
        default:
            System.out.println("********************");
            System.out.println("Invalid option..");
            System.out.println("---------");

    }
        }
    }

    //57 --stores ascii value of character in the string at index 'i'
    //58 --encryption logic for lowercase letters
    //60 --if c value exceeds the ascii value of 'z' reduce it by subtracting 26 to keep in boundaries of ascii values of 'a' and 'z'
    //64 --concatinate the encrypted characters/strings

    public static String encrypt(String str,int keyLength) {
        String encrypted="";
        for(int i=0;i<str.length();i++) {
            int c=str.charAt(i);
            if(Character.isLowerCase(c)) {
                c=c+(keyLength%26);
                if(c>'z')
                    c=c-26;
            }

            encrypted=encrypted+(char) c;
        }
        return encrypted;
    }


    public static String decrypt(String str,int keyLength) {
        String decrypted="";
        for(int i=0;i<str.length();i++) {
            int c=str.charAt(i);
            if(Character.isLowerCase(c)) {
                c=c-(keyLength%26);
                if(c<'a')
                    c=c+26;
            }

            decrypted = decrypted+(char) c;
        }
        return decrypted;
    }
}

