package assignments;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import assignments.annotations.FullNameProcessorGeneratorAnnotation;
import assignments.annotations.ListIteratorAnnotation;
import assignments.annotations.ReadFullProcessorNameAnnotation;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LocalProcessor {
    private String processorName;
    private long period = 10_000_000_000_000L;
    //protected String processorVersion;
    private String processorVersion;
    private int valueOfCheap;
    private Scanner informationScanner;
    private List<String> stringArrayList;// = new LinkedList<>();

    public LocalProcessor(String processorName, long period, String processorVersion, int valueOfCheap,
                          Scanner informationScanner, List<String> stringArrayList) {
        this.processorName = processorName;
        this.period = period;
        this.processorVersion = processorVersion;
        this.valueOfCheap = valueOfCheap;
        this.informationScanner = informationScanner;
        this.stringArrayList = stringArrayList;
    }

    public LocalProcessor() {
    }

    public String getProcessorName() {
        return processorName;
    }

    public void setProcessorName(String processorName) {
        this.processorName = processorName;
    }

    public long getPeriod() {
        return period;
    }

    public void setPeriod(long period) {
        this.period = period;
    }

    public String getProcessorVersion() {
        return processorVersion;
    }

    public void setProcessorVersion(String processorVersion) {
        this.processorVersion = processorVersion;
    }

    public int getValueOfCheap() {
        return valueOfCheap;
    }

    public void setValueOfCheap(int valueofCheap) {
        this.valueOfCheap = valueofCheap;
    }

    public Scanner getInformationScanner() {
        return informationScanner;
    }

    public void setInformationScanner(Scanner informationscanner) {
        this.informationScanner = informationscanner;
    }

    public List<String> getStringArrayList() {
        return stringArrayList;
    }

    public void setStringArrayList(List<String> stringArrayList) {
        this.stringArrayList = stringArrayList;
    }

    @ListIteratorAnnotation
    public void listIterator(List<String> stringList) {
        // stringArrayList = new LinkedList<>(stringList);
        stringArrayList = stringList;
        for (int i = 0; i < period; i++) {
            System.out.println(stringArrayList.get(i).hashCode());
        }
    }

    @FullNameProcessorGeneratorAnnotation
    public String fullNameProcessorGenerator(List<String> stringList) {
        StringBuilder stringBuilder = new StringBuilder();
        //for (int i = 0; i < stringArrayList.size(); i++) {
        for (String list : stringList){
            stringBuilder.append(list).append(" ");
            //processorName+=stringList.get(i)+' ';
        }
        //return processorName;
        return stringBuilder.toString();
    }

    @ReadFullProcessorNameAnnotation
    public void readFullProcessorName(File file) throws FileNotFoundException {
            informationScanner = new Scanner(file);
            StringBuilder stringBuilder = new StringBuilder();
            try {
                while (informationScanner.hasNext()) {
                    //ProcessorVersion += informationscanner.nextLine();
                    stringBuilder.append(informationScanner.nextLine());
                }

            } catch (IllegalStateException e){
                System.out.println(e);
            } finally {
                 try {
                     informationScanner.close();
                 } catch (IllegalStateException e){
                     System.out.println(e);
                 }
            }
        processorVersion = stringBuilder.toString();
    }
}
