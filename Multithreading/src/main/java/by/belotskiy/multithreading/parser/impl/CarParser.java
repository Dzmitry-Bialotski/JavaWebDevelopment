package by.belotskiy.multithreading.parser.impl;

import by.belotskiy.multithreading.entity.Car;
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
import java.util.ArrayList;
import java.util.List;

public class CarParser {
    public enum CarValue {
        CARS("cars"),
        CAR("car"),
        NAME("name"),
        WEIGHT("weight"),
        AREA("area");

        private String value;

        CarValue(String value) {
            this.value = value;
        }
        public String getValue() {
            return value;
        }
    }
    private static final Logger LOGGER = LogManager.getLogger(CarParser.class);
    private XMLInputFactory factory;
    private List<Car> cars;
    private FileValidator validator;
    private final static String XSD_PATH="src/main/resources/Cars.xsd";

    public CarParser(){
        factory = XMLInputFactory.newInstance();
        cars = new ArrayList<>();
    }

    public List parse(String filePath){
        FileInputStream fileStream = null;
        XMLStreamReader reader = null;
        String name;
        try{
            validator = new XmlFileValidator();
            validator.validate(filePath,XSD_PATH);
            fileStream=new FileInputStream(new File(filePath));
            reader=factory.createXMLStreamReader(fileStream);
            while(reader.hasNext()){
                int type=reader.next();
                if(type== XMLStreamConstants.START_ELEMENT) {
                    name = reader.getLocalName();
                    if (CarValue.valueOf(name.toUpperCase()) == CarValue.CAR){
                        Car car = buildCar(reader);
                        cars.add(car);
                    }
                }
            }
        }catch(FileNotFoundException e){
            LOGGER.error("File "+filePath+" not found. Incorrect filename or filepath");
        }catch(XMLStreamException e){
            LOGGER.error("Error while parsing file with StAX "+e);
        }catch(XmlValidatorException e){
            LOGGER.error("Incorrect xml file"+ e);
        }finally{
            try{
                if(fileStream!=null) {
                    fileStream.close();
                }
            }catch(IOException e){
                LOGGER.fatal("Couldn't close inputstream because of "+e);
            }
        }
        return cars;
    }

    private Car buildCar(XMLStreamReader reader)throws XMLStreamException{
        Car car=new Car();
        car.setName(reader.getAttributeValue(null, CarValue.NAME.getValue()));
        String name;
        while(reader.hasNext()){
            int type=reader.next();
            switch(type){
                case XMLStreamConstants.START_ELEMENT:
                    name=reader.getLocalName();
                    switch (CarValue.valueOf(name.toUpperCase())){
                        case WEIGHT:
                            car.setWeight(Integer.parseInt(getXMLText(reader)));
                            break;
                        case AREA:
                            car.setArea(Integer.parseInt(getXMLText(reader)));
                            break;
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    if(CarValue.valueOf(name.toUpperCase()) == CarValue.CAR){
                        LOGGER.info("Car "+ name + " is on the right bank");
                        return car;
                    }
                    break;
            }
        }
        return car;
    }

    private String getXMLText(XMLStreamReader reader)throws XMLStreamException{
        String text = null;
        if(reader.hasNext()){
            reader.next();
            text=reader.getText();
        }
        return text;
    }
}
