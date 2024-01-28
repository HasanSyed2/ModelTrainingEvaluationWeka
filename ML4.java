package ML;

import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;
import weka.classifiers.functions.LinearRegression;
import weka.classifiers.Evaluation;
import weka.filters.Filter;
import weka.filters.unsupervised.instance.Randomize;

public class ML4 {
    public static void LinearRegression() {
        try {
            DataSource source = new DataSource("C:\\Users\\hksye\\eclipse-workspace\\machinelearning\\ML\\src\\ML\\Height_Weight.arff");
            Instances data = source.getDataSet();

            if (data != null) {
                data.setClassIndex(data.numAttributes() - 1);
                Randomize randomize = new Randomize();
                randomize.setInputFormat(data);
                data = Filter.useFilter(data, randomize);
                int trainSize = (int) Math.round(data.numInstances() * 0.7);
                int testSize = data.numInstances() - trainSize;
                Instances trainData = new Instances(data, 0, trainSize);
                Instances testData = new Instances(data, trainSize, testSize);
                LinearRegression model = new LinearRegression();
                model.buildClassifier(trainData);
                Evaluation eval = new Evaluation(trainData);
                eval.evaluateModel(model, testData);
                System.out.println("Mean Absolute Error of M4: " + eval.meanAbsoluteError());
                System.out.println("Root Mean Square Error of M4: "+ eval.rootMeanSquaredError());

            } else {
                System.err.println("Failed to load data from ARFF.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
