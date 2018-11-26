package test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @Autowired
    private JITService jitService;

    @Autowired
    private GCService service;

    @RequestMapping(value = "/jit", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String jit(@RequestParam("fast") boolean isFastCompiling) {
        return jitService.fastOrSlowCompiling(isFastCompiling);
    }

    @RequestMapping(value = "/gc", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String gc() {
        return service.averagePrice();
    }
}
