package ML;

import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;
import weka.core.AttributeStats;

public class Metrics {

    public static void getStatistics() {
        try {
            DataSource source = new DataSource("C:\\Users\\hksye\\eclipse-workspace\\machinelearning\\ML\\src\\ML\\Height_Weight.arff");
            Instances data = source.getDataSet();
            int heightIndex = 1;
            int weightIndex = 2;
            AttributeStats heightStats = data.attributeStats(heightIndex);
            AttributeStats weightStats = data.attributeStats(weightIndex);
            System.out.println("Height Statistics:");
            System.out.println("Min: " + heightStats.numericStats.min);
            System.out.println("Max: " + heightStats.numericStats.max);
            System.out.println("Mean: " + heightStats.numericStats.mean);
            System.out.println("Standard Deviation: " + heightStats.numericStats.stdDev);
            System.out.println("Median: " + getMedian(data, heightIndex));
            System.out.println("\nWeight Statistics:");
            System.out.println("Min: " + weightStats.numericStats.min);
            System.out.println("Max: " + weightStats.numericStats.max);
            System.out.println("Mean: " + weightStats.numericStats.mean);
            System.out.println("Standard Deviation: " + weightStats.numericStats.stdDev);
            System.out.println("Median: " + getMedian(data, weightIndex));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static double getMedian(Instances data, int columnIndex) {
        int size = data.numInstances();
        if (size % 2 == 0) {
            double value1 = data.instance(size / 2 - 1).value(columnIndex);
            double value2 = data.instance(size / 2).value(columnIndex);
            return (value1 + value2) / 2.0;
        } else {
            return data.instance(size / 2).value(columnIndex);
        }
    }
}
