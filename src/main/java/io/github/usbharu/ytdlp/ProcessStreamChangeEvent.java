package io.github.usbharu.ytdlp;

import java.util.ArrayList;
import java.util.EventObject;
import java.util.List;

public class ProcessStreamChangeEvent extends EventObject {


  private final List<String> strings;
  private final String changedString;

  /**
   * Constructs a prototypical Event.
   *
   * @param source The object on which the Event initially occurred.
   * @throws IllegalArgumentException if source is null.
   */
  public ProcessStreamChangeEvent(Object source,List<String> strings,String changedString) {
    super(source);
    this.strings = strings;
    this.changedString = changedString;
  }

  public String getChangedString() {
    return changedString;
  }

  public List<String> getStrings() {
    return strings;
  }
}
