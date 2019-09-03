import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Encoders;
import org.apache.spark.sql.SparkSession;

import java.util.Collections;

public class ReadCsvAsDataset {

    public static void main(String[] args) {

        SparkSession spark = SparkSession.builder()
            .master("local[*]")
            .appName("Example")
            .config("spark.driver.host", "localhost")
            .config("spark.testing.memory", "2147480000")
            .getOrCreate();
        
        Dataset<Person> ds = spark.read()
            .option("header", "true")
            .csv("testdata/people.csv")
            .as(Encoders.bean(Person.class));

        ds.show();

    }



}

