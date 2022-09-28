package com.crs;
import java.io.File;
import com.crs.controller.CitizenController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CrimeReportingSystemApplication {

	public static void main(String[] args) {
		new File(CitizenController.uploadDirectory).mkdir();
		SpringApplication.run(CrimeReportingSystemApplication.class, args);
	}

}
