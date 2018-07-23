package br.edu.ifg.thread;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class testeCSV{
	
	public static void main(String[] args) {
		
		
		List<String> list = new ArrayList<String>();
		
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
		list.add("e");
		list.add("f");
		list.add("g");
		list.add("h");
		list.add("i");
		
		
		System.out.println(list.size());
		System.out.println(list.get(2));
		
		
		int i;
		try {
	        FileWriter writer = new FileWriter("E://gerar.csv");
	        for(i=0; i<list.size(); i++ ){
	        	writer.append(list.get(i));
	        };
	        writer.flush();
	        writer.close();
	    }catch(IOException e){
	         e.printStackTrace();
	    } 
		
		
		

	}
	
	
	
	

}
