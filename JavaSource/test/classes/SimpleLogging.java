package test.classes;

import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.log4j.Logger;

import br.com.srnimbus.amadorpro.exception.AmadorProException;

@SuppressWarnings(value = { "" })
public class SimpleLogging {

	public static FileOutputStream main(String[] args) throws AmadorProException{

		Logger logger = Logger.getLogger(SimpleLogging.class);

		logger.debug("Sample debug message");
		logger.info("Sample info message");
		logger.warn("Sample warn message");
		logger.error("Sample error message");
		logger.fatal("Sample fatal message");

		try {
			return new FileOutputStream("fileName");
		} catch (FileNotFoundException e) {
			throw new AmadorProException(e);
		}

	}

}
