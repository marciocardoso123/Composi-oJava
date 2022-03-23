package entities;

import entities_enums.WorkerLevel;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Handler;

public class Worker {
    private String name;
    private WorkerLevel level;
    private Double baseSalary;
    //associação com 1 departamento
    private Department department;
    //associação com varias contratos que n pode ir no contrutor
    //contracts recebe uma lista vazia
    private List<HourContract> contracts = new ArrayList<>();

    public Worker() {
    }
    //contrutor principal
    public Worker(String name, WorkerLevel level, Double baseSalary, Department department) {
        this.baseSalary = baseSalary;
        this.name = name;
        this.level = level;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public WorkerLevel getLevel() {
        return level;
    }

    public void setLevel(WorkerLevel level) {
        this.level = level;
    }

    public Double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(Double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public List<HourContract> getContracts() {
        return contracts;
    }
    // busca em Hours um novo e add na lista fazendo assiciação com o trabalhador
    public  void addContract(HourContract contract){
        contracts.add(contract);
    }
    //remove da lista contratos desfazendo associação com trabalhadores
    public  void removeContract(HourContract contract){
        contracts.remove(contract);
    }
    public  double income(int year,int month){
        double sum = baseSalary;
        Calendar cal = Calendar.getInstance();
        for(HourContract c : contracts){
            //definindo a data do contrato como base de data de calendario
            //ou seja do dia do contrato começa a contar
            cal.setTime(c.getDate());
            //pegando a data do contrato
            int c_year =cal.get(Calendar.YEAR);
            //pegando o mes do contrato
            int c_month = 1 + cal.get(Calendar.MONTH);
            //se ano e mês forem iguais sum recebe totalvalue
                    if(year == c_year && month == c_month){
                        sum += c.totalValue();
                    }
        }return sum;
    }








    @Override
    public String toString() {
        return name + " " + level + " " + department + " " + contracts;
    }
}