package org.maestronic.siri.vm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uk.org.siri.siri20.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;

import static org.rutebanken.siri20.util.SiriJson.toJson;

@Service
public class VehicleMonitorService {

    private final VehicleMonitorRepository vehicleMonitorRepository;
    private static JAXBContext jaxbContext;

    @Autowired
    public VehicleMonitorService(VehicleMonitorRepository vehicleMonitorRepository) {
        this.vehicleMonitorRepository = vehicleMonitorRepository;
    }

    /**
     * Normalize object data after querying from database
     * @return
     */
    private Siri normalizeXml() {
        Siri siri = new Siri();

        List<Object[]> resultList = vehicleMonitorRepository.getVehicleMonitor();
        ZonedDateTime responseTimestamp = ZonedDateTime.now(ZoneId.of("UTC"));

        // OnwardCall section
        StopPointRef onwardStopPointRef = new StopPointRef();
        onwardStopPointRef.setValue("51660");

        NaturalLanguageStringStructure onwardCallStopPointNames = new NaturalLanguageStringStructure();
        onwardCallStopPointNames.setValue("San Pablo Av & Schmidt Ln A");

        ZonedDateTime onwardCallAimedArrivalTime = ZonedDateTime.now(ZoneId.of("UTC"));
        ZonedDateTime onwardCallExpectedArrivalTime = ZonedDateTime.now(ZoneId.of("UTC"));
        ZonedDateTime onwardCallAimedDepartureTime = ZonedDateTime.now(ZoneId.of("UTC"));
        ZonedDateTime onwardCallExpectedDepartureTime = ZonedDateTime.now(ZoneId.of("UTC"));

        OnwardCallStructure onwardCall = new OnwardCallStructure();
        onwardCall.setStopPointRef(onwardStopPointRef);
        onwardCall.getStopPointNames().add(onwardCallStopPointNames);
        onwardCall.setAimedArrivalTime(onwardCallAimedArrivalTime);
        onwardCall.setExpectedArrivalTime(onwardCallExpectedArrivalTime);
        onwardCall.setAimedDepartureTime(onwardCallAimedDepartureTime);
        onwardCall.setExpectedDepartureTime(onwardCallExpectedDepartureTime);

        // OnwardCall section
        OnwardCallsStructure onwardCalls = new OnwardCallsStructure();
        onwardCalls.getOnwardCalls().add(onwardCall);

        // MonitoredCall section
        StopPointRef monitoredCallStopPointRef = new StopPointRef();
        monitoredCallStopPointRef.setValue("58855");

        NaturalLanguageStringStructure monitoredCallStopPointNames = new NaturalLanguageStringStructure();
        monitoredCallStopPointNames.setValue("San Pablo Av & Moeser Ln");

        LocationStructure vehicleLocationAtStop = new LocationStructure();
        vehicleLocationAtStop.setLongitude(null);
        vehicleLocationAtStop.setLatitude(null);

        ZonedDateTime monitoredCallAimedArrivalTime = ZonedDateTime.now(ZoneId.of("UTC"));
        ZonedDateTime monitoredCallExpectedArrivalTime = ZonedDateTime.now(ZoneId.of("UTC"));
        ZonedDateTime monitoredCallAimedDepartureTime = ZonedDateTime.now(ZoneId.of("UTC"));
        ZonedDateTime monitoredCallExpectedDepartureTime = ZonedDateTime.now(ZoneId.of("UTC"));

        MonitoredCallStructure monitoredCall = new MonitoredCallStructure();
        monitoredCall.setStopPointRef(monitoredCallStopPointRef);
        monitoredCall.getStopPointNames().add(monitoredCallStopPointNames);
        monitoredCall.setVehicleLocationAtStop(vehicleLocationAtStop);
        monitoredCall.setVehicleAtStop(true);
        monitoredCall.setAimedArrivalTime(monitoredCallAimedArrivalTime);
        monitoredCall.setExpectedArrivalTime(monitoredCallExpectedArrivalTime);
        monitoredCall.setAimedDepartureTime(monitoredCallAimedDepartureTime);
        monitoredCall.setExpectedDepartureTime(monitoredCallExpectedDepartureTime);

        // Location section
        LocationStructure vehicleLocation = new LocationStructure();
        vehicleLocation.setLongitude(new BigDecimal(-122.30732));
        vehicleLocation.setLatitude(new BigDecimal(37.9095535));

        // FramedVehicleJourneyRef section
        DataFrameRefStructure dataFrameRef = new DataFrameRefStructure();
        dataFrameRef.setValue("2021-09-22");

        FramedVehicleJourneyRefStructure framedVehicleJourneyRef = new FramedVehicleJourneyRefStructure();
        framedVehicleJourneyRef.setDataFrameRef(dataFrameRef);
        framedVehicleJourneyRef.setDatedVehicleJourneyRef("13437020");

        // MonitoredVehicleJourney section
        LineRef lineRef = new LineRef();
        lineRef.setValue("A001");

        DirectionRefStructure directionRef = new DirectionRefStructure();
        directionRef.setValue("N");

        NaturalLanguageStringStructure publishedLineNames = new NaturalLanguageStringStructure();
        publishedLineNames.setValue("Hilltop - CCC - San Pablo");

        OperatorRefStructure operatorRef = new OperatorRefStructure();
        operatorRef.setValue("CXX");

        JourneyPlaceRefStructure originRef = new JourneyPlaceRefStructure();
        originRef.setValue("51632");

        NaturalLanguagePlaceNameStructure originNames = new NaturalLanguagePlaceNameStructure();
        originNames.setValue("2nd St & Washington St");

        DestinationRef destinationRef = new DestinationRef();
        destinationRef.setValue("53733");

        NaturalLanguageStringStructure destinationNames = new NaturalLanguageStringStructure();
        destinationNames.setValue("Contra Costa College");

        VehicleRef vehicleRef = new VehicleRef();
        vehicleRef.setValue("1207");

        VehicleActivityStructure.MonitoredVehicleJourney monitoredVehicleJourney = new VehicleActivityStructure.MonitoredVehicleJourney();
        monitoredVehicleJourney.setLineRef(lineRef);
        monitoredVehicleJourney.setDirectionRef(directionRef);
        monitoredVehicleJourney.setFramedVehicleJourneyRef(framedVehicleJourneyRef);
        monitoredVehicleJourney.getPublishedLineNames().add(publishedLineNames);
        monitoredVehicleJourney.setOperatorRef(operatorRef);
        monitoredVehicleJourney.setOriginRef(originRef);
        monitoredVehicleJourney.getOriginNames().add(originNames);
        monitoredVehicleJourney.setDestinationRef(destinationRef);
        monitoredVehicleJourney.getDestinationNames().add(destinationNames);
        monitoredVehicleJourney.setMonitored(true);
        monitoredVehicleJourney.setInCongestion(false);
        monitoredVehicleJourney.setVehicleLocation(vehicleLocation);
        monitoredVehicleJourney.setBearing((float) 331.0000000000);
        monitoredVehicleJourney.setOccupancy(OccupancyEnumeration.fromValue("seatsAvailable"));
        monitoredVehicleJourney.setVehicleRef(vehicleRef);
        monitoredVehicleJourney.setMonitoredCall(monitoredCall);
        monitoredVehicleJourney.setOnwardCalls(onwardCalls);

        // VehicleActivity section
        ZonedDateTime validUntilTime = ZonedDateTime.now(ZoneId.of("UTC"));

        VehicleActivityStructure vehicleActivity = new VehicleActivityStructure();
        vehicleActivity.setRecordedAtTime(responseTimestamp);
        vehicleActivity.setValidUntilTime(validUntilTime);
        vehicleActivity.setMonitoredVehicleJourney(monitoredVehicleJourney);

        // VehicleMonitoringDelivery section
        VehicleMonitoringDeliveryStructure vehicleMonitoringDelivery = new VehicleMonitoringDeliveryStructure();
        vehicleMonitoringDelivery.setResponseTimestamp(responseTimestamp);
        vehicleMonitoringDelivery.getVehicleActivities().add(vehicleActivity);

        // ServiceDelivery section
        ServiceDelivery serviceDelivery = new ServiceDelivery();

        RequestorRef requestorRef = new RequestorRef();
        requestorRef.setValue("CXX");

        serviceDelivery.setResponseTimestamp(responseTimestamp);
        serviceDelivery.setProducerRef(requestorRef);
        serviceDelivery.setStatus(true);
        serviceDelivery.getVehicleMonitoringDeliveries().add(vehicleMonitoringDelivery);

        siri.setServiceDelivery(serviceDelivery);

        return siri;
    }

    public String getVehicleMonitorXml() {

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

    public String getVehicleMonitorJson() {

        try {
            Siri siri = normalizeXml();
            return toJson(siri);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
