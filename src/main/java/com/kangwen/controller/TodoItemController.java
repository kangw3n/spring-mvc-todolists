package com.kangwen.controller;

import com.kangwen.model.TodoData;
import com.kangwen.model.TodoItem;
import com.kangwen.service.TodoItemService;
import com.kangwen.util.AttributeNames;
import com.kangwen.util.Mappings;
import com.kangwen.util.ViewsName;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@Slf4j
@Controller
public class TodoItemController {

  private final TodoItemService todoItemService;

  @Autowired
  public TodoItemController(TodoItemService todoItemService) {
    this.todoItemService = todoItemService;
  }

  @ModelAttribute
  public TodoData todoData() {
    return todoItemService.getData();
  }

  @GetMapping(Mappings.ITEMS)
  public String items() {
    return ViewsName.ITEMS;
  }

  @GetMapping(Mappings.ADD_ITEM)
  public String addEditItem(@RequestParam(required = false, defaultValue = "-1") int id, Model model) {
    TodoItem todoItem = todoItemService.getItem(id);

    if (todoItem == null) {
      todoItem = new TodoItem("", "", LocalDate.now());
    }

    model.addAttribute(AttributeNames.TODO_ITEM, todoItem);

    return ViewsName.ADD_ITEM;
  }

  @PostMapping(Mappings.ADD_ITEM) //post redirect get
  public String processItem(@ModelAttribute(AttributeNames.TODO_ITEM) TodoItem todoItem) {
    log.info("todoItems = {} ", todoItem);

    if (todoItem.getId() == 0) {
      todoItemService.addItem(todoItem);
    } else {
      todoItemService.updateItem(todoItem);
    }

    return "redirect:/" + Mappings.ITEMS;
  }

  @GetMapping(Mappings.DELETE_ITEM)
  public String deleteITem(@RequestParam int id) {
    log.info("Deleting id = {}", id);
    todoItemService.removeItem(id);
    return "redirect:/" + Mappings.ITEMS;
  }

  @GetMapping(Mappings.VIEW_ITEM)
  public String viewItem(@RequestParam int id, Model model) {
    TodoItem todoItem = todoItemService.getItem(id);
    model.addAttribute(AttributeNames.TODO_ITEM, todoItem);
    return ViewsName.VIEW_ITEM;
  }
}
