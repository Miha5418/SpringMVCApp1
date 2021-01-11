package ru.karpeykin.springcourse.dao;

import org.springframework.stereotype.Component;
import ru.karpeykin.springcourse.models.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author karpeykin
 * @Date 31.12.2020
 */
@Component
public class PersonDAO {
    private static int PEOPLE_COUNT;
    private static String URL = "jdbc:postgresql://localhost:5432/lessons";
    private static String user = "admin";

    private static Connection connection;

    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            connection = DriverManager.getConnection(URL, user, user);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public List<Person> index() {
        List<Person> people = new ArrayList<>();

        try {
        Statement statement = connection.createStatement();
            String SQL = "Select * from Person";
            ResultSet resultSet = statement.executeQuery(SQL);

            while (resultSet.next()){
                Person person = new Person();

                person.setId(resultSet.getInt("id"));
                person.setName(resultSet.getString("name"));
                person.setAge(resultSet.getInt("age"));
                person.setEmail(resultSet.getString("email"));
                people.add(person);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return people;
    }

    public Person show(int id) {
        //return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
        return null;
    }

    public void save(Person person) {
        try {
            Statement statement = connection.createStatement();
            String SQL = "INSERT INTO PERSON (id, name, age, email) values (" +
                    1 + ",'" + person.getName() + "', '" + person.getAge() + "', '" + person.getEmail() + "')";

            statement.executeUpdate(SQL);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void update(int id, Person updatedPerson) {
  //      Person personToBeUpdated = show(id);
//
  //      personToBeUpdated.setName(updatedPerson.getName());
  //      personToBeUpdated.setAge(updatedPerson.getAge());
  //      personToBeUpdated.setEmail(updatedPerson.getEmail());
    }

    public void delete(int id) {
        //people.removeIf(p -> p.getId() == id);
    }
}
