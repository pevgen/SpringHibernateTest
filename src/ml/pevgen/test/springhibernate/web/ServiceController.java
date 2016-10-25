package ml.pevgen.test.springhibernate.web;

import ml.pevgen.test.springhibernate.domain.CustomLayout;
import ml.pevgen.test.springhibernate.domain.Splmt;
import ml.pevgen.test.springhibernate.domain.TmObjectOp;
import ml.pevgen.test.springhibernate.dto.DynObjectType;
import ml.pevgen.test.springhibernate.dto.DynObjectTypeConverter;
import ml.pevgen.test.springhibernate.service.GidService;
import ml.pevgen.test.springhibernate.service.PnxStationaryService;
import ml.pevgen.test.springhibernate.service.SplmtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by user on 16.09.2016.
 */
@RestController
public class ServiceController {

//    @RequestMapping("/")
//    public String welcome() {//Welcome page, non-rest
//        return "Welcome to RestTemplate Example.";
//    }

    @Autowired
    private SplmtService splmtService;

    @Autowired
    private GidService gidService;

    @Autowired
    private PnxStationaryService pnxStationaryService;

    /**
     * ГИД-операции факта
     *
     * @param idCustomization
     * @param baseDateTime
     * @param jsonMode
     * @return
     */
    @RequestMapping(path = "/gid/getFact", method = RequestMethod.GET)
    public List<DynObjectType> getFact(@RequestParam("in_idCustomization") String idCustomization,
                        @RequestParam("in_baseDateTime") String baseDateTime,
                        @RequestParam("in_mode_json") int jsonMode){

        /*
        * in_idCustomization in number,
                   in_baseDateTime    in date default null,
                   in_factOffsetHours in number default null,
                   in_planOffsetHours in number default null,
                   in_overlapHours    in number default null,
                   in_uri             in varchar2 default null,
                   in_mode_json       in varchar2 default '0'*/
        LocalDateTime to = LocalDateTime.parse(baseDateTime, DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss"));
        LocalDateTime from =  to.minus(1, ChronoUnit.YEARS);

        // Получить результат от сервиса (в терминах БД)
        List<TmObjectOp> fact = gidService.getFact(idCustomization, from, to);

        // Преобразовать результат из Entity в DTO
        List<DynObjectType> result = fact.parallelStream().map(DynObjectTypeConverter::convert).collect(Collectors.toList());
//        System.out.println(result);
        return result;
    }


    /**
     * Список дополнений
     *
     * @return -
     */
    @RequestMapping(path = "/getSupplements", method = RequestMethod.GET)
    public List<Splmt> message() {//REST Endpoint.
        return splmtService.getPlainList();
    }




}
