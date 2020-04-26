package com.anz.fxcal;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.anz.fxcal.bean.Response;
import com.anz.fxcal.config.FxContext;
import com.anz.fxcal.service.AppService;

@SpringBootApplication
public class FxCalculatorApplication {

	private static final Logger LOG = LoggerFactory.getLogger(FxCalculatorApplication.class);

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(FxCalculatorApplication.class, args);
		LOG.info("############################################################################");
		LOG.info("Welcome to – FX Calculator! : a console-based currency converter application");
		LOG.info("############################################################################");
		while (true) {
			LOG.info("Please enter the amount you want to convert and the currencies");
			System.out.println("#######################################");
			Response response = null;
			try {
				BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
				String input = reader.readLine();
				AppService appService = context.getBean(AppService.class);

				response = appService.execute(input);
			} catch (Exception e) {
				response = new Response();
				response.setSuccess(false);
			}
			System.out.println(response.getFinalResponse());
			System.out.println("#######################################");
			FxContext.getInstance().clearContext();
		}

	}

}
