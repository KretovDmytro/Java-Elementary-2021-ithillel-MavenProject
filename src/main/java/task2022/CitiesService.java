package task2022;

import java.sql.*;

public class CitiesService {

    private final static String GET_CITIES_NAME = "SELECT * FROM cities";
    private final static String GET_CITIES_WITH_POPULATION = "SELECT cities.name, city_detals.population FROM cities join city_detals ON cities.id = city_detals.city_id WHERE city_detals.population IS NOT NULL";
    private final static String GET_CITIES_WITHOUT_POPULATION = "SELECT cities.name FROM cities join city_detals ON cities.id = city_detals.city_id WHERE city_detals.population IS NULL";
    private Connection connection;
    private Statement statement;
    private final String url;

    public CitiesService(String url) {
        this.url = url;
    }

    public void getCities() throws SQLException {
        initializeConnection();
        ResultSet resultSet = statement.executeQuery(GET_CITIES_NAME);

        while (resultSet.next()) {
            String name = resultSet.getString("name");
            String id = resultSet.getString("id");
            System.out.println(id + "    " + name);
        }

        resultSet.close();
        closeConnection();
    }

    public void addCity(City object) throws SQLException {
        initializeConnection();
        statement.executeUpdate("insert into cities values ('" + object.getId() + "','" + object.getName() + "')");
        statement.executeUpdate("insert into city_detals values ('" + object.getId() + "'," + ClassForInput.inputPopulation(object.getName()) + ")");
        closeConnection();
    }

    public void showCitiesWithPopulation() throws SQLException {
        initializeConnection();
        ResultSet resultSet = statement.executeQuery(GET_CITIES_WITH_POPULATION);

        while (resultSet.next()) {
            String name = resultSet.getString("name");
            String population = resultSet.getString("population");
            System.out.println(name + " city with a population of: " + population + " people");
        }
        resultSet.close();

        ResultSet resultSet2 = statement.executeQuery(GET_CITIES_WITHOUT_POPULATION);

        System.out.print("\nBut cities without population: ");
        while (resultSet2.next()) {
            String name = resultSet2.getString("name");
            System.out.print(name + ", ");
        }

        resultSet2.close();
        closeConnection();
    }

    private void initializeConnection() throws SQLException {
        connection = DriverManager.getConnection(url);
        statement = connection.createStatement();
    }

    private void closeConnection() throws SQLException {
        statement.close();
        connection.close();
    }
}