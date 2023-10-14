package com.davacom.read.and.write.form.excel;

import com.davacom.read.and.write.form.excel.models.Person;
import com.davacom.read.and.write.form.excel.service.PersonService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileNotFoundException;

@SpringBootApplication
public class ReadAndWriteFormExcelApplication {

	public static void main(String[] args) {
//		SpringApplication.run(ReadAndWriteFormExcelApplication.class, args);
		System.out.println("Hello every one");

		PersonService p = new PersonService();

		System.out.println(p.readExcel());

	}

}
