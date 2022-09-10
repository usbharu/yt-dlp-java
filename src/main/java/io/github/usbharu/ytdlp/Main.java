package io.github.usbharu.ytdlp;

import java.io.IOException;

public class Main {

  public static void main(String[] args) {
////    LongProcessBroker longProcessBroker = new LongProcessBroker("mock.bat");
//    LongProcessBroker longProcessBroker = new LongProcessBroker("yt-dlp.exe","https://www.youtube.com/watch?v=pZeoBMhh1ls");
//    longProcessBroker.addProcessStreamChangeEventListener(event -> System.out.println(
//        "event.getChangedString() = " + event.getChangedString()));
//    longProcessBroker.execute();
    YtDlp.execute(YtDlpOptionBuilder.options().url("https://www.youtube.com/watch?v=pZeoBMhh1ls").output("%(title)s.%(ext)s").build());
  }

}
