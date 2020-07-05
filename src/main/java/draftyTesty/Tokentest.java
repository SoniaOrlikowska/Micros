package draftyTesty;

import java.util.StringTokenizer;

public class Tokentest {
    public Tokentest() {

        String tresc = "INT E5+1-6/2;INT E ODP 6";
        String delim = ";";
        StringTokenizer stringT = new StringTokenizer(tresc, delim);

        String strin1 = stringT.nextToken();
        String strin2 = stringT.nextToken();

        System.out.println(strin1 + "drugi : " + strin2);

    }

    public static void main(String[] args) {

        Tokentest test = new Tokentest();

    }

}
