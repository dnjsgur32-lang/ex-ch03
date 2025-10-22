package com.ljh.mybatis.controller;

import com.ljh.mybatis.domain.Student;
import com.ljh.mybatis.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;
    @GetMapping
    public String list(Model model) {
        model.addAttribute("students", studentService.getAllStudents());
        return "student/list";
    }

    @GetMapping("/new")
    public String createForm(Model model) {
        model.addAttribute("student", new Student());
        return "student/form";
    }

    @PostMapping
    public String create(@ModelAttribute Student student) {
        studentService.createStudent(student);
        return "redirect:/students";
    }

    @GetMapping("/{id}/edit")
    public String updateForm(@PathVariable Long id, Model model) {
        model.addAttribute("student", studentService.getStudent(id));
        return "student/form";
    }

    @PostMapping("/{id}")
    public String update(@PathVariable Long id, @ModelAttribute Student student) {
        student.setId(id);
        studentService.updateStudent(student);
        return "redirect:/students";
    }

    @PostMapping("/{id}/delete")
    public String delete(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return "redirect:/students";
    }
//    private final StudentService studentService;
//
//    //    http://localhost:8080/students
//    //    list 화면 : 전체 학생 목록
//    @GetMapping
//    public String list(Model model) {
//        model.addAttribute("students", studentService.getAllStudents());
//        return "student/list";
//    }
//
//    //    http://localhost:8080/students/new
//    //    등록 폼 (form) 화면 : 새로운 학생 정보를 입력하기 위한 빈 화면.
//    @GetMapping("/new")
//    public String createForm(Model model) {
//        model.addAttribute("student", new Student());
//        return "student/form";
//    }
//
//    //    등록 처리 : 학생 정보 기록후 저장 버튼을 클릭 하면, 학생 정보를 insert
//    @PostMapping
//    public String create(@ModelAttribute Student student) {
//
//        //    이미 학생 저장이 완료 되어 있음.
//        studentService.createStudent(student);
//        return "redirect:/students";
//    }
//
////    http://localhost:8080/students/5/
////    수정 (form) 폼
//    @GetMapping("/{id}/edit")
//    public String updateForm(@PathVariable Long id, Model model){
//        model.addAttribute("student", studentService.getStudent(id));
//        return "student/form";
//    }
//
////    수정 처리 :
//    @PostMapping("/{id}")
//    public String update(@PathVariable Long id, @ModelAttribute Student student) {
//        student.setId(id);
//        studentService.updateStudent(student);
//        return "redirect:/students";
//    }
//
//
////    http://localhost:8080/students/5/delete
////    삭제 처리 :
//    @PostMapping("/{id}/delete")
//    public String delete(@PathVariable Long id) {
//        studentService.deleteStudent(id);
//        return "redirect:/students";
//    }

}
