import java.util.*;
public class AffineCipher {
    static int a=3;
    static int b=12;
    static String alp="abcdefghijklmnopqrstuvwxyz";
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the string that is used to send to the receiver:");
        String str=sc.nextLine();
        String cipher=encrypted(str);
        System.out.println("The Encrypted text is:"+cipher);
        System.out.println("The Decrypted text is:"+decrypted(cipher));
        System.out.println((int)('H'-'A'));

    }
    private static String decrypted(String cipher) {
        //first convert the cipher text into lower case
        cipher=cipher.toLowerCase();
        //now we need find the reverse function that is (a^-1)(x-b)%mod m
        String decryptedtext="";
        /*The a inverse is obtained by using the condition that 
        1)Take the numbers from 0 to 26 numbers
        2)now multiply the each number with a and then apply the mod(26) function and find for which value the mod is 1
        3)repeat it until you reach the value 1
        */
        int inverse_a=findinginverse();
        System.out.println("The value of the inverse is:"+inverse_a);
        //now do the inverse function 
        for(int i=0;i<cipher.length();i++){
            if(cipher.charAt(i)==' '){
                decryptedtext+=' ';
                continue;
            }
            else{
                //we need to find the value of the x
                int x=alp.indexOf(cipher.charAt(i));
                System.out.println("The value of the Encrypted values are:"+x);
                //now calculate the inverse function
                int cal=((inverse_a*(val(x)))%26);
                System.out.println("The value of the calculated is:"+cal);
                decryptedtext+=alp.charAt(cal);
            }
        }
        return decryptedtext.toUpperCase();
    }
    private static int val(int x) {
        if(x>b){
            return x-b;
        }
        else{
            return 26-(b-x);
        }
    }
    private static int findinginverse() {
        int flag=0;
        int a_1=0;
        for(int i=0;i<26;i++){
            flag=(a*i)%26;
            if(flag==1){
                a_1=i;
                break;
            }
        }
        return a_1;
    }
    private static String encrypted(String str) {
        //we will use the function (ax+b)%26 where m is the size of teh alphabets in the english language
        //first convert the given sentece into lower case
        str=str.toLowerCase();
        String encryptedtext="";
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)==' '){
                encryptedtext+=' ';
                continue;
            }
            else{
               int x=alp.indexOf(str.charAt(i));//str.charAt(i)-'A';
               System.out.println("The value of x is:"+x);
               int cal=((a*x)+b)%26;
               System.out.println("The val of expression is:"+cal);
               encryptedtext+=alp.charAt(cal);//'A'-str.charAt(cal)
            }
        }
        return encryptedtext.toUpperCase() ;
    }
}
