package io.github.usbharu.ytdlp;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class YtDlpLauncher {

  public static void downloadYtDlp() {
    if (ytDlpFile().exists()) {
      return;
    }
    try (CloseableHttpClient client = HttpClients.createDefault()) {
      try (CloseableHttpResponse execute = client.execute(new HttpGet(ytDlpUrl()))) {
        try (OutputStream outStream = Files.newOutputStream(ytDlpFile().toPath())) {
          execute.getEntity().writeTo(outStream);
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static File ytDlpFile() {
    String os = System.getProperty("os.name").toLowerCase();
    if (os.startsWith("windows")) {
      return new File("yt-dlp.exe");
    } else if (os.startsWith("linux")) {
      return new File("yt-dlp_linux");
    }
    return new File("yt-dlp");
  }

  public static String ytDlpUrl(){
    String os = System.getProperty("os.name").toLowerCase();
    if (os.startsWith("windows")) {
      return "https://github.com/yt-dlp/yt-dlp/releases/latest/download/yt-dlp.exe";
    }else if (os.startsWith("linux")){
      return "https://github.com/yt-dlp/yt-dlp/releases/latest/download/yt-dlp_linux";
    }
    return "https://github.com/yt-dlp/yt-dlp/releases/latest/download/yt-dlp";
  }

  public static String run(String options) throws IOException, InterruptedException {
    ProcessBroker processBroker =
        new ProcessBroker(("./" + ytDlpFile().getPath() + "  " + options).split("  "));
    processBroker.execute();
    return processBroker.getStdout();
  }

  public static LongProcessBroker runLong(String option,ProcessStreamChangeEventListener listener){
    LongProcessBroker longProcessBroker = new LongProcessBroker(("./"+ytDlpFile().getPath()+"  "+option).split("  "));
    longProcessBroker.addProcessStreamChangeEventListener(listener);
    longProcessBroker.execute();
    return longProcessBroker;
  }
}
