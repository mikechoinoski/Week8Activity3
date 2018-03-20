package gov.weather;

import org.junit.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NdfdXMLBindingStubTest {

    @Test

    public void latLonListZipCode() throws Exception {

        NdfdXMLBindingStub binding = (NdfdXMLBindingStub)
                new NdfdXMLLocator().getndfdXMLPort();

        String result = binding.latLonListZipCode("53590");

        JAXBContext jaxbContext = JAXBContext.newInstance(DwmlType.class);

        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

        DwmlType dwml = (DwmlType) jaxbUnmarshaller.unmarshal(new StringReader(result));

        assertEquals("43.1837,-89.2323", dwml.getLatLonList());

    }
}
