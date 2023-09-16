package com.ltp.gradesubmission;

import java.util.ArrayList;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GradeController {

    List<Grade> studentGrades = new ArrayList<>();

    @GetMapping("/")
    public String getForm(Model model, @RequestParam(required = false) String id) {
        Integer index = getGradeIndex(id);
        model.addAttribute("grade", index == Constants.NOT_FOUND ? new Grade() : studentGrades.get(index));
        return "form";
    }

    @PostMapping("/handleSubmit")
    public String submitForm(@Valid Grade grade, BindingResult result) {
        if (result.hasErrors())
            return "form";
        Integer index = getGradeIndex(grade.getId());
        if (index == Constants.NOT_FOUND) {
            studentGrades.add(grade);
        } else {
            studentGrades.set(index, grade);
        }
        return "redirect:/grades";
    }

    @GetMapping("/grades")
    public String getGrades(Model model) {
        model.addAttribute("grade", studentGrades);
        return "grades";
    }
    // @GetMapping("/ratings")
    // public String getRatings() {
    // return "ratings";
    // }

    public Integer getGradeIndex(String id) {
        for (int i = 0; i < studentGrades.size(); i++) {
            if (studentGrades.get(i).getId().equals(id)) {
                return i;
            }
        }
        return Constants.NOT_FOUND;
    }
}