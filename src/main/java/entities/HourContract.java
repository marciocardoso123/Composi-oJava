package entities;

import java.util.Date;
import java.util.function.DoubleBinaryOperator;

public class HourContract {

    private Date date;
    private Double valuePerHour;
    private Integer hours;

    public HourContract(){

    }
    public HourContract(Date date,Double valuePerHour,Integer hours){
        this.date = date;
        this.hours = hours;
        this.valuePerHour = valuePerHour;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getValuePerHour() {
        return valuePerHour;
    }

    public void setValuePerHour(Double valuePerHour) {
        this.valuePerHour = valuePerHour;
    }

    public Integer getHours() {
        return hours;
    }

    public void setHours(Integer hours) {
        this.hours = hours;
    }
    public  double totalValue(){
        return valuePerHour * hours;
    }
    @Override
    public  String toString(){
        return date + " ," + valuePerHour + " ," + hours;
    }
}
