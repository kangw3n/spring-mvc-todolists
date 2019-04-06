package com.kangwen.controller;

import com.kangwen.model.TodoData;
import com.kangwen.util.Mappings;
import com.kangwen.util.Views;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class TodoItemController {

  @ModelAttribute
  public TodoData todoData() {
    return new TodoData();
  }

  @GetMapping(Mappings.ITEMS)
  public String items() {
    return Views.ITEMS;
  }

}
