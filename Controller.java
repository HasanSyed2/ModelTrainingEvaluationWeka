package ML;

public class Controller {
	 public static void main(String[] args) {
		CSVtoARFFConverter.Convert();
		Metrics.getStatistics();
		ML1.LinearRegression();
		ML2.LinearRegression();
		ML3.LinearRegression();
		ML4.LinearRegression();
	}
}
