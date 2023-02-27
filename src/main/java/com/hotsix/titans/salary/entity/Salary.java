package com.hotsix.titans.salary.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "TBL_SALARY")
//@SequenceGenerator(
//    name = "SALARY_SEQ_GENERATOR",
//    sequenceName = "SEQ_SALARY",
//    initialValue = 1,
//    allocationSize = 50
//)
public class Salary {

    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_SALARY")
    @Column(name = "SALARY_CODE")
    private String salaryCode;              // 급여 코드

    @Column(name = "BASIC_SALARY")
    private Long basicSalary;               // 기본급

    @Column(name = "BEFORE_SALARY")
    private Long beforeSalary;              // 세전 급액

    @Column(name = "AFTER_SALARY")
    private Long afterSalary;               // 세후 급액

    @Column(name = "MEAL_SALARY")
    private Long mealSalary;                // 식대

    @ManyToOne
    @JoinColumn(name = "TAX_CODE")
    private Tax tax;

    @OneToMany
    @JoinColumn(name = "BONUS_CODE")
    private List<Bonus> bonusList;

    public Salary() {
    }

    public Salary(String salaryCode, Long basicSalary, Long beforeSalary, Long afterSalary, Long mealSalary, Tax tax, List<Bonus> bonusList) {
        this.salaryCode = salaryCode;
        this.basicSalary = basicSalary;
        this.beforeSalary = beforeSalary;
        this.afterSalary = afterSalary;
        this.mealSalary = mealSalary;
        this.tax = tax;
        this.bonusList = bonusList;
    }

    public String getSalaryCode() {
        return salaryCode;
    }

    public void setSalaryCode(String salaryCode) {
        this.salaryCode = salaryCode;
    }

    public Long getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(Long basicSalary) {
        this.basicSalary = basicSalary;
    }

    public Long getBeforeSalary() {
        return beforeSalary;
    }

    public void setBeforeSalary(Long beforeSalary) {
        this.beforeSalary = beforeSalary;
    }

    public Long getAfterSalary() {
        return afterSalary;
    }

    public void setAfterSalary(Long afterSalary) {
        this.afterSalary = afterSalary;
    }

    public Long getMealSalary() {
        return mealSalary;
    }

    public void setMealSalary(Long mealSalary) {
        this.mealSalary = mealSalary;
    }

    public Tax getTax() {
        return tax;
    }

    public void setTax(Tax tax) {
        this.tax = tax;
    }

    public List<Bonus> getBonusList() {
        return bonusList;
    }

    public void setBonusList(List<Bonus> bonusList) {
        this.bonusList = bonusList;
    }

    @Override
    public String toString() {
        return "Salary{" +
                "salaryCode='" + salaryCode + '\'' +
                ", basicSalary=" + basicSalary +
                ", beforeSalary=" + beforeSalary +
                ", afterSalary=" + afterSalary +
                ", mealSalary=" + mealSalary +
                ", tax=" + tax +
                ", bonusList=" + bonusList +
                '}';
    }
}
