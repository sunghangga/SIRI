package org.maestronic.siri.vm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@RestController
@RequestMapping(path = "api/transit/vehicle-monitoring")
public class VehicleMonitorController {

    private final VehicleMonitorService vehicleMonitorService;

    @Autowired
    public VehicleMonitorController(VehicleMonitorService vehicleMonitorService) {
        this.vehicleMonitorService = vehicleMonitorService;
    }

    @GetMapping(produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public ResponseEntity<String> getOperators(@RequestParam(required = false) String format) {

        HttpHeaders headers = new HttpHeaders();

        if (format == null || format.equals("") || format.equals("xml")) {
            headers.setAccept(Collections.singletonList(MediaType.APPLICATION_XML));
            headers.setContentType(MediaType.APPLICATION_XML);

            return new ResponseEntity<String>(
                    vehicleMonitorService.getVehicleMonitorXml(),
                    headers,
                    HttpStatus.OK
            );
        }
        else if (format.equals("json")) {
            headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
            headers.setContentType(MediaType.APPLICATION_JSON);

            return new ResponseEntity<String>(
                    vehicleMonitorService.getVehicleMonitorJson(),
                    headers,
                    HttpStatus.OK
            );
        }
        else {
            headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
            headers.setContentType(MediaType.APPLICATION_JSON);

            return new ResponseEntity<String>(
                    "{\"status\":\"500\",\"message\":\"Something went wrong\"}",
                    headers,
                    HttpStatus.OK
            );
        }
    }
}
