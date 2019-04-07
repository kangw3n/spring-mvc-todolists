package com.kangwen.service;

import com.kangwen.model.TodoData;
import com.kangwen.model.TodoItem;

public interface TodoItemService {
  void addItem(TodoItem toAdd);
  void removeItem(int id);

  TodoItem getItem(int id);
  void updateItem(TodoItem toUpdate);

  TodoData getData();
}
