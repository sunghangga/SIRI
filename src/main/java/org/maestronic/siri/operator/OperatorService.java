package org.maestronic.siri.operator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uk.org.siri.siri20.ServiceDelivery;
import uk.org.siri.siri20.Siri;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;

import static org.rutebanken.siri20.util.SiriJson.toJson;

@Service
public class OperatorService {

    private final OperatorRepository operatorRepository;
    private static JAXBContext jaxbContext;

    @Autowired
    public OperatorService(OperatorRepository operatorRepository) {
        this.operatorRepository = operatorRepository;
    }

    /**
     * Normalize object data after querying from database
     * @return
     */
    private Siri normalizeXml() {
        Siri siri = new Siri();

        List<Operator> resultList = operatorRepository.getOperators();
        ZonedDateTime zonedDateTimeNow = ZonedDateTime.now(ZoneId.of("UTC"));

        ServiceDelivery serviceDelivery = new ServiceDelivery();
        serviceDelivery.setResponseTimestamp(zonedDateTimeNow);

        siri.setServiceDelivery(serviceDelivery);

        return siri;
    }

    public String getOperatorXml() {

        try {

            Siri siri = normalizeXml();

            jaxbContext = JAXBContext.newInstance(Siri.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            jaxbMarshaller.marshal(siri, byteArrayOutputStream);

            return byteArrayOutputStream.toString();
        } catch (JAXBException e) {

            e.printStackTrace();
        }
        return null;
    }

    public String getOperatorJson() {

        try {
            Siri siri = normalizeXml();
            return toJson(siri);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
