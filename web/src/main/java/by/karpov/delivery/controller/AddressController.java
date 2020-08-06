package by.karpov.delivery.controller;

import by.karpov.delivery.entity.Address;
import by.karpov.delivery.entity.PersonalInfo;
import by.karpov.delivery.entity.User;
import by.karpov.delivery.service.AddressService;
import by.karpov.delivery.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/address")
public class AddressController {

    private final UserService userService;
    private final AddressService addressService;

    @Autowired
    public AddressController(UserService userService, AddressService addressService) {
        this.userService = userService;
        this.addressService = addressService;
    }

    @ModelAttribute("currentUser")
    public User getCurrentUser() {
        return userService.getUserFromSecurityContext();
    }

    @ModelAttribute("newAddress")
    public Address newAddress() {
        return new Address();
    }

    @GetMapping("/edit/{id}")
    public String editAddress(@PathVariable Long id, Model model) {
        Address address = addressService.getById(id);
        model.addAttribute("currentAddress", address);
        return "addressEdit";
    }

    @GetMapping("/add")
    public String addAddress() {
        return "addressAdd";
    }

    @PostMapping("/add")
    public String addAddress(@RequestParam String city, Address newAddress) {
        PersonalInfo personalInfo = getCurrentUser().getPersonalInfo();
        newAddress.setCityName(city);
        newAddress.setPersonalInfo(personalInfo);
        addressService.save(newAddress);
        return "redirect:/user/" + getCurrentUser().getId();
    }

    @PostMapping("/edit")
    public String updateAddress(
            @RequestParam Long id,
            @RequestParam String city,
            @RequestParam(required = false) String street,
            @RequestParam(required = false) String house,
            @RequestParam(required = false) String flat,
            @RequestParam(required = false) String stage,
            @RequestParam(required = false) String entrance
    ) {
        Address address = addressService.getById(id);
        address.setCityName(city);
        address.setStreetName(street);
        address.setHouseNumber(house);
        address.setFlatNumber(flat);
        address.setStageNumber(stage);
        address.setEntranceNumber(entrance);
        addressService.save(address);
        return "redirect:/user/" + getCurrentUser().getId();
    }
    @PostMapping("/delete")
    public String deleteAddress(@RequestParam Long id){
        Address address = addressService.getById(id);
        addressService.deleteByAddress(address);
        return "redirect:/home";
    }
}
