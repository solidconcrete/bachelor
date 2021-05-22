//package com.bachelor.bachelor.controller.user;
//
//import com.bachelor.bachelor.TenantProvider;
//import com.bachelor.bachelor.model.shift.Shift;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import javax.validation.Valid;
//import java.util.List;
//
//@RestController
//@RequestMapping("/users")
//public class UserController {
//
//
//    @GetMapping
//    public List<Shift> findShifts() {
//        return shiftService.findAllShifts();
//    }
//
//    @PostMapping
//    public void upsertShift(@RequestBody @Valid Shift shift) {
//        TenantProvider.setCurrentDb("DB1");
//        shiftService.upsertShift(shift);
//    }
//}
