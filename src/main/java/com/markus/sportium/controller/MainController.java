package com.markus.sportium.controller;

import com.markus.sportium.beans.Sport;
import com.markus.sportium.controller.forms.InputForm;
import com.markus.sportium.converter.ConverterFactory;
import com.markus.sportium.converter.ISportConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class MainController {
    @Autowired
    private ConverterFactory factory;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView index(ModelMap model) {
        return new ModelAndView("index", "command", new InputForm());
    }

    @RequestMapping(value = "process", method = RequestMethod.POST)
    public ModelAndView processInput(ModelMap model, @ModelAttribute("SpringWeb") InputForm inputForm) {
        ISportConverter converter = factory.getConverter(inputForm.getInputValue());
        if (converter != null) {
            Sport convertInputToSport = converter.convertInputToSport();
            if (convertInputToSport != null) {
                model.addAttribute("result", convertInputToSport.toString());
            } else {
                getErrorMessage(model);
            }
        } else {
            getErrorMessage(model);
        }
        return new ModelAndView("index", "command", inputForm);
    }

    private ModelMap getErrorMessage(ModelMap model) {
        return model.addAttribute("errorMessage", "Was not possible to convert the input data into a valid sport result!");
    }
}