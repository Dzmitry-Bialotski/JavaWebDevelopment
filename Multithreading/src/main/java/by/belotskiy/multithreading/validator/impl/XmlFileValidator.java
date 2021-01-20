package by.belotskiy.multithreading.validator.impl;

import by.belotskiy.multithreading.exception.XmlValidatorException;
import by.belotskiy.multithreading.validator.FileValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

public class XmlFileValidator implements FileValidator {

    private static final Logger LOGGER = LogManager.getLogger(XmlFileValidator.class);
    @Override
    public boolean validate(String filePath,String xsdName) throws XmlValidatorException {
        SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        File schemaLocation = new File(xsdName);
        try {
            Schema schema = factory.newSchema(schemaLocation);
            Validator validator = schema.newValidator();
            Source source = new StreamSource(filePath);
            validator.validate(source);
            return true;
        } catch (SAXException | IOException e) {
            LOGGER.error(filePath + " is not valid because " + e.getMessage());
            throw new XmlValidatorException(e);
        }
    }
}
