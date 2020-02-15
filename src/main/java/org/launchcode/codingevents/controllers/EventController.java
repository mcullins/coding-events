package org.launchcode.codingevents.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Chris Bay
 */
@Controller
@RequestMapping("events")
public class EventController {

    private static List<String> events = new ArrayList<>();

//    @GetMapping
//    public String displayAllEvents(Model model) {
//        model.addAttribute("title", "All Events");
//        model.addAttribute("events", events);
//        return "events/index";
//    }

    @GetMapping
    public String displayEventsList(Model model){
        Map<String, String> events = new HashMap<>();
        events.put("LC101", "LaunchCode entry class");
        events.put("Planet Comicon KC", "Kansas City comic convention");
        events.put("LC Meetup", "Meet other students to work on projects together");
        model.addAttribute("events", events);

        List<String> images = new ArrayList<>();
        images.add("/comicon.jpg");
        images.add("/lc.jpg");
        images.add("/plaza.jpg");
        model.addAttribute("images", images);

        return "events/index";
    }
//
//    @GetMapping
//    public String getImages(Model model){
//        List<String> images = new ArrayList<>();
//        images.add("comicon.jpg");
//        images.add("lc.jpg");
//        images.add("plaza.jpg");
//        model.addAttribute("images", images);
//        return "events/index";
//    }

    @GetMapping("create")
    public String renderCreateEventForm(){
        return "events/create";
    }


//    @GetMapping("create")
//    public String displayCreateEventForm(Model model) {
//        model.addAttribute("title", "Create Event");
//        return "events/create";
//    }

    @PostMapping("create")
    public String createEvent(@RequestParam String eventName){
        events.add(eventName);
        return "redirect:";
    }

//    @PostMapping("create")
//    public String processCreateEventForm(@RequestParam String eventName) {
//        events.add(eventName);
//        return "redirect:";
//    }

}
