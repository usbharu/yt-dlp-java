package io.github.usbharu.ytdlp;

import java.util.EventListener;
import java.util.List;

public interface ProcessStreamChangeEventListener extends EventListener {
  void onStreamChange(ProcessStreamChangeEvent event);

}
