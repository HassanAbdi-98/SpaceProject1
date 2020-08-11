package com.space.controllers;

import com.space.domains.Address;
import com.space.domains.SpaceUser;
import com.space.services.AddressService;
import com.space.services.SpaceUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SpaceUserController {

    @Autowired
    private SpaceUserService spaceUserService;

    @Autowired
    private AddressService addressService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(){
        return "index";
    }
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView showRegistrationForm() {
        return new ModelAndView("register", "spaceUser", new SpaceUser());
    }

    @RequestMapping(value = "/addSpaceUser", method = RequestMethod.POST)
    public String processRegistrationForm(SpaceUser spaceUser,
                                          @RequestParam("street") String street,
                                          @RequestParam("city") String city,
                                          @RequestParam("postcode") String postcode,
                                          @RequestParam("country") String country) {

        Address address = new Address(street,city,postcode,country,spaceUser.getEmail());
        SpaceUser storedUser = spaceUserService.addSpaceUser(spaceUser);
        Address storedAddress = addressService.storeAddressDetails(address);

        if(storedUser!=null && storedAddress!=null) {
            return "space_user_added";
        }
        else{
            return "data_insert_failed";
        }
    }


    @RequestMapping("/allUsers")
    public ModelAndView getAllData(){

        ModelAndView mv = new ModelAndView("space_users");
        mv.addObject("users",spaceUserService.getSpaceUsers());
        mv.addObject("addresses",addressService.getAllAddress());
        return mv;


    }



}
