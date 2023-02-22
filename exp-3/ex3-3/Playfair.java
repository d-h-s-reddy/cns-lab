import java.util.*;
public class Playfair {
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the plaintext:");
        String plaintext=sc.nextLine();
        System.out.println("Enter the key:");
        String key=sc.next();
        //now we should remove the duplicates of the key
        key=removeduplicates(key);

    }

    private static String removeduplicates(String key) {
        char c[]=key.toCharArray();
        String newkey="";
        for(int i=0;i<key.length()-1;i++){
            for(int j=i+1;j<key.length();j++){
                if(key.charAt(i)==key.charAt(j)){
                    c[j]='1';
                }
            }
        }
        for(int i=0;i<c.length;i++){
            if(c[i]=='1'){
                continue;
            }
            else{
                newkey+=c[i];
            }
        }
        System.out.println("The new key is"+newkey);
        return newkey;
    }
}
