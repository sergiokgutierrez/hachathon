package edu.gmu.cs477.test;

/**
 * Created by sergiogutierrez on 12/2/17.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Richard on 12/2/2017.
 */

public class Crypto {

    URL url;
    ArrayList<String> cryptos;
    StringBuilder sb;
    boolean runDone = false;

    public Crypto() {
        cryptos = new ArrayList<>();
        sb = new StringBuilder();
        run();
    }

    public boolean run() {
        try {
            // get URL content
            String a = "https://api.coinmarketcap.com/v1/ticker/?limit=5";
            url = new URL(a);
            URLConnection conn = url.openConnection();

            // open the stream and put it into BufferedReader
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inputLine;
            int counter=1, cryptoCounter=0;
            while (true){

                br.readLine();
                br.readLine();
                while(counter != 16){
                    inputLine = br.readLine();
                    sb.append(inputLine);
                    sb.append("\n");
                    counter++;
                }
                cryptos.add(sb.toString()); // add crypto to the cryptos list
                sb = new StringBuilder();
                counter=1;
                cryptoCounter++;
                if(cryptoCounter == 5)
                    break;
            }
            br.close();
            runDone = true;
            return true;

        } catch (MalformedURLException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public ArrayList<String> getCrypto(int id){
        if(!runDone) throw new IllegalStateException();
        ArrayList<String> list = new ArrayList<String>();
        String s = cryptos.get(id);

        String temp, word;

        int name = s.indexOf("name");
        int symbol = s.indexOf("symbol");
        int usd = s.indexOf("price_usd");
        int pricebtc = s.indexOf("price_btc");

        temp = s.substring(name+8);
        Scanner reader= new Scanner(temp);
        word = reader.next();
        word = word.substring(0, word.length()-2);
        list.add(word);

        temp = s.substring(symbol+10);
        reader= new Scanner(temp);
        word = reader.next();
        word = word.substring(0, word.length()-2);
        list.add(word);

        temp = s.substring(usd+13);
        reader= new Scanner(temp);
        word = reader.next();
        word = word.substring(0, word.length()-2);
        list.add(word);

        temp = s.substring(pricebtc+13);
        reader= new Scanner(temp);
        word = reader.next();
        word = word.substring(0, word.length()-2);
        list.add(word);

        return list;
    }

}