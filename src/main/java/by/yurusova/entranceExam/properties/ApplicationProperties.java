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

    /**
     * Method gets REQUIRED_STUDENT_AMOUNT value.
     *
     * @return student amount.
     */
    public String getStudentAmount() {
        return properties.getProperty("REQUIRED_STUDENT_AMOUNT");
    }

    /**
     * Gets max length of login.
     *
     * @return max length.
     */
    public String getMaxLength() {
        return properties.getProperty("MAX_LENGTH");
    }

    /**
     * Gets regular expression for string that contains only letters.
     *
     * @return the regular expression.
     */
    public String getOnlyLettersRegEx() {
        return properties.getProperty("ONLY_LETTERS");
    }

    /**
     * Gets regular expression for string that contains only numbers.
     *
     * @return the regular expression.
     */
    public String getOnlyNumbersRegEx() {
        return properties.getProperty("ONLY_NUMBERS");
    }

    /**
     * Gets regular expression for valid password.
     *
     * @return the regular expression.
     */
    public String getValidPassRegEx() {
        return properties.getProperty("VALID_PASSWORD");
    }

    /**
     * Gets amount of records on page.
     *
     * @return amount of records.
     */
    public String getAmountOfRecordsPerPage() {
        return properties.getProperty("RECORDS_ON_PAGE");
    }
}