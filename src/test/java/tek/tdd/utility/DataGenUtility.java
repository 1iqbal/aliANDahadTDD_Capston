package tek.tdd.utility;

import java.util.concurrent.TimeUnit;


import net.datafaker.Faker;

public class DataGenUtility {
	
	public static String data(String input) {
	Faker faker = new Faker();
    

	String outPut = "";
	
	if(input.equals("firstName")) {
		outPut = faker.name().firstName();
	}else if(input.equals("lastName")) {
		outPut = faker.name().lastName();
	}else if(input.equals("name")) {
		outPut = faker.name().name();
	}else if(input.equals("email")) {
		outPut = faker.name().firstName()+"."+faker.name().lastName()+"@tek.us";
	}else if(input.equals("phoneNumber")) {
		outPut = faker.phoneNumber().cellPhone();
	}else if(input.equals("fullName")) {
		outPut = faker.name().fullName();
	}else if(input.equals("employmentStatus")) {
		outPut = faker.job().position();

		
	}else if(input.equals("userName")) {
		outPut = faker.name().username();
		if(input.equals("userName1"))
		outPut = faker.name().username();
		
		
	}else if(input.equals("addressNumber")) {
		outPut = faker.address().streetAddressNumber();
	}else if(input.equals("addressName")) {
		outPut = faker.address().streetName();
	}else if(input.equals("city")) {
		outPut = faker.address().city();
	}else if(input.equals("state")) {
		outPut = faker.address().state();
	}else if(input.equals("zipCode")) {
		outPut = faker.address().zipCode();
	}else if(input.equals("fullAddress")) {
		outPut = faker.address().fullAddress();
	}else if(input.equals("streetAddress")) {
		outPut = faker.address().streetAddress();
		
	}else if(input.equals("country")) {
		outPut = "United States";
		
		
	}else if(input.equals("futureDate")) {
		outPut = faker.date().future(10, TimeUnit.DAYS, "YYYY MM.dd mm:hh:ss");
	}else if(input.equals("pastDate")) {
		outPut = faker.date().past(15, TimeUnit.DAYS, "YYYY MM.dd mm:hh:ss");
	}else if(input.equals("birthday")) {
		outPut = faker.date().birthday(1, 25, "YYYY MM.dd");
		
	}else if(input.equals("cartName")){
		outPut = faker.expression("#{letterify '????? ?????'}");
	}else if(input.equals("cartNumber")){
		outPut = faker.expression("#{numerify '################'}");
	}else if(input.equals("cartCSV")){
		outPut = faker.expression("#{examplify '369'}");
	}else if(input.equals("userName")){
		outPut = faker.expression("#{examplify 'adghjk'}");
	}else if(input.equals("password")){
		outPut = faker.expression("#{examplify  '37afkow@aAS'}");

	}else if(input.equals("option")){
		outPut = faker.expression("#{options.option  '3', 'afkow','@', '$'}");
	}else if(input.equals("apt")) {
		outPut = faker.address().secondaryAddress();
	}
	return outPut;

}}
