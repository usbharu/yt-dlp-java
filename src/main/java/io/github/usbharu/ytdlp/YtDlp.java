package io.github.usbharu.ytdlp;

import io.github.usbharu.ytdlp.YtDlpOptionBuilder.YtDlpOption;
import java.io.IOException;

public class YtDlp {
  public static void execute(YtDlpOption options) throws IOException, InterruptedException {
    YtDlpLauncher.downloadYtDlp();
    String run = YtDlpLauncher.run(options.getStringBuilder() + "  " + options.getUrl());
    System.out.println(run);
  }
}
