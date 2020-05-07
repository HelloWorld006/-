package com.demo.gdadesign.gda.controller;

import com.demo.gdadesign.gda.service.GdaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GdaController {
    @Autowired
    private GdaService gdaService;

    
}
