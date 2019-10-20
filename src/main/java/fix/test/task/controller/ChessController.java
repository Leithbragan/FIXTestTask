package fix.test.task.controller;

import fix.test.task.service.BuildService;
import fix.test.task.util.validator.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChessController {

    private BuildService buildService;

    private Validator validator = new Validator();

    @Autowired
    public ChessController(BuildService buildService) {
        this.buildService = buildService;
    }

    @RequestMapping(value = "/horse/rest/count", method = RequestMethod.GET)
    public String getCount(@RequestParam(value = "width") String width, @RequestParam(value = "height") String height,
                        @RequestParam(value = "start") String start, @RequestParam(value = "end") String end) {

        if (validator.validate(width, height, start, end)) {
            return String.valueOf(buildService.initService(width, height, start, end));

        }
        return "Введенные данные некорректны";
    }
}
