
Model Training and Evaluation
Overview
This script demonstrates the training and evaluation of linear regression models using different sizes of training datasets. The models are applied to predict weight based on height and gender.

Data Preparation
The script reads a dataset from 'Height_Weight.csv' and converts height to centimeters and weight to kilograms. The Gender column is mapped to numerical values (0 for Female, 1 for Male).

Metrics
A function Metrics is defined to calculate descriptive statistics for the dataset, including mean, median, standard deviation, minimum, and maximum values for both height and weight.

Models
Four models (M1, M2, M3, and M4) are trained with different sizes of randomly sampled training datasets and evaluated on test datasets. The training dataset sizes are 100, 1000, 5000, and 10000 samples, respectively.

Model 1 (M1)
Training data size: 100 samples
Linear regression is applied using height and gender as features to predict weight.
Mean Squared Error (MSE) and model coefficients are printed.
Model 2 (M2)
Training data size: 1000 samples
Linear regression is applied using height and gender as features to predict weight.
MSE and model coefficients are printed.
Model 3 (M3)
Training data size: 5000 samples
Linear regression is applied using height and gender as features to predict weight.
MSE and model coefficients are printed.
Model 4 (M4)
Training data size: 10000 samples
Linear regression is applied using height and gender as features to predict weight.
MSE and model coefficients are printed.
Usage
Ensure you have the required libraries installed: weka.
Provide the dataset 'Height_Weight.csv'.
Run the script to train and evaluate the models.
Note: The models are trained on randomly sampled subsets of the dataset to showcase the impact of training dataset size on model performance