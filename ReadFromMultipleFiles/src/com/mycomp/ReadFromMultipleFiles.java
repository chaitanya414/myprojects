package com.mycomp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;

public class ReadFromMultipleFiles {

	public static void main(String[] args) throws Exception{
		File f=new File("D:\\trail\\sampel");
		File []files=f.listFiles();
		Integer counter=new Integer(0);
		String allFiles="";
		System.out.println(files.length+" no of files ");
		for(File temp : files){
			System.out.println(temp.getName());
			BufferedReader br=new BufferedReader(new FileReader(temp));
			String line="";
			while((line=br.readLine())!=null){
				if(line.substring(0,1).trim().equals("1")){
					counter=counter+1;
					allFiles=";"+allFiles+";"+temp.getName();
					System.out.println(temp.getName());
				}
			}
		}
		System.out.println(counter);
		System.out.println(allFiles);
		String[] filenames=allFiles.split(";");
		System.out.println(filenames.length);
	}
}
