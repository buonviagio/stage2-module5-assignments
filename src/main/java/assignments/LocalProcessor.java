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
    private Long period = 10_000_000_000_000L;
    //protected String processorVersion;
    private String processorVersion;
    private Integer valueofCheap;
    private Scanner informationscanner;
    private List<String> stringArrayList;// = new LinkedList<>();

    public LocalProcessor(String processorName, Long period, String processorVersion, Integer valueOfCheap,
                          Scanner informationscanner, List<String> stringArrayList) {
        this.processorName = processorName;
        this.period = period;
        this.processorVersion = processorVersion;
        this.valueofCheap = valueOfCheap;
        this.informationscanner = informationscanner;
        this.stringArrayList = stringArrayList;
    }

    public LocalProcessor() {
    }

    @ListIteratorAnnotation
    public void listiterator(LinkedList<String> stringList) {
        // stringArrayList = new LinkedList<>(stringList);
        stringArrayList = stringList;
        for (int i = 0; i < period; i++) {
            System.out.println(stringArrayList.get(i).hashCode());
        }
    }

    @FullNameProcessorGeneratorAnnotation
    public String fullnameProcessorgenerator(List<String> stringList) {
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
    public void readfullprocessorname(File file) throws FileNotFoundException {
            informationscanner = new Scanner(file);
            StringBuilder stringBuilder = new StringBuilder();
            try {
                while (informationscanner.hasNext()) {
                    //ProcessorVersion += informationscanner.nextLine();
                    stringBuilder.append(informationscanner.nextLine());
                }
            } catch (IllegalStateException e){
                informationscanner.close();
            }
        processorVersion = stringBuilder.toString();
    }
}
