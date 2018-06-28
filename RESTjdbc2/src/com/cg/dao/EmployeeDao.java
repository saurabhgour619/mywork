package com.cg.dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Component;

import com.cg.pojo.Employee;

@Component
public class EmployeeDao {
	ClassLoader classLoader = this.getClass().getClassLoader();

	public List<Employee> getAllDetails() {
		JSONParser parser = new JSONParser();
		List<Employee> empList = new ArrayList<>();
		try {
			// Getting resource(File) from class loader
			File jsonFile = new File(classLoader.getResource("sample1.json").getFile());

			JSONObject jsonObject = (JSONObject) parser.parse(new FileReader(jsonFile));
			String id = jsonObject.get("Employee id").toString();
			String name = jsonObject.get("Name").toString();
			JSONArray address = (JSONArray) jsonObject.get("Address");

			Employee employee = new Employee();
			employee.setId(id);
			employee.setName(name);
			employee.setAddress(address);
			empList.add(employee);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return empList;
	}

	public String getText() {
		StringBuffer stringBuffer = new StringBuffer();
		try {
			File textFile = new File(classLoader.getResource("test1.txt").getFile());

			// File file = new File("D://myfile.txt");
			FileReader fileReader = new FileReader(textFile);
			BufferedReader bufferedReader = new BufferedReader(fileReader);

			String line;

			while ((line = bufferedReader.readLine()) != null) {
				stringBuffer.append(line);

			}
			fileReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return stringBuffer.toString();
	}
}