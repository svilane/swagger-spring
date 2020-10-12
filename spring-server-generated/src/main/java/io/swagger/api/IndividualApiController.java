package io.swagger.api;

import io.swagger.model.Error;
import io.swagger.model.Individual;
import io.swagger.model.IndividualCreate;
import io.swagger.model.IndividualUpdate;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import io.swagger.service.IndividualService;
import io.swagger.util.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-08T11:42:54.708Z")

@Controller
public class IndividualApiController implements IndividualApi {

    private static final Logger log = LoggerFactory.getLogger(IndividualApiController.class);

    private final ObjectMapper objectMapper;
    private final IndividualService individualService;
    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public IndividualApiController(ObjectMapper objectMapper, HttpServletRequest request, IndividualService individualService) {
        this.objectMapper = objectMapper;
        this.request = request;
        this.individualService = individualService;
    }

    public ResponseEntity<List<Individual>> listIndividual(@ApiParam(value = "Comma-separated properties to be provided in response")
                                                           @Valid @RequestParam(value = "fields", required = false) String fields,
                                                           @ApiParam(value = "Requested index for start of resources to be provided in response")
                                                           @Valid @RequestParam(value = "offset", required = false) Integer offset,
                                                           @ApiParam(value = "Requested number of resources to be provided in response")
                                                           @Valid @RequestParam(value = "limit", required = false) Integer limit) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                List<Individual> individualList = individualService.getAllIndividuals();
                return new ResponseEntity(individualList, HttpStatus.OK);
            } catch (Exception e) {
                log.error("Couldn't get individual entitied from database", e.getMessage());
                return new ResponseEntity<List<Individual>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<Individual>>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Individual> retrieveIndividual(@ApiParam(value = "Identifier of the Individual",required=true) @PathVariable("id") String id,@ApiParam(value = "Comma-separated properties to provide in response") @Valid @RequestParam(value = "fields", required = false) String fields) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                Individual individual = individualService.getIndividualById(id);
                return new ResponseEntity(individual, HttpStatus.OK);
            } catch (Exception e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Individual>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
        return new ResponseEntity<Individual>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Individual> createIndividual(@ApiParam(value = "The Individual to be created" ,required=true )
                                                       @Valid @RequestBody IndividualCreate individualCreate) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            Individual inputIndividual = Mapper.createToIndividual(individualCreate);
            Individual individual = individualService.createIndividual(inputIndividual);
            if (individual != null) {
                return new ResponseEntity<Individual>(individual, HttpStatus.CREATED);
            }else{
                return new ResponseEntity<Individual>(individual, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
        return new ResponseEntity<Individual>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Individual> patchIndividual(@ApiParam(value = "Identifier of the Individual",required=true)
                                                      @PathVariable("id") String id,
                                                      @ApiParam(value = "The Individual to be updated" ,required=true )
                                                      @Valid @RequestBody IndividualUpdate individualUpdate) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                id = id.trim();
                Individual inputIndividual = Mapper.updateToIndividual(individualUpdate, id);
                Individual individual = individualService.updateIndividual(inputIndividual);
                if (individual != null) {
                    return new ResponseEntity<Individual>(individual, HttpStatus.OK);
                }
                return new ResponseEntity<Individual>(HttpStatus.NOT_FOUND);
            } catch (Exception e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Individual>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Individual>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> deleteIndividual(@ApiParam(value = "Identifier of the Individual",required=true)
                                                 @PathVariable("id") String id) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            boolean isDeleted = individualService.deleteIndividual(id);
            if (isDeleted) {
                return new ResponseEntity<Void>(HttpStatus.OK);
            }else{
                return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
            }
        }
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }
}
