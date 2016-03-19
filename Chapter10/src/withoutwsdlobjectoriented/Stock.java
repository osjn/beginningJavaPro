package withoutwsdlobjectoriented;

import java.util.Date;

public class Stock {
    private String symbol;
    private String name;
    private double last, open, high, low;
    private long volume;
    private Date timestamp;
    private double marketCap;
    private double previousClose;
    private double change, percentageChange;
    private double annRangeLow, annRangeHigh;
    private double earns;
    private double pe;

    public Stock(String symbol, String name, double last, double open, double high,
                 double low, long volume, Date timestamp, double marketCap,
                 double previousClose, double change, double percentageChange,
                 double annRangeLow, double annRangeHigh, double earns, double pe) {
        this.symbol = symbol;
        this.name = name;
        this.last = last;

        this.open = open;
        this.high = high;
        this.low = low;
        this.volume = volume;
        this.timestamp = timestamp;
        this.marketCap = marketCap;
        this.previousClose = previousClose;
        this.change = change;
        this.percentageChange = percentageChange;
        this.annRangeLow = annRangeLow;
        this.annRangeHigh = annRangeHigh;
        this.earns = earns;
        this.pe = pe;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLast() {
        return last;
    }

    public void setLast(double last) {
        this.last = last;
    }

    public double getOpen() {
        return open;
    }

    public void setOpen(double open) {
        this.open = open;
    }

    public double getHigh() {
        return high;
    }

    public void setHigh(double high) {
        this.high = high;
    }

    public double getLow() {
        return low;
    }

    public void setLow(double low) {
        this.low = low;
    }

    public long getVolume() {
        return volume;
    }

    public void setVolume(long volume) {
        this.volume = volume;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public double getMarketCap() {
        return marketCap;
    }

    public void setMarketCap(double marketCap) {
        this.marketCap = marketCap;
    }

    public double getPreviousClose() {
        return previousClose;
    }

    public void setPreviousClose(double previousClose) {
        this.previousClose = previousClose;
    }

    public double getChange() {
        return change;
    }

    public void setChange(double change) {
        this.change = change;
    }

    public double getPercentageChange() {
        return percentageChange;
    }

    public void setPercentageChange(double percentageChange) {
        this.percentageChange = percentageChange;
    }

    public double getAnnRangeLow() {
        return annRangeLow;
    }

    public void setAnnRangeLow(double annRangeLow) {
        this.annRangeLow = annRangeLow;
    }

    public double getAnnRangeHigh() {
        return annRangeHigh;
    }

    public void setAnnRangeHigh(double annRangeHigh) {
        this.annRangeHigh = annRangeHigh;
    }

    public double getEarns() {
        return earns;
    }

    public void setEarns(double earns) {
        this.earns = earns;
    }

    public double getPe() {
        return pe;
    }

    public void setPe(double pe) {
        this.pe = pe;
    }

    public String toString() {
        String r = "";
        r += "STOCK " + symbol + ": " + name + "\r\n";
        int l = r.length() - 2;
        for (int i = 0; i < l; i++) {
            r += "=";
        }
        r += "\r\n";
        r += "* Retrieved at: " + timestamp + "\r\n";
        r += "* Last / High / Low / Open: " +
                last + " / " + high + " / " + low + " / " + open + "\r\n";
        r += "* Previous close: " + previousClose + "\r\n";
        r +="* Volume: " + volume + "\r\n";
        r += "* Market Cap: " + marketCap + "B" + "\r\n";
        r += "* Change (%): " + change + " (" + percentageChange + "%)" + "\r\n";
        r += "* Annual range High / Low: " +
                annRangeHigh + " / " + annRangeLow + "\r\n";
        r += "* Earns: " + earns + "\r\n";
        r += "* P/E: " + pe + "\r\n";
        return r;
    }
}
