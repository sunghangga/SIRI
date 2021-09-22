package org.maestronic.siri.operator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@RestController
@RequestMapping(path = "api/transit/operator")
public class OperatorController {

    private final OperatorService operatorService;

    @Autowired
    public OperatorController(OperatorService operatorService) {
        this.operatorService = operatorService;
    }

    @GetMapping(produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public ResponseEntity<String> getOperators(@RequestParam(required = false) String format) {

        HttpHeaders headers = new HttpHeaders();

        if (format == null || format.equals("") || format.equals("xml")) {
            headers.setAccept(Collections.singletonList(MediaType.APPLICATION_XML));
            headers.setContentType(MediaType.APPLICATION_XML);

            return new ResponseEntity<String>(
                    operatorService.getOperatorXml(),
                    headers,
                    HttpStatus.OK
            );
        }
        else if (format.equals("json")) {
            headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
            headers.setContentType(MediaType.APPLICATION_JSON);

            return new ResponseEntity<String>(
                    operatorService.getOperatorJson(),
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
