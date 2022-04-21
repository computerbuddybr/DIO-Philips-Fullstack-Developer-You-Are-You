package info.adriana.abstracaoBootcamps.controller;

import info.adriana.abstracaoBootcamps.model.entities.Mentorship;
import info.adriana.abstracaoBootcamps.model.entities.MentorshipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mentorias")
public class MentoriaController {

    @Autowired
    private MentorshipRepository mentorshipRepository;

    @PostMapping("/create")
    public @ResponseBody Mentorship newMentorship(@RequestParam String name, @RequestParam String description){
        Mentorship mentorship = new Mentorship(name, description);
        mentorshipRepository.save(mentorship);
        return mentorship;

    }
}
