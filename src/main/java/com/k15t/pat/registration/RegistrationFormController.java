package com.k15t.pat.registration;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;
import java.io.StringWriter;
import java.util.List;

@RestController
public class RegistrationFormController {

    /*@Autowired
    private RegistrationFormRepository registrationFormRepository;

    @Autowired private VelocityEngine velocityEngine;

    private boolean successFailure;*/
    @Autowired
    private RegistrationResource registrationResource;

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String addUser(@Valid @ModelAttribute RegistrationForm registrationForm) {

       /* successFailure=hasDataSaved(registrationForm);

        Template template = velocityEngine.getTemplate("templates/registration.vm");
        VelocityContext context = new VelocityContext();*/

            /*if (successFailure) {
                saveData(registrationForm);
                context.put("status", "success");
                context.put("message", "Successfully Saved!");
                context.put("Name", registrationForm.getName());
                context.put("Adddress", registrationForm.getAddress());
                context.put("PhoneNo", registrationForm.getPhoneNumber());
                context.put("Email", registrationForm.getEmail());
            } else {
                context.put("status", "failure");
                context.put("message", "Data Not Saved!Email Address already present in the Database");
            }*/

        /*StringWriter writer = new StringWriter();
        template.merge(context, writer);*/

        return registrationResource.save(registrationForm);
    }

    /*private boolean hasDataSaved(RegistrationForm registrationForm) {
        if(getAllData().size() == 0)
            return successFailure = true;
        for(RegistrationForm item: getAllData()) {
            // Can't persisted the  duplicate email.
            if(item.getEmail().equalsIgnoreCase(registrationForm.getEmail())){
                return successFailure = false;
            }
        }
        return successFailure = true;
    }

    private List<RegistrationForm> getAllData() {
        return registrationFormRepository.findAll();
    }

    private void saveData(RegistrationForm registrationForm){
        registrationFormRepository.save(registrationForm);
    }*/
}
