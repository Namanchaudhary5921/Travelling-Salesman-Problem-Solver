package com.tsp.controller;

import com.tsp.model.Request;
import com.tsp.model.Response;
import com.tsp.service.TSPService;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TSPController {

    @GetMapping("/")
    public String home() {
        return "TSP Backend Running 🚀";
    }

    @GetMapping("/tsp/test")
    public String test() {
        return "TSP API Working ✅";
    }

    @PostMapping("/tsp/solve")
    public Response solve(@RequestBody Request request) {
        return TSPService.solve(request);
    }
}