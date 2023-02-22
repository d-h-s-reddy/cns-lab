import java.util.*;
import java.math.*;
import java.security.*;
public class sha1 {
    public static void main(String[] args) throws Exception{
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the plain text:");
        String plainText=sc.nextLine();
        //now to need to get the message digest
        MessageDigest md=MessageDigest.getInstance("SHA-1");
        //now we need to create an byte array to add the values into it
        byte[] digest=md.digest(plainText.getBytes());
        System.out.println(Arrays.toString(digest));
        BigInteger no=new BigInteger(1,digest);
        System.out.println(no);
        //now convert into the hexadecimal representation
        String hashtext=no.toString(16);

        while(hashtext.length()<32){
            hashtext="0"+hashtext;
        }
        System.out.println("The hash value is:"+hashtext);
        
    }
}
