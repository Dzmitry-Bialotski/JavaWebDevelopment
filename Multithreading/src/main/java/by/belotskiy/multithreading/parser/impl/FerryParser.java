package by.belotskiy.multithreading.parser.impl;

import by.belotskiy.multithreading.entity.Ferry;
import by.belotskiy.multithreading.exception.XmlValidatorException;
import by.belotskiy.multithreading.validator.FileValidator;
import by.belotskiy.multithreading.validator.impl.XmlFileValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FerryParser {
    public enum FerryValue {
        FERRIES("ferries"),
        FERRY("boat"),
        FERRYMAXLENGTH("ferryMaxLength"),
        FERRYAREA("ferryArea");

        private String value;

        FerryValue(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    private static final Logger LOGGER = LogManager.getLogger(CarParser.class);

    private XMLInputFactory factory;

    private Ferry ferry = Ferry.getInstance();

    private FileValidator validator;

    private final static String XSD_PATH = "src/main/resources/Ferry.xsd";

    public FerryParser() {
        factory = XMLInputFactory.newInstance();
    }

    public Ferry getFerry() {
        return ferry;
    }

    ;

    public Ferry parse(String filePath) {
        FileInputStream fileStream = null;
        XMLStreamReader reader = null;
        String name;
        try {
            validator = new XmlFileValidator();
            validator.validate(filePath, XSD_PATH);
            fileStream = new FileInputStream(new File(filePath));
            reader = factory.createXMLStreamReader(fileStream);
            while (reader.hasNext()) {
                int type = reader.next();
                if (type == XMLStreamConstants.START_ELEMENT) {
                    name = reader.getLocalName();
                    if (FerryValue.valueOf(name.toUpperCase()) == FerryValue.FERRY) {
                        ferry = buildFerry(reader);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            LOGGER.error("File " + filePath + " not found. Incorrect filename or filepath");
        } catch (XMLStreamException e) {
            LOGGER.error("Error while parsing file with StAX " + e);
        } catch (XmlValidatorException e) {
            LOGGER.error("Incorrect xml file" + e);
        } finally {
            try {
                if (fileStream != null) {
                    fileStream.close();
                }
            } catch (IOException e) {
                LOGGER.fatal("Couldn't close input stream because of " + e);
            }
        }
        return ferry;
    }

    public Ferry buildFerry(XMLStreamReader reader) throws XMLStreamException {
        String name;
        while (reader.hasNext()) {
            int type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
                    switch (FerryValue.valueOf(name.toUpperCase())) {
                        case FERRYAREA:
                            ferry.setFerryArea(Integer.parseInt(getXMLText(reader)));
                            break;
                        case FERRYMAXLENGTH:
                            ferry.setFerryMaxWeight(Integer.parseInt(getXMLText(reader)));
                            break;
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    if (FerryValue.valueOf(name.toUpperCase()) == FerryValue.FERRY) {
                        return ferry;
                    }
                    break;
            }
        }
        return ferry;
    }

    private String getXMLText(XMLStreamReader reader) throws XMLStreamException {
        String text = null;
        if (reader.hasNext()) {
            reader.next();
            text = reader.getText();
        }
        return text;
    }
}
