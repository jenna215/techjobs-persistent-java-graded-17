package org.launchcode.techjobs.persistent.controllers;

import jakarta.validation.Valid;
import org.launchcode.techjobs.persistent.models.Employer;
import org.launchcode.techjobs.persistent.models.Job;
import org.launchcode.techjobs.persistent.models.Skill;
import org.launchcode.techjobs.persistent.models.data.EmployerRepository;
import org.launchcode.techjobs.persistent.models.data.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by LaunchCode
 */

@Controller
public class HomeController{

    @Autowired
    private EmployerRepository employerRepository;

    @Autowired
    private SkillRepository skillRepository;

    @RequestMapping("/")
    public String index(Model model){
        model.addAttribute("title", "MyJobs");
        return "index";
    }

    @GetMapping("add")

    public void displayAddJobForm(Model model){
        model.addAttribute("title", "Add Job");
        model.addAttribute(new Job());

        List<Employer> employers = (List<Employer>) employerRepository.findAll();
        model.addAttribute("employers", employers);

        List<Skill> skills = (List<Skill>) skillRepository.findAll();
        model.addAttribute("skills", skills);
    }

    @PostMapping("add")

    public String processAddJobForm(@ModelAttribute

                                    @Valid Job newJob,
                                    Errors errors, Model model, @RequestParam

                                    int employerId, @RequestParam List<Integer> skillIds)
    {
        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Job");

            return "add";
        }

        Optional<Employer> employer = employerRepository.findById(employerId);
        employer.ifPresent(newJob::setEmployer);

        List<Skill> skills = new ArrayList<>();
        for (int skillId : skillIds) {
            Optional<Skill> skill = skillRepository.findById(skillId);
            skill.ifPresent(skills::add);
        }
        newJob.setSkills(skills.toString());

        return "redirect:";
    }

    @GetMapping("view/{jobId}")
    public String displayViewJob(Model model, @PathVariable int jobId) {

        return "view";
    }
}