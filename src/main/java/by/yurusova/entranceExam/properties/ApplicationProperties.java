package by.yurusova.entranceExam.properties;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Properties;

/**
 * Class that returns constant values from property file.
 *
 * @author Yuliya Yurusava <y.yurusava@sam-solurions.com>
 * @package by.yurusova.entranceExam.properties
 * @link http ://sam-solutions.com/
 * @copyright 2019 SaM
 */
public class ApplicationProperties {

    private final static Logger LOGGER = LoggerFactory.getLogger(ApplicationProperties.class);

    private final Properties properties;


    /**
     * Method loads properties from file.
     */
    public ApplicationProperties() {
        properties = new Properties();
        try {
            properties.load(getClass().getClassLoader().getResourceAsStream("app.properties"));
        }
        catch (IOException e) {
            LOGGER.error("Can't read properties from app.properties");
        }
    }

    /**
     * Method gets EXAMS_AMOUNT value.
     *
     * @return exams amount.
     */
    public String getExamAmount() {
        return properties.getProperty("EXAMS_AMOUNT");
    }
}