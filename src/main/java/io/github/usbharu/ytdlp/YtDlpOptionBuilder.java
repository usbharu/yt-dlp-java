package io.github.usbharu.ytdlp;

public class YtDlpOptionBuilder {

  protected final StringBuilder stringBuilder = new StringBuilder();
  public String url = "";

  private void append(String str) {
    stringBuilder.append(str).append("  ");
  }

  protected YtDlpOption create() {
    return new YtDlpOption(stringBuilder, url);
  }

  public class YtDlpOption {

    final StringBuilder stringBuilder;
    final String url;

    public StringBuilder getStringBuilder() {
      return stringBuilder;
    }

    public String getUrl() {
      return url;
    }

    public YtDlpOption(StringBuilder stringBuilder, String url) {
      this.stringBuilder = stringBuilder;
      this.url = url;
    }
  }

  public class AllOptionBuilder {

    public YtDlpOption help() {
      append("--help");
      return create();
    }

    public YtDlpOption version() {
      append("--help");
      return create();
    }

    public UrlOptionBuilder url(String urla) {
      url = urla;
      return this.new UrlOptionBuilder();
    }

    public class UrlOptionBuilder {

      public YtDlpOption build() {
        return create();
      }

      public UrlOptionBuilder output(String template) {
        append("--output  \"" + template + "\"");
        return this;
      }
    }
  }

  public static AllOptionBuilder options() {
    YtDlpOptionBuilder ytDlpOptionBuilder = new YtDlpOptionBuilder();
    return ytDlpOptionBuilder.new AllOptionBuilder();
  }

}
