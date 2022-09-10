package io.github.usbharu.ytdlp;

import io.github.usbharu.ytdlp.YtDlpOptionBuilder.YtDlpOption;
import java.io.IOException;

public class YtDlp {
  public static void execute(YtDlpOption options) {
    execute(options,event -> System.out.println(event.getChangedString()));
  }

  public static void execute(YtDlpOption options,ProcessStreamChangeEventListener listener){
    YtDlpLauncher.downloadYtDlp();
    YtDlpLauncher.runLong(options.getStringBuilder() + "  " + options.getUrl(),listener);
  }
}
