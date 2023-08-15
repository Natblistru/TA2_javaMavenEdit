package edu.step.db;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDB {

    public Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/test2";
        String username = "root";
        String password = "root";
        return DriverManager.getConnection(url, username, password);
    }

    public List<Employee> selectAll(){
        try{
            Connection connection = getConnection();
            String sql = "SELECT * FROM employee";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            List<Employee> list = new ArrayList<>();
            while(resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                String email = resultSet.getString("email");
               list.add(new Employee(id, name, surname, email));
            }
            connection.close();
            return list;
        } catch (SQLException ex) {
            System.out.println("Nu am putut face selectul: " + ex.getMessage());
            return new ArrayList<>(); // TODO: de inlocuit acest return cu throw new Exception()
        }
    }

    public void create(Employee employee){
        try{
            Connection connection = getConnection();
            String sql = "INSERT INTO employee(name, surname, email) values('" + employee.getName() + "', '" + employee.getSurname() + "', '" + employee.getEmail() + "' )";
            Statement statement = connection.createStatement();
            int rows = statement.executeUpdate(sql);
            System.out.println("S-au modificat " + rows  + " randuri");
            connection.close();
        } catch (SQLException ex) {
            System.out.println("Nu am putut face insertul: " + ex.getMessage());
        }
    }

    public void update(Employee employee){
        try{
            Connection connection = getConnection();
            String sql = "UPDATE employee SET name=?, surname=?, email=? WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, employee.getName());
            statement.setString(2, employee.getSurname());
            statement.setString(3, employee.getEmail());
            statement.setInt(4, employee.getId());
            int rows = statement.executeUpdate();
            System.out.println("S-au modificat " + rows  + " randuri");
            connection.close();
        } catch (SQLException ex) {
            System.out.println("Nu am putut face update-ul: " + ex.getMessage());
        }
    }

    public void delete(int id){
        try{
            Connection connection = getConnection();
            String sql = "DELETE FROM employee where id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            int rows = statement.executeUpdate();
            System.out.println("S-au sters " + rows  + " randuri");
            connection.close();
        } catch (SQLException ex) {
            System.out.println("Nu am putut face delete-ul: " + ex.getMessage());
        }
    }

    public void createWithPreparedStatement(Employee employee){
        try{
            Connection connection = getConnection();
            String sql = "INSERT INTO employee(name, surname, email) values(?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, employee.getName());
            statement.setString(2, employee.getSurname());
            statement.setString(3, employee.getEmail());
            int rows = statement.executeUpdate();
            System.out.println("S-au modificat " + rows  + " randuri");
            connection.close();
        } catch (SQLException ex) {
            System.out.println("Nu am putut face insertul: " + ex.getMessage());
        }
    }
}
