package assignments;

import assignments.annotations.FullNameProcessorGeneratorAnnotation;
import assignments.annotations.ListIteratorAnnotation;
import assignments.annotations.ReadFullProcessorNameAnnotation;
import lombok.Getter;
import lombok.Setter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

@Getter
@Setter
public class LocalProcessor {
    private String processorName;
    private Long period = 10_000_000_000_000L;
    private String processorVersion;
    private Integer valueOfCheap;
    private Scanner informationScanner;
    private List<String> stringArrayList = new LinkedList<>();
    private StringBuilder sb;

    public LocalProcessor(
            String processorName,
            Long period,
            String processorVersion,
            Integer valueOfCheap,
            Scanner informationScanner,
            List<String> stringArrayList
    ) {
        this.processorName = processorName;
        this.period = period;
        this.processorVersion = processorVersion;
        this.valueOfCheap = valueOfCheap;
        this.informationScanner = informationScanner;
        this.stringArrayList = stringArrayList;
    }

    public LocalProcessor() {
    }

    @ListIteratorAnnotation
    public void listIterator(List<String> stringList) {
        for (String item : stringList) {
            System.out.println(item == null ? null : item.hashCode());
        }
    }

    @FullNameProcessorGeneratorAnnotation
    public String fullNameProcessorGenerator(List<String> stringList) {
        StringBuilder sb = new StringBuilder();
        sb.append(processorName);

        for (String item : stringArrayList) {
            sb.append(item)
                    .append(" ");
        }

        processorName = sb.toString();
        return processorName;
    }

    @ReadFullProcessorNameAnnotation
    public void readFullProcessorName(File file) throws FileNotFoundException {
        this.informationScanner = new Scanner(file);
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(processorVersion);
            while (informationScanner.hasNext()) {
                sb.append(informationScanner.nextLine());
            }
            this.processorVersion = sb.toString();
        } finally {
            this.informationScanner.close();
        }
    }
}
