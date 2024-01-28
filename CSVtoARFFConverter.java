package ML;

import weka.core.Instances;
import weka.core.converters.CSVLoader;
import weka.core.converters.ArffSaver;

import java.io.File;
import java.io.IOException;

public class CSVtoARFFConverter {
    public static void Convert() {
        try {
            CSVLoader loader = new CSVLoader();
            //this location of height_csv file
            loader.setSource(new File("C:\\Users\\hksye\\eclipse-workspace\\machinelearning\\ML\\src\\ML\\Height_Weight.csv"));
            if (loader.getStructure() == null) {
                throw new IOException("CSV structure is null. Please check the CSV file format and content.");
            }
            Instances data = loader.getDataSet();
            if (data != null) {
                for (int i = 0; i < data.numInstances(); i++) {
                    String gender = data.instance(i).stringValue(0);
                    double numericGender = gender.equalsIgnoreCase("Male") ? 1.0 : 0.0;
                    data.instance(i).setValue(0, numericGender);
                    double originalHeight = data.instance(i).value(1);
                    data.instance(i).setValue(1, originalHeight * 2.54);
                    double originalWeight = data.instance(i).value(2);
                    data.instance(i).setValue(2, originalWeight * 0.453592);
                }

                ArffSaver saver = new ArffSaver();
                saver.setInstances(data);
                //this is location of new arff file for weka
                saver.setFile(new File("C:\\Users\\hksye\\eclipse-workspace\\machinelearning\\ML\\src\\ML\\Height_Weight.arff"));
                saver.writeBatch();
            } else {
                System.err.println("Failed to load data from CSV.");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Successful");
    }
}
