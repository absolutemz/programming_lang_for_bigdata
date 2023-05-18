package org.example;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

public class SampleData {
    public static void main(String[] args) {
        System.setProperty("hadoop.home.dir", "D:/BMSTU/NEW/java_projs/lab10/spark-3.4.0-bin-hadoop3");
        System.setProperty("java.util.logging.config.file", "D:/BMSTU/NEW/java_projs/lab10/");

        // Создаем объект SparkConf и SparkSession
        SparkConf conf = new SparkConf()
                .setAppName("YourAppName")
                .setMaster("local");
        JavaSparkContext sparkContext = new JavaSparkContext(conf);
        SparkSession sparkSession = SparkSession.builder().sparkContext(sparkContext.sc()).getOrCreate();

        // Загружаем данные из CSV файла с указанием кодировки
        String path = "Rus_schools_final.csv";
        Dataset<Row> data = sparkSession.read().option("header", "true").option("encoding", "CP1251").csv(path);

        // Регистрируем временную таблицу для выполнения SQL-запросов
        data.createOrReplaceTempView("schools");

        // 1) Вывести все строки про "лицеи"
        Dataset<Row> query1 = sparkSession.sql("SELECT * FROM schools WHERE name LIKE '%лицеи%'");
        query1.show(false);

        // 2) Вывести все школы Татарстана
        Dataset<Row> query2 = sparkSession.sql("SELECT * FROM schools WHERE addr LIKE '%Татарстан%'");
        query2.show(false);

        // 3) Вывести все школы Казани
        Dataset<Row> query3 = sparkSession.sql("SELECT * FROM schools WHERE addr LIKE '%Казань%'");
        query3.show(false);

        // 4) Вывести все Муниципальные образовательные учреждения
        Dataset<Row> query4 = sparkSession.sql("SELECT * FROM schools WHERE struct LIKE '%Муниципальное образовательное учреждение%'");
        query4.show(false);

        // 5) Вывести все вечерние школы
        Dataset<Row> query5 = sparkSession.sql("SELECT * FROM schools WHERE name LIKE '%вечерние%'");
        query5.show(false);

        // 6) Вывести просто все записи
        Dataset<Row> query6 = sparkSession.sql("SELECT * FROM schools");
        query6.show(false);

        // 7) Все школы Новосибирска
        Dataset<Row> query7 = sparkSession.sql("SELECT * FROM schools WHERE addr LIKE '%Новосибирск%'");
        query7.show(false);

        // 8) Количество школ Новосибирска
        Dataset<Row> query8 = sparkSession.sql("SELECT COUNT(*) as count FROM schools WHERE addr LIKE '%Новосибирск%'");
        query8.show(false);

        // 9) Все школы с улицы "школьная"
        Dataset<Row> query9 = sparkSession.sql("SELECT * FROM schools WHERE addr LIKE '%школьная%'");
        query9.show(false);

        // 10) Все школы коррекции
        Dataset<Row> query10 = sparkSession.sql("SELECT * FROM schools WHERE name LIKE '%коррекции%'");
        query10.show(false);

        sparkContext.close();
    }
}