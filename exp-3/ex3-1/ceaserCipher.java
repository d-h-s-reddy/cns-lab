import java.util.*;
public class ceaserCipher{
    public static String alp="abcdefghijklmnopqrstuvwxyz";
    public static void main(String[] args)throws Exception{
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the plain text:");
        String plaintext=sc.nextLine();
        System.out.println("Enter the shift of the plaintext");
        int shift=sc.nextInt();
        String encryptedtext=encrypted(plaintext,shift);
        System.out.println("The encrypted text is:"+encryptedtext);
        System.out.println("The Decrypted text is:"+(decrypted(encryptedtext,shift)));
        }
    private static String decrypted(String encryptedtext, int shift) {
        encryptedtext=encryptedtext.toLowerCase();
        String decryptedtext="";
        for(int i=0;i<encryptedtext.length();i++){
            //first find the position of the encrypted letter in the main alphabet
            if(encryptedtext.charAt(i)==' '){
                decryptedtext+=' ';
            }
            else{
            int pos=alp.indexOf(encryptedtext.charAt(i));
            //now find the correct answer by using the shift position
            int c=cal(pos,shift);
            decryptedtext+=alp.charAt(c);
            }
        }
        return decryptedtext.toUpperCase();
    }
    private static String encrypted(String plaintext, int shift) {
        plaintext=plaintext.toLowerCase();
        String decryptedtext="";
        //now make the loop to find the cipher text
        for(int i=0;i<plaintext.length();i++){
            //now find the index of the alphabet from the alp variable
            if(plaintext.charAt(i)==' '){
                decryptedtext+=' ';
                continue;
            }
            else{
            int pos=alp.indexOf(plaintext.charAt(i));
            //now find the value that is used to relpace the plaintext
            //System.out.println("The positiion is:"+pos);
            int c=(pos+shift)%26;
            decryptedtext+=alp.charAt(c);
            }
        }
        return decryptedtext.toUpperCase();
    }
    public static int cal(int pos,int shift){
        if(pos>shift){
            return (pos-shift)%26;
        }else{
           return (shift-pos)%26;
        }
    }
}