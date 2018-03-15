package jap.com;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MyDataModel {
    private String fname = null;
    private String data = null;
    
    public MyDataModel(){
        this("data.txt");
    }
    
    public MyDataModel(String s){
        this.fname = s;
        this.loadData();
    }
    
    public String getData(){
        return this.data;
    }
    public void setData(String s){
        this.data = s;
    }
    
    public void loadData(){
        FileReader reader = null;
        BufferedReader breader = null;
        try {
            reader = new FileReader(this.fname);
            breader = new BufferedReader(reader);
            String tmp = "";
            String result = "";
            while((tmp = breader.readLine()) != null){
                result += tmp + "\n";
            }
            this.data = result;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                breader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    public void saveData(){
        FileWriter writer = null;
        BufferedWriter bwriter = null;
        try {
            writer = new FileWriter(this.fname);
            bwriter = new BufferedWriter(writer);
            bwriter.write(this.data);
            bwriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bwriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
