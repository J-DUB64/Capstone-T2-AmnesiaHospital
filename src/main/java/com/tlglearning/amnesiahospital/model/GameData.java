package com.tlglearning.amnesiahospital.model;

import java.util.List;

public class GameData {
  private String title;
  private String description;
  private String startMessage;
  private List<Prompt> prompts;

  public GameData() {
  }

  public static class Prompt {
    private String question;
    private List<Choice> choices;

    public Prompt() {
    }

    public String getQuestion() {
      return question;
    }

    public void setQuestion(String question) {
      this.question = question;
    }

    public List<Choice> getChoices() {
      return choices;
    }

    public void setChoices(List<Choice> choices) {
      this.choices = choices;
    }
  }

  public static class Choice {
    private String label;
    private String action;

    public Choice() {
    }

    public String getLabel() {
      return label;
    }

    public void setLabel(String label) {
      this.label = label;
    }

    public String getAction() {
      return action;
    }

    public void setAction(String action) {
      this.action = action;
    }
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getStartMessage() {
    return startMessage;
  }

  public void setStartMessage(String startMessage) {
    this.startMessage = startMessage;
  }

  public List<Prompt> getPrompts() {
    return prompts;
  }

  public void setPrompts(List<Prompt> prompts) {
    this.prompts = prompts;
  }
}


